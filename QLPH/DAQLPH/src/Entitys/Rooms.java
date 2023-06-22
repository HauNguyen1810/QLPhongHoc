package Entitys;

import java.io.Serializable;

public class Rooms implements Serializable{
	private int Id;
	private int AreaId;
	private int RowOfHousesId;
	private String RoomName;
	public Rooms(int id, int areaId, int rowOfHousesId, String roomName) {
		super();
		Id = id;
		AreaId = areaId;
		RowOfHousesId = rowOfHousesId;
		RoomName = roomName;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getAreaId() {
		return AreaId;
	}
	public void setAreaId(int areaId) {
		AreaId = areaId;
	}
	public int getRowOfHousesId() {
		return RowOfHousesId;
	}
	public void setRowOfHousesId(int rowOfHousesId) {
		RowOfHousesId = rowOfHousesId;
	}
	public String getRoomName() {
		return RoomName;
	}
	public void setRoomName(String roomName) {
		RoomName = roomName;
	}
	@Override
	public String toString() {
		return "Rooms [Id=" + Id + ", AreaId=" + AreaId + ", RowOfHousesId=" + RowOfHousesId + ", RoomName=" + RoomName
				+ "]";
	}
	
	
}
