package Lesson1;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {

    private final List<T> fruits;

    public Box() {
        this.fruits = new ArrayList<>();
    }

    // получить содержание коробки
    public List<T> getFruitsBox() {
        return this.fruits;
    }

    public int getSizeBox() {
        return this.fruits.size();
    }

    public void addFruit(int number, T fruit) {
        for (int i = 0; i < number; i++) {
            fruits.add(fruit);
        }
    }

    // получить вес коробки с фруктами, если пустая - вес коробки 0
    public float getWeightBox() {
        if (fruits.size() == 0) return 0.0f;
        else return fruits.size() * fruits.get(0).getWeight();
    }

    // сравнить коробки: true вес равен
    public boolean compare(Box<?> anotherBox) {
        return this.getWeightBox() == anotherBox.getWeightBox();
    }

    // пересыпать фрукты из текущей коробки в другую коробку
    public void addAnotherBox(Box<T> anotherBox) {
        anotherBox.getFruitsBox().addAll(fruits);
        this.fruits.clear(); // освободить содержание текущей коробки
    }

}
