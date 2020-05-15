### 第8章　オブジェクト指向構文-カプセル化/継承/ポリモーフィズム

1. カプセル化
カプセル化の基本は、「使い手に関係ないものは見せない」です。クラスで用意された機能のうち、利用する上で知らなくても差し支えないものを隠してしまうことをいう。  
* アクセス修飾子  
特定のメンバーを見せるかどうか管理しているのはアクセス修飾子である。「public」、「private」等  
* フィールドのアクセス権限 
インスタンスフィールドは原則としてpublic宣言すべきではない。理由は以下のとおり。
  * 読み書きの許可/禁止を制御できない。
  * 値の妥当性を検証できない。
  * 内部状態の変更に左右される。
* アクセサーメソッド
  * ゲッター/セッターのこと
* 不変クラス
  * オブジェクトを最初に生成したところから、一切の値(フィールド)が変化しないクラスのこと。オブジェクトの状態が意図せず変えられてしまう心配がないことから、「可変クラス」よりも実装/利用が簡単になり、結果として、バグの混入を防げる、堅牢なコードにもつながる等のメリットがある。
2. 継承
元になるクラスのメンバーを引継ぎながら、新たな機能を加えたり、元の機能を上書きしたりする仕組みのこと。このとき、継承元となるクラスのことを規定クラス(またはスーパークラス、親クラス)、継承してできたクラスのことを派生クラス(またはサブクラス、子クラス)と呼ぶ。
* 継承の基本
  * 一般的なクラス宣言に加えて、extendsキーワードで継承元の(基底クラス)を指定する。
  * 命名は基底クラスよりも具体的に
    * 派生クラスには、基底クラスよりも具体的な命名をします。一般的には、2単語以上で命名する。その際、末尾に基底クラスの名前を付与すれば互いの継承関係を把握しやすくなる。
  * 基底クラスは１つだけ
    * 多重継承を認めると継承関係が複雑となり、名前が衝突した場合の解決が困難。
  * 派生クラスにメンバーを追加する。
    * 継承では、まず現在のクラスで要求されたメンバーを検索し、存在しなかった場合には、上位のクラスで定義されたメンバーを呼び出す。
* フィールドの隠蔽
   * 基底クラスの同名のフィールドを、派生クラスで定義した場合、基底クラスのフィールドは派生クラスによって見えなくなる。これがフィールドの隠蔽。
* メソッドのオーバーライド
   * 基底クラスで定義されたメソッドを派生クラスで上書きすること。基底クラスで手いふぃされた機能を、派生クラスで再定義することと言っていい。
* superによる基底クラスの参照
  * 予約変数superを使用することとで、派生クラスから基底クラスのメソッドを呼び出せる。   
* 派生クラスのコンストラクター
  * コンストラクターはメソッドのように派生クラスには引き継がれない。P356 リスト8.11,8.12参照
* 継承/オーバーライドの禁止
* 参照型における型変換
  * アップキャスト
    * 派生クラスから基底クラスへの変換
  * ダウンキャスト
    * 基底クラスから派生クラスへの変換
* 型の判定
  * ダウンキャスト時にはあらかじめオブジェクトの型をinstanceof演算子を使用しチェックすること。P364参照
* 委譲
  * 再利用した機能を持つオブジェクトを、現在のクラスのフィールとして取り込む。
3. ポリモーフィズム  
同じ名前のメソッドで異なる挙動を実現すること。
* ポリモーフィズムの基本
  * ポリモーフィズムを利用することで、異なる機能(実装)を同じ名前で呼び出せるので保守性に優れる(機能の差し替えにはｍインスタンスそのものの差し替えだけで済む)、開発者が理解しやすい、などのメリットがある。
* 抽象メソッド
  * 抽象メソッドとは、それ自体は中身(機能)を持たない「空のメソッド」のこと。抽象メソッドを含んだクラスのことを抽象クラスと呼ぶ。
* インターフェイス
  * 配下のメソッドがすべて抽象メソッドであるクラスのこと。抽象クラスと決定的に違うのは、多重継承が可能であること。
  * インターフェイスを定義するには、(class命令の代わりに)interface命令を使用する。
  * インターフェイスで定義てきるメンバー
    * 抽象メソッド
    * defaultメソッド
    * クラスメソッド
    * 定数フィールド
    * 入れ子のstaticクラス/インターフェイス
　* インターフェイスの実装
    * 定義済のインターフェイスを「継承」してクラスを定義することをインターフェイスを実装するという。
* インターフェイスのメンバー  
インターフェイスでは、抽象メソッドのほかにも、定数フィールド、そしてJava8以降ではdafaultメソッド/staticメソッドなどを持つことができる。
  * 定数フィールド
  * staticメソッド
  * defaultメソッド
  * 多重継承の問題点
    * 抽象メソッドの重複
    * 定数フィールドの重複
    * defaultメソッドの重複
* インターフェイスと抽象クラスの使い分け  
いずれかを迷ったら、インターフェイスを優先して利用すること。インターフェイスと中小クラスとの本質的な違いは、抽象クラスがクラス階層の一部を構成するのに対して、インターフェイスは独立している点。