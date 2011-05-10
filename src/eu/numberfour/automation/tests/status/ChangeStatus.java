//*****************************************************************************
// %name: ChangeStatus.java %
// Desc :
// 
// Copyright (©) n4
// @author Marius Ghiga
//*****************************************************************************
package eu.numberfour.automation.tests.status;

import org.junit.Test;

import eu.numberfour.automation.tests.AutomationBase;

public class ChangeStatus extends AutomationBase {
    
    
    @Test
    public void changeStatus() throws Exception {
        login();
        super.changeStatus();       
        logout();
// TODO: add verifications        
        
    

    }

}

