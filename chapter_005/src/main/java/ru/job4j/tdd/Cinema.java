package ru.job4j.tdd;

import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public interface Cinema {
    List<Session> find(Predicate<Session> filter);

    Ticket buy(Account account, int row, int column, Calendar date);

    void add(Session session);

    List<Integer[]> availableSeat(Session session, Calendar date);

    boolean checkDate(Session session, Calendar date) throws UnvailableSessionException;

    boolean checkSeat(Session session, int row, int column, Calendar date) throws UnvailableSessionException;
}