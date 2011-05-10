//*****************************************************************************
// %name: AllTests.java %
// Desc :
// 
// Copyright (©) n4
// @author  
//*****************************************************************************
package eu.numberfour.automation.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import eu.numberfour.automation.tests.login.Logout;
import eu.numberfour.automation.tests.login.Login;
import eu.numberfour.automation.tests.status.ChangeStatus;

// specify a runner class: Suite.class
@RunWith(Suite.class)

// specify an array of test classes
@Suite.SuiteClasses({
  Login.class, 
  Logout.class,
  ChangeStatus.class,
}
)

// the actual class is empty
public class AllTests {
}

// java -cp .;junit-4.4.jar org.junit.runner.JUnitCore AllTests

