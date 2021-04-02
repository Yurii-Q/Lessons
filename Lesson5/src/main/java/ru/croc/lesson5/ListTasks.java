package ru.croc.lesson5;


import java.io.Serializable;
import java.util.*;

/**
 * Меню в виде консоли.
 */
public class ListTasks implements Serializable {

    /**Список задач*/
    private Map<String,Task> tasks = new HashMap<>();

    /**Список кодов задач*/
    private Map<String,Integer> tasksCode = new HashMap<>();

    //Имя компьютера (исполнителя)
    private String computerName;

    /**
     * Конструктор
     *
     */
    public ListTasks(){

        //Получаем имя компьютера (исполнителя)
        computerName = new com.sun.security.auth.module.NTSystem().getName();
    }

    /**
     * Создаем задачу.
     * @param nameTask Имя задачи
     * @return true или false
     */
    public boolean createTask(String nameTask){
        //Проверка на уникальность имени
        if (tasks.containsKey(nameTask)){
            return false;
        }
        else {
            //Создаем и добавляем задачу
            tasks.put(nameTask,new Task(nameTask, computerName, tasks.hashCode()));

            //Добавляем код в список кодов
            tasksCode.put(nameTask,tasks.hashCode());

            //Обнавляем статус на Запущен
            tasks.get(nameTask).setStatus(Status.PROCESS);
            return true;
        }
    }

    /**
     * Удаление задачи по имени.
     * @param nameTask Имя задачи
     * @return true или false
     */
    public boolean removeTaskByName(String nameTask){
        //Проверка на существование имени
        if (tasks.containsKey(nameTask)){
            return false;
        }
        else {

            //Удаляем задачу
            tasks.remove(nameTask);

            //Удаляем его код
            tasksCode.remove(nameTask);

            return true;
        }
    }

    /**
     * Удаление задачи по коду
     * @param code
     * @return true или false
     */
    public boolean removeTaskByCode(Integer code){

        //Проверка на существование значения
        if (tasksCode.containsValue(code)){
            return false;
        }
        else {
            //Выявляем список задач
            Set<String> temp = tasksCode.keySet();

            //Переменная для хранения ключа
            String tempKey = new String();

            //Перебираем ключи пока не находим нужный ключ
            for (String names: temp){

                if(tasksCode.get(names) == code){
                    tempKey = names;
                    break;
                }
            }

            //Удаляем по ключу задачу
            tasks.remove(tempKey);
            tasksCode.remove(tempKey);

            return true;
        }
    }


    //***************** Методы редактирования задачи ***************************

    /**
     * Редактирование описания задачи
     * @return
     */
    public boolean editTaskDescription(String nameTask, String description){

        //Проверка на существование (правильное написание имени задчи)
        if (tasks.containsKey(nameTask)){
            //Обращаемся к задаче в списке и изменяем описание данной задачи
            tasks.get(nameTask).setDescription(description);
            return true;
        }
        return false;
    }

    //***************** Гетеры **********************************************

    //Получить имя компьютера(исполнителя) (для одного меню имя одно)
    public String getComputerName(){
        return computerName;
    }

    //Получить коллекцию задач
    public Map<String, Task> getTasks() {
        return tasks;
    }
}
