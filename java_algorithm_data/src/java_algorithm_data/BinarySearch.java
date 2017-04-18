package java_algorithm_data;
public class BinarySearch {
	//	テーブルのエントリ
	static private class Entry{
		int key; //比較の対象となるキー
		Object data; //それ以外の情報

		/*エントリを生成する
		 *＠param key　キー
		 *@param data キー keyに対応するdata
		 */	
		private Entry(int key, Object data){
			this.key = key;
			this.data = data;
		}	
	}
	final static int MAX = 100; //dataの最大個数
	Entry[] table = new Entry[MAX]; //dataを格納する配列
	int n = 0; //tableに登録されているdataの個数

	/*dataを登録する
	 *＠param key　キー
	 *@param data キー keyに対応するdata
	 */
	public void add (int key, Object data){
		if(n >= MAX){
			throw new IllegalStateException("データ個数が多すぎます");
		}
		
		/*昇順での追加イメージ
		 * int pos;
		 * pos = データを挿入すべき位置;
		 * 配列中のposより後ろの要素を1つずつ後ろにずらす;
		 * table[pos] = new Entry(key, data);
		 * */
		//２分検索の場合は昇順になるためデータを並べないといけないため以下は仮
		table[n++] = new Entry(key, data);
	}

	/*キーに対応するデータを探す
	 *＠param key　キー
	 *@return キー keyに対応するdata．キーが見つからなければnullを返す
	 */
	public Object search(int key){
		int low = 0;
		int heigh = n - 1;
		while(low <= heigh){
			int middle = (low + heigh) / 2;
			if(key == table[middle].key)
				return table[middle].data; //見つかった
			else if (key < table[middle].key)
				heigh = middle -1;
			else //　key > table[middle].key
				low = middle + 1;
		}
		return null;
	}
}
