package com.springboot.microservices.mvp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.microservices.mvp.model.SampleBoard;
import com.springboot.microservices.mvp.service.SampleBoardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Api(value="Hello Service API")
@RequestMapping(value="/board")
@RestController
public class SampleBoardController {
	
	@Autowired
	private SampleBoardService sampleBoardService;
	
	//=======================================================================

	@ApiOperation(value="게시판 리스트 가져오기 ")
	@RequestMapping(value="/boardList/{pageNo}", method=RequestMethod.GET)
	public ResponseEntity<SampleBoard> getUsserById(
				@PathVariable (name="pageNo", required = false) String pageNo
			) { 
		SampleBoard sbDTO = new SampleBoard();
		
		try {
			log.info("Start board list db select");
			log.info(pageNo);
			List<SampleBoard> boardList = sampleBoardService.selectBoardList(pageNo);
			sbDTO.setLists(boardList);
			sbDTO.setCurPageNo(pageNo);
			sbDTO.setTotPageNo(""+boardList.size());
			// rabbitmq 
//			broadcastMessageProducer.produceChargeOrder(re);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<SampleBoard> (sbDTO, HttpStatus.OK);
	}
	
	@ApiOperation(value="게시판 정보 등록하기 ")
	@RequestMapping(value="/boardReg", method=RequestMethod.POST)
	public ResponseEntity <String > setBoardInsert(
			@RequestBody SampleBoard sampleBoard
			) throws Exception { 
		
		log.info("Start db insert");
		int re  = sampleBoardService.insertBoard(sampleBoard);
		log.debug("result :"+ re);
		
		return new ResponseEntity<String> (re+"", HttpStatus.OK);
	}
	
	@ApiOperation(value="게시판 정보 여러개 등록하기 ")
	@RequestMapping(value="/boardRegMulti", method=RequestMethod.POST)
	public ResponseEntity <String > setBoardInsert(
			@RequestBody List<SampleBoard> list
			) throws Exception { 
		
		log.info("Start db insert");    
		int re = 0;
		if(list.size() > 0) {
			for(SampleBoard sampleBoard : list) {
				re  += sampleBoardService.insertBoard(sampleBoard);
				
			}
		}
		log.debug("result :"+ re);
		
		return new ResponseEntity<String> (re+"", HttpStatus.OK);
	}
	
	
	@ApiOperation(value="게시판 정보 수정하기 ")
	@RequestMapping(value="/boardUpt", method=RequestMethod.PUT)
	public ResponseEntity <String > setBoardUpdate(
			@RequestBody SampleBoard sampleBoard
			) throws Exception { 
		
		log.info("Start db insert");
		int re  = sampleBoardService.updateBoard(sampleBoard);
		log.debug("result :"+ re);
		
		return new ResponseEntity<String> (re+"", HttpStatus.OK);
	}
	
	
	@ApiOperation(value="게시판 정보 삭제하기 ")
	@RequestMapping(value="/boardDel/{boardId}", method=RequestMethod.DELETE)
	public ResponseEntity <String > setBoardDelete(
			@PathVariable(name="boardId",required = true ) String[] boardId
			) throws Exception { 
		
		SampleBoard sampleBoard = new SampleBoard();
		
		for(String bId : boardId) {
			sampleBoard.setBoardId(bId);
		}
		
		log.info("Start db insert");
		int re  = sampleBoardService.deleteBoard(sampleBoard);
		log.debug("result :"+ re);
		
		return new ResponseEntity<String> (re+"", HttpStatus.OK);
	}
	
	
	
	
	//=======================================================================

	
}
