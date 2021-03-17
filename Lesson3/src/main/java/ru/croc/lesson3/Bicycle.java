package ru.croc.lesson3;

import ru.croc.lesson3.Enum.Status;

/**
 * Велосипед.
 */
public class Bicycle extends Transport {
    //Количество велосипедов
    private static int quantityBicycle = 0;
    //Количество свободных велосипедов
    private static int quantityBicycleFree = 0;
    //Количесвто арендованных велосипедов
    private static int quantityBicycleRentable = 0;
    //Количество ремонтируемых велосипедов
    private static int quantityBicycleRepair = 0;

    /**
     * Конструктор
     * @param name Название
     * @param status Статус велосипеда
     */
    public Bicycle(String name, Status status){
        super(name);
        //Увеличить количесвто велосипедов на 1
        this.quantityBicycle++;
        //Присвоить велосипеду номер (Первый литерал тип транспорта)
        number = "B" + quantityBicycle;
        //Установить статус велосипеда
        this.status = status;

        //На основе статуса вычислить статистику
        switch (status){
            case FREE:
                quantityBicycleFree++;
                quantityFree++;
                break;
            case RENTABLE:
                quantityBicycleRentable++;
                quantityRentable++;
                break;
            case REPAIR:
                quantityBicycleRepair++;
                quantityRepair++;
                break;
        }
    }

    //******************* Сеттеры ************************************

    //Установить статус велосипеда
    @Override
    public void setStatus(Status status) {
        Status temp = this.status;
        this.status = status;
        //На основе статуса вычислить статистику
        switch (temp){
            case FREE:
                quantityBicycleFree--;
                quantityFree--;
                break;
            case RENTABLE:
                quantityBicycleRentable--;
                quantityRentable--;
                break;
            case REPAIR:
                quantityBicycleRepair--;
                quantityRepair--;
                break;
        }
        //На основе статуса вычислить статистику
        switch (status){
            case FREE:
                quantityBicycleFree++;
                quantityFree++;
                break;
            case RENTABLE:
                quantityBicycleRentable++;
                quantityRentable++;
                break;
            case REPAIR:
                quantityBicycleRepair++;
                quantityRepair++;
                break;
        }
    }

    //******************* Геттеры ************************************

    //Получить статус велосипеда
    @Override
    public String getStatus() {
        return "" + status;
    }

    //Получить номер велосипеда
    @Override
    public String getNumber() {
        return number;
    }

    //Получить общее количество велосипедов
    public static int getQuantityBicycle() {
        return quantityBicycle;
    }

    //Получить количесвто свободных велосипедов
    public static int getQuantityBicycleFree() {
        return quantityBicycleFree;
    }

    //Получить количество велосипедов сданных в аренду
    public static int getQuantityBicycleRentable() {
        return quantityBicycleRentable;
    }

    //Получить количество ремонтируемых велосипедов
    public static int getQuantityBicycleRepair() {
        return quantityBicycleRepair;
    }
}
