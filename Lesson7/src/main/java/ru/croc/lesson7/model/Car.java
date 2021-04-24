package ru.croc.lesson7.model;

import java.util.Date;

/**
 * Автомобиль.
 */
public class Car {

    /**Уникальный номер*/
    private Integer id;

    /**Название автомобиля*/
    private String name;

    /**Масса автомобиля*/
    private Float weight;

    /**Количество владельцев*/
    private Integer numberHosts;

    /**Дата создания*/
    private Date dateAssembly;

    /**Была ли в аварии*/
    private Boolean broken;

    /**
     *
     */
    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name=" + name +
                ", weight=" + weight +
                ", numberHosts=" + numberHosts +
                ", dateAssembly" + dateAssembly +
                ", isBroken" + broken +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Integer getNumberHosts() {
        return numberHosts;
    }

    public void setNumberHosts(Integer numberHosts) {
        this.numberHosts = numberHosts;
    }

    public Date getDateAssembly() {
        return dateAssembly;
    }

    public void setDateAssembly(Date dateAssembly) {
        this.dateAssembly = dateAssembly;
    }

    public Boolean getBroken() {
        return broken;
    }

    public void setBroken(Boolean broken) {
        this.broken = broken;
    }
}
