

package java_algorithm_data;

import java.util.Arrays;
import java.util.EmptyStackException;

public class GenericStack<E>{
	private E stack[]; //スタック本体
	private int stackSize; //スタックの大きさ
	private int sp; //スタックのポインタ
	
	private static final int DEFULT_STACK_SIZE = 100; //デフォルトのスタックの大きさ
	/*
	 * スタックを生成する（大きさはDEFAULT_STACK_SIZE）
	 * */
	public GenericStack(){
		this(DEFULT_STACK_SIZE);
	}
	/*
	 * 大きさを指定してスタックを生成する
	 * @param size スタックの大きさ
	 * 
	 * */
	@SuppressWarnings("unchecked")
	public GenericStack(int size) {
		/* 配列stackにはpushメソッドによってEクラス
		のオブジェクトのみが格納されるので，このキャストは安全である
		*/
		stack = (E[]) new Object[size];
		stackSize = size;
		sp = 0;
	}
	
	/*
	 * スタックの中身を捨ててからの状態にする
	 * */
	public void clear(){
		Arrays.fill(stack, 0, sp, null); //sタックをnullでクリアする
		sp = 0;
	}
	
	/*
	 * スタックにデータを積む
	 * @param x 積むデータ
	 * */
	public void push(E x){
		if(sp >= stackSize){
			throw new IllegalStateException("Stack overflow");
		}
		stack[sp++] = x;
	}
	
	/*
	 * スタックからデータを下ろす
	 * @return スタックからおろしたデータ
	 * */
	public E pop(){
		if(sp <= 0){
			throw new EmptyStackException();
		}
		E value = stack[--sp];
		stack[sp] = null; //空いた要素をnullでクリアする
		return value;
	}
	
	/*
	 * スタックが空かどうかを調べる
	 * @return 空ならばtrue，空でなければfalseを返す
	 * */
	public boolean isEmpty(){
		return sp ==0;
	}
	
	/*
	 * スタックの内容を表す
	 * @return スタックの内容を表す文字列
	 * */
	public String toString(){
		String s = "GenericStack=[";
		for(int i=0; i<sp; i++){
			s = s + stack[i];
			if(i < sp-1)
				s = s + ",";
		}
		s = s + "]";
		return s;
	}
	
}
