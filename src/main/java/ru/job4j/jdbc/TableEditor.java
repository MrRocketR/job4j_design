package ru.job4j.jdbc;

import ru.job4j.io.Config;

import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) throws Exception {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws Exception {
        String driver = properties.getProperty("driver");
        String url =  properties.getProperty("url");
        String login =  properties.getProperty("login");
        String password = properties.getProperty("password");
        Class.forName(driver);
        connection = DriverManager.getConnection(url, login, password);
    }

    public void createTable(String tableName) throws SQLException {
        String sql = String.format(
                "CREATE TABLE %s (id serial primary key);", tableName
        );
        statementEx(sql);
        System.out.println(getTableScheme(connection, tableName));
    }


    public void dropTable(String tableName) throws SQLException {
        String sql = String.format(
                "DROP TABLE %s;", tableName
        );
        statementEx(sql);
    }

    private void statementEx(String sql) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);

        }
    }

    public void addColumn(String tableName, String columnName, String type) throws SQLException {
        String sql = String.format(
                "ALTER TABLE %s "
                        + "ADD %s %s;",
                tableName, columnName, type
        );
        statementEx(sql);
        System.out.println(getTableScheme(connection, tableName));
    }

    public void dropColumn(String tableName, String columnName) throws SQLException {
        String sql = String.format(
                "ALTER TABLE %s "
                        + "DROP COLUMN %s",
                tableName, columnName
        );
        statementEx(sql);
        System.out.println(getTableScheme(connection, tableName));
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws SQLException {
        String sql = String.format(
                "ALTER TABLE %s "
                        + "RENAME COLUMN %s to %s",
                tableName, columnName, newColumnName
        );
        statementEx(sql);
        System.out.println(getTableScheme(connection, tableName));

    }

    public static String getTableScheme(Connection connection, String tableName) throws SQLException {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }


    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        try (InputStream in = TableEditor.class.getClassLoader().getResourceAsStream("app.properties")) {
            properties.load(in);
        }
        try (TableEditor tableEditor = new TableEditor(properties)) {
            System.out.println("CREATE TABLE");
            String testTable =  "test";
            tableEditor.createTable(testTable);
            System.out.println("addColumn");
            tableEditor.addColumn(testTable, "name", "varchar(255)");
            System.out.println("renameColumn");
            tableEditor.renameColumn(testTable, "name", "renamed");
            System.out.println("Drop Column");
            tableEditor.dropColumn(testTable, "renamed");
            System.out.println("And Drop Table");
            tableEditor.dropTable(testTable);
        }

    }
}

