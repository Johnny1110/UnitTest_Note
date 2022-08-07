# 單元測試生命週期

<br>

---

<br>

JUnit 5 測試生命週期主要由 4 各標註類別所標註的方法控制：

* `@BeforeAll`

* `@BeforeEach`

* `@AfterAll`

* `@AfterEach`

<br>

實際執行測試的方法則以 `@Test` 或 `@RepeatedTest` 標註。

<br>
<br>

## 7 個標註

<br>

---

<br>

`@BeforeAll` 標註的方法以 __設定__ 測試環境與初始測試資料為主，在所有測試開始前執行一次。

<br>

`@AfterAll` 標註的方法以 __拆除__ 測試環境與回收測試資料為主，在所有測試開始後執行一次。

<br>

被以上兩個標註的方法將在整個測試生命週期只執行一次，並且  __必須宣告為 `static`，當有 2 個以上相同標註，執行前後順序不能被保證__。

<br>

---

<br>


`@BeforeEach` 在每一個測試方法執行前都被調用一次。

<br>

`@AfterEach` 在每一個測試方法執行後都被調用一次。

<br>


`@Test` 標註要執行測試的方法。

<br>

`@RepeatedTest` 讓個別測試方法可以重複執行指定次數。

<br>

`@Disable` 停用個別測試方法，也可以標註在 Class 上，以停用整個測試類別。

<br>

__以上 5 個標註不用宣告為 static。__

<br>

---

<br>
<br>
<br>
<br>



## JUnit 4 與 JUnit 5 標註名稱比對：

<br>

| Junit 4 | JUnit 5 |
| :---: | :---: |
|  @BeforeClass   |  @BeforeAll   |
|  @AfterClass   |  @AfterAll   |
|  @Before   |  @BeforeEach  |
|  @After   |  @AfterEach   |
|  @org.junit.Test   |  @org.junit.jupiter.api.Test   |
|  無   |  @RepeatedTest   |
|  @Ignore   |  @Disable   |

<br>
<br>
<br>
<br>

## 生命週期示範

<br>

```java
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
```