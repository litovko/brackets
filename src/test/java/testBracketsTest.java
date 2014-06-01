
import module.Brackets;

import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class testBracketsTest {


    @Test
    public void testBrackets() {
        Brackets br = new Brackets("[](){(((}");
        assertEquals("not legal brackets", br.checkBrackets(), false);
        br.setStr("");
        assertEquals("not legal brackets", br.checkBrackets(), true);
        br.setStr(")");
        assertEquals("not legal brackets", br.checkBrackets(), false);
        br.setStr("(])");
        assertFalse("not legal brackets", br.checkBrackets());
        br.setStr("(a*(b*(c*[d+n]-e*d{f}-g)");
        assertTrue("not legal brackets", br.checkBrackets());

        br.setStr("(if (condition? x : y) sqrt(1 / x))");

        assertTrue(br.checkBrackets());

        br.setStr("Привет (тут я подумал (возможно) и передумал). (Возможно позже напишу)");

        assertTrue(br.checkBrackets());

        br.setStr(":-)");

        assertFalse(br.checkBrackets());

        br.setStr("())(");

        assertFalse(br.checkBrackets());
    }

    @Test
    public void checkBrackets()
    {
        Brackets b = new Brackets("");

        assertTrue("сбалансировано: '(if (condition? x : y) sqrt(1 / x))'", b.checkBrackets("(if (condition? x : y) sqrt(1 / x))"));

        assertTrue("сбалансировано: 'Привет (тут я подумал (возможно) и передумал). (Возможно позже напишу)'", b.checkBrackets("Привет (тут я подумал (возможно) и передумал). (Возможно позже напишу)"));

        assertFalse("не сбалансировано: ':-)'", b.checkBrackets(":-)"));

        assertFalse("не сбалансировано: '))('", b.checkBrackets("())("));
    }

}