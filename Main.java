package ru.geekbrains.java2.hw;

import static java.lang.Integer.valueOf;
/*
*
* author: Nikolay Bakhvalov
*
 */


//1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
// при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
//2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
// Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
// должно быть брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.
//3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException
// и MyArrayDataException, и вывести результат расчета.



public class Main {

    public static void main(String[] args) {

        String[][] stringArray0 = new String[][] {
                {"1", "r", "3", "8"},
                {"1", "2", "8", "4"},
                {"1", "8", "3", "4"},
                {"8", "2", "3", "4"}
        };
        String[][] stringArray1 = new String[][] {
                {"2", "3", "4", "9"},
                {"2", "3", "9", "5"},
                {"2", "9", "4", "5"},
                {"9", "3", "4", "5"}
        };
        String[][] stringArray2 = new String[][] {
                {"8", "r", "9"},
                {"3", "8", "9", "5"},
                {"3", "9", "8", "5"},
                {"9", "5", "3", "8"}
        };
        String[][] stringArray3 = new String[][] {
                {"1", "2", "3", "6"},
                {"1", "2", "6", "9"},

        };

        try {
            System.out.println("Сумма массива равна " + transformAndSum(stringArray0));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e);
        }
        try {
            System.out.println("Сумма массива равна " + transformAndSum(stringArray1));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e);
        }
        try {
            System.out.println("Сумма массива равна " + transformAndSum(stringArray2));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e);
        }
        try {
            System.out.println("Сумма массива равна " + transformAndSum(stringArray3));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e);
        }
    }

    private static int transformAndSum (String[][] in) throws MyArraySizeException, MyArrayDataException {
        int arrDim = 4;
        int sum = 0;

        // Проверяем, что у массива 4 основных измерения
        if (in.length != 4) {
            throw new MyArraySizeException(String.format("Размерность массива должна быть %dх%d.", arrDim, arrDim));
        }
        // Т.к. размерность вложенных массивов может быть не всегда одинакова, то проверяем,
        // что в каждом из 4-х основных измерений находится массив ровно из 4 элементов
        for (int i = 0; i < in.length; i++) {
            if (in[i].length != 4) {
                throw new MyArraySizeException(String.format("Размерность массива должна быть %dх%d.", arrDim, arrDim));
            }
        }

        for (int i = 0; i < in.length; i++) {
            for (int j = 0; j < in[i].length; j++) {
                try {
                    sum += valueOf(in[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(String.format("В позиции [%d][%d] исходного массива находится не целое число %s.", i, j, in[i][j]));
                }
            }
        }

        return sum;
    }

}
