package com.springboot.microservices.mvp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.microservices.mvp.dao.SampleBoardDao;
import com.springboot.microservices.mvp.model.SampleBoard;


@Service
public class SampleBoardServiceImpl implements SampleBoardService{

	@Autowired
	private SampleBoardDao sampleBoardDao;
	
	@Override
	public List<SampleBoard> selectBoardList(String pageNo) throws Exception {
		// TODO Auto-generated method stub
		return sampleBoardDao.selectBoardList(pageNo);
	}
	
	@Override
	public int insertBoard(SampleBoard sampleBoard) throws Exception {
		// TODO Auto-generated method stub
		return sampleBoardDao.insertBoard(sampleBoard);
	}
	
	@Override
	public int updateBoard(SampleBoard sampleBoard) throws Exception {
		// TODO Auto-generated method stub
		return sampleBoardDao.updateBoard(sampleBoard);
	}
	
	@Override
	public int deleteBoard(SampleBoard sampleBoard) throws Exception {
		// TODO Auto-generated method stub
		return sampleBoardDao.deleteBoard(sampleBoard);
	}

}
