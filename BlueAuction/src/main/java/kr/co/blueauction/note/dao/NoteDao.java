package kr.co.blueauction.note.dao;

import java.util.List;

import kr.co.blueauction.common.domain.SearchCriteria;
import kr.co.blueauction.note.domain.Note;

public interface NoteDao {

	public void create(Note note);

	public List<Note> listByReceiver(String memberId);

	public Note readNote(int noteId);

	public void deleteNote(int noteId);

	public void updateReadDate(int noteId);

	public List<Note> listByCri(SearchCriteria cri, String memberId);

	public int countCri(SearchCriteria cri, String memberId);

}
