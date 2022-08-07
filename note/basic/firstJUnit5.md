# 建立一個簡單 JUnit 5 測試專案

<br>

---

<br>

建立 maven 專案，導入依賴：

<br>

```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-engine</artifactId>
    <version>5.7.2</version>
    <scope>test</scope>
</dependency>
```

<br>

junit-jupiter-engine 依賴包含運行我們的單元測試的 JUnit Jupiter 測試引擎的實現。如果將此依賴項添加到類路徑中，Maven Surefire 和 Failsafe plugin（版本 2.22.0 或更高版本）可以運行使用 JUnit 5 的測試。

<br>

導入 plugin：


```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>2.22.2</version>
</plugin>
```

<br>

我們可以使用 Maven Surefire 插件運行單元測試。因為要使用它的原生 JUnit 5 支持，所以我們必須使用 2.22.0（或更新）版本。

<br>


<br>

建立 SUT：Calculator

<br>

```java
public class Calculator {

    public int add(int a, int b){
        return a + b;
    }

    public int subtract(int a, int b){
        return a - b;
    }

}
```

<br>

在 test 目錄新增 2 個測試類，分別對應測試 `add()` 與 `subtract()`。

<br>

CalculatorAddTest：

```java
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorAddTest {

    @Test
    @DisplayName("1+1=2") // 結果將以標註內容顯示，增加報告可讀性。
    public void addTwoNumbers() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.add(1, 1));
    }

}
```

<br>

CalculatorSubtractTest
```java
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorSubtractTest {

    @Test
    public void subtractNumbers() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.subtract(3, 1));
    }
}
```
