package ru.croc.lesson4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import ru.croc.lesson4.Class.Graph;

import java.util.ArrayList;
import java.util.Iterator;

public class AppTest {

    @Test
    @DisplayName("Начало теста")
    public void appGrathTest(){
        Graph<Integer> graph = new Graph<>("A",100);

        //Проврека на добавление вершин, уже имеющихся вершин
        Assertions.assertSame(null,graph.addTop("B",100));
        Assertions.assertSame(100,graph.addTop("B",210));
        Assertions.assertSame(null,graph.addTop("C",300));
        Assertions.assertSame(null,graph.addTop("D",400));

        //Количесвто связностей
        Assertions.assertEquals(4,graph.getQuantityComponentsConnectivity());

        //Проверка создания ребер
        Assertions.assertTrue(graph.addEdge("A","B"));
        Assertions.assertTrue(graph.addEdge("B","C"));
        Assertions.assertTrue(graph.addEdge("A","C"));

        //Количесвто связностей
        Assertions.assertEquals(2,graph.getQuantityComponentsConnectivity());
        //Вывод множества связностей
        System.out.println(graph.getComponentsConnectivity());

        //Проверка на создание уже существующего ребра
        Assertions.assertFalse(graph.addEdge("A","C"));

        //Проверка на создание ребра с несуществующей вершиной
        Assertions.assertFalse(graph.addEdge("A","G"));

        //Вывести все данные в консоль
        System.out.println(graph.getEdges());
        System.out.println(graph.getTops());

        //Удалиение вершину
        graph.removeTop("A");

        //Удаление уже несуществующего ребра
        Assertions.assertFalse(graph.removeEdge("B-A"));

        //Вывести все данные в консоль
        System.out.println(graph.getEdges());
        System.out.println(graph.getTops());

        //Количесвто связностей
        Assertions.assertEquals(2,graph.getQuantityComponentsConnectivity());
        //Вывод множества связностей
        System.out.println(graph.getComponentsConnectivity());

    }
}
