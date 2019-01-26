package ru.geekbrains.classes;

import ru.geekbrains.classes.animals.Animal;

import java.util.Arrays;

public class Team {

    private final String name;
    private final Participant[] participants;

    public Team(String name, Participant[] participants) {
        this.name = name;
        this.participants = participants;
    }

    public String getName() {
        return name;
    }

    public Participant[] getParticipants() {
        return participants;
    }

    /**
     * Метод вывода информации обо всех членах команды
     */
    public void showAllNames() {
        System.out.println("Имена участников: ");
        for (Participant participant : participants) {
            System.out.println(getName(participant));
        }
        System.out.println();
    }

    /**
     * Метод для вывода информации о членах команды, прошедших дистанцию
     */
    public void showFinished() {
        System.out.println("Участники, прошедшие дистанцию: ");
        for (Participant participant : participants) {
            if (participant.isOnDistance()) {
                System.out.println(getName(participant));
            }
        }
    }

    /**
     * Метод возвращает имя участника. Независимо от того робот это или животное.
     * Этот метод позволяет не дубоировать код в showAllNames() и showFinished()
     *
     * @param participant Принимает тип Participant
     * @return String Имя участника
     */
    public String getName(Participant participant) {
        String name = "";
        if (participant instanceof Animal) {
            Animal animal = (Animal) participant;
            name = animal.getName();
        } else if (participant instanceof Robot) {
            Robot robot = (Robot) participant;
            name = robot.getName();
        }
        return name;
    }

    /**
     * Возвращает строковое представление объекта типа Team
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Команда " + name + " в составе: " + Arrays.toString(participants);
    }

    public void showResults() {
        showAllNames();
        System.out.println("Итоги:" + "\n");
        showFinished();
    }
}
