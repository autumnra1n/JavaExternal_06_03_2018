package lesson1.task2;

import java.util.Random;

/**
 * Created by Михаил on 11.03.2018.
 */
public class Sorting {

    //ЗАДАЧА 1. Упорядочить одномерный масиве вначале отрицательные по возрастанию затем положительные по убыванию.

    //ЗАДАЧА 2. В одномерном массиве сначала положительные потом отрицательные за О(n).

    private final static int DEFAULT_CAPACITY = 10;//Эта константа введена для того что бы не создавать свои исключения
    //и не бросать их в коде, так как этого в условии задачи не было
    private final static int DEFAULT_RANGE = 100;//Аналогично

    public static void main(String[] args) {
        int[] a = generateRandomMass(15,1000);//Генерируеться массив из случайных чисел
        printMass(a);//Выводиться массив из случайных чисел
        System.out.println();
        System.out.println("------------------------РЕШЕНИЕ ПЕРВОЙ ЗАДАЧИ НА МАТРИЦЫ------------------------");
        System.out.println();
        printMass(quickSortMass(a));//Массив сортируеться и выводиться согласно Задаче 1 (Сортировка со сложностью o(n))
        System.out.println();
        System.out.println("------------------------РЕШЕНИЕ ВТОРОЙ ЗАДАЧИ НА МАТРИЦЫ------------------------");
        System.out.println();
        printMass(fullSortMass(quickSortMass(a)));//Массив сортируеться и выводиться согласно Задаче 2
        // (Упорядочить одномерный масив: вначале отрицательные повозрастанию затем положительные по убыванию)
    }

    private static int[] quickSortMass(int[] mass) {
        int a = 0;
        int b = mass.length - 1;
        for (int i = 0; i < mass.length && i <= b; i++) {
            int cur = mass[i];
            if (cur < 0) {
                swap(mass, i, a);
                a++;
            } else if (cur > 0) {
                swap(mass, i, b);
                b--;
                i--;
            }
        }
        return mass;
    }

    private static int[] fullSortMass(int[]mass){
        int i;
        for(i = 0; mass[i]<0; i++) {
            for (int j = 0; j < i; j++) {
                if (mass[j] > mass[i]) {
                    swap(mass, j, i);
                }
            }
            if(i==mass.length-1)
                break;
        }
        for(int n = i; n<mass.length; n++){
            for(int j = i ; j < n ; j++){
                if(mass[j]<mass[n]) {
                    swap(mass, j, n);
                }
            }
            if(n==mass.length-1)
                break;
        }
        return mass;
    }

    private static void swap(int[] mass, int i, int j) {
        int temp = mass[i];
        mass[i] = mass[j];
        mass[j] = temp;
    }

    private static int[] generateRandomMass(int capacity, int range){
        if(capacity<1){
            capacity=DEFAULT_CAPACITY;
            System.out.println("Установлена стандартная емкость массива так как указанная < 1");
        }
        if(range<1){
            range=DEFAULT_RANGE;
            System.out.println("Установлен стандартный диапазон значений массива так как указанный < 1");
        }
        int[] arr = new int[capacity];
        int i = 0;
        while(i<arr.length){
            arr[i] = new Random().nextInt(range*2)-range;
            i++;
        }
        System.out.println();
        return arr;
    }

    private static void printMass(int[] arr){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i<arr.length-1;i++){
            sb.append(arr[i]);
            sb.append(", ");
        }
        sb.append(arr[arr.length-1]);
        sb.append("]");
        System.out.println(sb);
        System.out.println();
    }
}
