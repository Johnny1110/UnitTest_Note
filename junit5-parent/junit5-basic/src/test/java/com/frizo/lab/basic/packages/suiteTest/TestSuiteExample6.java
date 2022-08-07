package com.frizo.lab.basic.packages.suiteTest;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludeClassNamePatterns;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages("com.frizo.lab.basic.packages")
@ExcludeClassNamePatterns({".*ATest"})
public class TestSuiteExample6 {}
