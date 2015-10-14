package model;

import java.util.ArrayList;
import java.util.UUID;

public class Member implements Comparable<Member>{
	
    private String id;
	private String name;
	private String personalnumber;
	ArrayList<Boat> boats=new ArrayList<Boat>();
	
	public Member(){
		id=UUID.randomUUID().toString();
	}
	public Member(String name,String personalnumber,String id){
		
		this.name=name;
		this.personalnumber=personalnumber;
		this.id=id;
		
	}
	
	

	public String getId() {
		return id;
	}
	
	public void setId(String id){
		
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
