package ru.croc.lesson3;

import ru.croc.lesson3.Enum.Status;

/**
 * Автомобиль.
 */
public class Car extends Transport {
    //Количество атомобилей
    private static int quantityCar = 0;
    //Количество свободных атомобиля
    private static int quantityCarFree = 0;
    //Количесвто арендованных атомобиля
    private static int quantityCarRentable = 0;
    //Количество ремонтируемых атомобиля
    private static int quantityCarRepair = 0;

    //Государственный (регистрационный) номер автомобиля
    private String stateNumber;

    /**
     * Конструктор
     * @param name Название
     * @param status Статус автомобиля
     * @param stateNumber Регистрационный номер автомобиля
     */
    public Car(String name, Status status, String stateNumber){
        super(name);
        //Увеличить количесвто автомобилей на 1
        this.quantityCar++;
        //Присвоить автомобилю номер (Первый литерал тип транспорта)
        number = "C" + quantityCar;
        //Записать регистрационный номер атомобиля
        this.stateNumber = stateNumber;
        //Установить статус автомобиля
        this.status = status;

        //На основе статуса вычислить статистику
        switch (status){
            case FREE:
                quantityCarFree++;
                quantityFree++;
                break;
            case RENTABLE:
                quantityCarRentable++;
                quantityRentable++;
                break;
            case REPAIR:
                quantityCarRepair++;
                quantityRepair++;
                break;
        }
    }

    //******************* Сеттеры ************************************

    //Установить статус автомобиля
    @Override
    public void setStatus(Status status) {
        Status temp = this.status;
        this.status = status;

        //На основе статуса вычислить статистику
        switch (temp){
            case FREE:
                quantityCarFree--;
                quantityFree--;
                break;
            case RENTABLE:
                quantityCarRentable--;
                quantityRentable--;
                break;
            case REPAIR:
                quantityCarRepair--;
                quantityRepair--;
                break;
        }
        //На основе статуса вычислить статистику
        switch (status){
            case FREE:
                quantityCarFree++;
                quantityFree++;
                break;
            case RENTABLE:
                quantityCarRentable++;
                quantityRentable++;
                break;
            case REPAIR:
                quantityCarRepair++;
                quantityRepair++;
                break;
        }
    }

    //******************* Геттеры ************************************

    //Получить статус автомобиля
    @Override
    public String getStatus() {
        return "" + status;
    }

    //Получить номер автомобиля
    @Override
    public String getNumber() {
        return number;
    }

    //Получить регистрационный номер автомобиля
    public String getStateNumber() {
        return stateNumber;
    }

    //Получить общее количество автомобилей
    public static int getQuantityCar() {
        return quantityCar;
    }

    //Получить количесвто свободных автомобилей
    public static int getQuantityCarFree() {
        return quantityCarFree;
    }

    //Получить количество автомобилей сданных в аренду
    public static int getQuantityCarRentable() {
        return quantityCarRentable;
    }

    //Получить количество ремонтируемых автомобилей
    public static int getQuantityCarRepair() {
        return quantityCarRepair;
    }
}
