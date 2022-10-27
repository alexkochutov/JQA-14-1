package ru.netology;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {
    Ticket ticket1 = new Ticket(1, 10500, "VVO", "LED", 95);
    Ticket ticket2 = new Ticket(2, 12000, "SVO", "LED", 90);
    Ticket ticket3 = new Ticket(3, 9200, "DME", "LED", 105);

    /*
        Set of tests for findAll method
    */
    @Test
    public void shouldReturnEmptyArray() {
        Repository repo = new Repository();
        Ticket[] expected = {};
        Ticket[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnResult() {
        Repository repo = new Repository();
        repo.save(ticket1);
        Ticket[] expected = {ticket1};
        Ticket[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    /*
        Set of tests for save method
    */
    @Test
    public void shouldSaveInEmptyRepository() {
        Repository repo = new Repository();
        repo.save(ticket2);
        Ticket[] expected = {ticket2};
        Ticket[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveInNonEmptyRepository() {
        Repository repo = new Repository();
        repo.save(ticket1);
        repo.save(ticket2);
        Ticket[] expected = {ticket1, ticket2};
        Ticket[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSaveTheSameTicket() {
        Repository repo = new Repository();
        repo.save(ticket1);
        repo.save(ticket2);
        assertThrows(AlreadyExistsException.class, () -> {
            repo.save(ticket1);
        });
    }

    /*
        Set of tests for findById method
    */
    @Test
    public void shouldNotFindByIdInEmptyRepository() {
        Repository repo = new Repository();
        Ticket actual = repo.findById(3);
        assertNull(actual);
    }

    @Test
    public void shouldNotFindByIdInNonEmptyRepository() {
        Repository repo = new Repository();
        repo.save(ticket1);
        repo.save(ticket2);
        Ticket actual = repo.findById(3);
        assertNull(actual);
    }

    /*
        Set of tests for removeById method
    */
    @Test
    public void shouldThrowEmptyArrayException() {
        Repository repo = new Repository();
        assertThrows(EmptyArrayException.class, () -> {
            repo.removeByID(3);
        });
    }

    @Test
    public void shouldThrowNotFoundException() {
        Repository repo = new Repository();
        repo.save(ticket1);
        repo.save(ticket2);
        assertThrows(NotFoundException.class, () -> {
            repo.removeByID(3);
        });
    }

    @Test
    public void shouldRemoveByIdFromBegin() {
        Repository repo = new Repository();
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.removeByID(1);
        Ticket[] expected = {ticket2, ticket3};
        Ticket[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdFromEnd() {
        Repository repo = new Repository();
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.removeByID(3);
        Ticket[] expected = {ticket1, ticket2};
        Ticket[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }
}