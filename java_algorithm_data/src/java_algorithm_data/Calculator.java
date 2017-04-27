package java_algorithm_data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PushbackReader;
import java.io.StringReader;
import java.util.EmptyStackException;

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
					System.out.println("ch " + ch);

				}
				input.unread(c); //1文字読みすぎているので，それを戻す
				stack.push(num);
				System.out.println("num " + num);
				System.out.println("c " + c);
			}else{
				long a, b; //作業用の変数
				switch (ch){
				case '+'://加算
					b = (Long)stack.pop(); a = (Long)stack.pop();
					stack.push(a + b);
					System.out.println("a, b " + String.valueOf(a) + ", " + String.valueOf(b));
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
		public static void main(String args[]) throws IOException{
			//逆ポーランド電卓 P97
			//標準入力から読み込んだ式を評価して結果を表示
			//標準入力から1行ずつ読み込むために．リーダーを用意する
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			//逆ポーランド電卓を生成する
			Calculator calculator = new Calculator();

			//標準入力から式を1行ずつ読み込んで電卓で値を求めて表示
			String line;
			while ((line = input.readLine()) != null){
				//1行読み込む
				try{
					long answer = calculator.compute(line);
					System.out.println("値は" + answer + "です．");
				}catch(EmptyStackException e){
					//スタック画からの場合にはメッセージ文字列がないので自前でメッセージ
					System.out.println("式が正しくありません");
				}catch(Exception e){
					//それ以外の例外では例外のメッセージを表示する
					System.out.println(e.getMessage());

				}
			}
		}
	}
