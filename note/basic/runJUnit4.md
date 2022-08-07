# 在 Junit 5 架構下執行 Junit 4 的測試

<br>

---

<br>

加入依賴：

```xml
<dependency>
    <groupId>org.junit.platform</groupId>
    <artifactId>junit-platform-runner</artifactId>
    <version>${junit.platform.version}</version>
    <scope>test</scope>
</dependency>
```

<br>

使用 Junit4 API 編寫測試：

<br>

```java
import org.junit.Test; // JUnit4 API

import static org.junit.Assert.assertEquals; // JUnit4 API

public class CalculatorAddJUnit4Test {

    @Test
    public void addTwoNumber() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.add(1, 1));
    }

}
```

<br>

```java
import org.junit.Test;

import static org.junit.Assert.assertEquals; // JUnit4 API

public class CalculatorSubtractJUnit4Test {

    @Test
    public void subtractNumbers() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.subtract(3, 1));
    }
}
```

<br>

再試試建立 JUnit4 的成套測試類別（Suite）。關鍵做法在類別名稱上以 `@RunWIth(SUite.class)` 與 `@Suite.SuiteClasses` 標註：

<br>

```java
@RunWith(Suite.class)
@Suite.SuiteClasses({
        CalculatorAddJUnit4Test.class,
        CalculatorSubtractJUnit4Test.class
})
public class TestJUnit4Suite {
    // 兩個類一起測
}
```

<br>
