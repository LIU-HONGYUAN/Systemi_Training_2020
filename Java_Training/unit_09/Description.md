### 第9章　オブジェクト指向構文-入れ子のクラス/ジェネリクス/例外処理など

1. Objectクラス  
クラスを宣言する際にextends句を省略した場合に、暗黙的に継承されるのがObjectクラス。すべてのクラスは直接/間接を問わず最終的にObjectクラスを上位クラスに持つという意味で、Objectクラスはすべてのクラスのルートであると言える。P390 表9.1参照
* オブジェクトの文字列表現を取得する ―toStringメソッド
  * printlnメソッドにオブジェクトを渡した場合、内部的にはtoStringメソッドが呼び出される。
* オブジェクト同士が等しいかどうかを判定する -equalsメソッド
  * 同一性(オブジェクト参照が同じオブジェクトを示していること)を確認する。
* オブジェクトのハッシュ値を取得する -hashCodeメソッド
  * オブジェクトのハッシュ値、オブジェクトデータをもとに生成されたint値を返す。
* オブジェクトを比較する -compareToメソッド
  * オブジェクト同士をを比較するメソッドで、Arrays.sortメソッドによるオブジェクトのソートや、TreeMap/TreeSetによえう順序月キーの管理にも利用する。
* オブジェクトを複製する -cloneメソッド
  * オブジェクトの複製(コピー)を生成するためのメソッド
2. 例外処理  
アプリを実行したときに発生する異常な状態、エラーのこと。また、発生した例外に対処するための処理のことを例外処理という。
* 例外処理の基本
  * 例外を処理するのは、try...catch命令 
  * tryブロックがアプリ本来の処理。ここで例外が発生すると、その種類(型)に応じてcatchブロックが呼び出される。例外が発生することを、例外スロー(throw)されるという。
  * 発生した例外を受け取ることを、例外をキャッチ(catch)するという。
  * スタックトレースとは、例外が発生するまでに経てきたメソッドの履歴。エントリーポイントであるmainメソッドを起点に呼び出し順に記録される。
* finallyブロック
  * try...catch命令には、必要に応じてfinallyブロックを追加することもできる。finallyブロックは、例外の有無にかかわらず最終的に実行されるブロックで、一般的には、tryブロックの中で利用したリソースの後始末のためなどに利用する。複数列記できるcatchブロックに対して、finallyブロックは1つしか指定できない。
* try-with-resource構文
  * P413 リスト9.15参照 注意点は以下。
    * AutoCloseableインターフェイスを実施していること。
    * リソース解放の順序が変わる。
    * リソースのスコープが異なる。
* 例外クラスの階層構造
  * すべての例外/エラークラスはThrowableクラス(java.langパッケージ)を頂点とした階層ツリーの中に属する。P415 図9.7参照
  * 例外処理の注意点
    * Exceptionで補足しない。
    * マルチキャッチを活用する。
    * catchブロックの記述順
* 例外をスローする
  * 例外は、標準で用意されたライブラリがスローするばかりではなく、throw命令を利用することで開発者が自らスローすることもできる、
  * 例外をスローする際の注意点
    * Exceptionをスローしない。
    * 検査例外/日検査例外を適切に選択する。
    * できるだけ標準例外を利用する。
    * privateメソッドではassert命令で代用。
* 例外の再スロー
　　* 例外はその場で処理するばかりではなく、その場ではログ出力にとどめ、処理そのものは呼び出し元にゆだねることもある。これを例外の再スローという。
3. 列挙型
*  列挙型の基本
  * enumブロックの配下に、名前をカンマ区切りで列挙するだけ。定数の一種なので、名前はアンダースコア記法で表すのが一般的。配列と同じく、列挙定数の末尾はカンマで終わっても問題ない。
* 列挙型の正体
  * enumブロックで定義された列挙型ですが、その正体は、Enumクラス(java.langパッケージ)を暗黙的に継承したクラス。P431 表9.8参照
* メンバーの定義
  * P432 リスト9.30参照
* ビットフィールドによるフラグ管理
  * ビットフィールドとは、複数のフラグ(オンオフ)をビットの並びとして表現する手法のこと。定数値として2の累乗を割り当てることで表現する。
4. 入れ子のクラス  
クラスは、class{...}の配下に入れ子で定義することもできる。これを入れ子のクラスという。
* staticメンバークラス
  * P440 リスト9.36参照
* 非staticメンバークラス
  * static修飾子がつかないメンバークラスのことを非staticなメンバークラス、または内部クラスと呼ぶ。P443 リスト9.37参照
* 匿名クラス
  * 名前のないクラスのこと。名前がないので、特定の文の　中でしか利用できないし、あとから呼び出すこともできない。P445 リスト9.39参照
* ローカルクラス
  * ローカルクラスとは、メソッド/コンストラクターなどのブロック配下で定義されたクラスをいう。クラスが、特定のメソッド/コンストラクターでのみ利用される場合に利用する。
5. ジェネリクス  
ジェネリクスは汎用的なクラス/メソッドに対して。特定の型を割り当てて、その型の専用のクラスを生成する機能。
* ジェネリック型の定義
  * P448 リスト9.41、図9.14参照
  * ジェネリック型ではまず、特定の型を受け取るための型パラメータを宣言する。
  * 型パラメータ(<...>)の中で宣言された型のことを型変数という。
* 型パラメーターの制約条件
  * P451 リスト9.42参照
* ジェネリックメソッド/ジェネリックコンストラクター
  * ジェネリック型とよく似た概念として、ジェネリックメソッド/ジェネリックコンストラクターがある。引数/戻り値、ローカル変数などの型を、呼び出し字に決められるメソッド/コンストラクター。
* 境界ワイルドカード型
  * 境界ワイルドカード型の基本
    * P454 リスト9.44参照
  * 標準ライブラリの例
    * ArrayListクラスのaddAllメソッド等
  * 下限境界ワイルドカード型
    * <? extends E>で表される境界ワイルドカード型は、指示された境界型を上限にして、その下位型(派生型)を認めることから、上限境界ワイルドカード型と呼ばれる。一方、指定された境界型を下限にして、その上位型を認める下限境界ワイルドカードもある。P456 リスト9.46、9.47参照
  * 非境界ワイルドカード型
    * リスト9.48参照