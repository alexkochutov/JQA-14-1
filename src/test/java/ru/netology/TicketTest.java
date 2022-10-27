package ru.netology;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TicketTest {
    Ticket ticket1 = new Ticket(1, 10500, "VVO", "LED", 95);
    Ticket ticket2 = new Ticket(2, 12000, "SVO", "LED", 90);
    Ticket ticket3 = new Ticket(3, 12000, "DME", "LED", 105);

    @Test
    public void shouldGetId() {
        int expected = 1;
        int actual = ticket1.getId();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetCost() {
        int expected = 12000;
        int actual = ticket2.getCost();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetFrom() {
        String expected = "VVO";
        String actual = ticket1.getFrom();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetTo() {
        String expected = "LED";
        String actual = ticket1.getTo();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetDuration() {
        int expected = 90;
        int actual = ticket2.getDuration();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareToFirstLessThanSecond() {
        int expected = -1;
        int actual = ticket1.compareTo(ticket2);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareToFirstMoreThanSecond() {
        int expected = 1;
        int actual = ticket2.compareTo(ticket1);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareToFirstEqualSecond() {
        int expected = 0;
        int actual = ticket2.compareTo(ticket3);
        assertEquals(expected, actual);
    }
}