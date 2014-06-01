package module;

import java.util.Stack;

/**
* Created by lss on 5/26/14.
*/
public class Brackets {
    private String Str;

    public Brackets(String str) {
        Str = str;
    }

    public String getStr() {
        return Str;
    }

    public void setStr(String str) {
        Str = str;
    }
    public boolean checkBrackets () {
        Stack<Character> st = new Stack();
        Character ch;
        for (int i=0; i<Str.length();i++) {
            ch=Str.charAt(i);
            //System.out.println("peek:"+st.peek());
            switch (ch) {
                case '(': st.push(ch); break;
                case '{': st.push(ch); break;
                case '[': st.push(ch); break;
                case ')':
                    if (!st.empty() && st.peek()=='(')
                        st.pop();
                    else {
                       // System.out.println(Str.substring(0,i+1)+"<illegal bracket");
                        return false;
                    }
                    break;
                case '}':
                    if (!st.empty() && st.peek()=='{')
                        st.pop();
                    else {
                       // System.out.println(Str.substring(0,i+1)+"<illegal bracket");
                       return false;
                    }
                    break;
                case ']':
                    if (!st.empty() && st.peek()=='[')
                        st.pop();
                    else {
                        //System.out.println(Str.substring(0,i+1)+"<illegal bracket");
                        return false;
                    }
                    break;
            }
            //System.out.println("stack: " + st+"i="+i);
        }
        return true;

    }

    public boolean checkBrackets(String string)
    {
        return checkBrackets(string, 0);
    }

    private boolean checkBrackets(String string, int start)
    {
        if (string.isEmpty()) return start == 0;
        else if (string.startsWith("(")) return checkBrackets(string.substring(1), start + 1);
        else if (string.startsWith(")")) return (start > 0 && checkBrackets(string.substring(1), start - 1));
        else return checkBrackets(string.substring(1), start);
    }

}
