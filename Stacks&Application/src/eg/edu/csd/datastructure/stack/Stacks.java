package eg.edu.csd.datastructure.stack;
public class Stacks implements IStack{
	class Node{
		Object value;Node next;
	}Node top;
    @Override
	public int size() {
		// TODO Auto-generated method stub
    	int size=0;Node n=top;
    	while(n!=null) {size++;n=n.next;}
		return size;}
   	
	
	@Override
	public void push(Object element) {
		// TODO Auto-generated method stub
		Node n=new Node();n.value=element;
		if(top==null) top=n;
		else {
			n.next=top;top=n;
		}
	}
	
	@Override
	public Object pop() {
		// TODO Auto-generated method stub
		try {
			Node n=top.next;Object element=top.value;
			top.next=null;top=n;
			return element;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Stack is empty");return null;
		}
		
		
	}
	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		try {
			Object element=top.value;
			return element;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Stack is empty");return null;
		}
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(top==null) return true;
		else return false;
	}
	
    }

