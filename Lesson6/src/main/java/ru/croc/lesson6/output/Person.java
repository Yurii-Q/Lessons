package ru.croc.lesson6.output;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Человек, работавший над фильмами.
 */
public class Person implements Serializable {

    /**Фильмы в котором принимал участие*/
    @XmlElement
    private List<String> films = new ArrayList<>();

    /**Функции выполняющие при съемке фильма*/
    @XmlElement
    private List<String> functions = new ArrayList<>();


    /**
     * Добавить фильм
     * @param film Фильм
     */
    public void addFilm (String film){
        films.add(film);
    }

    /**
     * Удалить фильм
     * @param film
     */
    public void removeFilm (String film){
        films.remove(film);
    }

    /**
     * Добавить функцию
     * @param function
     */
    public void addFun (String function){
        functions.add(function);
    }

    /**
     * Удалить функцию
     * @param function
     */
    public void removeFun (String function){
        functions.remove(function);
    }

    //*************** Геттеры **********************

    public List<String> getFilms() {
        return films;
    }

    public List<String> getFunctions() {
        return functions;
    }
}
