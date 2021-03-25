package ru.croc.lesson4.Class;

import java.util.*;

//Символ "-" зарезервирован для ключа ребра,
//этот символ запрещено использовать для имени ключей

/**
 * Граф.
 */
public class Graph<T> {

    /**Коллекция вершин графа */
    private Map<String, T> tops = new HashMap<>();

    /**Коллекция ребер графа */
    private Set<String> edges = new HashSet<>();
    //private Map<String, String> edges = new HashMap<>();

    /**Массив вершин в виде строк*/
    ArrayList<String> topsString = new ArrayList<>();

    /**Коллекция компонент связности графа */
    private Map<String,String> сomponentsConnectivity = new HashMap<>();

    /**
     * Конструктор.
     * @param key Ключ типа String
     * @param data Данные типа Т
     */
    public Graph(String key, T data){
        addTop(key, data);
    }

    /**
     * Добавить вершину в граф.
     * @param key Ключ типа String
     * @param data Данные типа Т
     *
     * @return Если перзаписывает, то возвращает предыдущие данные для этого ключа, иначе вернет null
     */
    public T addTop(String key, T data){
        //Добавляем вершину в массви вершин в строковом формате
        topsString.add(key);

        //Добавляем вершину как компонент связности
        сomponentsConnectivity.put("-" + key,"");

        //Добовляем вершину в граф
        return tops.put(key,data);
    }

    /**
     * Удалить вершину из графа.
     * @param key Ключ вершины.
     *
     * @return Возвращает удаленные данные
     */
    public T removeTop(String key){
        //Временная переменная для хранения коллекции ребер с данной вершиной
        ArrayList<String> temp = new ArrayList<>();

        //Удаляем сначала ребра связаные с этой вершиной
        //Перебираем все ключи существующих ребер, если одна из вершин входит в ключ ребра, то добавляем
        for (String keyEdge: edges){
            if(keyEdge.contains(key)) {
                temp.add(keyEdge);
            }
        }

        //Удаляем все добавленные ребра из графа
        for (String temp1: temp){
            removeEdge(temp1);
        }

        //Удаляем вершину из массива вершин в строковом формате
        topsString.remove(key);

        //Удаляем вершину из компонет связности (он появиться после удаления всех ребер связанных с этой вершиной)
        сomponentsConnectivity.remove("-" + key);

        //Удаляем вершину с данным ключем
        return tops.remove(key);
    }

    /**
     * Добавить(создать) ребро между существующими вершинами графа.
     * @param key1 Ключ1
     * @param key2 Ключ2
     *
     * @return Возвращает true если добавлено, иначе false
     */
    public boolean addEdge(String key1, String key2){

        //Временные переменные для хранения вершин
        String temp1 = new String();
        String temp2 = new String();
        String temp3 = new String();

        //Временные переменные для хранения ребер
        String tempE1 = new String();
        String tempE2 = new String();
        String tempE3 = new String();

        //Проверяем на совпадение ключей
        if(!key1.equals(key2))
        {
            //Проверяем наличие двух вершин и отсутствие их в множестве ребер
            if(tops.containsKey(key1) && tops.containsKey(key2) &&
                    !(edges.contains("#" + key1 + "-" + key2) || edges.contains("#" + key2 + "-" + key1))) {
                //Добавить ребро в коллекцию
                edges.add(String.format("#%s-%s", key1, key2));

                //Найти вершины в связностях
                for (String content: сomponentsConnectivity.keySet()){
                    if(content.contains(key1)){
                        temp1 = content;
                        tempE1 = сomponentsConnectivity.get(temp1);
                    }
                    if(content.contains(key2)){
                        temp2 = content;
                        tempE2 = сomponentsConnectivity.get(temp2);
                    }
                }
                //Равны ли найденые связности
                if(temp1.equals(temp2)){
                    return true;
                }
                ///если нет то объединить их, а две предыдущие удалить
                else{
                    temp3 = temp1 + temp2;
                    tempE3 = tempE1 + tempE2 + String.format("#" + "%s-%s", key1, key2);
                    сomponentsConnectivity.remove(temp1);
                    сomponentsConnectivity.remove(temp2);
                    сomponentsConnectivity.put(temp3,tempE3);
                }
                return true;
            }else {
                return false;
            }
        }
        else{
            return false;
        }
    }

