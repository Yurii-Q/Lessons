package ru.croc.lesson3;

import ru.croc.lesson3.Enum.Status;

/**
 * Транспорт. Родительский класс.
 */
public abstract class Transport {
    //Статус трансопрота
    protected Status status;

    //Уникальный номер транспорта
    protected String number;

    //Название транспорта
    private String name;

    //Координаты
    //todo

    //Общее количество транспорта зарегитрированных в системе
    private static int quantity = 0;
    //Количество свободного транспорта
    protected static int quantityFree = 0;
    //Количесвто арендованного траснопорта
    protected static int quantityRentable = 0;
    //Количество ремонтируемого транспорта
    protected static int quantityRepair = 0;

    /**
     * Конструктор
     *
     */
    public Transport(String name){
        //Увеличиваем количество транспорта на 1
        this.quantity++;
        this.name = name;
    }

    //******************* Сеттеры ************************************

    //Установить статус транспорта
    public abstract void setStatus(Status status);

    //******************* Геттеры ************************************

    //Получить статус транспорта
    public abstract String getStatus();
    //Получить номер транспорта
    public abstract String getNumber();
    //Получить общее количество транспорта
    public static int getQuantity() {
        return quantity;
    }

    //Получить общее количество свободного транспорта
    public static int getQuantityFree() {
        return quantityFree;
    }

    //Получить общее количество транспорта сданного в аренду
    public static int getQuantityRentable() {
        return quantityRentable;
    }

    //Получить общее количество ремонтируемых транспортов
    public static int getQuantityRepair() {
        return quantityRepair;
    }
}
