package com.cjc.tesng;

import org.testng.ISuite;

public class UsingISuiteListner  implements ISuiteListners{
	public void OnStart(ISuite s) {
		System.out.println("This is ISuite on Start method");
	}

	public void Onfinish(ISuite s) {
		System.out.println("This is on Finish method");
	}
}
