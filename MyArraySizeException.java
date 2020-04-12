package ru.geekbrains.java2.hw;

class MyArraySizeException extends RuntimeException {
    MyArraySizeException(String msg) {
        super("Ошибка размерности массива.\n" + " " + msg);
    }

}