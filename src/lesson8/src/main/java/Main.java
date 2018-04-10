import java.io.StringReader;

public class Main {
    private static final String INFIX = "(1+cos(0))*(3+4)";

    public static void main(String[] args) {
        System.out.println(Postfix.toPostfix(INFIX));
        Readable src = new StringReader(Postfix.toPostfix(INFIX));
        System.out.println("calc: " + Calculator.calc(src));
    }
}
