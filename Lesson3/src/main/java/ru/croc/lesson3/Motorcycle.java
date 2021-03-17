package ru.croc.lesson3;

import ru.croc.lesson3.Enum.Status;

/**
 * Мотоцикл.
 */
public class Motorcycle extends Transport {
    //Количество мотоциклов
    private static int quantityMotorcycle = 0;
    //Количество свободных мотоциклов
    private static int quantityMotorcycleFree = 0;
    //Количесвто арендованных мотоциклов
    private static int quantityMotorcycleRentable = 0;
    //Количество ремонтируемых мотоциклов
    private static int quantityMotorcycleRepair = 0;

    //Государственный (регистрационный) номер мотоцикла
    private String stateNumber;

    /**
     * Конструктор
     * @param name Название
     * @param status Статус мотоцикла
     * @param stateNumber Регистрационный номер мотоцикла
     */
    public Motorcycle(String name, Status status, String stateNumber){
        super(name);
        //Увеличить количесвто мотоциклов на 1
        this.quantityMotorcycle++;
        //Присвоить мотоциклу номер (Первый литерал тип транспорта)
        number = "M" + quantityMotorcycle;
        //Записать регистрационный номер мотоцикла
        this.stateNumber = stateNumber;
        //Установить статус мотоцикла
        this.status = status;

        //На основе статуса вычислить статистику
        switch (status){
            case FREE:quantityMotorcycleFree++;
                quantityFree++;break;
            case RENTABLE:quantityMotorcycleRentable++;
                quantityRentable++;break;
            case REPAIR:quantityMotorcycleRepair++;
                quantityRepair++;break;
        }
    }

    //******************* Сеттеры ************************************

    //Установить статус мотоцикла
    @Override
    public void setStatus(Status status) {
        Status temp = this.status;
        this.status = status;
        //На основе статуса вычислить статистику
        switch (temp){
            case FREE:
                quantityMotorcycleFree--;
                quantityFree--;
                break;
            case RENTABLE:
                quantityMotorcycleRentable--;
                quantityRentable--;
                break;
            case REPAIR:
                quantityMotorcycleRepair--;
                quantityRepair--;
                break;
        }
        //На основе статуса вычислить статистику
        switch (status){
            case FREE:
                quantityMotorcycleFree++;
                quantityFree++;
                break;
            case RENTABLE:
                quantityMotorcycleRentable++;
                quantityRentable++;
                break;
            case REPAIR:
                quantityMotorcycleRepair++;
                quantityRepair++;
                break;
        }
    }

    //******************* Геттеры ************************************

    //Получить статус мотоцикла
    @Override
    public String getStatus() {
        return "" + status;
    }

    //Получить номер мотоцикла
    @Override
    public String getNumber() {
        return number;
    }

    //Получить регистрационный номер мотоцикла
    public String getStateNumber() {
        return stateNumber;
    }

    //Получить общее количество мотоциклов
    public static int getQuantityMotorcycle() {
        return quantityMotorcycle;
    }

    //Получить количесвто свободных мотоциклов
    public static int getQuantityMotorcycleFree() {
        return quantityMotorcycleFree;
    }

    //Получить количество мотоциклов сданных в аренду
    public static int getQuantityMotorcycleRentable() {
        return quantityMotorcycleRentable;
    }

    //Получить количество ремонтируемых мотоциклов
    public static int getQuantityMotorcycleRepair() {
        return quantityMotorcycleRepair;
    }
}
