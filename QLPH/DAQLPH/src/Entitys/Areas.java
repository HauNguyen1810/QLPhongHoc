package Entitys;

import java.io.Serializable;

public class Areas implements Serializable{
	private int Id;
	private String AreaName;
	public Areas(int id, String areaName) {
		super();
		Id = id;
		AreaName = areaName;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getAreaName() {
		return AreaName;
	}
	public void setAreaName(String areaName) {
		AreaName = areaName;
	}
	@Override
	public String toString() {
		return "Areas [Id=" + Id + ", AreaName=" + AreaName + "]";
	}
	
}
