package ru.croc.lesson3;

import ru.croc.lesson3.Enum.Status;

/**
 * Самолет.
 */
public class Airplane extends Transport {
    //Количество самолетов
    private static int quantityAirplane = 0;
    //Количество свободных самолетов
    private static int quantityAirplaneFree = 0;
    //Количесвто арендованных самолетов
    private static int quantityAirplaneRentable = 0;
    //Количество ремонтируемых самолетов
    private static int quantityAirplaneRepair = 0;

    /**
     * Конструктор
     * @param name Название
     */
    public Airplane(String name, Status status){
        super(name);
        //Увеличить количесвто самолетов на 1
        this.quantityAirplane++;
        //Присвоить самолету номер (Первый литерал тип транспорта)
        number = "A" + quantityAirplane;
        //Установить статус самолета
        this.status = status;

        //На основе статуса вычислить статистику
        switch (status){
            case FREE:
                quantityAirplaneFree++;
                quantityFree++;
                break;
            case RENTABLE:
                quantityAirplaneRentable++;
                quantityRentable++;
                break;
            case REPAIR:
                quantityAirplaneRepair++;
                quantityRepair++;
                break;
        }
    }

    //******************* Сеттеры ************************************

    //Установить статус самолета
    @Override
    public void setStatus(Status status) {
        Status temp = this.status;
        this.status = status;
        //На основе статуса вычислить статистику
        switch (temp){
            case FREE:
                quantityAirplaneFree--;
                quantityFree--;
                break;
            case RENTABLE:
                quantityAirplaneRentable--;
                quantityRentable--;
                break;
            case REPAIR:
                quantityAirplaneRepair--;
                quantityRepair--;
                break;
        }
        //На основе статуса вычислить статистику
        switch (status){
            case FREE:
                quantityAirplaneFree++;
                quantityFree++;
                break;
            case RENTABLE:
                quantityAirplaneRentable++;
                quantityRentable++;
                break;
            case REPAIR:
                quantityAirplaneRepair++;
                quantityRepair++;
                break;
        }
    }

    //******************* Геттеры ************************************

    //Получить статус самолета
    @Override
    public String getStatus() {
        return "" + status;
    }

    //Получить номер самолета
    @Override
    public String getNumber() {
        return number;
    }

    //Получить общее количество самолета
    public static int getQuantityAirplane() {
        return quantityAirplane;
    }

    //Получить количесвто свободных самолетов
    public static int getQuantityAirplaneFree() {
        return quantityAirplaneFree;
    }

    //Получить количество самолетов сданных в аренду
    public static int getQuantityAirplaneRentable() {
        return quantityAirplaneRentable;
    }

    //Получить количество ремонтируемых самолетов
    public static int getQuantityAirplaneRepair() {
        return quantityAirplaneRepair;
    }
}
