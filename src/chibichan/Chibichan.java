package chibichan;

import java.io.Serializable;
import java.util.Random;

public class Chibichan implements Serializable {

    private String name;
    private int hunger;
    private int happiness;
    private int energy;
    private int health;
    private boolean alive;

    // This one is not saved in the file (it's marked transient)
    public transient Random random;

    // Constructor to make a new pet
    public Chibichan(String name) {
        this.name = name;
        this.hunger = 50;
        this.happiness = 50;
        this.energy = 50;
        this.health = 100;
        this.alive = true;
        this.random = new Random();
    }

    // These are the things the pet can do:

    public void feed() {
        if (alive) {
            hunger -= 20;
            if (hunger < 0) hunger = 0;
            health += 5;
            if (health > 100) health = 100;
        }
    }

    public void play() {
        if (alive && energy > 10) {
            happiness += 20;
            if (happiness > 100) happiness = 100;
            energy -= 10;
        }
    }

    public void sleep() {
        if (alive) {
            energy += 30;
            if (energy > 100) energy = 100;
            health += 10;
            if (health > 100) health = 100;
        }
    }

    public void takeMedicine() {
        if (alive && health < 50) {
            health += 30;
            if (health > 100) health = 100;
        }
    }

    public void bathe() {
        if (alive) {
            happiness += 10;
            if (happiness > 100) happiness = 100;
        }
    }

    public void walk() {
        if (alive && energy > 10) {
            happiness += 10;
            if (happiness > 100) happiness = 100;
            energy -= 10;
            health += 5;
            if (health > 100) health = 100;
        }
    }

    public void randomEvent() {
        if (alive) {
            int event = random.nextInt(5);
            if (event == 0) {
                health -= 20;
                if (health < 0) health = 0;
            } else if (event == 1) {
                happiness += 15;
                if (happiness > 100) happiness = 100;
            } else if (event == 2) {
                energy += 20;
                if (energy > 100) energy = 100;
            } else if (event == 3) {
                hunger += 15;
                if (hunger > 100) hunger = 100;
                health -= 10;
                if (health < 0) health = 0;
            }
            // else nothing happens
        }
    }

    // This happens every time after an action
    public void tick() {
        if (alive) {
            hunger += random.nextInt(11) + 5;
            if (hunger > 100) hunger = 100;

            happiness -= random.nextInt(6) + 5;
            if (happiness < 0) happiness = 0;

            energy -= random.nextInt(6) + 5;
            if (energy < 0) energy = 0;

            health -= random.nextInt(4) + 2;
            if (health < 0) health = 0;

            if (hunger >= 100 || happiness <= 0 || energy <= 0 || health <= 0) {
                alive = false;
            }
        }
    }

    // === Getters ===
    public String getName() {
        return name;
    }

    public int getHunger() {
        return hunger;
    }

    public int getHappiness() {
        return happiness;
    }

    public int getEnergy() {
        return energy;
    }

    public int getHealth() {
        return health;
    }

    public boolean isAlive() {
        return alive;
    }

    // === Setters (not used in the GUI yet, but just in case) ===
    public void setName(String name) {
        this.name = name;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}

