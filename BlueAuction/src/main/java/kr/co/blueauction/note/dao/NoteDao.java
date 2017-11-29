package kr.co.blueauction.note.dao;

import java.util.List;

import kr.co.blueauction.common.domain.Criteria;
import kr.co.blueauction.common.domain.SearchCriteria;
import kr.co.blueauction.note.domain.Note;

public interface NoteDao {
	/**쪽지쓰기*/
	public void create(Note note);

	public List<Note> listByReceiver(String memberId);
	/**쪽지읽기*/
	public Note readNote(int noteId);
	/**쪽지삭제*/
	public void deleteNote(int noteId);
	/**쪽지읽은 날짜 업데이트*/
	public void updateReadDate(int noteId);
	/**쪽지 목록 출력*/
	public List<Note> listByCri(Criteria cri, String memberId);
	/**쪽지 전체 카운트*/
	public int countCri(Criteria cri, String memberId);

}
