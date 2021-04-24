package ru.croc.lesson8.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

/**
 * Исходящий рейс.
 */
@XmlRootElement
public class FlightOut {

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
    public FlightOut(String company, String place_departure, String place_purpose, String date, String time, String id){
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
    public FlightOut() {

    }

    @Override
    public String toString() {
        return "FlightOut{" +
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
        FlightOut flightOut = (FlightOut) o;
        return Objects.equals(id, flightOut.id) &&
                Objects.equals(company, flightOut.company) &&
                Objects.equals(placeDeparture, flightOut.placeDeparture) &&
                Objects.equals(placePurpose, flightOut.placePurpose) &&
                Objects.equals(date, flightOut.date) &&
                Objects.equals(time, flightOut.time);
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
