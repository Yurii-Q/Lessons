
import Classes.Worker;
import Classes.Zoo;

public class Main {
    public static void main(String[] args) {
        //Создаем зоопарк
        Zoo zoo = new Zoo(100,"Krasnodar");

        //Массив рабочих (Всего 3 сотрудников)
        Worker[] workers = new Worker[3];
        workers[0] = new Worker("Vasya", 32);
        workers[1] = new Worker("Petya", 28);
        workers[2] = new Worker("Ivan", 33);

        //Добавить 3 вальера в зоопарк
        zoo.addAviary(10,"Cow",workers[0]);
        zoo.addAviary(10,"Tiger",workers[1]);
        zoo.addAviary(10,"Elephant",workers[2]);

        //Добавить 3х животных в варьер 0
        zoo.addAnimal(zoo.aviaries[0],"Burenka");
        zoo.addAnimal(zoo.aviaries[0],"Korovka");
        zoo.addAnimal(zoo.aviaries[0],"Plotva");

        //Добавить 3х животных в варьер 1
        zoo.addAnimal(zoo.aviaries[1],"Polosatik");
        zoo.addAnimal(zoo.aviaries[1],"Mursic");
        zoo.addAnimal(zoo.aviaries[1],"Pushistik");

        //Добавить 3х животных в варьер 2
        zoo.addAnimal(zoo.aviaries[2],"Vasya");
        zoo.addAnimal(zoo.aviaries[2],"Apolon");
        zoo.addAnimal(zoo.aviaries[2],"Zevs");

        //Происходят какие-то действия
        zoo.addRecordClear(zoo.aviaries[2].getTypeAviary(),zoo.aviaries[2].getWorker().getName());
        zoo.addRecordFeed(zoo.aviaries[1].getTypeAviary(),zoo.aviaries[1].getWorker().getName());
        zoo.addRecordSick(zoo.aviaries[0].getTypeAviary(),zoo.aviaries[0].getWorker().getName());

        //Показать журнал
        zoo.showJurnal();

        //Показать информацию о вальерах
        zoo.showAviary();

        //Удалить из 1ого вальера 2ое животное
        zoo.removeAnimal(zoo.aviaries[1],2);

        //Показать информацию о вальерах
        zoo.showAviary();
    }
}
