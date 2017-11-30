/**
 * Copyright(c) 2017, BlueAuction. All right reserved
 * @author 박성준
 * @since 2017. 11. 22.
 */
package kr.co.blueauction.note.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.blueauction.common.domain.Criteria;
import kr.co.blueauction.note.dao.NoteDao;
import kr.co.blueauction.note.domain.Note;

/**
 * Note Service
 * @author 박성준
 * @since 2017. 11. 22.
 */
@Service
public class NoteServiceImpl implements NoteService {
	
	@Inject
	private NoteDao noteDao;

	/* 
	 * 쪽지 보내기
	 * @param Note
	 * @see kr.co.blueauction.note.dao.NoteDao#create(kr.co.blueauction.note.domain.Note)
	 */
	@Override
	public void sendNote(Note note) {
		noteDao.create(note);
	}

	/* 
	 * 쪽지 받는사람에 따른 쪽지 리스트
	 * @param memberId
	 * @return List<Note>
	 * @see kr.co.blueauction.note.dao.NoteDao#create(kr.co.blueauction.note.domain.Note)
	 */
	@Override
	public List<Note> listByReceiver(String memberId) {
		return noteDao.listByReceiver(memberId);
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
		return noteDao.readNote(noteId);
	}

	/* 
	 * 쪽지번호로 쪽지 삭제
	 * @param noteId
	 * @see kr.co.blueauction.note.dao.NoteDao#create(kr.co.blueauction.note.domain.Note)
	 */
	@Override
	public void deleteNote(int noteId) {
		 noteDao.deleteNote(noteId);
	}

	/* 
	 * 쪽지번호로 쪽지 수정
	 * @param noteId
	 * @see kr.co.blueauction.note.dao.NoteDao#create(kr.co.blueauction.note.domain.Note)
	 */
	@Override
	public void updateReadDate(int noteId) {
		noteDao.updateReadDate(noteId);
		
	}

	/* 
	 * 회원아이디, Cri에 따른 쪽지 조회
	 * @param Criteria, memberId
	 * @return List<Note>
	 * @see kr.co.blueauction.note.dao.NoteDao#create(kr.co.blueauction.note.domain.Note)
	 */
	@Override
	public List<Note> listByCri(Criteria cri, String memberId) {
		// TODO Auto-generated method stub
		return noteDao.listByCri(cri, memberId);
	}

	/* 
	 * 회원아이디, Cri에 따른 쪽지 수
	 * @param Criteria, memberId
	 * @return int
	 * @see kr.co.blueauction.note.dao.NoteDao#create(kr.co.blueauction.note.domain.Note)
	 */
	@Override
	public int listCountCriteria(Criteria cri, String memberId) {
		// TODO Auto-generated method stub
		return noteDao.countCri(cri,memberId);
	}

}
