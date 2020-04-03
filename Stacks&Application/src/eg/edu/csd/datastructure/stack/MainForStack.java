package eg.edu.csd.datastructure.stack;
import java.util.Scanner;
import eg.edu.csd.datastructure.stack.Stacks.Node;
public class MainForStack {
	static Stacks stack=new Stacks();
	public static void main(String[]args) {
		Scanner input=new Scanner(System.in);MainForStack nb=new MainForStack();
		int r=0;
		while(r!=6) {
        System.out.println("choose one of the following number:");
		System.out.println("1-PushElement:");
		System.out.println("2-PopElement:");
		System.out.println("3-DetectSizeOfStack:");
		System.out.println("4-PeekElement:");
		System.out.println("5-StackIsEmptyOrNot:");
		System.out.println("6-Exit:");
		int n=input.nextInt();
		switch(n) {
		case 1 :
			Scanner k=new Scanner(System.in);StringBuilder m=new StringBuilder();
			System.out.println("Enter element:");
			String s=k.nextLine();
	    	stack.push(s);
			System.out.println("List will be:");
			nb.show();break;
		case 2 :
			System.out.println("Element which is poped:"+stack.pop());
			System.out.println("List after poping will be:");
			nb.show();break;
		case 3 :
			System.out.println("Size will be:"+stack.size());break;
		case 4 :
			System.out.println("Element at the peek will be:"+stack.peek());break;
		case 5 :
			if(stack.isEmpty()==true) System.out.println("Stack is empty");
			else System.out.println("Stack is not empty");break;
		case 6:
			r=n;break;
		}}
	    
	}
    public void show() {
    	try {
    		 Node n=stack.top;
    	    	while(n.next!=null) {System.out.println(n.value);n=n.next;}
    	    	System.out.println(n.value);
		} catch (Exception e) {
			System.out.println("Stack is empty");
		}
       
    }
}
