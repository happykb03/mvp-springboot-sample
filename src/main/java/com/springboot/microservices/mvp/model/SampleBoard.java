package com.springboot.microservices.mvp.model;

import java.util.List;

import lombok.Data;

@Data
public class SampleBoard {
	 private String  boardId 		; //게시물 아이디 
	 private String  boardSubject 		; // 게시물 제목 
	 private String  boardContents 		    ; // 게시물 내용 
	 private String  regUserNm 	    ; // 등록자명 
	 private String  regYms    ; // 등록일시  
	 private String  amndYms 	    ; // 수정일시  
	 private String  curPageNo 	    ; // 현재 페이지번호  
	 private String  totPageNo 	    ; // 전체 페이지수 
	 
	 private List<SampleBoard>	 lists;
}
