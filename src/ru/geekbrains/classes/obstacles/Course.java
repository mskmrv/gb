package ru.geekbrains.classes.obstacles;

import ru.geekbrains.classes.Participant;
import ru.geekbrains.classes.Team;

public class Course {
    private Obstacle[] obstacles = new Obstacle[3];

    public Course(int crossLength, int wallHeight, int waterLength) {
        obstacles[0] = new Cross(crossLength);
        obstacles[1] = new Wall(wallHeight);
        obstacles[2] = new Water(waterLength);
    }

    public void doIt(Team team){
        System.out.println("Начали!");
        for (Participant participant : team.getParticipants()) {
            for (Obstacle obstacle : obstacles) {
                obstacle.doIt(participant);
                if (!participant.isOnDistance()) {
                    break;
                }
            }
        }
        System.out.println("\n");
    }
}
