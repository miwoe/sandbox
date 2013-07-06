package mwoelm.sample;

public class MyObject {
	private int counter = 0 ;
	private static int c = 0;
	
	public MyObject() {
		this.counter = ++c;
	}
	
	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
	

	public String toString() {
		return ""+this.counter;
	}
	
}
