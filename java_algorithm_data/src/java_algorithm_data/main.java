package java_algorithm_data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;


public class Main {
	public static void main(String args[]) throws IOException{
	//public static void main(String args[]){
		//System.out.println("HelloWorld");
		/*			LinearSearch table = new LinearSearch();
			table.add(1, "one");
			table.add(10, "ten");
			table.add(2, "two");

			String x;
			x = (String) table.search(12);
			if(x != null){
				System.out.println("value= " + x);
			}else{
				System.out.println("not found");
			}
		 */
		
		/*
		Robot robita = new Robot(new Position(10, 20), "ロビタ");
		Robot robitaMkII = robita.makeClone2();
		System.out.println("移動前のrobita" + robita);
		robita.moveX(10);
		System.out.println("移動後のrobita" + robita);
		System.out.println("robitaMKII = " + robitaMkII);*/
		
		//stack test P.91
		/*MyStack stack = new MyStack(100);
		
		stack.push("a");
		stack.push("b");
		stack.push("c");
		System.out.println(stack);
		System.out.println("pop: " + stack.pop());
		System.out.println(stack);
		stack.push("d");
		stack.push("e");
		stack.push("f");
		System.out.println(stack);
		while(!stack.isEmpty()){
			System.out.println("pop: " + stack.pop());
		}
		System.out.println("DONE! " + stack);*/
		
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
