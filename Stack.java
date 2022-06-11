package sample;

public class Stack {
	private int size;
	private Object[] stack;
	private int counter;

	public Stack(int size) {
		super();
		this.size = size;
		this.stack = new Object[size];
		counter = 0;
	}

	public Stack() {
		super();
		// TODO Auto-generated constructor stub
		this.stack = new Object[10];
		counter = 0;
	}
	
	public void push(Object obj) throws StackOwerflowException {
		if (counter == 0) {
			stack[0] =(Object)obj;
		}
		else {
			if(counter < size) {
				for(int temp = counter; temp >0; temp--) {
					stack[temp] = stack[temp-1];
				}
				stack[0] = obj;
			} else {throw new StackOwerflowException("Stack Owerflow");}
		}
//		readStack();
		counter++;
	}

	public Object peek() throws StackIsEmtyException {
		if (counter == 0) {throw new StackIsEmtyException("Stack is emty");}
		
		return stack[0];		
	}
	
	public Object pop() throws StackIsEmtyException {
		if (counter == 0) {throw new StackIsEmtyException("Stack is emty");}
		else {
			Object temp = stack[0];
			if (counter == 1) {counter = 0;}
			else {
				for (int i = 0; i < counter; i++) {
					stack[i] = stack[i+1];
				}
				counter--;
			}
//			readStack();
			return temp;
		
		}
	}
	public void readStack () {
		System.out.println("-------------------");
		for (int i = 0; i < stack.length; i++) {
			System.out.println(stack[i]);
		}
		System.out.println("-------------------");
	}
}
