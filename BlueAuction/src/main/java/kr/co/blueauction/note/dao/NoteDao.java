/**
 * Copyright(c) 2017, BlueAuction. All right reserved
 * @author 박성준
 * @since 2017. 11. 22.
 */
package kr.co.blueauction.note.dao;

import java.util.List;

import kr.co.blueauction.common.domain.Criteria;
import kr.co.blueauction.note.domain.Note;

/**
 * Note Dao InterFace
 * @author 박성준
 * @since 2017. 11. 22.
 */
public interface NoteDao {
	
	/**쪽지쓰기*/
	public void create(Note note);

	/** 쪽지받는사람에 따른 쪽지 리스트 */
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
