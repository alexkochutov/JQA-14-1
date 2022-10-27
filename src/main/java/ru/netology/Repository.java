package ru.netology;

public class Repository {
    private Ticket[] tickets = new Ticket[0];

    public void save(Ticket ticket) {
        if (findById(ticket.getId()) != null) {
            throw new AlreadyExistsException("Ticket with id " + ticket.getId() + "already exists");
        }
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }

    public Ticket[] findAll() {
        return tickets;
    }

    public Ticket findById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    public void removeByID(int id) {
        if (tickets.length == 0) {
            throw new EmptyArrayException("You are trying to remove from empty repository");
        }
        if (findById(id) == null) {
            throw new NotFoundException("Ticket with id " + id + "not found");
        }
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int copyToIndex = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[copyToIndex] = ticket;
                copyToIndex++;
            }
        }
        tickets = tmp;
    }
}