package com.frizo.lab.basic.packages.suiteTest;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;


import org.junit.platform.runner.JUnitPlatform;

@RunWith(JUnitPlatform.class)
@SelectPackages({"com.frizo.lab.basic.packages.packageA", "com.frizo.lab.basic.packages.packageB"})
public class TestSuiteExample1 {
}
