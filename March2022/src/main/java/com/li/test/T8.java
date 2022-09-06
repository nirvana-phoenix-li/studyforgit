package com.li.test;

public class T8 {

    public static void main(String[] args) {

        Cat cat = new Cat();
        cat.age=11;
        changeAge(cat);
        System.out.println(cat);

    }

    private static void changeAge(Cat cat){
        cat.age =66;
    }
}

class Cat {
    String name;
    int age;

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}