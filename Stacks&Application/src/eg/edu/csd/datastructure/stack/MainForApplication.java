package eg.edu.csd.datastructure.stack;
import java.util.Scanner;
public class MainForApplication {
       public static void main(String []args) {
    	   try {
    		   Application application=new Application();
    			 Scanner input=new Scanner(System.in);StringBuilder ss=new StringBuilder();
    			 System.out.println("Enter Infix Expression:");
    			 String s=input.nextLine();
    			 String str=application.infixToPostfix(s);
    			 System.out.println(str);char o = 0;int i=0;String j=new String();
    			 while(i<str.length()) {
    				 if(Character.isLetter(str.charAt(i))&&o!=str.charAt(i)) {
    					 System.out.println("Enter value for symbolic expression:");
    					 String v=input.nextLine();o=str.charAt(i);j=v;
    					 ss.append(v);i++;
    				 }
    				 else if(o==str.charAt(i)) {ss.append(j);i++;}
    				 else {ss.append(str.charAt(i));i++;}
    			 }
    		     int n=application.evaluate(ss.toString());
    			 System.out.println(n);
    			 input.close();
		} catch (Exception e) {
			System.out.println("Invalid input");
		}
		
	 }
}
			