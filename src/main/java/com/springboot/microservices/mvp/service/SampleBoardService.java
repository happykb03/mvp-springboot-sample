package com.springboot.microservices.mvp.service;

import java.util.List;

import com.springboot.microservices.mvp.model.SampleBoard;


public interface SampleBoardService {
	/**
	 * 게시판 정보 가져오기
	 * @return
	 * @throws Exception 
	 */
	public List<SampleBoard> selectBoardList(String pageNo) throws Exception;	

	/**
	 * 게시판 정보 등록하기
	 * @return
	 * @throws Exception 
	 */
	public int insertBoard(SampleBoard sampleBoard) throws Exception;	
	
	/**
	 * 게시판 정보 수정하기
	 * @return
	 * @throws Exception 
	 */
	public int updateBoard(SampleBoard sampleBoard) throws Exception;
	
	
	/**
	 * 게시판 정보 삭제하기
	 * @return
	 * @throws Exception 
	 */
	public int deleteBoard(SampleBoard sampleBoard) throws Exception;
}
