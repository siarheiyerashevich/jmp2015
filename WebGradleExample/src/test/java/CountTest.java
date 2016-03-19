package test.java;

import org.junit.Assert;
import org.junit.Test;

import main.java.Count;

public class CountTest {

	@Test
	public void testCount() {
		System.out.println("Running test.");
		Assert.assertEquals(10, Count.count(5, 5));
	}

}
