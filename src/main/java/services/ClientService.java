package services;

import config.Database;
import interfaces.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
    static Connection conn = Database.getConnection();
    public static void main(String[] args) {
    }

    public long create(String name) {
        long generatedId = -1;
        String sqlTemplate = "INSERT INTO worker (NAME) VALUES (?)";
        if(name.length() > 3 && name.length() < 100) {
            try {
                PreparedStatement queryStatement = conn.prepareStatement(sqlTemplate, Statement.RETURN_GENERATED_KEYS);
                queryStatement.setString(1, name);
                queryStatement.executeUpdate();
                ResultSet resultSet = queryStatement.getGeneratedKeys();

                if (resultSet.next()) {
                    generatedId = resultSet.getInt(1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            throw new RuntimeException("The name must be at least 3 characters and no more than 100!");
        }


        return generatedId;
    }

    public String getById(long id) {
        String foundName = "";
        String sqlTemplate = "SELECT name FROM worker WHERE id = ?;";
        try {
            PreparedStatement queryStatement = conn.prepareStatement(sqlTemplate, Statement.RETURN_GENERATED_KEYS);
            queryStatement.setLong(1, id);
            ResultSet resultSet = queryStatement.executeQuery();
            if (resultSet.next()) {
                foundName =resultSet.getString("name");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return foundName;
    }

    public void setName(long id, String name) {
        if (name.length() > 3 && name.length() < 100) {
            String sqlTemplate = "UPDATE worker SET name = ? WHERE id = ?";
            try {
                PreparedStatement queryStatement = conn.prepareStatement(sqlTemplate);
                queryStatement.setString(1, name);
                queryStatement.setLong(2, id);
                int resultSet = queryStatement.executeUpdate();

                if (resultSet > 0) {
                    System.out.println("Name updated successfully for user with ID " + id);
                } else {
                    System.out.println("User not found with ID " + id);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            throw new RuntimeException("The name must be at least 3 characters and no more than 100!");
        }
    }

    public void deleteById(long userId) {
        String sqlTemplate = "DELETE FROM worker WHERE id = ?";

        try (PreparedStatement queryStatement = conn.prepareStatement(sqlTemplate)) {
            queryStatement.setLong(1, userId);
            int resultSet = queryStatement.executeUpdate();

            if (resultSet > 0) {
                System.out.println("User deleted successfully with ID " + userId);
            } else {
                System.out.println("User not found with ID " + userId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Client> listAll() {
        List<Client> clients = new ArrayList<>();

        String query = "SELECT id, name FROM worker";

        try (PreparedStatement queryStatement = conn.prepareStatement(query)) {
            ResultSet resultSet = queryStatement.executeQuery();

            while (resultSet.next()) {
                Client client = new Client();
                long userId = resultSet.getLong("id");
                String userName = resultSet.getString("name");
                client.setId(userId);
                client.setName(userName);
                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clients;
    }


}
