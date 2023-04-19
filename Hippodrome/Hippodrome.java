package Hippodrome;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses = new ArrayList<>();
    public static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public void run() throws InterruptedException {
        for (int i = 1; i <= 100; i++) {
            move();
            print();
            Thread.sleep(1000);
        }
    }

    public void move() {
        for (Horse horse: horses) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse: horses) {
            horse.print();
        }
    }
    public Horse getWinner() {
       return Collections.max(horses, (h1,h2)-> (int) (h1.getDistance() - h2.getDistance()));
    }
    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Horse> horsesList = new ArrayList();
        Hippodrome hippodrome = new Hippodrome(horsesList);
        hippodrome.horses.add(new Horse("\uD83D\uDC0E", 3, 0));
        hippodrome.horses.add(new Horse("\uD83D\uDC0E", 3, 0));
        hippodrome.horses.add(new Horse("\uD83D\uDC0E", 3, 0));
        game = hippodrome;
        game.run();
        game.printWinner();
    }
}
