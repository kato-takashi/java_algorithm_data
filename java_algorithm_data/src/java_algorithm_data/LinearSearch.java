package java_algorithm_data;
//線形検索
public class LinearSearch {
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
		table[n++] = new Entry(key, data);
	}
	
	/*キーに対応するデータを探す
	 *＠param key　キー
	 *@return キー keyに対応するdata．キーが見つからなければnullを返す
	 */
	public Object search(int key){
		int i = 0;
		while(i < n){
			if(table[i].key == key)
				return (table[i].data);
			i++;
		}
		return null;
		}
}
