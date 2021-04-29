package ru.croc.lesson8.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Список исходящих рейсов.
 */
@XmlRootElement
public class FlightOutsList {

    /**
     * Список исходящих рейсов
     */
    @XmlElementWrapper(name = "flightOuts")
    @XmlElement(name = "flightOut")
    private List<FlightOut> flightOuts = new ArrayList<>();

    public FlightOutsList(){

    }

    /**
     * Дабавить рейс в список.
     * @param flightOut
     */
    public void addFlight(FlightOut flightOut){
        flightOuts.add(flightOut);
    }

    /**
     * Удалить рейс из списка.
     * @param flightOut
     */
    public void removeFlight(FlightOut flightOut){
        flightOuts.remove(flightOut);
    }

    @Override
    public String toString() {
        return "FlightOutsList{" +
                "flightOuts=" + flightOuts +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightOutsList that = (FlightOutsList) o;
        return Objects.equals(flightOuts, that.flightOuts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightOuts);
    }

    public List<FlightOut> getFlightOuts() {
        return flightOuts;
    }


}
