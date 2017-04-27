package java_algorithm_data;

import java.util.Arrays;
import java.util.NoSuchElementException;

/*
 * 配列による待ち行列の実装
 * */
public class MyQueue {
	private Object queue[]; //待ち行列の本体
	private int queueSize; //待ち行列の大きさ
	private int front; //待ち行列の先頭
	private int rear; //待ち行列の末尾
	
	//デフォルトの待ち行列の大きさ
	private static final int DEFAULT_QUEUE_SIZE = 100;
	
	/*
	 * 待ち行列を生成する（大きさはDEFAULT_QUEUE_SIZE）
	 * */
	public MyQueue(){
		this(DEFAULT_QUEUE_SIZE);
	}
	
	/*
	 * 大きさを指定して，待ち行列を生成する
	 * @param size 待ち行列の大きさ
	 * */
	public MyQueue(int size){
		queueSize = size;
		queue = new Object[size];
		front = rear = 0;
	}
	
	/*
	 * 次の要素の添字を求める
	 * @param a 現在の要素の添字
	 * */
	private int next(int a){
		return(a+1) % queueSize;
	}
	
	/*
	 * 待ち行列の中身を捨てて空にする
	 * */
	public void clear(){
		front = rear = 0;
		Arrays.fill(queue,  0, queueSize, null); //待ち行列をnullでクリア
	}
	
	/*
	 * 待ち行列にデータを入れる
	 * @param x 待ち行列に入れるデータ
	 * */
	public void enqueue(Object x){
		if(next(rear) == front){
			throw new IllegalStateException("これ以上，待ち行列に要素を追加できません");
		}
		queue[rear] = x;
		rear = next(rear);
	}
	
	/*
	 * 待ち行列からデータを取り出す
	 * @return 待ち行列から取り出したデータ
	 * */
	public Object dequeue(){
		if(front == rear){
			throw new NoSuchElementException("待ち行列が空なので，要素を取り出せません");
		}
		Object x = queue[front];
		queue[front] = null;
		front = next(front);
		return x;
	}
	
	/*
	 * 待ち行列が空かどうかを調べる
	 * @return 空ならtrue, 空でなければfalseを返す
	 * */
	public boolean isEmpty(){
		return front ==  rear;
	}
	
	/*
	 * 待ち行列の内容を表す文字列を返す
	 * @return 待ち行列の内容を表す文字列
	 * */
	public String toString(){
		String s = "MyQueue = [";
		for(int i=front; i!=rear; i=next(i) ){
			s += queue[i] + " ";
		}
		s += "] front" + front + " rear=" + rear;
		return s;
	}
}
