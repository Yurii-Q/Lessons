package ru.croc.lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.croc.lesson6.input.Film;
import ru.croc.lesson6.input.Films;


import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class AppTest {

    @Test
    @DisplayName("Начало теста")
    public void testConvert() throws IOException {

        //Фильм1
        final Film film1 = new Film("Фильм 1");

        //Описание
        film1.setDescription("Это фильм1");

        //Режисеры
        film1.addDirector("Name1");
        film1.addDirector("Name2");

        //Сценаристы
        film1.addScreenWriter("Writer1");
        film1.addScreenWriter("Writer2");
        film1.addScreenWriter("Writer3");

        //Фильм2
        final Film film2 = new Film("Фильм 2");

        //Описание
        film2.setDescription("Это фильм2");

        //Режисеры
        film2.addDirector("Name1");
        film2.addDirector("Name2");

        //Сценаристы
        film2.addScreenWriter("Writer1");
        film2.addScreenWriter("Writer2");
        film2.addScreenWriter("Writer3");

        //Создание списка фильмов (ввиде класса)
        final Films films = new Films();
        films.addFilm(film1);
        films.addFilm(film2);

        //Конвертация
        final Converter converter = new Converter();
        final String xml = converter.toXml(films);

        System.out.println(xml);

        Films films_in = converter.fromXml(xml, Films.class);

        //Assertions.assertEquals(films, films_in);


//        String str = new String();
//
//        // Чтение объекта из файла
//        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("InputData.txt"))){
//
//            str = ois.toString();
//
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }
//        System.out.println(str);
    }
}
