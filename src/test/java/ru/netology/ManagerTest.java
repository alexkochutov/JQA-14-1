package ru.netology;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    Ticket ticket1 = new Ticket(1, 11500, "VVO", "LED", 95);
    Ticket ticket2 = new Ticket(2, 12000, "SVO", "LED", 90);
    Ticket ticket3 = new Ticket(3, 9200, "DME", "LED", 105);
    Ticket ticket4 = new Ticket(4, 10500, "VVO", "LED", 100);
    Ticket ticket5 = new Ticket(5, 12900, "VVO", "LED", 90);
    Ticket ticket6 = new Ticket(6, 25400, "VVO", "LED", 80);
    Ticket ticket7 = new Ticket(7, 18390, "VVO", "LED", 100);

    @Test
    public void shouldFindAllInEmptyRepository() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("VVO", "DME");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllInNonEmptyRepository() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("VVO", "DME");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllOneResult() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        Ticket[] expected = {ticket1};
        Ticket[] actual = manager.findAll("VVO", "LED");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllFewResults() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        repo.save(ticket7);
        repo.save(ticket4);
        repo.save(ticket1);
        repo.save(ticket5);
        repo.save(ticket2);
        repo.save(ticket6);
        repo.save(ticket3);
        Ticket[] expected = {ticket7, ticket4, ticket1, ticket5, ticket6};
        Ticket[] actual = manager.findAll("VVO", "LED");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllFewResultsSortedByCost() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        repo.save(ticket7);
        repo.save(ticket4);
        repo.save(ticket1);
        repo.save(ticket5);
        repo.save(ticket2);
        repo.save(ticket6);
        repo.save(ticket3);
        Ticket[] expected = {ticket4, ticket1, ticket5, ticket7, ticket6};
        Ticket[] actual = manager.sortByCost("VVO", "LED");
        assertArrayEquals(expected, actual);
    }
}