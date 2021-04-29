package ru.croc.lesson8.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Список входящих рейсов.
 */
@XmlRootElement
public class FlightInsList {

    /**
     * Список исходящих рейсов
     */
    @XmlElementWrapper(name = "flightIns")
    @XmlElement(name = "flightIn")
    private List<FlightIn> flightIns = new ArrayList<>();

    public FlightInsList(){

    }

    /**
     * Дабавить рейс в список.
     * @param flightIn
     */
    public void addFlight(FlightIn flightIn){
        flightIns.add(flightIn);
    }

    /**
     * Удалить рейс из списка.
     * @param flightIn
     */
    public void removeFlight(FlightIn flightIn){
        flightIns.remove(flightIn);
    }

    @Override
    public String toString() {
        return "FlightInsList{" +
                "flightIns=" + flightIns +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightInsList that = (FlightInsList) o;
        return Objects.equals(flightIns, that.flightIns);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightIns);
    }

    public List<FlightIn> getFlightIns() {
        return flightIns;
    }


}
