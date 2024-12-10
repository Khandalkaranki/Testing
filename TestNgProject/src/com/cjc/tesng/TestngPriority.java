package com.cjc.tesng;

import org.testng.annotations.Test;

public class TestngPriority {

	@Test
	public void add() {
		System.out.println("This is add method");
	}
	@Test(priority =1)
	public void sub() {
		System.out.println("This is sub method");
		
	}
    @Test(priority=2)
     public void mul() {
    	System.out.println("This is mul method");
    }
    @Test(priority=-1)
    public void div() {
    	System.out.println("This is div method");
    }
}
