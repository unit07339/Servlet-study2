package com.korai.servletstudy2.database;

import com.korai.servletstudy2.entity.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnectionTest2 {
    public static void main(String[] args) {

        String protocol = "jdbc:mysql";
        String host = "localhost";
        String port = "3308";
        String databaseName = "hanip_delivery02";
        String username = "root";
        String password = "1q2w3e4r!";

        String url = String.format("%s://%s:%s/%s", protocol,host, port, databaseName);

        List<Customer> customers = new ArrayList<>();

        try(Connection connection = DriverManager.getConnection(url, username, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement("""
select
    *
from customers""");
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                Customer customer = new Customer(
                        rs.getInt("customer_id"),
                        rs.getString("name"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("birth_date"),
                        rs.getString("district"),
                        rs.getString("address"),
                        rs.getString("grade"),
                        rs.getBoolean("marketing_agreed"),
                        rs.getString("joined_at")
                );
                customers.add(customer);
            }
        } catch (SQLException e) {
            System.out.println("연결 실패!");
            e.printStackTrace();
        }
        customers.forEach(System.out::println);
















//        List<Customer> customers = new ArrayList<>();
//
//        try (Connection cn = DriverManager.getConnection(url, username, password)) {
//            PreparedStatement ps = cn.prepareStatement("""
//
//                    select
//                        *
//                    from
//                        customers""");
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                Customer customer = new Customer(
//                        rs.getInt("customer_id"),
//                        rs.getString("name"),
//                        rs.getString("phone"),
//                        rs.getString("email"),
//                        rs.getString("birth_date"),
//                        rs.getString("district"),
//                        rs.getString("address"),
//                        rs.getString("grade"),
//                        rs.getBoolean("marketing_agreed"),
//                        rs.getString("joined_at")
//                );
//                customers.add(customer);
//            }
//        } catch (SQLException e) {
//            System.out.println("연결실패!");
//            e.printStackTrace();
//        }
//        customers.forEach(System.out::println);
    }
}







