package practice;

import org.testng.Assert;

import org.testng.annotations.Test;

import genericUtilities.RetryAnalyserImplimentation;

public class RetryAnalyserPractice {
	@Test(retryAnalyzer =genericUtilities.RetryAnalyserImplimentation.class)
	
	public void retryAnalyser()
	{
		Assert.fail();
		System.out.println("Hi");
	}

}
