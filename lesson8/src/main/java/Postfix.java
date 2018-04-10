import java.util.Stack;

public class Postfix {

    private final static String DELIMETR = " ";

    public static String toPostfix (String infix) {

        String postfix = "";
        Stack<Character> operator = new Stack<Character>();
        char popped;
        boolean isOperator = false;
        boolean finished = false;
        String function = "";

        for (int i = 0; i < infix.length(); i++) {

            char get = infix.charAt(i);

            if(precedence(get)==4||!postfix.equals("")&&precedence(postfix.charAt(postfix.length()-2))==4&&precedence(get)==4){
                function = function.trim();
                function += get + DELIMETR;
            }

            if(!postfix.equals("")&&!isOperator(get)&&!function.equals("")){
                finished = true;
            }

            if (!isOperator(get)) {
                if (!postfix.equals("")&&!isOperator(postfix.charAt(postfix.length()-2))&&!isOperator) {
                    postfix = postfix.trim();
                    isOperator = false;
                }
                postfix += get + DELIMETR;
                if(finished){
                    finished = false;
                    postfix += function;
                    function = "";
                }
                isOperator = false;
            }
            else if (get == ')') {
                isOperator = true;
                while ((popped = operator.pop()) != '(')
                    postfix += popped + DELIMETR;
            }

            else if(precedence(get)!=4){
                isOperator = true;
                while (!operator.isEmpty() && get != '(' && precedence(operator.peek()) >= precedence(get))
                    postfix += operator.pop()+DELIMETR;
                operator.push(get);
            }
        }
        // pop any remaining operator
        while (!operator.isEmpty())
            postfix += operator.pop()+DELIMETR;

        return postfix;
    }

    private static boolean isOperator(char i) {
        return precedence(i) > 0;
    }

    private static int precedence(char i) {
        int j = 0;
        for(j = 0;j < 10; j++){
            if(i == j + '0')
                return 0;
        }
        if (i == '(' || i == ')') return 1;
        else if (i == '-' || i == '+') return 2;
        else if (i == '*' || i == '/') return 3;
        else return 4;
    }
}