    /**
     * Удалить ребро из графа.
     * @param edge Ребро
     *
     * @return Возвращает true если удален, иначе false
     */
    public boolean removeEdge(String edge){

        //Переменная для хранения свзности в которой находиться вершина
        String tempC = new String();
        //String tempC1 = new String();//Для проверки на ошибки

        //Переменная для хранения ребер имеющих вершину1 данного ребра
        Set<String> edgesE1 = new HashSet<>();
        //Множество вершин ребер связанных с вершиной1
        Set<String> topsE1 = new HashSet<>();

        //Переменная для хранения ребер имеющих вершину2 данного ребра
        Set<String> edgesE2 = new HashSet<>();
        //Множество вершин ребер связанных с вершиной2
        Set<String> topsE2 = new HashSet<>();

        //Разделяем строку на два ключа
        String[] keys = edge.substring(1).split("-");
        //Вершина 1
        String key1 = keys[0];
        //Вершина 2
        String key2 = keys[1];

        //Ищем связность в которой находиться эти вершины
        for (String content: сomponentsConnectivity.keySet()){
            if(content.contains(key1) && content.contains(key2)){
                //Копируем связность в новую переменную
                tempC = content;

                //Так как ребро находиться только в одной свзности,
                // можно уже входить из цикла что бы не занимать время
                break;
            }
        }
        /*
                //Ищем связность в которой находиться ребро
                for (String content: сomponentsConnectivity.values()){
                    if(content.contains(edge)){
                        //Копируем связность в новую переменную
                        tempC1 = content;

                        //Так как ребро находиться только в одной свзности,
                        // можно уже входить из цикла что бы не занимать время
                        break;
                    }
                }
                //проверка на ошибки
                /*
                if (!tempC.equals(tempC1)){
                    return false;
                }
        */

        //Удаляем ребро между вершинами
        boolean f1 = edges.remove(keys[0] + "-" + keys[1]);
        boolean f2 = edges.remove(keys[1] + "-" + keys[0]);

        //Выделяем ребра из свзности
        String[] edgesSplit = tempC.split("#");

        //Ищем ребра которые содержат вершины данного ребра
        for (String content: edgesSplit) {
            if (content.contains(key1)) {
                //Копируем ребра в новую переменную
                edgesE1.add(content);
            }
            if (content.contains(key2)) {
                //Копируем ребра в новую переменную
                edgesE2.add(content);
            }
        }

        //Формируем два множества вершин сцепленных с исходными вершинами
        //Получаем два множества вершин, каждая из которых сцеплена с вершино1 и с вершиной2 соответсвенно
        String[] temp1;
        for(String tops: edgesE1){
            temp1 = tops.split("-");
            for (String t : temp1){
                topsE1.add(t);
            }
        }
        for(String tops: edgesE2){
            temp1 = tops.split("-");
            for (String t : temp1){
                topsE2.add(t);
            }
        }

        //Проверяем на наличее ребра между множетсвами вершин потенциальных связностей
        boolean flag = false;
        A:
        for (String t1: topsE1){
            for(String t2: topsE2){
                if(tempC.contains(t1 + "-" + t2)){
                    flag = true;
                    break A;
                }
            }
        }

        //Проверяем на наличие ребра которое связывает потенциальные множества связности
        //если такое ребро есть, то количесвто связностей не меняется,
        if(flag){
            return (f1 || f2);
        }
        else{
            //расщепляем связность на две

            return (f1 || f2);
        }
    }


//********************************** Геттеры ********************************************
    /**
     * Получить коллекцию ребер графа
     * @return edges Ребра
     */
    public Set<String> getEdges(){
        return edges;
    }

    /**
     * Получить коллекцию вершин графа
     * @return tops Вершины
     */
    public Map<String, T> getTops() {
        return tops;
    }

    /**
     * Получить количество компонент связности
     */
    public int getQuantityComponentsConnectivity(){
        return сomponentsConnectivity.size();
    }

    /**
     * Получить коллекцию компонент связности в упорядоченном виде
     */
    public Map<String,String> getComponentsConnectivity(){
        return сomponentsConnectivity;
    }
}
