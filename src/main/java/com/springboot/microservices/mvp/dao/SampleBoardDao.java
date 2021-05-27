package com.springboot.microservices.mvp.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.springboot.microservices.mvp.model.SampleBoard;
import com.springboot.microservices.mvp.model.SampleUser;


@Mapper
public interface SampleBoardDao {

	/**
	 * 게시판 리스트 조회  
	 * @return
	 * @throws Exception
	 */
	List<SampleBoard> selectBoardList(String pageNo) throws Exception;	
	

	/**
	 * 게시판정보 등록
	 * @param sampleBoard
	 * @return
	 * @throws Exception
	 */
	int insertBoard(SampleBoard sampleBoard) throws Exception;
	
	/**
	 * 게시판정보 등록
	 * @param sampleBoard
	 * @return
	 * @throws Exception
	 */
	int updateBoard(SampleBoard sampleBoard) throws Exception;
	
	/**
	 * 게시판정보 등록
	 * @param sampleBoard
	 * @return
	 * @throws Exception
	 */
	int deleteBoard(SampleBoard sampleBoard) throws Exception;
	
	List<SampleUser> selectUser2() throws Exception;		
	
	/**
	 * 아이디로 사용자 정보 조회하
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	SampleUser selectUserById(String userId) throws Exception;	
	
	/**
	 * 사용자 정보 변경하
	 * @param sampleUser
	 * @return
	 * @throws Exception
	 */
	int updateUser(SampleUser sampleUser) throws Exception;
	
	/**
	 * 사용자 등록하기 
	 * @param sampleUser
	 * @return
	 * @throws Exception
	 */
	int insertUser(SampleUser sampleUser) throws Exception;
	
	/**
	 * 사용자 정보 삭제하기 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	int deleteUser(String userId) throws Exception;		
	
	int selectTest() throws Exception;

}
			