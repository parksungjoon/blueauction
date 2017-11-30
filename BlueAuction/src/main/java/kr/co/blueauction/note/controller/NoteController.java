/**
 * Copyright(c) 2017, BlueAuction. All right reserved
 * @author 박성준
 * @since 2017. 11. 22.
 */
package kr.co.blueauction.note.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.blueauction.note.domain.Note;
import kr.co.blueauction.note.service.NoteService;

/**
 * Note관련 기능 Controller
 * @author 박성준
 * @since 2017. 11. 22.
 */
@RequestMapping("/note")
@Controller
public class NoteController {
	
	@Inject
	private NoteService noteService;
	
	Logger logger=Logger.getLogger(NoteController.class);
	
	/**
	 * 쪽지리스트 조회
	 * @param receiver
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/{receiver}", method = RequestMethod.GET)
	public String notePageGet(@PathVariable("receiver") String receiver,Model model, HttpSession session)throws Exception{
		model.addAttribute("receiver", receiver);
		
		return "note/noteregister";
	}
	
	/**
	 * 쪽지 보내기
	 * @param note
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody Note note){
		
		/*logger.info("쪽지 데이터 들어옴"+note.toString());*/
		ResponseEntity<String> entity=null;
		
		try {
			noteService.sendNote(note);
		entity=new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		}catch(Exception e) {
		entity=new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);	
		}
		return entity;
	}

}
