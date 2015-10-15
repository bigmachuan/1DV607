package controller;

public class Counter {
	
	int count=0;
	
	public Counter(){
		
	}
	
	public void add(){
		count++;
	}
	
	public boolean check(){
		return count>5;
	}
	
	public void reset(){
		count=0;
	}
	

}
