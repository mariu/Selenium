// *****************************************************************************
// %name: MySelenium.java %
// Desc :
//
// Copyright (©) http://functionaltestautomation.blogspot.com/2010/05/extending-default-selenium.html 
// @author Mahesh Narayanan
// *****************************************************************************
package eu.numberfour.automation.tests;

import com.thoughtworks.selenium.DefaultSelenium;

/**
 * Should be removed
 * I used it just to better identify which element is actually clicked, during code testing 
 * 
 */
public class MySelenium extends DefaultSelenium
{

    public MySelenium( String seleniumSeverHost,
            int port,
            String browserString,
            String autURL )
    {
        super( seleniumSeverHost, port, browserString, autURL );
    }

    @Override
    public void click( String target )
    {
        try
        {
            for ( int i = 0; i < 3; i++ )
            {
                super.highlight( target );
                Thread.sleep( 500 );
            }

            super.click( target );
        }
        catch ( Exception e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void type( String target, String value )
    {
        try
        {
            for ( int i = 0; i < 3; i++ )
            {
                super.highlight( target );
                Thread.sleep( 500 );
            }
            super.type( target, value );
        }
        catch ( Exception e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
