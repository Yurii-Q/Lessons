package ru.croc.lesson3;

import ru.croc.lesson3.Enum.Status;

/**
 * Грузовик.
 */
public class Truck extends Transport {
    //Количество грузовиков
    private static int quantityTruck = 0;
    //Количество свободных грузовика
    private static int quantityTruckFree = 0;
    //Количесвто арендованных грузовика
    private static int quantityTruckRentable = 0;
    //Количество ремонтируемых грузовика
    private static int quantityTruckRepair = 0;

    //Государственный (регистрационный) номер грузовика
    private String stateNumber;

    /**
     * Конструктор
     * @param name Название
     * @param status Статус грузовика
     * @param stateNumber Регистрационный номер грузовика
     */
    public Truck(String name, Status status, String stateNumber){
        super(name);
        //Увеличить количесвто грузовиков на 1
        this.quantityTruck++;
        //Присвоить грузовику номер (Первый литерал тип транспорта)
        number = "T" + quantityTruck;
        //Записать регистрационный номер грузовика
        this.stateNumber = stateNumber;
        //Установить статус грузовика
        this.status = status;

        //На основе статуса вычислить статистику
        switch (status){
            case FREE:
                quantityTruckFree++;
                quantityFree++;
                break;
            case RENTABLE:
                quantityTruckRentable++;
                quantityRentable++;
                break;
            case REPAIR:
                quantityTruckRepair++;
                quantityRepair++;
                break;
        }
    }

    //******************* Сеттеры ************************************

    //Установить статус грузовика
    @Override
    public void setStatus(Status status) {
        Status temp = this.status;
        this.status = status;

        //На основе статуса вычислить статистику
        switch (temp){
            case FREE:
                quantityTruckFree--;
                quantityFree--;
                break;
            case RENTABLE:
                quantityTruckRentable--;
                quantityRentable--;
                break;
            case REPAIR:
                quantityTruckRepair--;
                quantityRepair--;
                break;
        }
        //На основе статуса вычислить статистику
        switch (status){
            case FREE:
                quantityTruckFree++;
                quantityFree++;
                break;
            case RENTABLE:
                quantityTruckRentable++;
                quantityRentable++;
                break;
            case REPAIR:
                quantityTruckRepair++;
                quantityRepair++;
                break;
        }
    }

    //******************* Геттеры ************************************

    //Получить статус грузовика
    @Override
    public String getStatus() {
        return "" + status;
    }

    //Получить номер грузовика
    @Override
    public String getNumber() {
        return number;
    }

    //Получить регистрационный номер грузовика
    public String getStateNumber() {
        return stateNumber;
    }

    //Получить общее количество грузовиков
    public static int getQuantityTruck() {
        return quantityTruck;
    }

    //Получить количесвто свободных грузовиков
    public static int getQuantityTruckFree() {
        return quantityTruckFree;
    }

    //Получить количество грузовиков сданных в аренду
    public static int getQuantityTruckRentable() {
        return quantityTruckRentable;
    }

    //Получить количество ремонтируемых грузовиков
    public static int getQuantityTruckRepair() {
        return quantityTruckRepair;
    }
}
