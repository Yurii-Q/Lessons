package ru.croc.lesson7.repository;

import org.apache.derby.jdbc.EmbeddedDataSource;

import java.sql.*;

/**
 * Репозиторий для доступа к таблице с данными об автомобидях.
 */
public class CarRepository {

    /**Название таблицы*/
    private static final String NAME_TABLE = "cars";

    /**База данных*/
    private EmbeddedDataSource dataSource;

    /**
     * Конструктор.
     */
    public CarRepository(EmbeddedDataSource dataSource){
        this.dataSource = dataSource;
        initTable();
    }

    /**
     * Инициализация БД
     */
    private void initTable(){
        System.out.println(String.format("Start initializing %s table", NAME_TABLE));
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            DatabaseMetaData databaseMetadata = connection.getMetaData();
            ResultSet resultSet = databaseMetadata.getTables(
                    null,
                    null,
                    // Несмотря на то, что мы создаем таблицу в нижнем регистре (и дальше к ней так же обращаемся),
                    // поиск мы осуществляем в верхнем. Такие вот приколы
                    NAME_TABLE.toUpperCase(),
                    new String[]{"TABLE"});
            if (resultSet.next()) {
                System.out.println("Table has already been initialized");
            } else {
                statement.executeUpdate(
                        "CREATE TABLE "
                                + NAME_TABLE
                                + " ("
                                + "id INTEGER PRIMARY KEY, "
                                + "title VARCHAR(255)"
                                + ")");
                System.out.println("Table was successfully initialized");
            }
        } catch (SQLException e) {
            System.out.println("Error occurred during table initializing: " + e.getMessage());
        } finally {
            System.out.println("=========================");
        }

    }

}
