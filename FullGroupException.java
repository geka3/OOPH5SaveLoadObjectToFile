package net.ukr.geka3;

public class FullGroupException extends Exception {
	String str = "";
	public FullGroupException(String str) {
		// TODO Auto-generated constructor stub
		this.str = str;
		
	}
	
	public String toString(){
		return str;
	}
}
