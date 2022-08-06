# JUnit 5 簡介

<br>

---

<br>

Junit 是成熟的且運用廣泛的 Java 測試框架。JUnit 5 於 2017 年發布，和 2006 年發布的 JUnit 4 相比多出了 lambda 表達式。架構上 5 也向前兼容，可以執行 4 的編寫測試。

<br>

JUnit 5 由 3 個子項目組成：

1. __JUnit Platform__

    為了能夠在 JVM 上進行單元測試，包含使用 IDE 開發工具（Idea），建構工具（Maven），或擴充插件等，必須先具備測試平台，就是指 JUnit Platform。

<br>

2. __JUnit Jupiter__

    JUnit Jupiter 是最直接影響開發者編寫測試的部分，它包含 2 個 lib：

    * junit-jupiter-api

      我們使用 API 里的 lib 來寫測試並進行套件擴充，包含新增標註和 lambda。

      <br>

    * junit-jupiter-engine

      要執行符合 jupiter 編寫的測試程式碼，執行時期就需要 junit-jupiter-engine 提供的測試引擎。


<br>

3. __JUnit Vintage__

    JUnit 5 藉由 JUnit Vintage 達成向前相容的功能性，只要把測試引擎由 junit-jupiter-engine 換成 junit-vintage-engine 就可以執行 JUnit 4 編寫的舊版程式碼。

    