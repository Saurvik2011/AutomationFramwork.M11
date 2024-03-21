package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

@Test
public class TestNGPractice {
	
	@Test
	public void createContact()
{
		Assert.fail();
	System.out.println("Create");	
}
	@Test(dependsOnMethods="createContact")
	public void modifyContact()
	{
		System.out.println("Modify");
	}
	@Test
	public void DeleteContact()
	{
		System.out.println("Delete");
	}
}
