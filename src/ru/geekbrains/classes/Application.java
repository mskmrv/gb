package ru.geekbrains.classes;

import ru.geekbrains.classes.animals.Cat;
import ru.geekbrains.classes.animals.Dog;
import ru.geekbrains.classes.obstacles.*;

public class Application {

    public static void main(String[] args) {
        Course c = new Course(5, 3, 7);

        Participant cat1 = new Cat("Барсик", 10, 12, 0);
        Participant dog = new Dog("Дружок", 20, 5, 15);
        Participant cat2 = new Cat("Мурзик", 9, 14, 0);
        Participant robot = new Robot("Вертер", 50, 50, 50);

        Team team = new Team("Зоотех", cat1, dog, cat2, robot);
        c.doIt(team);
        team.showResults();
    }
}
