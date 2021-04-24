package ru.croc.lesson6.input;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Фильм
 */
public class Film implements Serializable{

    /**Название фильма*/
    @XmlElement(name = "title")
    private String title;

    /**Описание*/
    @XmlElement(name = "description")
    private String description;

    /**Список сценаристов*/
    @XmlElementWrapper
    @XmlElement(name = "screenwriter")
    private List<String> screenwriters = new ArrayList<>();

    /**Список режиссеров*/
    @XmlElementWrapper
    @XmlElement(name = "director")
    private List<String> directors = new ArrayList<>();

    public Film(String name){
        this.title = name;
    }
     public Film(){

     }

    /**
     * Добавить сценариста.
     * @param name
     */
    public void addScreenWriter(String name){
        screenwriters.add(name);
    }

    /**
     * Удалить сценариста.
     * @param name
     */
    public void removeScreenWriters(String name){
        screenwriters.remove(name);
    }

    /**
     * Добавить режисера.
     * @param name
     */
    public void addDirector(String name){
        directors.add(name);
    }

    /**
     * Удалить режисера.
     * @param name
     */
    public void removeDirectors(String name){
        directors.remove(name);
    }

    /**
     * Установить/изменить описание
     * @param str
     */
    public void setDescription(String str){
        description = str;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return Objects.equals(title, film.title) && Objects.equals(description, film.description) && Objects.equals(directors, film.directors)
                && Objects.equals(screenwriters,film.screenwriters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, screenwriters, directors);
    }



    //***************** Геттеры **************************************

    public String getDescription() {
        return description;
    }

    public List<String> getScreenwriters() {
        return screenwriters;
    }

    public List<String> getDirectors() {
        return directors;
    }

}
