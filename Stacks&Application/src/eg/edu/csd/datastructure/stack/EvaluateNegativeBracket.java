package eg.edu.csd.datastructure.stack;
public class EvaluateNegativeBracket {
	public String infixToPostfix(String expression) {
		 String a=expression.replaceAll("\\s+", "");
		char []infix=a.toCharArray();int i=0;
		StringBuilder postfix=new StringBuilder();Stacks stack=new Stacks();
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
					if(i!=0&&((infix[i-1]=='+'||infix[i-1]=='-'||infix[i-1]=='*'||infix[i-1]=='/'
							||infix[i-1]=='(')&&(infix[i+1]!='+'&&infix[i+1]!='-'&&infix[i+1]!='*'
							&&infix[i+1]!='/'&&infix[i+1]!='('))) {
					    stack.push('(');stack.push('-');postfix.append('0');postfix.append(" ");
					    postfix.append(infix[i+1]);postfix.append(" ");
						Object element=stack.pop();postfix.append(element);
						stack.pop();i+=2;
					}
					else if(i==0&&(infix[i+1]!='+'&&infix[i+1]!='-'&&infix[i+1]!='*'
							&&infix[i+1]!='/'&&infix[i+1]!='(')) {
						stack.push('(');stack.push('-');postfix.append('0');postfix.append(" ");
					    postfix.append(infix[i+1]);postfix.append(" ");
						Object element=stack.pop();postfix.append(element);
						stack.pop();i+=2;
					}
					else if(i!=0&&(infix[i-1]=='+'||infix[i-1]=='-'||infix[i-1]=='*'||infix[i-1]=='/')
							&&infix[i+1]=='('){
						stack.push('(');stack.push('-');postfix.append('0');postfix.append(" ");
						StringBuilder v=new StringBuilder();v.append(infix[i+1]);
						i+=2;char c = 0;
						while(true) {
							if(infix[i]=='('||infix[i]==')') {
								if(infix[i]=='(') {
									c=0;v.append(infix[i]);i++;
								}
								else {
									if(infix[i]==c) {v.append(infix[i]);break;}
									else {c=')';v.append(c);i++;}
								}
							}
							else {v.append(infix[i]);i++;}
						}
					}
					else if(i==0&&infix[i+1]=='('){
						stack.push('(');stack.push('-');postfix.append('0');postfix.append(" ");
						StringBuilder v=new StringBuilder();v.append(infix[i+1]);
						i+=2;char c = 0;
						while(true) {
							if(infix[i]=='('||infix[i]==')') {
								if(infix[i]=='(') {
									c=0;v.append(infix[i]);i++;
								}
								else {
									if(infix[i]==c) {v.append(infix[i]);break;}
									else {c=')';v.append(c);i++;}
								}
							}
							else {v.append(infix[i]);i++;}
						}
					}
					else {
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
				}
               else {
					postfix.append(" ");
				if(stack.isEmpty()||(char) stack.top.value=='(') stack.push(infix[i]);
					else if((char) stack.top.value=='+'||(char) stack.top.value=='-') 
						stack.push(infix[i]);
					else {
						boolean found=false;Object element=stack.pop();postfix.append(element);postfix.append(" ");
						while(found==false) {
							if(stack.isEmpty()||(char) stack.top.value=='(') {stack.push(infix[i]);found=true;}
							else if((char) stack.top.value=='+'||(char) stack.top.value=='-') {stack.push(infix[i]);found=true;}
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
	public int evaluate(String expression) {
		char []str=expression.toCharArray();StringBuilder s=new StringBuilder();
		Stacks stack=new Stacks();int i=0;
		while(i<str.length) {
			while(i!=str.length&&(str[i]=='+'||str[i]=='-'||str[i]=='*'||str[i]=='/'||str[i]==' ')) {
				if(str[i]=='+') {
					float element1=(float) stack.pop();
					float element2=(float) stack.pop();
					Object element3=element2+element1;
					stack.push(element3);i++;
				}
				else if(str[i]=='-') {
					float element1=(float) stack.pop();
					float element2=(float) stack.pop();
					Object element3=element2-element1;
					stack.push(element3);i++;
				}
				else if(str[i]=='*') {
					float element1=(float) stack.pop();
					float element2=(float) stack.pop();
					Object element3=element2*element1;
					stack.push(element3);i++;
				}
				else if(str[i]=='/') {
					float element1=(float) stack.pop();
				    float element2=(float) stack.pop();
					Object element3=element2/element1;
					stack.push(element3);i++;
				}
				else if(str[i]==' ') i++;
				else break;
			}
			while(i!=str.length&&(str[i]!='+'&&str[i]!='*'&&str[i]!='/'&&str[i]!=' ')) {
				s.append(str[i]);i++;
			}
		    if(i!=str.length) {stack.push(Float.parseFloat(s.toString()));
			s.setLength(0);}
			}
		return Math.round((float)stack.top.value);
	}
}
