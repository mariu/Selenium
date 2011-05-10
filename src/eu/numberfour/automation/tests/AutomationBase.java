//*****************************************************************************
// %name: AutomationBase.java %
// Desc :
// 
// Copyright (©) n4
// @author  Marius Ghiga
//*****************************************************************************
package eu.numberfour.automation.tests;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import com.thoughtworks.selenium.Selenium;

import eu.numberfour.automation.utils.Constants;

public class AutomationBase
{
    
    protected static Selenium selenium;

    static
    {
        Runtime.getRuntime().addShutdownHook( new Thread( new Runnable()
        {
            public void run()
            {
                if ( selenium != null )
                {
                    selenium.stop();
                    selenium = null;
                }
            }
        } ) );

        selenium = new MySelenium ( "localhost", 4444, "*firefox", "http://www.facebook.com/" );
        // selenium = new DefaultSelenium(
        // "ondemand.saucelabs.com",
        // 80,
        // "{\"username\": \"mariu\"," +
        // "\"access-key\": \"14d6410d-acab-41a9-81b8-b16bf98ab44d\"," +
        // "\"os\": \"Windows 2003\"," +
        // "\"browser\": \"firefox\"," +
        // "\"browser-version\": \"3.6.\"," +
        // "\"name\": \"Facebook\"}",
        // "http://facebook.com/");
        selenium.start();
        selenium.setSpeed( Constants.SPEED );
    }
    
    /**
     * @throws Exception
     */
    protected void login() throws Exception {
        // TODO: uncheck keep me logged in      
        selenium.open("/");
        
        selenium.type("email", "marius.ghiga@gmail.com");
        selenium.type("pass", "numberfour");

        selenium.click("//input[@value='Login']");
        selenium.waitForPageToLoad("30000");
      
    }
    
    /**
     * @throws Exception
     */
    protected void logout() throws Exception {
        
        selenium.click("//li[@id='navAccount']/a[@id='navAccountLink']");
        selenium.click("//li[@id='navAccount']/ul/li/form[@id='logout_form']/label/input");
    }
    
    /**
     * @throws Exception
     */
    protected void changeStatus () throws Exception 
    {
        // Pressing 'News Feed' link again as this might not always be the default selected page
        selenium.open("/?sk=nf");
        selenium.waitForPageToLoad("30000");
        selenium.click("//li[@id='navItem_nf']/a/span[3]");
        selenium.waitForPageToLoad("30000");
        String expectedText = new Date().toString();
        selenium.type("//div[@id='contentArea']/div[@id='pagelet_composer']/div/div/div/form/div[2]/div[1]/div/div/div[1]/div/textarea", expectedText);
        selenium.click("link=Everyone");
        selenium.click("link=Friends of Friends");
        selenium.click("//div/div/div/ul/li[2]/a/span");
        selenium.click("//input[@value='Share']");

        Thread.sleep( 1000 ); // remember 'waitForTextPresent'
        
        selenium.isTextPresent(expectedText);
        String actualText = selenium.getText( "//ul[@id='home_stream']/li/div/div/div/div/h6/span");
        assertEquals( "Status message not found: ", expectedText, actualText );
        
        // TODO: move verification to a separate method
        
    }
    
    /**
     * @return
     */
    protected Boolean isLoggedIn ()
    {
        return true;
    }
    
    /**
     * @return
     */
    protected Boolean isLoggedOut ()
    {
        return true;
    }
    
//  @BeforeClass
//  public static void startSelenium()
//  {
//      selenium = new DefaultSelenium( "localhost", 4444, "*firefox", "http://www.facebook.com/" );
//      selenium.start();
//
//  }
//
//  @AfterClass
//  public static void stopSelenium()
//  {
//      selenium.stop();
//  }

}
