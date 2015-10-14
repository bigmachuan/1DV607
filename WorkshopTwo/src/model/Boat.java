package model;

import java.util.UUID;

public class Boat {
	
	private String id;
	private String type;
	private int length;
	
	
	
	public Boat(){
		id=UUID.randomUUID().toString();
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setType(String type) {
		this.type = type;
	}
	public Boat(String type,int length,String id){
		
		this.type=type;
		this.length=length;
		this.id=id;
		
	}
	
    

	public String getType() {
		return type.toString();
	}

	public void setType(BoatType type) {
		this.type = type.toString();
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	

}
