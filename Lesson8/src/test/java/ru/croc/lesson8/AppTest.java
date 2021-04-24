package ru.croc.lesson8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.croc.lesson8.converterxml.ConverterXml;
import ru.croc.lesson8.dbprovider.DataSourceProvider;
import ru.croc.lesson8.model.*;
import ru.croc.lesson8.repository.FlightRepository;
import ru.croc.lesson8.service.FlightService;

import java.io.IOException;


public class AppTest {

    @Test
    @DisplayName("Начало теста")
    public void convertToXmlTest() throws IOException{

        //Конвертер Xml для получения рейсов
        ConverterXml converter = new ConverterXml();

        //Рейсы
        Flights flights = new Flights();

        //Созадем исходящие рейсы
        FlightOut flightOut1 = new FlightOut("Com","Moscow","Kras","18.04.2021","12:25","fhf89h");
        FlightOut flightOut2 = new FlightOut("Com","Novgorod","Kras","19.04.2021","18:35","fhgg89h");
        FlightOut flightOut3 = new FlightOut("Com","Magadan","Kras","12.04.2021","13:46","fhhtf89h");

        //Создаем список исходящих рейсов
        FlightOutsList flightOutsList = new FlightOutsList();
        flightOutsList.addFlight(flightOut1);
        flightOutsList.addFlight(flightOut2);
        flightOutsList.addFlight(flightOut3);

        //Создаем входящие рейсы
        FlightIn flightIn1 = new FlightIn("Com","Moscow","Giorgia","18.04.2021","12:25","fhf89h");
        FlightIn flightIn2 = new FlightIn("Com","Moscow","Grot","18.04.2021","12:25","fhf89h");
        FlightIn flightIn3 = new FlightIn("Com","Moscow","Berlin","18.04.2021","12:25","fhf89h");

        //Создаем список входящих рейсов
        FlightInsList flightInsList = new FlightInsList();
        flightInsList.addFlight(flightIn1);
        flightInsList.addFlight(flightIn2);
        flightInsList.addFlight(flightIn3);

        //Конвертируем исходящие рейсы в Xml формат
        String xmlOut = converter.toXml(flightOutsList);
        System.out.println(xmlOut);

        //Конвертируем входящие рейсы в Xml формат
        String xmlIn = converter.toXml(flightInsList);
        System.out.println(xmlIn);

        //Проверка на десериализацию из Xml формата
        Assertions.assertEquals(flightOutsList,converter.fromXml(xmlOut,FlightOutsList.class));
        Assertions.assertEquals(flightInsList,converter.fromXml(xmlIn,FlightInsList.class));

        //Создание десериализованных списков исходящих и входящих рейсов
        FlightOutsList flightOutsList_deserialization = converter.fromXml(xmlOut,FlightOutsList.class);
        FlightInsList flightInsList_deserialization = converter.fromXml(xmlIn,FlightInsList.class);

        //Добавляем полученные данные об исходящих рейсах в объект рейсы
        for (FlightOut i: flightOutsList_deserialization.getFlightOuts()){
            flights.addFlightOuts(i);
        }

        //Добавляем полученные данные о входящих рейсах в объект рейсы
        for (FlightIn i: flightInsList_deserialization.getFlightIns()){
            flights.addFlightIns(i);
        }

        System.out.println(flights);


        // Создаем драйвер для подключения к БД
        DataSourceProvider driver = new DataSourceProvider();

        //Получаем доступ к БД
        FlightRepository database = new FlightRepository(driver.getDataSource());

        //Подключаем модуль управления БД
        FlightService fs = new FlightService(database);

        //Записываем в БД информацию о рейсах
        fs.write(flights);


    }
}
