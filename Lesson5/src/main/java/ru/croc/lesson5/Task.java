package ru.croc.lesson5;


import java.io.Serializable;

/**
 * Задача.
 *
 * Номер и Имя задачи уникальны.
 */
public class Task implements Serializable {

    /**Код задачи*/
    private Integer id;

    /**Имя задачи*/
    private final String nameTask;

    /**Статус задачи*/
    private Status status;

    /**Описание задачи*/
    private String description = "";

    /**Имя компрьютера выполняемого задачу*/
    private String nameComp = "";

    /**
     * Конструктор
     *
     * @param nameTask Имя задачи
     * @param nameComp Имя исполнителя
     */
    public Task(String nameTask, String nameComp, Integer id){

        //Стутус ЗАПУСК
        status = Status.STARTED;

        //Присваевам имя исполняющей машины
        this.nameComp = nameComp;

        //Присваеваем имя задачи
        this.nameTask = nameTask;

        this.id = id;

        //Статус Выпаолнения задачи
        status = Status.PROCESS;

    }

    //**************** Сетеры *******************************

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //****************** Гетеры *******************************

    public Integer getId() {
        return id;
    }

    public String getNameTask() {
        return nameTask;
    }

    public Status getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public String getNameComp() {
        return nameComp;
    }
}
