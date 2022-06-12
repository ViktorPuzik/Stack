package sample;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack stack = new Stack();
		Cat cat1 =  new Cat(10 , "Vaska");
		Cat cat2 =  new Cat(3 , "Funtik");
		Cat cat3 =  new Cat(6 , "Luska");
		
		try {
			stack.push(cat1);
			stack.push(cat2);
			stack.push(cat3);
			stack.push(12);
			stack.push("Hello");
			
			for (int i = 0; i < 100; i++) {
				//stack.push((Math.random()*50));
				stack.push(i);
			}
			stack.readStack();
			
		}
		catch (StackOwerflowException e) {
			System.err.println(e.getMessage());
		}
		
		try {
			System.out.println(stack.peek());
			stack.readStack();
			System.out.println(stack.pop());
			stack.readStack();
			System.out.println(stack.peek());
			stack.readStack();
		}
		catch (StackIsEmtyException e) {
			System.err.println(e.getMessage());
		}
		
		
	}

}
