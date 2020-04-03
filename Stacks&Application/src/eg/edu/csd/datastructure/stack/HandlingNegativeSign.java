package eg.edu.csd.datastructure.stack;
/**
 * @This Method takes string infix expression as parameter
 * @This Method used to handle negative sign
 * @This Method return string infix expression after handling
 */
public class HandlingNegativeSign {
	StringBuilder postfix=new StringBuilder();
	
	public String HandleNegative(String expression) {
		int i=0,counter=0;StringBuilder v=new StringBuilder();
		char []in=expression.toCharArray();
		while(i<in.length) {
			if(i<in.length&&in[i]=='-') {
			if(i<in.length&&i==0&&(in[i+1]=='('||in[i+1]=='-')) {
				postfix.append(v);postfix.append('(');postfix.append('0');postfix.append('-');i++;boolean f=false;
				v.setLength(0);
			    while(i<in.length&&f==false) {
			    	if(in[i]=='(') {v.append(in[i]);counter++;i++;
					if(counter==0) f=true;}
					else if(in[i]==')'&&counter!=0) {v.append(in[i]);counter--;i++;
					if(counter==0) f=true;}
					else if(in[i]==')'&&counter==0) f=true;
					else {v.append(in[i]);i++;}
			   }
			     HandleNegative(v.toString());
			     postfix.append(')');v.setLength(0);
			   }
			else if(i<in.length&&i!=0&&(in[i+1]=='('||in[i+1]=='-')&&(in[i-1]=='+'||in[i-1]=='-'||in[i-1]=='*'||in[i-1]=='/'||in[i-1]=='(')) {
				postfix.append(v);postfix.append('(');postfix.append('0');postfix.append('-');i++;boolean f=false;
				v.setLength(0);
			    while(i<in.length&&f==false) {
			    	if(in[i]=='(') {v.append(in[i]);counter++;i++;
					if(counter==0) f=true;}
					else if(in[i]==')'&&counter!=0) {v.append(in[i]);counter--;i++;
					if(counter==0) f=true;}
					else if(in[i]==')'&&counter==0) f=true;
					else {v.append(in[i]);i++;}
					}
			    HandleNegative(v.toString());
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
	 return postfix.toString();	
	}

}
