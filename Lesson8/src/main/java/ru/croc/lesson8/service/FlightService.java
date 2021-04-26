package ru.croc.lesson8.service;

import ru.croc.lesson8.model.FlightGeneral;
import ru.croc.lesson8.model.FlightIn;
import ru.croc.lesson8.model.FlightOut;
import ru.croc.lesson8.model.Flights;
import ru.croc.lesson8.repository.FlightRepository;

import java.util.List;

/**
 * Класс-сервис
 */
public class FlightService {

    //Подключаем Repository модуль
    FlightRepository fr;

    /**
     * Конструктор
     * @param fr
     */
    public FlightService(FlightRepository fr){
        this.fr = fr;
    }

    /**
     * Метод для записи в БД.
     * @param flights
     */
    public void write(Flights flights){

        //Записываем исходящие рейсы
        for(FlightOut i: flights.getFlightOuts()){
            fr.createNew(i);
        }

        //Записываем входящие рейсы
        for(FlightIn i: flights.getFlightIns()){
            fr.createNew(i);
        }

    }

    /**
     * Метод поиска всех рейсов в БД.
     * @return List
     */
    public List<FlightGeneral> findAll (){
        return fr.findAll();

    }
}
