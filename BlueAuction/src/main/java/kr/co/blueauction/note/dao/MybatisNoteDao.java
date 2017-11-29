package kr.co.blueauction.note.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.blueauction.common.domain.Criteria;
import kr.co.blueauction.common.domain.SearchCriteria;
import kr.co.blueauction.note.domain.Note;

@Repository
public class MybatisNoteDao implements NoteDao {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="kr.co.blueauction.mapper.noteMapper";
	
	@Override
	public void create(Note note) {
		sqlSession.insert(namespace+".send",note);
	}

	@Override
	public List<Note> listByReceiver(String memberId) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".notelist",memberId);
	}

	@Override
	public Note readNote(int noteId) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".noteRead",noteId);
	}

	@Override
	public void deleteNote(int noteId) {
		sqlSession.delete(namespace+".noteDelete",noteId);
		
	}

	@Override
	public void updateReadDate(int noteId) {
		sqlSession.update(namespace+".updateReadDate",noteId);
		
	}

	@Override
	public List<Note> listByCri(Criteria cri, String memberId) {
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("cri", cri);
		paramMap.put("memberId", memberId);
		return sqlSession.selectList(namespace+".listByCri",paramMap);
	}

	@Override
	public int countCri(Criteria cri, String memberId) {
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("cri", cri);
		paramMap.put("memberId", memberId);
		return sqlSession.selectOne(namespace+".listCount",paramMap);
	}

}
