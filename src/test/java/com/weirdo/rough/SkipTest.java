package com.weirdo.rough;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class SkipTest {

	
	@Test
	public void skipTest()
	{
		throw new SkipException("Skipping the test");
	}
}
