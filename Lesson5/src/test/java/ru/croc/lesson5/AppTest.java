package ru.croc.lesson5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.croc.lesson5.menu.Menu;

import java.io.*;


public class AppTest {

    @Test
    @DisplayName("Начало теста")
    public void appTest() {
        //Создаем скписок задач
        ListTasks tasks = new ListTasks();
        //Создаем меню для работы со списком задач
        Menu menu = new Menu(tasks);

        // Чтение объектов из файла
        try{
            FileInputStream fis = new FileInputStream(new File("./JavaObjects.txt"));
            ObjectInputStream ois = new ObjectInputStream(fis);
            tasks = (ListTasks) ois.readObject();
            System.out.println(tasks.toString());
            fis.close();
            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }

       //menu.begin();

        //Запись объекта в файл
        try {
            FileOutputStream fos = new FileOutputStream(new File("./JavaObjects.txt"));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            // Запись объектов в файл
            oos.writeObject(tasks);
            oos.close();
            fos.close();
        }catch (Exception e){

        }



    }
}
