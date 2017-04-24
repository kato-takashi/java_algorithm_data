package java_algorithm_data;

import java.nio.channels.IllegalSelectorException;
import java.util.Arrays;
import java.util.EmptyStackException;

/*配列によるスタックの実装
 * */

public class MyStack {
	private Object stack[]; //スタック本体
	private int stackSize; //スタックの大きさ
	private int sp; //スタックのポインタ
	
	private static final int DEFAULT_STACK_SIZE = 100; //デフォルトのスタックの大きさ
	/*スタックを生成する（大きさはDEFAULT_STACK_SIZE）
	 * */
	public MyStack(int size){
		stack = new Object[size];
		stackSize = size;
		sp = 0;
	}
	
	/*スタックの中身を捨ててからの状態にする
	 * */
	public void clear(){
		Arrays.fill(stack, 0, sp, null); //スタックをnullでクリアする
		sp = 0; //スタックポインタを0にする
	}
	
	/*スタックにデータを積む
	 * @param x 積むデータ
	 * */
	public void push(Object x){
		if(sp >= stackSize){
			throw new IllegalStateException("Stack overflow");
		}
		stack[sp++] = x;
	}
	
	/*スタックからデータを降ろす
	 * @return スタックから降ろしたデータ
	 * */
	public Object pop(){
		if(sp <= 0){
			throw new EmptyStackException();
		}
		Object value = stack[--sp];
		stack[sp] = null; //空いた要素をnullでクリアする
		return value;
	}

	/*スタックが空かどうかを調べる
	 * @return 空ならばtrue, 空でなければfalseを返す
	 * */
	public boolean isEmpty(){
		return sp == 0;
	}
	
	/*スタックの内容を表す文字列を返す
	 * @return スタックの内容を表す文字列
	 * */
	public String toString(){
		String s = "MyStack=[";
		for(int i=0; i<sp; i++){
			s = s + stack[i];
			if(i < sp -1)
				s = s + ", ";
		}
		s = s + "]";
		return s;
	}	
	
}
