# 基本觀念與專有名詞

<br>

---

<br>

## 基本觀念

<br>

對於開發 Java 應用而言，我們在遵循物件導向開發原則（Object Oriented Programming, OOP）。像是 __[SOLID]__：SRP、OCP、LSP、ISP、DIP。

<br>

1. 單一責任原則（Single-responsibility principle, SRP）

2. 開放封閉原則（Open–closed principle, OCP）

3. 里氏替換原則（Liskov substitution principle, LSP）

4. 介面分割原則（Interface segregation principle, ISP）

5. 依賴反轉原則（Dependency inversion principle, DIP）

<br>

這些原則這裡不多介紹了，需要的話可以參考一下 YC 大大分享的文章：[使人瘋狂的 SOLID 原則：目錄](https://medium.com/%E7%A8%8B%E5%BC%8F%E6%84%9B%E5%A5%BD%E8%80%85/%E4%BD%BF%E4%BA%BA%E7%98%8B%E7%8B%82%E7%9A%84-solid-%E5%8E%9F%E5%89%87-%E7%9B%AE%E9%8C%84-b33fdfc983ca)

<br>
<br>

而對於測試程式，通常就可以把上面的原則拋在腦後了，我們只需要注意三段式結構：__Given（甚麼條件下）、When（做甚麼事）、Then（預期得到甚麼）__。

<br>

測試程式：

* 不需要計較重複程式碼，看的清楚每一個項測試邏輯為優先。

* 方法命名可以很長，確認程式規格需求為優先。

* 可以用底線區隔命名，不必用駝峰字。

<br>
<br>
<br>
<br>

## 單元測試專有名詞

<br>
<br>

* ### __SUT__（System Under Test）

    待測元件

<br>
<br>

* ### __DOC__（Depended-On Component）

    待測元件所依賴的元件，改變 DOC 的行為會影像 SUT 測試結果。

<br>
<br>
<br>
<br>


* Test Double

    測試替身，當要控制 DOC 類別呼叫的結果能符合我們預期時，通常就 __建立一個替身類別繼承原本的 DOC，在測試程式中替換原本的 DOC__。

    像是在測 UserDetailSetvice（SUT） 時，依賴 UserDAO（DOC） 回傳使用者資料，但是又不想真的去連 DB 取資料，就可以寫一個繼承 UserDAO 的假 DAO（Test Double），這個假類別的 `getUserById()` 方法
    里吐的資料事寫死的。這樣保證不用連 DB，且每次得到的 User 資料都是一樣的。

<br>

* Direct Input/Output

    單元測試建立 SUT 後，提供輸入參數呼叫 SUT 方法，這些輸入稱為 Direct Input，經 SUT 運算後回傳特定結果，稱之為 Direct Output。

<br>

* Indirect Input

    一般來說系統很少有類別可以獨攬大局，一個人實現一個大功能，基本上類別間都要互相依賴協作才能提供完整功能。__當 SUT 狀態被 DOC 運行結果影響，就可以稱這些 DOC 結果是 SUT 的 Indirect Input__。


<br>

* Test Stub

    對於提供 Indirect Input 給 SUT 的 DOC，可以使用 Test Double 中的 Test Stub 替換。

    Stub 的翻譯是 __殘枝__， Test Stub 相較於完整的 DOC，通常只實作被 SUT 呼叫的方法，所以就像 "殘缺" 的DOC 類別。

    舉例，Controller 會呼叫 Service，若要對 Controller 單元測試，就要對 Service 進行控制：

    1. 以 Test Stub 實作 Service 的 interface 然後取代原本的 Service。

    2. 當 Controller 需要呼叫 Service 的 `getUserById()` 方法，就要實作 Test Stub 的  `getUserById()` 方法，但不需要實現 Test Stub 其他方法。

<br>

* Indirect Output

    間接輸出指 SUT 輸出到 DOC，而由 DOC 真正輸出結果，__像是 Service（SUT）輸出給 DAO（DOC），DAO 再把資料寫入到 DB。我們只能藉由觀測 DB 來得知測試結果。__

    常見 Indirect Output 如：

    1. SUT 傳送訊息到 MQ 或 JMS

    2. SUT 新增資料到 DB

    3. SUT 開 IO 寫資料到檔案

<br>

* Mock Object

    要觀察 SUT 的 Indirect Output 也並不用真的去 MQ DB 或開檔案看，可以用 DOC 測試替身的 Mock Object 攔截輸出，再與預期值進行比較。

    以 Controller 呼叫 Service 的 `getUserById()` 方法的情境來說，對 Controller 進行單元測試，除了要有 Test Stub 給 Controller 提供 `getUserById()` 方法，有時還需要釐清 `getUserById()` 被調用幾次，這時就需要 Mock Object 攔截間接輸出。實務上 Mock Object 也具備 Test Stub 的功能。


<br>

* Test Spy

    Test Spy 是 強化版的 Test Stub，除了需要提供 Indirect Input 給 SUT，執行時也可以捕獲 SUT 的 Indirect Output 並保存他們以供測試驗證。

<br>

* Fake Obkect

    Fake Object 具備和 DOC 相似的功能，通常是簡化版，當真實的 DOC 不可用於測試，或用於測試時速度太慢就可以用 Fake Object 替代。

    以 DAO 為例，真正的 DAO 將會訪問 DB，對於測試來說效率太差，所以 DAO 的 Fake Object 就可以用 __HashMap__ 取代。


<br>

* Dummy Object 

    SUT 的某些方法可能需要某物件參數作為 input，但是若因為測試情境關係，該參數實際上不會影響測試結果，我們就可以傳入一個 Dummy Object，可能是一個 null，或是 Object 類別實例。目的就是為了讓測試正常進行。


<br>

* Test Fixture

    測試時需要一些環境，如測試用的資料，稱為 Test Fixture（測試裝置），或稱為 Test Context（測試情境）。

<br>