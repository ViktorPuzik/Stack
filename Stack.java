package sample;

public class Stack {
	private int size;
	private Object[] stack;
	private int counter;
	private boolean autoResize;

	public Stack(int size) {
		super();
		this.size = size;
		this.stack = new Object[size];
		counter = 0;
		this.autoResize = false;
	}

	public Stack() {
		super();
		this.size = 10;
		this.stack = new Object[size];
		counter = 0;
		this.autoResize = true;
	}
	
	public Stack(int size, Boolean autoResize) {
		super();
		this.size = size;
		this.stack = new Object[size];
		counter = 0;
		this.autoResize = autoResize;
	}
	
	public Stack(Boolean autoResize) {
		super();
		this.size = 10;
		this.stack = new Object[size];
		counter = 0;
		this.autoResize = autoResize;
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
			} else {
				if (autoResize) {
					stackResize(obj);
				}else {
					throw new StackOwerflowException("Stack Owerflow");
				}
			}
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

	private void stackResize(Object obj) {
		size = size*2;
		Object[] st = new Object[size];
		st[0] = obj;
		for (int i = 0; i < counter; i++) {
			st[i+1] = stack[i];
		}
		stack = st;
		st = null;
	}
}
