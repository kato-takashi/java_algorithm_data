package java_algorithm_data;


public class Main {
	public static void main(String args[]){
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
		MyStack stack = new MyStack(100);
		
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
		System.out.println("DONE! " + stack);
	}

}
