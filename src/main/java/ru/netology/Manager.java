package ru.netology;

import java.util.Arrays;

public class Manager {
    private Repository repo;

    public Manager(Repository repo) {
        this.repo = repo;
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.findAll()) {
            if ((ticket.getFrom().equals(from)) && (ticket.getTo().equals(to))) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        return result;
    }

    public Ticket[] sortByCost(String from, String to) {
        Ticket[] result = findAll(from, to);
        Arrays.sort(result);
        return result;
    }
}