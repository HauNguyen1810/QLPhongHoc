package Entitys;

import java.io.Serializable;

public class ClassNames implements Serializable{
	private int id;
	private String ClassName;
	public ClassNames(int id, String className) {
		super();
		this.id = id;
		ClassName = className;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClassName() {
		return ClassName;
	}
	public void setClassName(String className) {
		ClassName = className;
	}
	@Override
	public String toString() {
		return "ClassNames [id=" + id + ", ClassName=" + ClassName + "]";
	}
	
	
}
