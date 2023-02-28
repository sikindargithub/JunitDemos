package com.trial;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludePackages;
import org.junit.platform.suite.api.IncludePackages;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.testcases.calcapp.CalculatorTest;
import com.testcases.studentapp.trial.UserTest;

@RunWith(JUnitPlatform.class)
//@SelectPackages({"com.testcases.calcapp","com.testcases.studentapp"})
//@IncludePackages("com.testcases.studentapp.trial")
@ExcludePackages("com.testcases.studentapp.trial")
@SelectClasses({UserTest.class,CalculatorTest.class})
public class AllTests {

}

