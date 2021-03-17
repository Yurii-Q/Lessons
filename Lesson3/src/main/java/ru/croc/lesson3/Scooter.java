package ru.croc.lesson3;

import ru.croc.lesson3.Enum.Status;

/**
 * Самокат.
 */
public class Scooter extends Transport {
    //Количество самокатов
    private static int quantityScooter = 0;
    //Количество свободных самокатов
    private static int quantityScooterFree = 0;
    //Количесвто арендованных самокатов
    private static int quantityScooterRentable = 0;
    //Количество ремонтируемых самокатов
    private static int quantityScooterRepair = 0;

    /**
     * Конструктор
     * @param name Название
     * @param status Статус самоката
     */
    public Scooter(String name, Status status){
        super(name);
        //Увеличить количесвто самокатов на 1
        this.quantityScooter++;
        //Присвоить самокату номер (Первый литерал тип транспорта)
        number = "S" + quantityScooter;
        //Установить статус самоката
        this.status = status;

        //На основе статуса вычислить статистику
        switch (status){
            case FREE:
                quantityScooterFree++;
                quantityFree++;
                break;
            case RENTABLE:
                quantityScooterRentable++;
                quantityRentable++;
                break;
            case REPAIR:
                quantityScooterRepair++;
                quantityRepair++;
                break;
        }
    }

    //******************* Сеттеры ************************************

    //Установить статус самоката
    @Override
    public void setStatus(Status status) {
        Status temp = this.status;
        this.status = status;
        //На основе статуса вычислить статистику
        switch (temp){
            case FREE:
                quantityScooterFree--;
                quantityFree--;
                break;
            case RENTABLE:
                quantityScooterRentable--;
                quantityRentable--;
                break;
            case REPAIR:
                quantityScooterRepair--;
                quantityRepair--;
                break;
        }
        //На основе статуса вычислить статистику
        switch (status){
            case FREE:
                quantityScooterFree++;
                quantityFree++;
                break;
            case RENTABLE:
                quantityScooterRentable++;
                quantityRentable++;
                break;
            case REPAIR:
                quantityScooterRepair++;
                quantityRepair++;
                break;
        }
    }

    //******************* Геттеры ************************************

    //Получить статус самоката
    @Override
    public String getStatus() {
        return "" + status;
    }

    //Получить номер самоката
    @Override
    public String getNumber() {
        return number;
    }

    //Получить общее количество самокатов
    public static int getQuantityScooter() {
        return quantityScooter;
    }

    //Получить количесвто свободных самокатов
    public static int getQuantityScooterFree() {
        return quantityScooterFree;
    }

    //Получить количество самокатов сданных в аренду
    public static int getQuantityScooterRentable() {
        return quantityScooterRentable;
    }

    //Получить количество ремонтируемых самокатов
    public static int getQuantityScooterRepair() {
        return quantityScooterRepair;
    }
}
