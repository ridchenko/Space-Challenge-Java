package com.example.spacechallengejava;

public class Rocket implements Spaceship {
    int cost;
    int rocketWeight;
    int maxWeight;

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        return rocketWeight + item.getWeight() <= maxWeight;
    }

    @Override
    public void carry(Item item) {
            rocketWeight += item.getWeight();
    }

    public int getCost() {
        return cost;
    }

    public int getRocketWeight() {
        return rocketWeight;
    }
}
