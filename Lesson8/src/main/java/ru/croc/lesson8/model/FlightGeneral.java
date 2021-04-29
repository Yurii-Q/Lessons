package ru.croc.lesson8.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

/**
 * Входящий рейс.
 */
@XmlRootElement
public class FlightGeneral {

    /**
     * Номер рейса
     */
    @XmlElement
    protected String id;

    /**
     * Компания
     */
    @XmlElement
    protected String company;

    /**
     * Место назначения
     */
    @XmlElement
    protected String placePurpose;

    /**
     * Место вылета
     */
    @XmlElement
    protected String placeDeparture;

    /**
     * Дата вылета
     */
    @XmlElement
    protected String date;

    /**
     * Время вылета
     */
    @XmlElement
    protected String time;


    /**
     * Конструктор
     * @param company
     * @param place_departure
     * @param place_purpose
     * @param date
     * @param time
     * @param id
     */
    public FlightGeneral(String company, String place_departure, String place_purpose, String date, String time, String id){
        this.company = company;
        this.placeDeparture = place_departure;
        this.placePurpose = place_purpose;
        this.date = date;
        this.time = time;
        this.id = id;
    }

    /**
     * Конструктор пустой
     */
    public FlightGeneral() {

    }

    @Override
    public String toString() {
        return "FlightIn{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", place departure='" + placeDeparture + '\'' +
                ", place purpose='" + placePurpose + '\'' +
                ", date=" + date +
                ", time=" + time +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightGeneral flight = (FlightGeneral) o;
        return Objects.equals(id, flight.id) &&
                Objects.equals(company, flight.company) &&
                Objects.equals(placeDeparture, flight.placeDeparture) &&
                Objects.equals(placePurpose, flight.placePurpose) &&
                Objects.equals(date, flight.date) &&
                Objects.equals(time, flight.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, company, placeDeparture, placePurpose, date, time);
    }

    //********************** Getters ************************************************
    public String getId() {
        return id;
    }

    public String getCompany() {
        return company;
    }

    public String getPlacePurpose() {
        return placePurpose;
    }

    public String getPlaceDeparture(){ return placeDeparture;}

    public String getDate(){
        return date;
    }

    public String getTime() {
        return time;
    }
}

