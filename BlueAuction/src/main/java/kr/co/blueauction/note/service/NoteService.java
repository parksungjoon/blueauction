package kr.co.blueauction.note.service;

import java.util.List;

import kr.co.blueauction.common.domain.SearchCriteria;
import kr.co.blueauction.note.domain.Note;


public interface NoteService {

	/** 족지 보내기*/
	public void sendNote(Note note);

	public List<Note> listByReceiver(String memberId);

	public Note readNote(int noteId);

	public void deleteNote(int noteId);

	public void updateReadDate(int noteId);

	public List<Note> listByCri(SearchCriteria cri, String memberId);

	public int listCountCriteria(SearchCriteria cri, String memberId);

}
