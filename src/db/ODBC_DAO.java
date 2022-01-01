package db;

import java.sql.*;

public class ODBC_DAO implements ODBC_CRUD{

    Connection connection;
    Statement statement;

    ODBC_DAO() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "1111");
            statement = connection.createStatement();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void select() {
        try {
            String sql = "SELECT * FROM TBL_BOOKS";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                System.out.print(resultSet.getString(1) + "\t");
                System.out.print(resultSet.getString(2) + "\t");
                System.out.print(resultSet.getString(3) + "\t");
                System.out.print(resultSet.getString(4) + "\t");
                System.out.println(resultSet.getString(5));
            }
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(String bookName, String bookAuthor, String bookPublisher, String bookImageUrl) {

        try {
            String sql = "INSERT INTO TBL_BOOKS (bookName, bookAuthor, bookPublisher, bookImage) VALUES (" +
                    "'" + bookName + "'," +
                    " '" + bookAuthor + "'," +
                    " '" + bookPublisher + "'," +
                    " '" + bookImageUrl + "')";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(String targetBookName, String bookName, String bookAuthor, String bookPublisher, String bookImageUrl) {
        try {
            String sql = "UPDATE TBL_BOOKS SET " +
                    "BOOKNAME = '" + bookName + "'," +
                    "BOOKAUTHOR = '" + bookAuthor + "'," +
                    "BOOKPUBLISHER = '" + bookPublisher + "'," +
                    "BOOKIMAGE = '" + bookImageUrl + "'" +
                    "WHERE BOOKNAME = '" + targetBookName + "'";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String targetBookName) {
        try {
            String sql = "DELETE TBL_BOOKS WHERE BOOKNAME = '" + targetBookName + "'";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
