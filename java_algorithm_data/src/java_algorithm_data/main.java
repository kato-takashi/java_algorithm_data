package java_algorithm_data;


public class main {
	public static void main(String args[]){
			//System.out.println("HelloWorld");
			LinearSearch table = new LinearSearch();
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
		}
	
}
