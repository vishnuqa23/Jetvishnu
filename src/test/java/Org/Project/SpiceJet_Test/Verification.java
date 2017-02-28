package Org.Project.SpiceJet_Test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Verification {
  @Test
  public void f() {
	  System.out.println("success");
  }
  @BeforeTest
  public void beforeTest() {
	  
	  System.out.println("login");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("logout");
  }

}
