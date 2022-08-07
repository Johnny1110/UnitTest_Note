package com.frizo.lab.basic.packages.suiteTest;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeClassNamePatterns;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages("com.frizo.lab.basic.packages")
@IncludeClassNamePatterns({".*ATest"})
public class TestSuiteExample5 {}
