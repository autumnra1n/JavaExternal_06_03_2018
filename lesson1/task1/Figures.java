package lesson1.task1;

/**
 * Created by Михаил on 11.03.2018.
 */
public class Figures {

//    ЗАДАЧА 1
//    Используя циклы и метод:
//            System.out.print("* "), System.out.print("  "),
//            System.out.print("\n")
//            (для перехода на новую строку).
//    Выведите на экран:
//            · прямоугольник
//            · прямоугольный треугольник
//            · равносторонний треугольник
//            · ромб

    public static void main(String[] args) {
        drawRectangle(24,46);
        drawRightTriangle(35);
        drawEquilateralTriangle(41);
        drawRhombus(37);
    }

    private static void drawRectangle(int height, int width) {

         //Этот код генерирует прямоугольник с точки зрения геометрии, а не количества знаков "*", в условии задачи
         //не было сказано про то, чем должны быть входящие параметры метода - высотой и шириной или количеством звездочек
         //в одной стороне и в другой, потому я счел более правильным во входящие параметры передавать именно высоту и
         //ширину с точки зрения геометрии

        if (height < 2 || width < 2) {
            System.out.println("Give correct parameters for rectangle");
        } else {
            for (int i = 0; i < width; i++) {
                System.out.print("*");
                System.out.print(" ");
            }
            System.out.print("\n");
            for (int i = 0; i < height - 2; i++) {
                System.out.print("*");
                for (int j = 0; j < (width - 2) * 2 + 1; j++) {
                    System.out.print(" ");
                }
                System.out.print("*");
                System.out.print("\n");
            }
            for (int i = 0; i < width; i++) {
                System.out.print("*");
                System.out.print(" ");
            }
            System.out.println("\n");
        }
    }

    private static void drawRightTriangle(int side) {

         //Этот код генерирует прямоугольный треугольник исходя из соображений, изложенных выше, так как мы рисуем
         //лишь с помощью звездочек, а не векторов, я счел нужным передавать лишь одну сторону в метод, что бы фигура
         //хотя бы выглядела как треугольник, а не как нечто, у которого один катет это одна звездочка, а другой - 100 звездочек
         //фигура не имеет полостей внутри ее площади в виде пробелов, так как об этом в условии задачи не было сказано

        if (side < 2) {
            System.out.println("Give correct parameters for right triangle");
        } else {
            for (int i = 0; i < side; i++) {
                for (int j = 0; j < i; j++) {
                    System.out.print(" ");
                }
                for (int j = i; j < side; j++) {
                    System.out.print("*");
                }
                System.out.print("\n");
            }
            System.out.print("\n");
        }
    }

    private static void drawEquilateralTriangle(int side) {

         //тут все аналогично выше сказанному
         //фигура не имеет полостей внутри ее площади в виде пробелов, так как об этом в условии задачи не было сказано

        if (side < 3) {
            System.out.println("Give correct parameters for equilateral triangle");
        }
        else{
            for (int i = 1; i <= side; i++) {
                for (int j = side - 1; j >= i; j--) {
                    System.out.print(" ");
                }
                for (int k = 1; k <= (2 * i - 1); k++) {
                    System.out.print("*");
                }
                System.out.print("\n");
            }
            System.out.print("\n");
        }

    }

    private static void drawRhombus(int side) {

        //фигура не имеет полостей внутри ее площади в виде пробелов, так как об этом в условии задачи не было сказано

        if (side < 2) {
            System.out.println("Give correct parameters for rhombus");
        }
        else {
            for (int i = 1; i <= side; i++) {
                for (int j = side - 1; j >= i; j--) {
                    System.out.print(" ");
                }
                for (int k = 1; k <= (2 * i - 1); k++) {
                    System.out.print("*");
                }
                System.out.print("\n");
            }
            for (int i = 0; i <side; i++) {
                for (int j = 1; j <= i+1; j++) {
                    System.out.print(" ");
                }
                for (int k = side; k >=(2 * i - side + 4); k--) {
                    System.out.print("*");
                }
                System.out.print("\n");
            }
        }
    }
}
