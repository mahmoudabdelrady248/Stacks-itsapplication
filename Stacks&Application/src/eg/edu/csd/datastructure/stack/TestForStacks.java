package eg.edu.csd.datastructure.stack;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class TestForStacks {
    @Test
	void test() {
		Stacks stack=new Stacks();
		stack.push(4);stack.push(5.5);stack.push('a');
		assertEquals('a',stack.peek());
		assertEquals(3,stack.size());
		assertEquals(false,stack.isEmpty());
		assertEquals('a',stack.pop());
		assertEquals(5.5,stack.peek());
		assertEquals(2,stack.size());
		assertEquals(false,stack.isEmpty());
		assertEquals(5.5,stack.pop());
		assertEquals(4,stack.peek());
		assertEquals(1,stack.size());
		assertEquals(false,stack.isEmpty());
		assertEquals(4,stack.pop());
		assertEquals(null,stack.peek());
		assertEquals(0,stack.size());
		assertEquals(true,stack.isEmpty());
		assertEquals(null,stack.pop());
		assertEquals(0,stack.size());
		assertEquals(true,stack.isEmpty());
	}

}
