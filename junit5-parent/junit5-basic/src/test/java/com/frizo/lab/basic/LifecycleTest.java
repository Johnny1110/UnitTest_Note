package com.frizo.lab.basic;

import org.junit.jupiter.api.*;

public class LifecycleTest {

    private static Calculator calculator;

    @BeforeAll // 在標註 @Test @RepeatedTest 方法執行前執行一次 (總共只執行一次)，通常用來作事前準備。
    public static void setup() {
        System.out.println("@BeforeAll executed.");
        calculator = new Calculator();
        System.out.println("----------------------");
    }

    @BeforeEach // 在標註 @Test @RepeatedTest 方法執行前執行一次 (因 @Test 數量可被執行多次)。
    public void setupThis() {
        System.out.println("@BeforeEach executed.");
        System.out.println("----------------------");
    }

    @Test // 一般單元測試，TestInfo 由 JUnit5 框架傳入。
    public void testCommon(TestInfo testInfo) {
        System.out.println("@Test executed: " + testInfo.getTestMethod().get());
        Assertions.assertEquals(4, calculator.add(2, 2));
        System.out.println("----------------------");
    }

    @RepeatedTest(3) // 可指定測試次數的 @Test，可以由 RepetitionInfo 得知目前是第幾次。
    public void testRepeat(RepetitionInfo repetitionInfo) {
        System.out.println("@RepeatedTest executed: " + repetitionInfo.getCurrentRepetition());
        Assertions.assertEquals(2, calculator.add(1, 1), "1 + 1 = 2");
        System.out.println("----------------------");
    }

    @Disabled // 相當於被刪掉了
    @Test
    public void testDisable() {
        System.out.println("@Disabled executed.");
        Assertions.assertEquals(6, calculator.add(3, 3), "3 + 3 = 6");
        System.out.println("----------------------");
    }

    @AfterEach // 會在所有標註 @Test 與 @RepeatedTest 的測試方法執行後都執行一次 (因 @Test 數量可被執行多次)。
    public void tearThis() {
        System.out.println("@AfterEach executed.");
        System.out.println("distoryed something...");
        System.out.println("----------------------");
    }

    @AfterAll // 會在所有標註 @Test 與 @RepeatedTest 的測試方法執行後執行一次 (總共執行一次)。
    static void tearDown() {
        System.out.println("@AfterAll executed.");
        System.out.println("distoryed something...");
        System.out.println("----------------------");
    }

}
