
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
    }

}