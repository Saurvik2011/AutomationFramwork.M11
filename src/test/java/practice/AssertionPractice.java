package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {
	
	@Test
	public void sample()
	{
		String a="Hi";
		System.out.println("step1");
		System.out.println("step2");
		System.out.println("step3");
		//Assert.assertEquals("a", "a");
		//Assert.assertEquals(1, 1);
		//Assert.assertTrue(a.contains("I"));
		System.out.println("step4");
		System.out.println("step5");
	}
	@Test
	public void sample1()
	{
		SoftAssert sa = new SoftAssert();
		
		String a="Hi";
		System.out.println("step1");
		sa.assertTrue(true);
		System.out.println("step2");
		System.out.println("step3");
		sa.assertEquals(1,1);
		//Assert.assertEquals("a", "a");
		//Assert.assertEquals(1, 1);
		//Assert.assertTrue(a.contains("I"));
		System.out.println("step4");
		System.out.println("step5");
		sa.assertAll();
	}
}
