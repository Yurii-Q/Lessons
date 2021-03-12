package Classes;

public class Worker {
    //Имя рабочего
    private final String name;
    //Возраст рабочего
    private int age;

    /**
     * Конструтор
     * @param name Имя рабочего
     * @param age Возраст рабочего
     */
    public Worker(String name, int age){
        this.name = name;
        this.age = age;
    }


    //******************* Служебные методы ************************************
    /**
     * Узнать имя рабочего
     * @return name
     */
    public String getName(){
        return name;
    }

    /**
     * Узнать возраст рабочего
     * @return age
     */
    public int getAge(){
        return age;
    }
}
