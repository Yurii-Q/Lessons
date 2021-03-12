package Classes;

import java.util.Arrays;

/**
 * Зоопарк
 */
public class Zoo {
    //Площадь зоопарка
    private float square;
    //Адрес зоопарка
    private final String address;
    //Массив вальеров
    public Aviary[] aviaries = new Aviary[]{};
    //Журнал
    private Record[] jurnal = new Record[]{};

    /**
     * Конструтор
     * @param square Площадь зоопарка
     * @param address Адрес зоопарка
     */
    public Zoo(float square, String address){
        this.address = address;
        this.square = square;
    }

    /**
     * Создание вальера
     * @param typeAviary Название вальера
     * @param worker Имя рабочего который относиться к даннному вальеру
     */
    public void addAviary(int square, String typeAviary, Worker worker){
        //Создаем на основе старого массива новый на единицу длинее
        aviaries = Arrays.copyOf(aviaries, aviaries.length + 1);
        //Определяем новый вальер
        aviaries[aviaries.length - 1] = new Aviary(square,typeAviary,worker);
    }

    /**
     * Удалить вальер
     * @param number - номер вальера
     */
    public void removeAviary(int number){
        //todo
    }

    /**
     * Добавить животное в вальер
     * @param aviary Вальер в который добовлям животное
     * @param nameAnimal Имя добавляемого живтного
     */
    public void addAnimal(Aviary aviary, String nameAnimal){
        //Создаем на основе старого массива новый на единицу длинее
        aviary.animals = Arrays.copyOf(aviary.animals, aviary.animals.length + 1);
        //Определяем новое животное типа соответствующего типу вальера
        aviary.animals[aviary.animals.length - 1] = new Animal(aviary.getTypeAviary(), nameAnimal);
    }

    /**
     * Удалить животное из вальера
     * @param aviary Вальер из которого удаляем животное
     * @param number Номер удаляемого животного
     */
    public void removeAnimal(Aviary aviary, int number){
        //Копируем массив животных в временную переменную
        Animal[] copy = Arrays.copyOf(aviary.animals,aviary.animals.length);
        //Обновили длину массива
        aviary.animals = Arrays.copyOf(aviary.animals,aviary.animals.length - 1);
        //Копируем из массива copy часть без животного с индексом number
        for (int i = 0; i < aviary.animals.length;++i) {
            if(i >= number)aviary.animals[i] = copy[i+1];
            else aviary.animals[i] = copy[i];
        }
    }

    /**
     * Показать информацию о вальерах зоопарка
     */
    public void showAviary(){
        System.out.println("#\tType\tWorker\tSquare\tNumber animals");
        for(int i = 0; i < aviaries.length; ++i){
            System.out.println(i + "\t" + aviaries[i].getTypeAviary() + "\t" +
                    aviaries[i].getWorker().getName() + "\t" + aviaries[i].getSquare() + "\t" +
                    aviaries[i].animals.length);
        }
    }

    /**
     * Показать журнал
     */
    public void showJurnal(){
        System.out.println("No\tDate\t\t\t\t\t\t\tAviary\t\tAction\t\t\tWorker");
        for(int i = 0; i < jurnal.length;++i){
            System.out.println(i + "\t" + jurnal[i].getDate() + "\t" + jurnal[i].getAviary() +
                                "\t" + jurnal[i].getAction() + "\t" + jurnal[i].getWorker());
        }
    }

    /**
     * Добовляем запись в журнал (общий метод)
     * @param aviary Вольер для которого делается запись
     * @param action Действие
     * @param worker Рабочий который делает запись
     */
    private void addRecord(String aviary, String action, String worker){
        //Создаем на основе старого массива новый на единицу длинее
        jurnal = Arrays.copyOf(jurnal, jurnal.length + 1);
        //Определяем новое животное типа соответствующего типу вальера
        jurnal[jurnal.length - 1] = new Record(aviary,action,worker);
    }

    /**
     * Добавить запись о болезни животного
     * @param aviary Вальер
     * @param worker Рабочий
     */
    public void addRecordSick(String aviary,String worker){
        addRecord(aviary,"Animal is sick",worker);
    }

    /**
     * Добавить запись о уборке вальера
     * @param aviary Вальер
     * @param worker Рабочий
     */
    public void addRecordClear(String aviary,String worker){
        addRecord(aviary,"Aviary is clear",worker);
    }

    /**
     * Добавить запись о кормлении животных
     * @param aviary Вальер
     * @param worker Рабочий
     */
    public void addRecordFeed(String aviary,String worker){
        addRecord(aviary,"Animals are fed",worker);
    }

    //******************* Служебные методы ************************************
    /**
     * Узнать адрес зоопарка
     * @return address
     */
    public String getAddress(){
        return address;
    }

    /**
     * Узнать площадь зоопарка
     * @return square
     */
    public float getSquare(){
        return square;
    }
}
