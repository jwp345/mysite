package com.bit2020.mysite.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2020.mysite.vo.BoardVo;

@Repository
public class BoardRepository {

	@Autowired
	private SqlSession sqlSession;

	public List<BoardVo> findAll() {
		return sqlSession.selectList("board.findAll");
	}

	public boolean save(BoardVo vo) {
		int count = sqlSession.insert("board.save", vo);
		return count == 1;
	}

	public BoardVo findbyNo(long no) {
		return sqlSession.selectOne("board.findbyNo", no);
	}

	public boolean update(BoardVo vo) {
		int count = sqlSession.update("board.update", vo);
		return count == 1;
	}

	public boolean delete(BoardVo vo) {
		int count = sqlSession.delete("board.delete", vo);
		return count==1;
	}

	public boolean hit(long no) {
		int count = sqlSession.update("board.hit", no);
		return count == 1;
	}
	
}
