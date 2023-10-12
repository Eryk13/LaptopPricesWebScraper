package org.eryk;

import java.sql.*;
import java.util.List;

public class LaptopDTO {
    private final String dbUrl = "jdbc:postgresql://localhost:5432/ComputerPrices";
    private final String user = "postgres";
    private final String userPassword = "root";

//    public LaptopDTO(String dbUrl, String user, String userPassword) {
//        this.dbUrl = dbUrl;
//        this.user = user;
//        this.userPassword = userPassword;
//    }

    public String getDbUrl() {
        return dbUrl;
    }

    public String getUser() {
        return user;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void insert(List<Laptop> laptops) {
        try(Connection conn = DriverManager.getConnection(getDbUrl(), getUser(), getUserPassword());
            Statement statement = conn.createStatement();) {
            Date date = new Date(System.currentTimeMillis());
            for(Laptop laptop : laptops) {
                PreparedStatement st = conn.prepareStatement("INSERT INTO laptopprices (name, price, link, date) VALUES (?, ?, ?, ?)");
                st.setString(1, laptop.getName());
                st.setInt(2, laptop.getPrice());
                st.setString(3, laptop.getLink());
                st.setObject(4, date);
                st.executeUpdate();
                st.close();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
