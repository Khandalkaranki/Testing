package com.cjc.tesng;

import org.testng.annotations.Test;

public class SamePriorityExample {
	@Test(priority=1)
	public void add() {
		System.out.println("This is add method");
	}
    @Test(priority=-1)
    public void sub() {
    	System.out.println("This is sub method");
    }
    @Test(priority=2)
    public void mul() {
    	System.out.println("this is mul method");
    }
    @Test(priority=3)
    public void div() {
    	System.out.println("this is div method");
    }
    @Test(priority=4)
    public void AreaOfTriangle() {
    	System.out.println("This is areaOfTrinagle");
    }
    @Test(priority=-2)
    public void AreaOfCirlce() {
    	System.out.println("This is areaofcircle");
    }
    @Test(priority=2)
    public void AreaofParallelogram() {
    	System.out.println("This is areaofparellelogram");
    }
    @Test(priority=5)
    public void AreaofTrapazium() {
    	System.out.println("This is areaoftrapazium");
    }
	
}
