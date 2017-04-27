package java_algorithm_data;

import java.util.Arrays;
import java.util.EmptyStackException;

/*配列によるスタックの実装
 * */

//public class MyStack {
//	private Object stack[]; //スタック本体
//	private int stackSize; //スタックの大きさ
//	private int sp; //スタックのポインタ
//	
//	private static final int DEFAULT_STACK_SIZE = 100; //デフォルトのスタックの大きさ
//	/*スタックを生成する（大きさはDEFAULT_STACK_SIZE）
//	 * */
//	public MyStack(){
//		this(DEFAULT_STACK_SIZE);
//	}
//	public MyStack(int size){
//		stack = new Object[size];
//		stackSize = size;
//		sp = 0;
//	}
//	
//	/*スタックの中身を捨ててからの状態にする
//	 * */
//	public void clear(){
//		Arrays.fill(stack, 0, sp, null); //スタックをnullでクリアする
//		sp = 0; //スタックポインタを0にする
//	}
//	
//	/*スタックにデータを積む
//	 * @param x 積むデータ
//	 * */
//	public void push(Object x){
//		if(sp >= stackSize){
//			throw new IllegalStateException("Stack overflow");
//		}
//		stack[sp++] = x;
//	}
//	
//	/*スタックからデータを降ろす
//	 * @return スタックから降ろしたデータ
//	 * */
//	public Object pop(){
//		if(sp <= 0){
//			throw new EmptyStackException();
//		}
//		Object value = stack[--sp];
//		stack[sp] = null; //空いた要素をnullでクリアする
//		return value;
//	}
//
//	/*スタックが空かどうかを調べる
//	 * @return 空ならばtrue, 空でなければfalseを返す
//	 * */
//	public boolean isEmpty(){
//		return sp == 0;
//	}
//	
//	/*スタックの内容を表す文字列を返す
//	 * @return スタックの内容を表す文字列
//	 * */
//	public String toString(){
//		String s = "MyStack=[";
//		for(int i=0; i<sp; i++){
//			s = s + stack[i];
//			if(i < sp -1)
//				s = s + ", ";
//		}
//		s = s + "]";
//		return s;
//	}	
//	
//}

public class MyStack
{
    private Object  stack[];    // ÉXÉ^ÉbÉNñ{ëÃ
    private int  stackSize;     // ÉXÉ^ÉbÉNÇÃëÂÇ´Ç≥
    private int  sp;            // ÉXÉ^ÉbÉNÉ|ÉCÉìÉ^

    private static final int  DEFAULT_STACK_SIZE = 100; // ÉfÉtÉHÉãÉgÇÃÉXÉ^ÉbÉNÇÃëÂÇ´Ç≥

    /**
     * ÉXÉ^ÉbÉNÇê∂ê¨Ç∑ÇÈÅiëÂÇ´Ç≥ÇÕDEFAULT_STACK_SIZEÅj
     */
    public MyStack()
    {
        this(DEFAULT_STACK_SIZE);
    }

    /**
     * ëÂÇ´Ç≥ÇéwíËÇµÇƒÉXÉ^ÉbÉNÇê∂ê¨Ç∑ÇÈ
     *
     * @param size  ÉXÉ^ÉbÉNÇÃëÂÇ´Ç≥
     */
    public MyStack(int size)
    {
        stack = new Object[size];
        stackSize = size;
        sp = 0;
    }

    /*
     * ÉXÉ^ÉbÉNÇÃíÜêgÇéÃÇƒÇƒãÛÇÃèÛë‘Ç…Ç∑ÇÈ
     */
    public void clear()
    {
        Arrays.fill(stack, 0, sp, null);   // ÉXÉ^ÉbÉNÇnullÇ≈ÉNÉäÉAÇ∑ÇÈ
        sp = 0;                            // ÉXÉ^ÉbÉNÉ|ÉCÉìÉ^Ç0Ç…Ç∑ÇÈ
    }

    /*
     * ÉXÉ^ÉbÉNÇ…ÉfÅ[É^ÇêœÇﬁ
     *
     * @param x  êœÇﬁÉfÅ[É^
     */
    public void push(Object x)
    {
        if (sp >= stackSize) {
            throw new IllegalStateException("Stack overflow");
        }
        stack[sp++] = x;
    }

    /*
     * ÉXÉ^ÉbÉNÇ©ÇÁÉfÅ[É^Çç~ÇÎÇ∑
     *
     * @return  ÉXÉ^ÉbÉNÇ©ÇÁç~ÇÎÇµÇΩÉfÅ[É^
     */
    public Object pop()
    {
        if (sp <= 0) {
            throw new EmptyStackException();
        }
        Object  value = stack[--sp];
        stack[sp] = null;               // ãÛÇ¢ÇΩóvëfÇnullÇ≈ÉNÉäÉAÇ∑ÇÈ
        return value;
    }

    /*
     * ÉXÉ^ÉbÉNÇ™ãÛÇ©Ç«Ç§Ç©Çí≤Ç◊ÇÈ
     *
     * @return ãÛÇ»ÇÁÇŒtrueÅCãÛÇ≈Ç»ÇØÇÍÇŒfalseÇï‘Ç∑
     */
    public boolean isEmpty()
    {
        return sp == 0;
    }

    /*
     * ÉXÉ^ÉbÉNÇÃì‡óeÇï\Ç∑ï∂éöóÒÇï‘Ç∑
     *
     * @return ÉXÉ^ÉbÉNÇÃì‡óeÇï\Ç∑ï∂éöóÒ
     */
    public String toString()
    {
        String s = "MyStack=[";
        for (int i = 0; i < sp; i++) {
            s = s + stack[i];
            if (i < sp - 1)
                s = s + ",";
        }
        s = s + "]";
        return s;
    }

    /*
     * ÉeÉXÉgópÉÅÉCÉìÉãÅ[É`Éì
     */
    /*public static void main(String args[])
    {
        MyStack stack = new MyStack();

        stack.push("a");  stack.push("b");  stack.push("c");
        System.out.println(stack);
        System.out.println("pop:" + stack.pop());
        System.out.println(stack);
        stack.push("d");  stack.push("e");  stack.push("f");
        System.out.println(stack);
        while (!stack.isEmpty()) {
                System.out.println("pop:" + stack.pop());
        }
        System.out.println("DONE! " + stack);
    }*/
}
