package ru.croc.lesson3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import ru.croc.lesson3.Enum.Status;

public class AppTest {

    @Test
    @DisplayName("Начало теста")
    public void appTest(){
        //Текущий набор транспорта в компании
        Airplane[] airplanes = new Airplane[2];
        Bicycle[] bicycles = new Bicycle[10];
        Car[] cars = new Car[5];
        Motorcycle[] motorcycles = new Motorcycle[6];
        Scooter[] scooters = new Scooter[10];
        Truck[] trucks = new Truck[3];

        //Регестрация Самолетов в системе
        airplanes[0] = new Airplane("Boing737", Status.FREE);
        airplanes[1] = new Airplane("Boing925", Status.FREE);

        //Регестрация Велосипедов в системе
        for (int i = 0; i < bicycles.length; ++i){
            bicycles[i] = new Bicycle("Forward",Status.FREE);
        }

        //Регестрация Автомобилей в системе
        cars[0] = new Car("Ford",Status.FREE,"о589то193");
        cars[1] = new Car("Ford",Status.FREE,"р256оо193");
        cars[2] = new Car("Ford",Status.FREE,"у389уу193");
        cars[3] = new Car("Ford",Status.FREE,"е951оо193");
        cars[4] = new Car("Ford",Status.FREE,"к654мм193");

        //Регестрация Мотоциклов в системе
        motorcycles[0] = new Motorcycle("Mot",Status.FREE,"1458нн193");
        motorcycles[1] = new Motorcycle("Mot",Status.FREE,"5892нн193");
        motorcycles[2] = new Motorcycle("Mot",Status.FREE,"9875нн193");
        motorcycles[3] = new Motorcycle("Mot",Status.FREE,"1588нн193");
        motorcycles[4] = new Motorcycle("Mot",Status.FREE,"1457нн193");
        motorcycles[5] = new Motorcycle("Mot",Status.FREE,"9856нн193");

        //Регестрация Самокатов в системе
        for (int i = 0; i < scooters.length; ++i){
            scooters[i] = new Scooter("Scoo",Status.FREE);
        }

        //Регестрация Грузовиков в системе
        trucks[0] = new Truck("Kamaz",Status.FREE,"р458то193");
        trucks[1] = new Truck("Kamaz",Status.FREE,"р459то193");
        trucks[2] = new Truck("Kamaz",Status.FREE,"р460то193");

        //Проверка общих количественных данных
        Assertions.assertEquals(36, Transport.getQuantity());
        Assertions.assertEquals(36, Transport.getQuantityFree());
        Assertions.assertEquals(0, Transport.getQuantityRentable());
        Assertions.assertEquals(0, Transport.getQuantityRepair());

        //Проверка данных категории Самолет
        Assertions.assertEquals(2, Airplane.getQuantityAirplane());
        Assertions.assertEquals(2, Airplane.getQuantityAirplaneFree());
        Assertions.assertEquals(0, Airplane.getQuantityAirplaneRentable());
        Assertions.assertEquals(0, Airplane.getQuantityAirplaneRepair());
        Assertions.assertEquals("FREE",airplanes[0].getStatus());
        Assertions.assertEquals("FREE",airplanes[1].getStatus());

        Assertions.assertEquals("A1",airplanes[0].getNumber());
        Assertions.assertEquals("A2",airplanes[1].getNumber());

        //Изменяем статус первого самолета (Сдан в аренду)
        airplanes[0].setStatus(Status.RENTABLE);
        //Проверка нового статуса
        Assertions.assertEquals("RENTABLE",airplanes[0].getStatus());

        //Изменяем статус второго самолета (Сломался)
        airplanes[1].setStatus(Status.REPAIR);
        //Проверка нового статуса
        Assertions.assertEquals("REPAIR",airplanes[1].getStatus());

        //Другие объеты имеют такие же методы, поэтому проверим уникальные методы других объектов

        //Проверка методов автомобиля
        Assertions.assertEquals("у389уу193",cars[2].getStateNumber());
        Assertions.assertEquals("C3",cars[2].getNumber());

        //Проверка методов велосипеда
        Assertions.assertEquals("FREE",bicycles[4].getStatus());
        Assertions.assertEquals("B5",bicycles[4].getNumber());

        //Проверка методов грузовика
        Assertions.assertEquals("р460то193",trucks[2].getStateNumber());
        Assertions.assertEquals("T3",trucks[2].getNumber());

        //Проверка методов самоката
        Assertions.assertEquals("FREE",scooters[2].getStatus());
        Assertions.assertEquals("S3",scooters[2].getNumber());

        //Проверка методов мотоцикла
        Assertions.assertEquals("9875нн193",motorcycles[2].getStateNumber());
        Assertions.assertEquals("M3",motorcycles[2].getNumber());

    }
}
