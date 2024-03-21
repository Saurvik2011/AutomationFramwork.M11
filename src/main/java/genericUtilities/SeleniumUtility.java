package genericUtilities;

import java.awt.Desktop.Action;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class SeleniumUtility {
/**
 * This method will maximize the windows
 * @param driver
 */
	
	public void maximizewindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method will minimize the windows
	 * @param driver
	 */
		
		public void minimizewindow(WebDriver driver)
		{
			driver.manage().window().minimize();
		}
		/**
		 * This method will add implicitly wait for 10 secs
		 * @param driver
		 */
			
			public void addImplicitlywait(WebDriver driver)
			{
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			}
			
			/**
			 * This method will wait for 10 secs for web element to visible
			 * @param driver
			 * @param element
			 */
				
				public void waitForElementToBeVisible(WebDriver driver,WebElement element)
				{
					WebDriverWait wait =new WebDriverWait(driver ,Duration.ofSeconds(10));
					wait.until(ExpectedConditions.visibilityOf(element));
				}
				
				/**
				 * This method will wait for 10 secs for web element to Clickable
				 * @param driver
				 * @param element
				 */
					
					public void waitForElementToBeClickable(WebDriver driver,WebElement element)
					{
						WebDriverWait wait =new WebDriverWait(driver ,Duration.ofSeconds(10));
						wait.until(ExpectedConditions.elementToBeClickable(element));
					}
					/**
					 * This method will handle drop down by index
					 * @param driver
					 * @param element
					 */
						
						public void handledropdown(WebElement element,int index)
						{
							Select sel = new Select(element);
							sel.selectByIndex(index);
						}
						/**
						 * This method will handle drop down by value
						 * @param driver
						 * @param element
						 */
							
							public void handledropdown(WebElement element,String value)
							{
								Select sel = new Select(element);
								sel.selectByValue(value);
							}
							/**
							 * This method will handle drop down by visible text
							 * @param driver
							 * @param element
							 */
								
								public void handledropdown(String text,WebElement element)
								{
									Select sel = new Select(element);
									sel.selectByVisibleText(text);
								}
								/**
								 * This method will handle Mouse hovering action on a web element  
								 * @param driver
								 * @param element
								 */
									
									public void mouseOverAction(WebDriver driver,WebElement element)
									{
										
										Actions act = new Actions(driver);
										act.moveToElement(element).perform();
										 
									}
									/**
									 * This method will handle double click action on a web element  
									 * @param driver
									 * @param element
									 */
										
										public void doubleClickAction(WebDriver driver,WebElement element)
										{
											
											Actions act = new Actions(driver);
											act.doubleClick().perform();
											 
										}
										/**
										 * This method will handle right click action on a web element  
										 * @param driver
										 * @param element
										 */
											
											public void rightClickAction(WebDriver driver,WebElement element)
											{
												
												Actions act = new Actions(driver);
												act.contextClick().perform();
												 
											}
											/**
											 * This method will handle drag and drop  action on a web element  
											 * @param driver
											 * @param element
											 */
												
												public void dragAndDropAction(WebDriver driver,WebElement src,WebElement target)
												{
													
													Actions act = new Actions(driver);
													act.dragAndDrop(src , target).perform();
													 
												}
												/**
												 * This method will handle frames by index on a web element  
												 * @param driver
												 * @param element
												 */
													
													public void switchToFrame(WebDriver driver,WebElement frameElement)
													{
														
														driver.switchTo().frame(frameElement);

														 
													}
													/**
													 * This method will handle frames by Names or Id  on a web element  
													 * @param driver
													 * @param element
													 */
														
														public void framesbyNameorId(WebDriver driver,WebElement src,WebElement target)
														{
															
															driver.switchTo().frame("iframe1");
															driver.switchTo().frame("id of the element");
															 
														}
														/**
														 * This method will handle frames by Web element   on a web element  
														 * @param driver
														 * @param element
														 */
															
															public void framesbyWebElement(WebDriver driver,WebElement element)
															{
																
																driver.switchTo().frame(element);
																 
															}
															/**
															 * This method will handle Alert by dismiss   on a web element  
															 * @param driver
															 * @param element
															 */
																
																public void alertDismiss(WebDriver driver,WebElement element)
																{
																	
																	driver.switchTo().alert().dismiss();
																	 
																}
																/**
																 * This method will handle Alert by Accept   on a web element  
																 * @param driver
																 * @param element
																 */
																	
																	public void alertAccepts(WebDriver driver,WebElement element)
																	{
																		
																		driver.switchTo().alert().accept();
																		 
																	}
																	/**
																	 * This method will handle Alert by get string   on a web element  
																	 * @param driver
																	 * @param element
																	 */
																		
																		public String alertGetStringtext(WebDriver driver,WebElement element,String text)
																		{
																			
																			return driver.switchTo().alert().getText();
																			 
																		}
																		/**
																		 * This method will handle Alert by passing data    on a web element  
																		 * @param driver
																		 * @param element
																		 */
																			
																			public void alertPassingData(WebDriver driver,WebElement element,String text)
																			{
																				
																				driver.switchTo().alert().sendKeys("Text");
																				 
																			}
																			/**
																			 * This method will handle scroll down on a web element  
																			 * @param driver
																			 * @param element
																			 */
																				
																				public void scrollDown(WebDriver driver,WebElement element,String text)
																				{
																					
																					
																					JavascriptExecutor jse = (JavascriptExecutor)driver;
																					jse.executeScript("window.scrollBy(0,250)","");
																					 
																				}
																				/**
																				 * This method will handle scroll up on a web element  
																				 * @param driver
																				 * @param element
																				 */
																					
																					public void scrollUp(WebDriver driver,WebElement element,String text)
																					{
																						
																						
																						JavascriptExecutor jse = (JavascriptExecutor)driver;
																						
																						jse.executeScript("window.scrollBy(0,-250)","");
																						 
																					}
																					/**
																					 * This method will take screenshot and store in required location 
																					 * @param driver
																					 * @param element
																					 */
																						
																						public String captureScreenshot(WebDriver driver,String screenshotname) throws IOException
																						{
																							
																						TakesScreenshot ts = (TakesScreenshot)driver;
																						File src=ts.getScreenshotAs(OutputType.FILE);
																						File dest =	new File(".\\Screenshots\\"+screenshotname+".png");
																						Files.copy(src,dest);
																							return dest.getAbsolutePath();//used in extent reports
																							 
																						}
}
