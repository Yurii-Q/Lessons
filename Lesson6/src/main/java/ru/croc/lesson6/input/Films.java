package ru.croc.lesson6.input;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Фильмы
 */
@XmlRootElement(name = "films")
public class Films implements Serializable{

    @XmlElementWrapper(name = "films")
    @XmlElement(name = "film")
    private List<Film> films = new ArrayList<>();

    public Films(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Films films1 = (Films) o;
        return Objects.equals(films, films1.films);
    }

    @Override
    public int hashCode() {
        return Objects.hash(films);
    }

    /**
     * Добавить фильм
     * @param film
     */
    public void addFilm(Film film){
        this.films.add(film);
    }

    /**
     * Удалить фильм
     * @param film
     */
    public void removeFilm(Film film){
        this.films.remove(film);
    }

    /**
     * Получить список фильмов
     * @return
     */
    public List<Film> getFilms() {
        return films;
    }
}
