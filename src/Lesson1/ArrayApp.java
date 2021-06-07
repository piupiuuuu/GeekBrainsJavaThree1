package Lesson1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
 * 2. Написать метод, который преобразует массив в ArrayList;
 */

public class ArrayApp {

    public static <T> ArrayList<T> convertToList(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }

    public static <T> void swapIndex(T [] array, int index1, int index2) {
        if(index1 < 0 || index1 >= array.length || index2 < 0 || index2 >= array.length) {
            System.out.println("Неправильный индекс");
            return;
        }
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
        System.out.println(Arrays.toString(array));
    }

    public static <T> void swapValue(T [] array, T value1,  T value2) {
        for(T element : array) {
            if(!value1.equals(element) || !value2.equals(element)) {
                System.out.println("В массиве нет таких элементов");
                return;
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value1)) {
                array[i] = value2;
            } else if (array[i].equals(value2)) {
                array[i] = value1;
            }
        }

        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        String[] array = {"aaa", "bbb", "ccc"};
        System.out.println(Arrays.toString(array));
        swapIndex(array, 1, 2);
        swapIndex(array, 1, 5);
        swapValue(array, "aaa", "ccc");
        swapValue(array, "B", "F");
        convertToList(array);
    }

}
