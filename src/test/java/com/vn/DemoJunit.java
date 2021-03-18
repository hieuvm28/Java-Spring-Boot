package com.vn;

import org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;

public class DemoJunit {
	@Test
	public void testSetup() {
		String str = "Hello World";
		Assert.assertEquals("Hello World",str);
	}
	
}
