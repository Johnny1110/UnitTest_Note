package com.frizo.lab.basic.packages.suiteTest;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludePackages;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages("com.frizo.lab.basic.packages")
@ExcludePackages("com.frizo.lab.basic.packages.packageA")
public class TestSuiteExample4 {}
