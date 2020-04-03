package eg.edu.csd.datastructure.stack;
public class Application implements IExpressionEvaluator {
	/**
	 * @This Method takes string infix expression as parameter
	 * @This Method used to convert expression from infix to postfix
	 * @This Method return string posfix expression
	 */
	public String infixToPostfix(String expression) {
		String q=expression.replaceAll("\\s+", "");
		for(int i=0;i<expression.length();i++) {
			if(expression.contains("**")||
					expression.contains("//")||expression.contains("@")||
					expression.contains("$")||expression.contains("!")||
					expression.contains("^")||expression.contains("&")||
					expression.contains("|")||expression.contains("\\")||
					expression.contains("+.")||expression.contains(".+")||
					expression.contains("-.")||expression.contains(".-")||
					expression.contains("*.")||expression.contains(".*")||
					expression.contains("/.")||expression.contains("./")||
					expression.contains("+*")||expression.contains("+/")||
					expression.contains("-*")||expression.contains("-/")||
					expression.contains("+)")||expression.contains("-)")||
					expression.contains("*)")||expression.contains("/)")){
				throw new IllegalStateException();}
			}
		StringBuilder ss=new StringBuilder();int i=0;
		String a=q.trim().replaceAll("\\++","+");
		while(i<a.length()-1) {
			if(Character.isLetter(a.charAt(i))&&Character.isLetter(a.charAt(i+1))) {
				ss.append(a.charAt(i));ss.append('*');i++;}
			else if(a.charAt(i)==')'&&a.charAt(i+1)=='(') {
				ss.append(a.charAt(i));ss.append('*');i++;}
			else if((Character.isLetterOrDigit(a.charAt(i))&&a.charAt(i+1)=='(')
					||(Character.isLetterOrDigit(a.charAt(i+1))&&a.charAt(i)==')')) {
				ss.append(a.charAt(i));ss.append('*');i++;}
			else if((a.charAt(i)=='-'||a.charAt(i)=='*'||a.charAt(i)=='/'||a.charAt(i)=='(')
					&&a.charAt(i+1)=='+') {
				ss.append(a.charAt(i));i+=2;
			}
			else if((i==0)&&a.charAt(i)=='+'&&Character.isLetterOrDigit(a.charAt(i+1))) {
				i++;
			}
			else if(i!=0&&a.charAt(i)=='+'&&Character.isLetterOrDigit(a.charAt(i+1))&&Character.isLetterOrDigit(a.charAt(i-1))) {
				ss.append(a.charAt(i));i++;
			}
			else {ss.append(a.charAt(i));i++;}
		}
        ss.append(a.charAt(i));
		char []in=ss.toString().toCharArray();int counter=0;
	    StringBuilder postfix=new StringBuilder();Stacks stack=new Stacks();
		StringBuilder v=new StringBuilder();i=0;
		while(i<in.length) {
			if(i<in.length&&in[i]=='-') {
			if(i<in.length&&i==0&&(in[i+1]=='('||in[i+1]=='-')) {
				postfix.append('(');postfix.append('0');postfix.append('-');i++;boolean f=false;
			    while(i<in.length&&f==false) {
					if(in[i]=='(') {v.append(in[i]);counter++;i++;
					if(counter==0) f=true;}
					else if(in[i]==')'&&counter!=0) {v.append(in[i]);counter--;i++;
					if(counter==0) f=true;}
					else if(in[i]==')'&&counter==0) f=true;
					else {v.append(in[i]);i++;}
			   }
			    HandlingNegativeSign nb=new HandlingNegativeSign();
			    postfix.append(nb.HandleNegative(v.toString()));
			    postfix.append(')');v.setLength(0);
			   }
			else if(i<in.length&&i!=0&&(in[i+1]=='('||in[i+1]=='-')&&(in[i-1]=='+'||in[i-1]=='-'||in[i-1]=='*'||in[i-1]=='/'||in[i-1]=='(')) {
				postfix.append('(');postfix.append('0');postfix.append('-');i++;boolean f=false;
			    while(i<in.length&&f==false) {
					if(in[i]=='(') {v.append(in[i]);counter++;i++;
					if(counter==0) f=true;}
					else if(in[i]==')'&&counter!=0) {v.append(in[i]);counter--;i++;
					if(counter==0) f=true;}
					else if(in[i]==')'&&counter==0) f=true;
					else {v.append(in[i]);i++;}
					}
			    HandlingNegativeSign nb=new HandlingNegativeSign();
			    postfix.append(nb.HandleNegative(v.toString()));
			    postfix.append(')');v.setLength(0);
			}
			else if(i<in.length&&i==0&&(in[i+1]!='+'&&in[i+1]!='-'&&in[i+1]!='*'&&in[i+1]!='/'&&in[i+1]!='(')) {
				postfix.append('(');postfix.append("0");postfix.append(in[i]);i++;
				 while(i<in.length&&in[i]!=')'&&in[i]!='+'&&in[i]!='-'&&in[i]!='*'&&in[i]!='/') {
					 postfix.append(in[i]);i++;}
				 postfix.append(')');
			  }
		   else if(i<in.length&&i!=0&&((in[i+1]!='+'&&in[i+1]!='-'&&in[i+1]!='*'&&in[i+1]!='/'&&in[i+1]!='(')
					&&(in[i-1]=='+'||in[i-1]=='-'||in[i-1]=='*'||in[i-1]=='/'||in[i-1]=='('))) {
			   postfix.append('(');postfix.append("0");postfix.append(in[i]);i++;
			   while(i<in.length&&in[i]!=')'&&in[i]!='+'&&in[i]!='-'&&in[i]!='*'&&in[i]!='/') {
					 postfix.append(in[i]);i++;}
			   postfix.append(')');
	        }
		   else {postfix.append(in[i]);i++;}
			}
			else {postfix.append(in[i]);i++;}
		}
		char []infix=postfix.toString().toCharArray();i=0;postfix.setLength(0);
		while(i<infix.length) {
			if(infix[i]!='+'&&infix[i]!='-'&&infix[i]!='*'&&infix[i]!='/'&&infix[i]!='('&&infix[i]!=')') {
				postfix.append(infix[i]);i++;}
			else if(infix[i]=='(') {stack.push(infix[i]);i++;}
			else if(infix[i]=='+'||infix[i]=='-'||infix[i]=='*'||infix[i]=='/') {
				if(infix[i]=='+') {
					postfix.append(" ");
					if(stack.isEmpty()||(char) stack.top.value=='(') stack.push(infix[i]);
					else {
						boolean found=false;Object element=stack.pop();postfix.append(element);postfix.append(" ");
						while(found==false) {
						    if(stack.isEmpty()||(char) stack.top.value=='(') {stack.push(infix[i]);found=true;}
							else {element=stack.pop();postfix.append(element);postfix.append(" ");}
						}
					}
					i++;}
				else if(infix[i]=='-') {
					postfix.append(" ");
						if(stack.isEmpty()||(char)stack.top.value=='('||(char)stack.top.value=='+'||(char)stack.top.value=='-') stack.push(infix[i]);
						else {
							boolean found=false;Object element=stack.pop();postfix.append(element);postfix.append(" ");
							while(found==false) {
							    if(stack.isEmpty()||(char) stack.top.value=='(') {stack.push(infix[i]);found=true;}
								else {element=stack.pop();postfix.append(element);postfix.append(" ");}
							}
						}
					i++;
				}
               else {
				postfix.append(" ");
				if(stack.isEmpty()||(char) stack.top.value=='('||(char) stack.top.value=='+'||(char) stack.top.value=='-') stack.push(infix[i]);
				else {
						boolean found=false;Object element=stack.pop();postfix.append(element);postfix.append(" ");
						while(found==false) {
							if(stack.isEmpty()||(char) stack.top.value=='('||(char) stack.top.value=='+'||(char) stack.top.value=='-') {stack.push(infix[i]);found=true;}
							else {element=stack.pop();postfix.append(element);postfix.append(" ");}
						}
				}
					i++;}
			}
			else {
				while((char) stack.top.value!='(') {
					postfix.append(" ");Object element=stack.pop();postfix.append(element);}
				stack.pop();i++;
			}}
		while(stack.isEmpty()==false) {
			postfix.append(" ");Object element=stack.pop();postfix.append(element);}
	   return postfix.toString();
 }
	/**
	 * @This Method takes string postfix expression as parameter
	 * @This Method used to evaluate and express value of postfix expression
	 * @This Method return integer value for  postfix expression
	 */
	public int evaluate(String expression) {
		char []str=expression.toCharArray();StringBuilder s=new StringBuilder();
		for(int i=0;i<str.length;i++) {
		if(Character.isLetter(str[i])){
			throw new IllegalStateException();}
		}
		Stacks stack=new Stacks();int i=0;
		while(i<str.length) {
		       while(i<str.length&&(str[i]=='+'||str[i]=='-'||str[i]=='*'||str[i]=='/'||str[i]==' ')) {
		    	  if(i<str.length&&str[i]=='+') {
					float element1=(float) stack.pop();
					float element2=(float) stack.pop();
					Object element3=element2+element1;
					stack.push(element3);i++;
				}
				else if(i<str.length-1&&str[i]=='-'&&Character.isDigit(str[i+1])) {
					while(str[i]!=' ') {s.append(str[i]);i++;}
					stack.push(Float.parseFloat(s.toString()));s.setLength(0);
				}
				else if(i<str.length&&str[i]=='-'&&str[i-1]==' ') {
					float element1=(float) stack.pop();
					float element2=(float) stack.pop();
					Object element3=element2-element1;
					stack.push(element3);i++;
				}
				else if(i<str.length&&str[i]=='*') {
					float element1=(float) stack.pop();
					float element2=(float) stack.pop();
					Object element3=element2*element1;
					stack.push(element3);i++;
				}
				else if(i<str.length&&str[i]=='/') {
					float element1=(float) stack.pop();
				    float element2=(float) stack.pop();
				    if(element1==0) throw new ArithmeticException("Invalid input");
				    else {
					Object element3=element2/element1;
					stack.push(element3);i++;}
				}
				else if(i<str.length&&str[i]==' ') i++;
				else break;
			}
			while(i<str.length&&(str[i]!='+'&&str[i]!='*'&&str[i]!='/'&&str[i]!=' ')) {
				s.append(str[i]);i++;
			}
		    if(i<str.length) {stack.push(Float.parseFloat(s.toString()));
			s.setLength(0);}
			}
		return Math.round((float)stack.top.value);
	}
}
