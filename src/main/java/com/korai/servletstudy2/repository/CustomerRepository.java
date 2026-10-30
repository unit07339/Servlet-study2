package com.korai.servletstudy2.repository;

import com.korai.servletstudy2.database.DatabaseProvider;
import com.korai.servletstudy2.entity.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CustomerRepository implements Repository<Customer> {
    public List<Customer> findAllByLikeName(String value) {
        String sql = """
                select * from customers where name like concat('%', ?, '%') // 문자열 합치기
                """;

        return null;
    }

    @Override
    public List<Customer> findAll() {
        String  sql = """
                select * from customer
                """;
        try {
            return select(DatabaseProvider.getInstance().getConnection(), sql, null)
                    .stream()
                    .map(Customer::new) // .map((row) -> new Customer(row)) 둘 중 아무거나 해도 됨
                    .toList();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    @Override
    public Customer findById(int id) {
        String  sql = """
                select * from customers where customer_id = ?
                """;
        try {
            return new Customer(selectOne(DatabaseProvider.getInstance().getConnection(), sql, List.of(id)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 위아래 같은
    // 데이터베이스에서 데이터 가져오는 거


    public Customer findById2(int id) {
        String  sql = """
                select * from customers where customer_id = ?
                """;

        try (Connection conn = DatabaseProvider.getInstance().getConnection()) {
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, id);
                try(ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        return new Customer(
                                rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getString(4),
                                rs.getString(5),
                                rs.getString(6),
                                rs.getString(7),
                                rs.getString(8),
                                rs.getInt(9),
                                rs.getString(10)
                        );
                    }
                } catch(SQLException e) {
                    e.printStackTrace();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
