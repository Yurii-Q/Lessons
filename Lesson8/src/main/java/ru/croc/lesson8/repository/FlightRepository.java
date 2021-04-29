package ru.croc.lesson8.repository;

import org.apache.derby.jdbc.EmbeddedDataSource;
import ru.croc.lesson8.model.FlightGeneral;
import ru.croc.lesson8.model.FlightIn;
import ru.croc.lesson8.model.FlightOut;
import ru.croc.lesson8.model.Flights;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Репозиторий для доступа к таблице с данными об автомобидях.
 */
public class FlightRepository {

    /**
     * Название таблицы
     */
    private static final String NAME_TABLE = "flights";

    /**
     * Генератор уникальных значений
     */
    private int counter = 0;

    /**
     * Запрос на создание таблицы
     */
    private static final String QUERY = "CREATE TABLE " + NAME_TABLE +
                                        " (" +
                                        "id int NOT NULL PRIMARY KEY, " +
                                        "id_number VARCHAR(255), " +
                                        "company VARCHAR(255), " +
                                        "place_purpose VARCHAR(255), " +
                                        "place_departure VARCHAR(255), " +
                                        "date VARCHAR(255), " +
                                        "time VARCHAR(255)" +
                                        ")";

    /**
     * База данных
     */
    private EmbeddedDataSource dataSource;

    /**
     * Конструктор.
     */
    public FlightRepository(EmbeddedDataSource dataSource){
        this.dataSource = dataSource;
        initTable();
    }

    /**
     * Инициализация БД.
     */
    private void initTable() {
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
                statement.executeUpdate(QUERY);
                System.out.println("Table was successfully initialized");
            }
        } catch (SQLException e) {
            System.out.println("Error occurred during table initializing: " + e.getMessage());
        } finally {
            System.out.println("=========================");
        }
    }

    /**
     * Метод поиска всех рейсов в БД.
     *
     * @return список всех созданных задач
     */
    public List<FlightGeneral> findAll() {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + NAME_TABLE);
            List<FlightGeneral> taskList = new ArrayList<>();
            while (resultSet.next()) {
                taskList.add(
                        new FlightGeneral(
                                resultSet.getString("company"),
                                resultSet.getString("place_departure"),
                                resultSet.getString("place_purpose"),
                                resultSet.getString("date"),
                                resultSet.getString("time"),
                                resultSet.getString("id_number")
                                ));
            }
            return taskList;
        } catch (Exception e) {
            System.out.println("Ошибка выполнения запроса: " + e.getMessage());
        }
        return new ArrayList<>();
    }

    /**
     * Метод создания записи в БД о входящем рейсе.
     *
     * @param flight задача
     */
    public void createNew(FlightGeneral flight) {
        String sqlQuery = "INSERT INTO " + NAME_TABLE + " VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setInt(1,++counter);
            statement.setString(2, flight.getId());
            statement.setString(3, flight.getCompany());
            statement.setString(4, flight.getPlacePurpose());
            statement.setString(5, flight.getPlaceDeparture());
            statement.setString(6, flight.getDate());
            statement.setString(7, flight.getTime());
            statement.execute();
        } catch (Exception e) {
            System.out.println("Ошибка выполнения запроса: " + e.getMessage());
        }
    }

    /**
     * Метод удаления записи в БД о входящем рейсе (по номеру рейса).
     *
     * @param flight задача
     */
    public void delete(FlightGeneral flight) {
        String sqlQuery = "DELETE FROM " + NAME_TABLE + " WHERE id_number=" + flight.getId();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.execute();
        } catch (Exception e) {
            System.out.println("Ошибка выполнения запроса: " + e.getMessage());
        }
    }

    /**
     * Удалить все записи.
     */
    public void deleteAll() {
        String sqlQuery = "DELETE FROM " + NAME_TABLE;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.execute();
        } catch (Exception e) {
            System.out.println("Ошибка выполнения запроса: " + e.getMessage());
        }
    }
}
