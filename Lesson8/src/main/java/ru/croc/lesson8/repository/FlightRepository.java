package ru.croc.lesson8.repository;

import org.apache.derby.jdbc.EmbeddedDataSource;
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

    /**Название таблицы*/
    private static final String NAME_TABLE = "flights";

    private static final String QUERY = "CREATE TABLE " + NAME_TABLE +
                                        " (" +
                                        "id INTEGER PRIMARY KEY, " +
                                        "id_flight VARCHAR(255) " +
                                        "company VARCHAR(255) " +
                                        "place_purpose VARCHAR(255) " +
                                        "place_departure VARCHAR(255) " +
                                        "date VARCHAR(255) " +
                                        "time VARCHAR(255)" +
                                        ")";

    /**База данных*/
    private EmbeddedDataSource dataSource;

    /**
     * Конструктор.
     */
    public FlightRepository(EmbeddedDataSource dataSource){
        this.dataSource = dataSource;
        initTable();
    }

    /**
     * Инициализация БД
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

//    /**
//     * Метод поиска всех задач в БД.
//     *
//     * @return список всех созданных задач
//     */
//    public List<Task> findAll() {
//        try (Connection connection = dataSource.getConnection();
//             Statement statement = connection.createStatement()) {
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + NAME_TABLE);
//            List<Task> taskList = new ArrayList<>();
//            while (resultSet.next()) {
//                taskList.add(
//                        new Task(
//                                resultSet.getInt("id"),
//                                resultSet.getString("title")));
//            }
//            return taskList;
//        } catch (Exception e) {
//            System.out.println("Ошибка выполнения запроса: " + e.getMessage());
//        }
//        return new ArrayList<>();
//    }

    /**
     * Метод создания записи в БД о входящем рейсе.
     *
     * @param flightIn задача
     */
    public void createNew(FlightIn flightIn) {
        String sqlQuery = "INSERT INTO " + NAME_TABLE + " VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setString(1, flightIn.getId());
            statement.setString(2, flightIn.getCompany());
            statement.setString(3, flightIn.getPlacePurpose());
            statement.setString(4, flightIn.getPlaceDeparture());
            statement.setString(5, flightIn.getDate());
            statement.setString(6, flightIn.getTime());
            statement.execute();
        } catch (Exception e) {
            System.out.println("Ошибка выполнения запроса: " + e.getMessage());
        }
    }

    /**
     * Метод создания записи в БД о исходящем рейсе.
     *
     * @param flightOut задача
     */
    public void createNew(FlightOut flightOut) {
        String sqlQuery = "INSERT INTO " + NAME_TABLE + " VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setString(1, flightOut.getId());
            statement.setString(2, flightOut.getCompany());
            statement.setString(3, flightOut.getPlacePurpose());
            statement.setString(4, flightOut.getPlaceDeparture());
            statement.setString(5, flightOut.getDate());
            statement.setString(6, flightOut.getTime());
            statement.execute();
        } catch (Exception e) {
            System.out.println("Ошибка выполнения запроса: " + e.getMessage());
        }
    }



}
