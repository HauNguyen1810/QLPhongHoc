package Entitys;

import java.io.Serializable;

public class RoomDetails implements Serializable{
	private int Roomid;
	private String date;
	private int ClassNameId;
	private int SubjectNameId;
	public RoomDetails(int roomid, String date, int classNameId, int subjectNameId) {
		super();
		Roomid = roomid;
		this.date = date;
		ClassNameId = classNameId;
		SubjectNameId = subjectNameId;
	}
	public int getRoomid() {
		return Roomid;
	}
	public void setRoomid(int roomid) {
		Roomid = roomid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getClassNameId() {
		return ClassNameId;
	}
	public void setClassNameId(int classNameId) {
		ClassNameId = classNameId;
	}
	public int getSubjectNameId() {
		return SubjectNameId;
	}
	public void setSubjectNameId(int subjectNameId) {
		SubjectNameId = subjectNameId;
	}
	@Override
	public String toString() {
		return "RoomDetails [Roomid=" + Roomid + ", date=" + date + ", ClassNameId=" + ClassNameId + ", SubjectNameId="
				+ SubjectNameId + "]";
	}

	
	
}
