package kr.co.blueauction.note.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.blueauction.common.domain.Criteria;
import kr.co.blueauction.common.domain.SearchCriteria;
import kr.co.blueauction.note.dao.NoteDao;
import kr.co.blueauction.note.domain.Note;

@Service
public class NoteServiceImpl implements NoteService {
	
	@Inject
	private NoteDao noteDao;

	@Override
	public void sendNote(Note note) {
		noteDao.create(note);
		
	}

	@Override
	public List<Note> listByReceiver(String memberId) {
		return noteDao.listByReceiver(memberId);
	}

	@Override
	public Note readNote(int noteId) {
		// TODO Auto-generated method stub
		return noteDao.readNote(noteId);
	}

	@Override
	public void deleteNote(int noteId) {
		 noteDao.deleteNote(noteId);
	}

	@Override
	public void updateReadDate(int noteId) {
		noteDao.updateReadDate(noteId);
		
	}

	@Override
	public List<Note> listByCri(Criteria cri, String memberId) {
		// TODO Auto-generated method stub
		return noteDao.listByCri(cri, memberId);
	}

	@Override
	public int listCountCriteria(Criteria cri, String memberId) {
		// TODO Auto-generated method stub
		return noteDao.countCri(cri,memberId);
	}

}
