import java.io.StringReader;
import java.util.Scanner;
import java.util.Stack;

public class Calculator{

    public static double calc(Readable src) {
        Stack<Double> stack = new Stack<>();
        Scanner in = new Scanner(src);
        double x = 0;
        double y = 0;

        while(in.hasNext()) {
            if (in.hasNextDouble()) {
                stack.push(in.nextDouble());
            } else {
                String op = in.next();
                switch (op) {
                    case "+":
                        x = stack.pop();
                        y = stack.pop();
                        stack.push(y + x);
                        break;
                    case "-":
                        x = stack.pop();
                        y = stack.pop();
                        stack.push(y - x);
                        break;
                    case "*":
                        x = stack.pop();
                        y = stack.pop();
                        stack.push(y * x);
                        break;
                    case "/":
                        x = stack.pop();
                        y = stack.pop();
                        stack.push(y / x);
                        break;
                    case "%":
                        x = stack.pop();
                        y = stack.pop();
                        stack.push(y % x);
                        break;
                    case "sin":
                        stack.push(Math.sin(stack.pop()));
                        break;
                    case "cos":
                        stack.push(Math.cos(stack.pop()));
                        break;
                    case "tan":
                        stack.push(Math.tan(stack.pop()));
                        break;
                    case "asin":
                        stack.push(Math.asin(stack.pop()));
                        break;
                    case "acos":
                        stack.push(Math.acos(stack.pop()));
                        break;
                    case "atan":
                        stack.push(Math.atan(stack.pop()));
                        break;
                    case "atan2":
                        x = stack.pop();
                        y = stack.pop();
                        stack.push(Math.atan2(y, x));
                        break;
                    case "toRadians":
                        stack.push(Math.toRadians(stack.pop()));
                        break;
                    case "toDegrees":
                        stack.push(Math.toDegrees(stack.pop()));
                        break;
                    case "exp":
                        stack.push(Math.exp(stack.pop()));
                        break;
                    case "sinh":
                        stack.push(Math.sinh(stack.pop()));
                        break;
                    case "cosh":
                        stack.push(Math.cosh(stack.pop()));
                        break;
                    case "tanh":
                        stack.push(Math.tanh(stack.pop()));
                        break;
                    case "pow":
                        x = stack.pop();
                        y = stack.pop();
                        stack.push(Math.pow(x, y));
                        break;
                    case "log":
                        stack.push(Math.log(stack.pop()));
                        break;
                    case "log10":
                        stack.push(Math.log10(stack.pop()));
                        break;
                    case "sqrt":
                        stack.push(Math.sqrt(stack.pop()));
                        break;
                    case "cbrt":
                        stack.push(Math.cbrt(stack.pop()));
                        break;
                    case "signum":
                        stack.push(Math.signum(stack.pop()));
                        break;
                    case "ceil":
                        stack.push(Math.ceil(stack.pop()));
                        break;
                    case "floor":
                        stack.push(Math.floor(stack.pop()));
                        break;
                    case "rint":
                        stack.push(Math.rint(stack.pop()));
                        break;
                    case "round":
                        stack.push((double) Math.round(stack.pop()));
                        break;
                    case "abs":
                        stack.push(Math.abs(stack.pop()));
                        break;
                    case "max":
                        x = stack.pop();
                        y = stack.pop();
                        stack.push(Math.max(y, x));
                        break;
                    case "min":
                        x = stack.pop();
                        y = stack.pop();
                        stack.push(Math.min(y, x));
                        break;
                    case "hypot":
                        x = stack.pop();
                        y = stack.pop();
                        stack.push(Math.hypot(y, x));
                        break;
                    default:
                        System.err.println("Illegal function." + op);

                }
            }
        }
        return stack.pop();
    }
}
