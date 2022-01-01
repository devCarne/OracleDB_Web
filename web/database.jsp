<%@ page import="java.sql.*" %><%--
  Created by IntelliJ IDEA.
  User: kms
  Date: 2022-01-01
  Time: 오후 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%!
    Connection connection;
    Statement statement;
    String s = "데이터";
%>
<%
    out.println(s);
    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");

        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "1111");
        statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM TBL_BOOKS");

        while (resultSet.next()) {
            out.println(resultSet.getString(1) + "\t");
            out.println(resultSet.getString(2) + "\t");
            out.println(resultSet.getString(3) + "\t");
            out.println(resultSet.getString(4) + "\t");
            out.println(resultSet.getString(5));
        }
        out.println();
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    }
%>
</body>
</html>
