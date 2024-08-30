package com.flower.repository;

import com.flower.exception.RunException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBUtils {
    public static Connection getConnection() {
        try {
            InitialContext context = new InitialContext();
            DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/postgres");
            if (ds == null) {
                throw new RunException("datasource not found");
            }
            return ds.getConnection();
        } catch (NamingException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}