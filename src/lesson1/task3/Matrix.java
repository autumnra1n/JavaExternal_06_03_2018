package lesson1.task3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Михаил on 12.03.2018.
 */
public class Matrix {

//    ЗАДАЧА 1. Дана целочисленная прямоугольная матрица.
//    Упорядочить столбцы по убыванию среднего значения.

//    ЗАДАЧА 2. Дана целочисленная прямоугольная матрица.
//    Упорядочить строки по самой длинной серии одинаковых элементов.

//    ЗАДАЧА 3. Дана квадратная матрица A порядка M (M — нечетное число). Начи-
//    ная с элемента A1,1 и перемещаясь по часовой стрелке, вывести все ее эле-
//    менты по спирали: первая строка, последний столбец, последняя строка в
//    обратном  порядке,  первый  столбец  в  обратном  порядке,  оставшиеся  эле-
//    менты второй строки и т. д.; последним выводится центральный элемент
//    матрицы.

    private final static int DEFAULT_CAPACITY = 7;
    private final static int DEFAULT_RANGE = 100;

    public static void main(String[] args) {
        int[][] rectangularMatrix1 = generateRectangularRandomMatrix(8,10,10);
        System.out.println();
        System.out.println("------------------------РЕШЕНИЕ ПЕРВОЙ ЗАДАЧИ НА МАТРИЦЫ------------------------");
        System.out.println();
        printMatrix(rectangularMatrix1);
        printMatrix(sortByAverageValue(rectangularMatrix1));
        System.out.println();

        int[][] rectangularMatrix2 = generateRectangularRandomMatrix(5,7,4);
        System.out.println();
        System.out.println("------------------------РЕШЕНИЕ ВТОРОЙ ЗАДАЧИ НА МАТРИЦЫ------------------------");
        System.out.println();
        printMatrix(rectangularMatrix2);
        printMatrix(sortByEqualElements(rectangularMatrix2));
        System.out.println();

        final int[][] squareMatrix = generateOddOrderRandomSquareMatrix(20,100);
        System.out.println();
        System.out.println("------------------------РЕШЕНИЕ ТРЕТЬЕЙ ЗАДАЧИ НА МАТРИЦЫ------------------------");
        System.out.println();
        printMatrix(squareMatrix);
        spiralPrint(squareMatrix);
    }

    private static void spiralPrint(int matrix[][]){
        int i, k = 0, l = 0;
        int rows = matrix.length;
        int columns = matrix[0].length;
        while (k < rows && l < columns) {
            for (i = l; i < columns; ++i) {
                System.out.print(matrix[k][i]+" ");
            }
            k++;
            for (i = k; i < rows; ++i) {
                System.out.print(matrix[i][columns-1]+" ");
            }
            columns--;
            if (k < columns){
                for (i = columns-1; i >= l; --i) {
                    System.out.print(matrix[rows-1][i]+" ");
                }
                rows--;
            }
            if (l < columns) {
                for (i =rows-1; i >= k; --i) {
                    System.out.print(matrix[i][l]+" ");
                }
                l++;
            }
        }
    }

    private static int[][] sortByEqualElements(int[][]matrix) {
        int i, j, k;
        int rows = matrix.length;
        int max1 = 0;
        int max2 = 0;
        int columns = matrix[0].length;
        int count = 0;
        for (i = 0; i < rows; i++) {
            for (k = 0; k < columns - 1; k++) {
                if(matrix[i][k]==matrix[i][k+1])
                    count++;
                if(count>max1)
                    max1=count;
            }
            for (j = 0; j < rows; j++) {
                count=0;
                for (k = 0; k < columns - 1; k++) {
                    if (matrix[j][k] == matrix[j][k + 1])
                        count++;
                    if(count>max2)
                        max2=count;
                }
                if (max2 < max1) {
                    swapRows(matrix, i, j);
                }
                count=0;
                max2 = 0;
            }
            max1 = 0;
        }
        return matrix;
    }

    private static int[][] sortByAverageValue(int[][]matrix){
        int i,j,k;
        int rows = matrix.length;
        double sum1 = 0;
        double sum2 = 0;
        int columns = matrix[0].length;
        for(i = 0; i<columns; i++){
            for(k = 0; k<rows; k++) {
                sum1+=matrix[k][i];
            }
            for(j = 0; j<columns; j++) {
               for(k = 0; k<rows; k++) {
                   sum2+=matrix[k][j];
               }
               if((sum2/matrix.length)<(sum1/matrix.length)){
                   swapColumns(matrix, i, j);
               }
               sum2 = 0;
            }
            sum1 = 0;
        }
        return matrix;
    }

    private static void swapRows(int[][] matrix, int i, int j) {
        int columns = matrix[0].length;
        for(int a = 0; a<columns;a++){
            int temp = matrix[i][a];
            matrix[i][a] = matrix[j][a];
            matrix[j][a] = temp;
        }
    }

    private static void swapColumns(int[][] matrix, int i, int j) {
        int rows = matrix.length;
        for(int a = 0; a<rows;a++){
            int temp = matrix[a][i];
            matrix[a][i] = matrix[a][j];
            matrix[a][j] = temp;
        }
    }

    private static void printMatrix(int[][]matrix){
        StringBuilder sb = new StringBuilder();
        for (int[] row : matrix) {
            sb.append("[");
            for (int i = 0; i<row.length-1;i++) {
                sb.append(row[i]);
                sb.append(", ");
            }
            sb.append(row[row.length-1]);
            sb.append("]");
            sb.append("\n");
        }
        System.out.print(sb);
        System.out.println();
    }

    private static int[][] generateOddOrderRandomSquareMatrix(int capacityRange, int valueRange){
        if(valueRange<0){
            valueRange = DEFAULT_RANGE;
        }
        if(capacityRange<2){
            capacityRange = DEFAULT_CAPACITY;
        }
        int x=(int)(Math.random()*capacityRange);
        x+=(x%2==0?1:0);
        if(x<2){
            x = DEFAULT_CAPACITY;
        }
        int [][] matrix = new int[x][x];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = new Random().nextInt(valueRange*2)-valueRange;
            }
        }
        return matrix;
    }

    private static int[][] generateRectangularRandomMatrix(int rowCapacityRange, int columnCapacityRange, int valueRange){
        if(valueRange<0){
            valueRange = DEFAULT_RANGE;
        }
        if(rowCapacityRange<2){
            rowCapacityRange = DEFAULT_CAPACITY;
        }
        if(columnCapacityRange<2){
            columnCapacityRange = DEFAULT_CAPACITY;
        }
        int [][] matrix = new int[rowCapacityRange][columnCapacityRange];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = new Random().nextInt(valueRange*2)-valueRange;
            }
        }
        return matrix;
    }
}
