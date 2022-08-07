# 以程式驅動專案內大量測試

<br>

---

<br>

要以 Junit 5 執行專案內的大量單元測試，除了使用 IDE 驅動測試，也可以使用程式驅動，更可以達到大量且分類執行的目的。

<br>

以下使用程式驅動測試 __CalculatorAddTest__ 與 __CalculatorSubtractTest__。

<br>

```java
import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

import java.io.PrintWriter;

import static org.junit.platform.engine.discovery.ClassNameFilter.includeClassNamePatterns;

public class RunTest {

    // 建立 SummaryGeneratingListener 用來記錄測試結果
    private SummaryGeneratingListener listener = new SummaryGeneratingListener();

    // 選具體 Class 的方式測試
    private void testSelectClass() {
        // 建立測試請求
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder
                .request()
                .selectors(
                        DiscoverySelectors.selectClass(CalculatorAddTest.class),
                        DiscoverySelectors.selectClass(CalculatorSubtractTest.class)
                ).build();

        Launcher launcher = LauncherFactory.create(); // 建立測試平台
        launcher.registerTestExecutionListeners(listener); // 註冊 summaryListener
        launcher.execute(request); // 執行測試請求
    }

    // 選 Package 的方式測試
    private void testSelectPackage() {
        // 建立測試請求
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder
                .request()
                .selectors(DiscoverySelectors.selectPackage("com.frizo.lab.basic"))
                .filters(includeClassNamePatterns(".*AddTest", ".*SubtractTest"))
                .build();

        Launcher launcher = LauncherFactory.create(); // // 建立測試平台
        launcher.registerTestExecutionListeners(listener); // 註冊 summaryListener
        launcher.execute(request); // 執行測試請求
    }

    public static void main(String[] args) {
        RunTest runner = new RunTest();
        TestExecutionSummary summary;

        System.out.println("testSelectClass(): ");
        runner.testSelectClass();
        summary = runner.listener.getSummary();
        summary.printTo(new PrintWriter(System.out));

        System.out.println("testSelectPackage(): ");
        runner.testSelectPackage();
        summary = runner.listener.getSummary();
        summary.printTo(new PrintWriter(System.out));
    }
}
```

<br>

印出報告：

<br>

```
testSelectClass(): 

Test run finished after 111 ms
[         4 containers found      ]
[         0 containers skipped    ]
[         4 containers started    ]
[         0 containers aborted    ]
[         4 containers successful ]
[         0 containers failed     ]
[         2 tests found           ]
[         0 tests skipped         ]
[         2 tests started         ]
[         0 tests aborted         ]
[         2 tests successful      ]
[         0 tests failed          ]

testSelectPackage(): 

Test run finished after 5 ms
[         4 containers found      ]
[         0 containers skipped    ]
[         4 containers started    ]
[         0 containers aborted    ]
[         4 containers successful ]
[         0 containers failed     ]
[         2 tests found           ]
[         0 tests skipped         ]
[         2 tests started         ]
[         0 tests aborted         ]
[         2 tests successful      ]
[         0 tests failed          ]
```

<br>

