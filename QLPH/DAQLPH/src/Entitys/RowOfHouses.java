package Entitys;

import java.io.Serializable;

public class RowOfHouses implements Serializable{
	private int id;
	private String name;
	public RowOfHouses(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "RowOfHouses [id=" + id + ", name=" + name + "]";
	}
	
}
