//*****************************************************************************
// %name: Login.java %
// Desc :
// 
// Copyright (©) n4
// @author  Marius Ghiga
//*****************************************************************************
package eu.numberfour.automation.tests.login;

import org.junit.Assert;
import org.junit.Test;
import eu.numberfour.automation.tests.AutomationBase;

public class Login extends AutomationBase{

    @Test
    @Override
    public final void login() throws Exception {
        Assert.assertTrue( "Should be logged out!", isLoggedOut() );
        super.login();
        Assert.assertTrue( "Should be logged in!", isLoggedIn() );
        logout();
    }

}
