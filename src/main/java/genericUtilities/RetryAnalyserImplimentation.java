package genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImplimentation implements IRetryAnalyzer {
	int count =0;
	int retryCount =3; //manual analyser
	public boolean retry(ITestResult result )
	{
		
		while(count<retryCount)
		{
			count++;
			return true;//retry retry retry 
		}
		return false;
	}

}
