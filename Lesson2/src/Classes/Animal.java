package Classes;

/**
 * Животное
 */
public class Animal {
    //Тип животного
    private final String type;
    //Имя животного
    private final String name;
    //Возраст животного
    private int age;

    //Конструтор
    public Animal(String type, String name){
        this.type = type;
        this.name = name;
    }



    //******************* Служебные методы ************************************
    /**
     * Узнать тип животного
     * @return type
     */
    public String getType(){
        return type;
    }

    /**
     * Узнать имя животного
     * @return name
     */
    public String getName(){
        return name;
    }

    /**
     * Узнать возраст животного
     * @return age
     */
    public int getAge(){
        return age;
    }

}
