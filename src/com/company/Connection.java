package com.company;

import java.sql.*;

public class Connection {
    private final String url = "jdbc:postgresql://localhost:5432/";
    private final String user = "postgres";
    private final String password = "123";

    public java.sql.Connection connect() {
        java.sql.Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to server successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void insertNews(News news) {
        String SQL = "INSERT INTO \"DailyNews\".news" +
                " (ID, headline, textline, publicationDate)" +
                " VALUES (?, ?, ?, ?); ";
        try (java.sql.Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setInt(1, news.getID());
            stmt.setString(2, news.getHeadline());
            stmt.setString(3, news.getTextline());
            stmt.setDate(4, (Date) news.getPublicationDate());
            ResultSet rs = stmt.executeQuery();
            rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getNews() {
        String SQL = "SELECT * FROM \"DailyNews\".news";

        try (java.sql.Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {

            while (rs.next()) {
                System.out.print(rs.getString("headline") + "  ");
                System.out.print(rs.getString("textline") + "  ");
                System.out.println();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void deleteNews() {
        String SQL = "DELETE * FROM \"DailyNews\".news where ID = 2";

        try (java.sql.Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {

            while (rs.next()) {
                System.out.print(rs.getInt("ID") + "  ");
                System.out.print(rs.getString("headline") + "  ");
                System.out.print(rs.getString("textline") + "  ");
                System.out.print(rs.getDate("publicationDate") + "  ");
                System.out.println();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void updateNews() {
        String SQL = "UPDATE \"DailyNews\".news set headline = 'Last news', textline = 'No any news' where ID = 3";

        try (java.sql.Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {

            while (rs.next()) {
                System.out.print(rs.getInt("ID") + "  ");
                System.out.print(rs.getString("headline") + "  ");
                System.out.print(rs.getString("textline") + "  ");
                System.out.print(rs.getDate("publicationDate") + "  ");
                System.out.println();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
