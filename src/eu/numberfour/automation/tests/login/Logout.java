//*****************************************************************************
// %name: Logout.java %
// Desc :
// 
// Copyright (©) n4
// @author  Marius Ghiga
//*****************************************************************************
package eu.numberfour.automation.tests.login;

import org.junit.Assert;
import org.junit.Test;
import eu.numberfour.automation.tests.AutomationBase;

public class Logout extends AutomationBase{

    @Test
    @Override
    public void logout() throws Exception {
        // if we are here, login is already tested
        login();
        Assert.assertTrue( "Should be logged in!", isLoggedIn() );
        super.logout();
        Assert.assertTrue( "Should be logged out!", isLoggedOut() );
    }

}
