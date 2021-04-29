package ru.croc.lesson8.model;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * Входящий рейс.
 */
@XmlRootElement
public class FlightIn extends FlightGeneral{

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
        super(company,place_departure,place_purpose,date,time,id);
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
}
