package dao.impl;

import dao.Dao;
import data.Database;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Andrey Volinskiy on 17.02.2018.
 */
public class DaoImpl implements Dao {

    private final String GET_BY_ID = "SELECT * FROM db_chat.users WHERE id = ?";
    private final String GET_BY_LOGIN = "SELECT * FROM db_chat.users WHERE login = ?";
    private final String GET_ALL = "SELECT * FROM db_chat.users";
    private final String CREATE = "INSERT INTO users (`name`, `login`, `password`) VALUES (?,?,?)";
    private final String CHECK = "";
    private final String WRITE_MESSAGE = "";

    public User getUserById(int id) {
        User user = new User();
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
        } catch (SQLException e) {
            System.out.println("There is no such user in db.");
        }
        return user;
    }

    @Override
    public User getUserByLogin(String login) {
        User user = new User();
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_BY_LOGIN)) {
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            user.setId(resultSet.getInt("id"));
            user.setLogin(resultSet.getString("login"));
            user.setPassword(resultSet.getString("password"));
        } catch (SQLException e) {
            System.out.println("There is no such user in db.");
        }
        return user;
    }

    public List<User> getAllUsers() {
        List<User> list = new LinkedList<>();
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void createNewUser(User user) {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void writeMessageToDB(String message, User userFrom, User userTo) {

    }
}
