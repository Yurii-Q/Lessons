package ru.croc.lesson8.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Рейсы.
 */
public class Flights {

    /**
     * Список исходящих рейсов
     */
    private List<FlightOut> flightOuts = new ArrayList<>();

    /**
     * Список входящих рейсов
     */
    private List<FlightIn> flightIns = new ArrayList<>();

    /**
     * Добавить исходящий рейс
     * @param flightOuts
     */
    public void addFlightOuts(FlightOut flightOuts) {
        this.flightOuts.add(flightOuts);
    }

    /**
     * Добавить входящий рейс
     * @param flightIns
     */
    public void addFlightIns(FlightIn flightIns) {
        this.flightIns.add(flightIns);
    }

    /**
     * Удалить исходящий рейс
     * @param flightOuts
     */
    public void removeFlightOuts(FlightOut flightOuts) {
        this.flightOuts.remove(flightOuts);
    }

    /**
     * Удалить входящий рейс
     * @param flightIns
     */
    public void removeFlightIns(FlightIn flightIns) {
        this.flightIns.remove(flightIns);
    }

    @Override
    public String toString() {
        return "Flights{" +
                "flightOuts=" + flightOuts +
                ", flightIns=" + flightIns +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flights flights = (Flights) o;
        return Objects.equals(flightOuts, flights.flightOuts) && Objects.equals(flightIns, flights.flightIns);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightOuts, flightIns);
    }

    //**************************** Getters ******************************************

    public List<FlightIn> getFlightIns() {
        return flightIns;
    }

    public List<FlightOut> getFlightOuts() {
        return flightOuts;
    }

}
