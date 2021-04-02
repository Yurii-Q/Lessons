package ru.croc.lesson5;

import ru.croc.lesson5.menu.Menu;

import java.io.*;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        //Создаем скписок задач
        ListTasks tasks = new ListTasks();


        // Чтение списка задач из файла
        try{
            FileInputStream fis = new FileInputStream(new File("./JavaObjects.txt"));
            ObjectInputStream ois = new ObjectInputStream(fis);
            tasks = (ListTasks) ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }

        //Создаем меню для работы со списком задач
        Menu menu = new Menu(tasks);

        //Возвращаем получившийся список задач
        tasks = menu.begin();

        //Запись списка задач в файл
        try {
            FileOutputStream fos = new FileOutputStream(new File("./JavaObjects.txt"));
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(tasks);
            oos.close();
            fos.close();
            System.out.println("Программа завершена");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
