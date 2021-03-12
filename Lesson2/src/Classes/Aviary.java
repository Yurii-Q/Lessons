package Classes;

import java.util.Arrays;

/**
 * Вальер
 */
public class Aviary {
    //Площадь вальера
    private float square;
    //Название вальера
    private String typeAviary;
    //Рабочий
    private Worker worker;
    //Массив животных
    Animal[] animals = new Animal[]{};
    //Массив записей (Журнал)
    private Record[] records = new Record[]{};

    /**
     * Конструтор
     * @param square Площадь вальера
     * @param typeAviary Название вальера
     * @param worker Имя рабочего закрепленного на данный вальер
     */
    public Aviary(float square, String typeAviary, Worker worker){
        this.square = square;
        this.typeAviary = typeAviary;
        this.worker = worker;
    }

    /**
     * Добавить запись в журнал
     */
    public void addRecord(){
        //todo
    }


    //******************* Служебные методы ************************************
    /**
     * Узнать площадь вальера
     * @return square
     */
    public float getSquare(){
        return square;
    }

    /**
     * Узнать тип вальера
     * @return typeAviary
     */
    public String getTypeAviary(){return typeAviary;}

    /**
     * Узнать рабочего вальера
     * @return worker
     */
    public Worker getWorker(){return worker;}
}
