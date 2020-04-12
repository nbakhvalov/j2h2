package ru.geekbrains.java2.hw;

class MyArrayDataException extends RuntimeException {
    MyArrayDataException(String msg) {
        super("Ошибка преобразования элемента массива в целое число.\n" + " " + msg);
    }

}