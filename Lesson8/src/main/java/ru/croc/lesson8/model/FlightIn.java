package ru.croc.lesson8.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

/**
 * Входящий рейс.
 */
@XmlRootElement
public class FlightIn {

    /**Номер рейса*/
    @XmlElement
    private String id;

    /**Компания*/
    @XmlElement
    private String company;

    /**Место назначения*/
    @XmlElement
    private String placePurpose;

    /**Место вылета*/
    @XmlElement
    private String placeDeparture;

    /**Дата вылета*/
    @XmlElement
    private String date;

    /**Время вылета*/
    @XmlElement
    private String time;


    /**
     * Конструктор
     * @param company
     * @param place_departure
     * @param place_purpose
     * @param date
     * @param time
     * @param id
     */
    public FlightIn(String company, String place_departure, String place_purpose, String date, String time, String id){
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
    public FlightIn() {

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
        FlightIn flightIn = (FlightIn) o;
        return Objects.equals(id, flightIn.id) &&
                Objects.equals(company, flightIn.company) &&
                Objects.equals(placeDeparture, flightIn.placeDeparture) &&
                Objects.equals(placePurpose, flightIn.placePurpose) &&
                Objects.equals(date, flightIn.date) &&
                Objects.equals(time, flightIn.time);
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
