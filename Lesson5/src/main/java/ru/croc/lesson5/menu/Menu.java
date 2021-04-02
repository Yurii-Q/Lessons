package ru.croc.lesson5.menu;

import ru.croc.lesson5.ListTasks;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 * Меню для работы со списком задач.
 */
public class Menu {

    //Переменная для входной команды
    private String inputComand;

    //Переменная для работы со списком задач
    private ListTasks tasks;

    /**
     * Конструктор Меню
     * @param tasks Список задач которому нужно оболочка
     */
    public Menu(ListTasks tasks){
        this.tasks = tasks;
    }

    /**
     * Запуск программы Меню
     */
    public ListTasks begin() {

        //Выводим пользовательскую информацию
        System.out.println("Работа с менеджером задач");
        System.out.println("Набор доступных команд:");
        System.out.println("create имя_задачи\t-создать задачу");
        System.out.println("edit имя_задачи\t-редактировать задачу");
        System.out.println("delete имя_задачи\t-удалить задачу");
        System.out.println("list\t-Список задач");
        System.out.println("exit\t-выход из программы");
        System.out.println("help\t-Помощь");

        Scanner in = new Scanner(System.in);
        String name;

        //Флаг для завершения программы
        boolean w = true;

        while (w) {

            //Считываем значение
            inputComand = in.next();

            //Проверяем какая команда была введена
            if (inputComand.equals("create")) {
                //Добовляем задачу в коллекцию
                tasks.createTask(in.next());
            }
            if (inputComand.equals("edit")) {
                //Переменная для хранения имени задача + первое считывание
                name = in.next();
                //Редактирование задачи (описания выбранной задачи) + второе считывание
                tasks.editTaskDescription(name, in.next());
            }
            if (inputComand.equals("delete")) {

                    tasks.removeTaskByName(in.next());

            }
            if (inputComand.equals("help") ){
                //Выводим пользовательскую информацию
                System.out.println("Работа с менеджером задач");
                System.out.println("Набор доступных команд:");
                System.out.println("create имя_задачи\t-создать задачу");
                System.out.println("edit имя_задачи\t-редактировать задачу");
                System.out.println("delete имя_задачи\t-удалить задачу");
                System.out.println("list\t-Список задач");
                System.out.println("exit\t-выход из программы");
                System.out.println("help\t-Помощь");
            }
            if (inputComand.equals("exit")) {
                w = false;
            }
            if (inputComand.equals("list")) {
                //Вывести список задач
                System.out.println(tasks.getTasks().keySet());
            } else {

            }
        }
        return tasks;
    }
}
