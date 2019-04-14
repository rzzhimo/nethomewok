import org.junit.Test;

import static org.junit.Assert.*;

public class TestWord {

    @Test
    public void TestgetChar() {
        WordLadder w1 = new WordLadder();
        assertEquals('a', w1.getChar(0));
        assertNotEquals('a', w1.getChar(1));

    }

    @Test
    public void TestsetUsed() {
        WordLadder W1 = new WordLadder();
        W1.setUsed("dog");
        assertTrue(W1.isUsed("dog"));
        assertFalse(W1.isUsed("cat"));
    }

    @Test
    public void TestisUsed() {
        WordLadder W1 = new WordLadder();
        assertFalse(W1.isUsed("dog"));
        W1.setUsed("dog");
        assertTrue(W1.isUsed("dog"));
        assertFalse(W1.isUsed("cat"));
    }

    @Test
    public void testDicInit() throws Exception {
        try {
            WordLadder w1 = new WordLadder();


        } catch (IllegalAccessError error) {
            System.out.println("IllegalAccessError error");
        } catch (NoSuchMethodError error) {
            System.out.println("not such method");
        }
    }

    @Test
    public void Testdfs() {
        WordLadder w1 = new WordLadder();
        assertEquals("cat cag cog dog ", w1.dfs("dog", "cat"));
        assertEquals("peach peace pease peise prise arise anise anile anole amole ample apple ",
                w1.dfs("apple", "peach"));
        assertEquals("data date cate cade code ", w1.dfs("code", "data"));
        assertEquals("there is no ladder", w1.dfs("code", "peach"));
    }


}