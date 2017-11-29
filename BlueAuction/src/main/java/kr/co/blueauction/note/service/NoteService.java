package kr.co.blueauction.note.service;

import java.util.List;

import kr.co.blueauction.common.domain.Criteria;
import kr.co.blueauction.common.domain.SearchCriteria;
import kr.co.blueauction.note.domain.Note;


public interface NoteService {

	/** 족지 보내기*/
	public void sendNote(Note note);

	public List<Note> listByReceiver(String memberId);
	/**쪽지 읽기*/
	public Note readNote(int noteId);
	/**쪽지 삭제*/
	public void deleteNote(int noteId);
	/**쪽지 읽은 날짜 수정*/
	public void updateReadDate(int noteId);
	/**쪽지 리스트 출력*/
	public List<Note> listByCri(Criteria cri, String memberId);
	/**쪽지 전체 갯수 */
	public int listCountCriteria(Criteria cri, String memberId);

}
