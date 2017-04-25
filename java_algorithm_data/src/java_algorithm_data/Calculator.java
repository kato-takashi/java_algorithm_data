package java_algorithm_data;

import java.io.IOException;
import java.io.PushbackReader;
import java.io.StringReader;

/*
 * 逆ポーランド電卓
 * */
public class Calculator {
	private final MyStack stack; //stack
	/*
	 * 逆ポーランド電卓オブジェクトを生成する
	 * */
	public Calculator(){
		stack = new MyStack(); //スタックを生成する
	}
	
	/*
	 * 逆ポーランド記法の数式の値を計算する
	 * @param exp 逆ポーランド記法の数式を表す文字列
	 * @return 数式の値
	 * */
	public long compute(String exp) throws IOException{
		//スタックの内容をクリアする
		stack.clear();
		/*字列expを1文字ずつ読み込むためのリーダーを用意する
		*PushbackReaderクラスを利用して読みすぎた文字をunreadで戻せるようにする
		*文字列の末尾に式の終わりを示すセミコロンをつけていることに注意
		*/
		PushbackReader input = new PushbackReader(new StringReader(exp + ";"));
		//セミコロンに出会うまで1文字読み込んで繰り返す
		int c; //読み込んだ文字
		while((c = input.read()) != ';'){
			char ch = (char)c;
			if(Character.isDigit(ch)){
				/*
					読み込んだ文字が数字があった
					数字が続く限り読み込んで，それを十進数として解釈し，
					long値に変換する．得られた値をスタックに積む
				 */			
				long num = 0;
				while(Character.isDigit(ch)){
					num = 10*num+(ch-'0');
					c = input.read();
					ch = (char)c;
				}
				input.unread(c); //1文字読みすぎているので，それを戻す
				stack.push(num);
			}else{
				long a, b; //作業用の変数
				switch(ch){
				case '+'://加算
					b = (Long)stack.pop(); a = (Long)stack.pop();
					stack.push(a + b);
					break;
				case '-'://減算
					b = (Long)stack.pop(); a = (Long)stack.pop();
					stack.push(a - b);
					break;
				case '*'://乗算
					b = (Long)stack.pop(); a = (Long)stack.pop();
					stack.push(a * b);
					break;
				case '/'://除算
					b = (Long)stack.pop(); a = (Long)stack.pop();
					stack.push(a / b);
					break;
				//空白文字は何もしないで飛ばす
				case '　'://除算
				case '\t'://除算
				case '\r'://除算
					break;
				default:
					throw new IllegalArgumentException("不正な文字"+ ch + "がありました．");
				}
			}
		}
		
		//計算結果をスタックから取り出して返す
		if(! stack.isEmpty()){
			return (Long)stack.pop();
		}else{
			//スタックが空の場合には，式がなかったので，例外をスローする
			throw new IllegalArgumentException("式がありません．");
		}
	}
	
}
