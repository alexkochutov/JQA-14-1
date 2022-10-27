package ru.netology;

public class Ticket implements Comparable<Ticket> {
    private int id;
    private int cost;
    private String from;
    private String to;
    private int duration;

    public Ticket(int id, int cost, String from, String to, int duration) {
        this.id = id;
        this.cost = cost;
        this.from = from;
        this.to = to;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public int getCost() {
        return cost;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public int compareTo(Ticket o) {
        if (this.getCost() > o.getCost()) {
            return 1;
        }
        if (this.getCost() < o.getCost()) {
            return -1;
        }
        return 0;
    }
}