package com.frizo.lab.basic.packages.suiteTest;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludePackages;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages("com.frizo.lab.basic.packages")
@IncludePackages("com.frizo.lab.basic.packages.packageA")
public class TestSuiteExample3 {}
