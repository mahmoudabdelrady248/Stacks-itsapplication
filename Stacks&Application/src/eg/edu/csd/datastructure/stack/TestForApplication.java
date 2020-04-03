package eg.edu.csd.datastructure.stack;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class TestForApplication {
    @Test
	void test() {
		Application test=new Application();
		try {
			assertEquals("a b * 5 +",test.infixToPostfix("a*b+5"));
			assertEquals("a b * c /",test.infixToPostfix("a*b/c"));
			assertEquals("a b c - d + / e a - * c *",test.infixToPostfix("(a/(b-c+d))*(e-a)*c"));
			assertEquals("a b / c - d e * + a c * -",test.infixToPostfix("a/b-c+d*e-a*c"));
			assertEquals("6 2 / 3 - 4 2 * +",test.infixToPostfix("6/2-3+4*2"));
			assertEquals(8,test.evaluate("6 2 / 3 - 4 2* + "));
			assertEquals("2 3 4 * +",test.infixToPostfix("2+3*4"));
			assertEquals(14,test.evaluate("2 3 4 * +"));
			assertEquals("1 2 + 7 *",test.infixToPostfix("(1+2)*7"));
			assertEquals(21,test.evaluate("1 2 + 7 *"));
			assertEquals("3 2 / 3 2 / +",test.infixToPostfix("3/2+3/2"));
			assertEquals(3,test.evaluate("3 2 / 3 2 / +"));
			assertEquals("1.5 1.5 +",test.infixToPostfix("1.5+1.5"));
			assertEquals(3,test.evaluate("1.5 1.5 +"));
			assertEquals("5 0 2 - * 3 -",test.infixToPostfix("(5*-2)-3"));
			assertEquals(-13,test.evaluate("5 0 2 - * 3 -"));
			assertEquals("1 3 0 5 - * -",test.infixToPostfix("1-(3*-5)"));
			assertEquals(16,test.evaluate("1 3 0 5 - * -"));
			assertEquals("0 1 - 3 5 - *",test.infixToPostfix("-1*(3-5)"));
			assertEquals(2,test.evaluate("0 1 - 3 5 - *"));
			assertEquals("5 0 0 7 4 * - 0 5 2 / - 7 * + - +",test.infixToPostfix("5+-(-(7*4)+-(5/2)*7)"));
			assertEquals(51,test.evaluate("5 0 0 7 4 * - 0 5 2 / - 7 * + - +"));
			assertEquals("0 3 - 2 0 2 - * + 0 0 0 0 0 0 0 0 0 0 0 0 5 - - - - - - - - - - - - -",test.infixToPostfix("-3+2*(-2)--(--(--(--(-----5))))"));
			assertEquals(-12,test.evaluate("0 3 - 2 0 2 - * + 0 0 0 0 0 0 0 0 0 0 0 0 5 - - - - - - - - - - - - -"));
			assertEquals("50 0 2 0 7 5 + - - - /",test.infixToPostfix("50/-(2--(7+5))"));
			assertEquals(-4,test.evaluate("50 0 2 0 7 5 + - - - /"));
			assertEquals("2 0 2 0 0 3 2 * - - + - +",test.infixToPostfix("2+-(2+-(-(3*2)))"));
			assertEquals(-6,test.evaluate("2 0 2 0 0 3 2 * - - + - +"));
			assertEquals("2 0 2.5 - 3.14 + 0 5.4 - 8.1 + * +",test.infixToPostfix("2+(-2.5+3.14)*(-5.4+8.1)"));
			assertEquals(4,test.evaluate("2 0 2.5 - 3.14 + 0 5.4 - 8.1 + * +"));
			assertEquals("0 0 2.5 - 3.5 0 5 2 / - * + 3 + -",test.infixToPostfix("-(-2.5+3.5*-(5/2)+3)"));
			assertEquals(8,test.evaluate("0 0 2.5 - 3.5 0 5 2 / - * + 3 + -"));
			assertEquals("0 10 - 0 0 3 - 5 * 0 2 3 * 0 2 - / 5 + 0 0 2 - - + - 3 0 1 - * - + - / 0 2 - / 0 5 - *",test.infixToPostfix("-10/-(-3*5+(-(2*3/-2+5+-(-2)))-(3*-1))/-2*-5"));
			assertEquals(-2,test.evaluate("0 10 - 0 0 3 - 5 * 0 2 3 * 0 2 - / 5 + 0 0 2 - - + - 3 0 1 - * - + - / 0 2 - / 0 5 - *"));
			assertEquals("0 2 - 3 3 + * 3 * 2 0 0 3 - - + * 0 0 3 5 * 0 2 5 / 5 3 * - - 0 0 2 0 1 - / - - / + 0 2 0 5 - * - - - - / 2 0 5 - + * 2 / 5 2 / + 2 0 2 - / -",test.infixToPostfix("-2(3+3)3(+2+++++-+-3)/-(-(++3*5+-(2/+5-5*++3)/--(2/-1)--(2*-5)))*(2+-5)/2+5/2-(2)/(-2)"));
			assertEquals(-114,test.evaluate("0 2 - 3 3 + * 3 * 2 0 0 3 - - + * 0 0 3 5 * 0 2 5 / 5 3 * - - 0 0 2 0 1 - / - - / + 0 2 0 5 - * - - - - / 2 0 5 - + * 2 / 5 2 / + 2 0 2 - / -"));
			assertEquals("0 0 0 2 0 0 332 - - / - - - 0 0 332 - 0 5 - 0 2 0 332 - * 3 1 - * 2 5 / - 0 0 5 - 0 332 - * - + - + 4 0 2 - / + * - *",test.infixToPostfix("---(2/--332)*--332(-5+-(2*-332(3-1)-2/5++--+5*-332)+4/-2)"));
			assertEquals(-5963,test.evaluate("0 0 0 2 0 0 332 - - / - - - 0 0 332 - 0 5 - 0 2 0 332 - * 3 1 - * 2 5 / - 0 0 5 - 0 332 - * - + - + 4 0 2 - / + * - *"));
			assertEquals("InvalidInput",test.infixToPostfix("5*$3"));
			assertEquals("InvalidInput",test.evaluate("a+b"));
			assertEquals("6 0 /",test.infixToPostfix("6/0"));
			assertEquals("Invalid input",test.evaluate("6 0 /"));
		} catch (Exception e) {
			System.out.println("Invalid input");
		}
		
	}
 }
