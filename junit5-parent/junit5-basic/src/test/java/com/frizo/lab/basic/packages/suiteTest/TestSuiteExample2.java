package com.frizo.lab.basic.packages.suiteTest;

import com.frizo.lab.basic.packages.packageA.ClassATest;
import com.frizo.lab.basic.packages.packageB.ClassBTest;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({ClassATest.class, ClassBTest.class})
public class TestSuiteExample2 {}
