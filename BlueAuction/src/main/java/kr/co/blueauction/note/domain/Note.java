package kr.co.blueauction.note.domain;

public class Note {

	  private int noteId; 
	  private String sender; 
	  private String receiver;  
	  private String subject; 
	  private String content; 
	  private String readdate; 
	  private String regdate; 
	  private String deletestatus;
	
	  public Note() {
	}

	public Note(int noteId, String sender, String receiver, String subject, String content, String readdate,
			String regdate, String deletestatus) {
		super();
		this.noteId = noteId;
		this.sender = sender;
		this.receiver = receiver;
		this.subject = subject;
		this.content = content;
		this.readdate = readdate;
		this.regdate = regdate;
		this.deletestatus = deletestatus;
	}

	public int getNoteId() {
		return noteId;
	}

	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReaddate() {
		return readdate;
	}

	public void setReaddate(String readdate) {
		this.readdate = readdate;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getDeletestatus() {
		return deletestatus;
	}

	public void setDeletestatus(String deletestatus) {
		this.deletestatus = deletestatus;
	}

	@Override
	public String toString() {
		return "Note [noteId=" + noteId + ", sender=" + sender + ", receiver=" + receiver + ", subject=" + subject
				+ ", content=" + content + ", readdate=" + readdate + ", regdate=" + regdate + ", deletestatus="
				+ deletestatus + "]";
	}  
}
