package org.example;

interface Person {
    String name = null;
    int age = 0;

    Person createPerson(String name, int age);

    Person createPerson(String name);
}

class Teacher implements Person {
    public String name;
    public int age;
    public String course = "Java";

    public Teacher(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person createPerson(String name) {
        return new Teacher(name, 0);
    }

    public Person createPerson(String name, int age) {
        return new Teacher(name, age);
    }
}


class Student implements Person {
    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person createPerson(String name) {
        return new Student(name, 0);
    }

    public Person createPerson(String name, int age) {
        return new Student(name, age);
    }
}


public class OverAndFriends {
    public static void main(String[] args) {
        Person person1 = new Student("John", 25);
        Person person2 = new Teacher("John", 25);

        System.out.println(person1.createPerson("John").name);
        System.out.println(person2.createPerson("John", 24).name);
    }
}
