/**
 * Copyright(c) 2017, BlueAuction. All right reserved
 * @author 박성준
 * @since 2017. 11. 22.
 */
package kr.co.blueauction.note.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.blueauction.common.domain.Criteria;
import kr.co.blueauction.note.domain.Note;

/**
 * Note Dao
 * @author 박성준
 * @since 2017. 11. 22.
 */
@Repository
public class MybatisNoteDao implements NoteDao {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="kr.co.blueauction.mapper.noteMapper";
	
	/* 
	 * 쪽지 보내기
	 * @param Note
	 * @see kr.co.blueauction.note.dao.NoteDao#create(kr.co.blueauction.note.domain.Note)
	 */
	@Override
	public void create(Note note) {
		sqlSession.insert(namespace+".send",note);
	}

	/* 
	 * 쪽지 받는사람에 따른 쪽지 리스트
	 * @param memberId
	 * @return List<Note>
	 * @see kr.co.blueauction.note.dao.NoteDao#create(kr.co.blueauction.note.domain.Note)
	 */
	@Override
	public List<Note> listByReceiver(String memberId) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".notelist",memberId);
	}

	/* 
	 * 쪽지번호로 쪽지 조회
	 * @param noteId
	 * @return Note
	 * @see kr.co.blueauction.note.dao.NoteDao#create(kr.co.blueauction.note.domain.Note)
	 */
	@Override
	public Note readNote(int noteId) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".noteRead",noteId);
	}

	/* 
	 * 쪽지번호로 쪽지 삭제
	 * @param noteId
	 * @see kr.co.blueauction.note.dao.NoteDao#create(kr.co.blueauction.note.domain.Note)
	 */
	@Override
	public void deleteNote(int noteId) {
		sqlSession.delete(namespace+".noteDelete",noteId);
		
	}

	/* 
	 * 쪽지번호로 쪽지 수정
	 * @param noteId
	 * @see kr.co.blueauction.note.dao.NoteDao#create(kr.co.blueauction.note.domain.Note)
	 */
	@Override
	public void updateReadDate(int noteId) {
		sqlSession.update(namespace+".updateReadDate",noteId);
		
	}

	/* 
	 * 회원아이디, Cri에 따른 쪽지 조회
	 * @param Criteria, memberId
	 * @return List<Note>
	 * @see kr.co.blueauction.note.dao.NoteDao#create(kr.co.blueauction.note.domain.Note)
	 */
	@Override
	public List<Note> listByCri(Criteria cri, String memberId) {
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("cri", cri);
		paramMap.put("memberId", memberId);
		return sqlSession.selectList(namespace+".listByCri",paramMap);
	}

	/* 
	 * 회원아이디, Cri에 따른 쪽지 수
	 * @param Criteria, memberId
	 * @return int
	 * @see kr.co.blueauction.note.dao.NoteDao#create(kr.co.blueauction.note.domain.Note)
	 */
	@Override
	public int countCri(Criteria cri, String memberId) {
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("cri", cri);
		paramMap.put("memberId", memberId);
		return sqlSession.selectOne(namespace+".listCount",paramMap);
	}

}
