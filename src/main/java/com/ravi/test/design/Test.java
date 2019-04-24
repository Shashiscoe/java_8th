package com.ravi.test.design;

public class Test {
	private Parent p;
	
	public Test(Parent p) {
		this.p = p;
	}
	
	public void methodCall() {
		p.pDisp();
	}
	
	
	public static void main(String[] args) {
		Parent p = new Parent();
		Parent p1 = new Child();
		p1.pDisp();
		Child c = new Child();
		Test t = new Test(c);
	}
	
	
	
}
