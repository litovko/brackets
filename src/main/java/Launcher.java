import module.Brackets;

public class Launcher {

    public static void main(String[] args) {
        Brackets br = new Brackets("[](){(((}");
        System.out.println("Start="+br.getStr());
        System.out.println("Result="+br.checkBrackets());
    }
}