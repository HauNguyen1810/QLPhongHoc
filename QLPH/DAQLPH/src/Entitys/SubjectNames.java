package Entitys;

import java.io.Serializable;

public class SubjectNames implements Serializable{
	private int id;
	private String SubjectName;
	public SubjectNames(int id, String subjectName) {
		super();
		this.id = id;
		SubjectName = subjectName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubjectName() {
		return SubjectName;
	}
	public void setSubjectName(String subjectName) {
		SubjectName = subjectName;
	}
	
	
	
}
