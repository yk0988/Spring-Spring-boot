package com.company.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.company.domain.BoardVO;
import com.company.domain.Criteria;
import com.company.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{
  
	 private BoardMapper mapper;

	 @Override
	 public void register(BoardVO board){
		 
		 log.info("register" +board);
		 
		 mapper.insertSelectKey(board);
	 }

	@Override
	public BoardVO get(Long bno) {
		log.info("get" + bno);	
		
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		log.info("modify"+board);
		return mapper.update(board)==1;
	}

	@Override
	public boolean remove(Long bno) {
		log.info("remove"+bno);
		return mapper.delete(bno)==1;
	}

	@Override
	public List<BoardVO> getList() {
		log.info("getList");
		return mapper.getList();
	}
	@Override
	public List<BoardVO> getList(Criteria criteria) {
		log.info("getList");
		return mapper.getListWithPaging(criteria);
	}
	
	@Override
	public int getTotal(Criteria criteria){
		log.info("get total count");
		return mapper.getTotalCount(criteria);
	}
	
}
