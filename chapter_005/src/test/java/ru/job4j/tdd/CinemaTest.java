package ru.job4j.tdd;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import javax.xml.crypto.dsig.spec.ExcC14NParameterSpec;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class CinemaTest {

    @Test
    public void buy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Test
    public void find() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList(new Session3D())));
    }

    @Test
    public void availableSeat() {
        Cinema cinema = new Cinema3D();
        Session session = new Session3D();
        Calendar dateWish = Calendar.getInstance();
        dateWish.set(2021, 5, 20);
        cinema.add(session);
        List<Integer[]> availableSeats = Arrays.asList(new Integer[] {1, 3, 6}, new Integer[] {3, 5, 7});
        assertThat(cinema.availableSeat(session, dateWish), is(availableSeats));
    }

    @Test
    public void checkDate() throws UnvailableSessionException {
        Cinema cinema = new Cinema3D();
        Session session = new Session3D();
        cinema.add(session);
        Calendar dateWish = Calendar.getInstance();
        dateWish.set(2021, 5, 20);
        assertTrue(cinema.checkDate(session, dateWish));
    }

    @Test
    public void checkSeat() throws UnvailableSessionException {
        Cinema cinema = new Cinema3D();
        Session session = new Session3D();
        cinema.add(session);
        Calendar date = Calendar.getInstance();
        date.set(2021, Calendar.MAY, 11);
        int row = 3;
        int column = 4;
        assertTrue(cinema.checkSeat(session, row, column, date));
    }

    @Test (expected = UnvailableSessionException.class)
    public void checkSeatException() throws UnvailableSessionException {
        Cinema cinema = new Cinema3D();
        Session session = new Session3D();
        cinema.add(session);
        Account account = new AccountCinema();
        Calendar date = Calendar.getInstance();
        date.set(2021, Calendar.FEBRUARY, 3);
        int row = 4;
        int column = 4;
        cinema.buy(account, row, column, date);
        cinema.checkSeat(session, row, column, date);
    }
}