package com.trial;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(JUnitPlatform.class)
// use tags
@SelectPackages({"com.testcases"})
@IncludeTags({"creation","check"})
public class AllTagTests {

}
