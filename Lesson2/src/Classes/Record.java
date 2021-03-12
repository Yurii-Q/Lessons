package Classes;

import java.util.Date;

public class Record {
    //Дата записи
    private Date date1 = new Date();
    private String date;
    //Вальер
    private String aviary;
    //Действие
    private String action;
    //Рабочий
    private String worker;

    /**
     * Конструтор
     * @param aviary Вальер для которого делается запись
     * @param action Действие
     * @param worker Рабочий
     */
    public Record(String aviary,String action, String worker){
        this.aviary = aviary;
        this.action = action;
        this.worker = worker;
        date = date1.toString();
    }

    //Getters
    public Date getDate1() {
        return date1;
    }

    public String getDate() {
        return date;
    }

    public String getAviary() {
        return aviary;
    }

    public String getAction() {
        return action;
    }

    public String getWorker() {
        return worker;
    }
}
