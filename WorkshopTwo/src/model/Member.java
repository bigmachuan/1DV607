package model;

import java.util.ArrayList;
import java.util.UUID;

public class Member implements Comparable<Member>{
	
    private UUID id;
	private String name;
	private String personalnumber;
	ArrayList<Boat> boats=new ArrayList<Boat>();
	
	public Member(){
		id=UUID.randomUUID();
	}
	

	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id){
		
		this.id=id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPersonalnumber() {
		return personalnumber;
	}

	public void setPersonalnumber(String personalnumber) {
		this.personalnumber = personalnumber;
	}

	public ArrayList<Boat> getboats(){
		
		return boats;
		
	}


	@Override
	public int compareTo(Member o) {
		
		return this.getPersonalnumber().compareTo(o.getPersonalnumber());
	}

}
