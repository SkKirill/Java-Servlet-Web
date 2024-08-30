package com.flower.repository;

import com.flower.entity.Profile;
import com.flower.exception.DBException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.flower.constants.ProfileSQLQuery.*;

public class ProfileRepository {

    public Profile findByLoginAndPassword(String login, String password) {
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(QUERY_TEMPLATE_FIND_BY_LOGIN_PASSWORD)) {
            ps.setString(1, login);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapProfile(rs);
            }
            return null;
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    private Profile mapProfile(ResultSet rs) throws SQLException {
        return new Profile(rs.getLong("id"),
                rs.getString("fio"),
                rs.getString("login"),
                rs.getString("password"));
    }

    public void addProfile(String login, String password, String fio) {
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement statement = conn.prepareStatement(QUERY_TEMPLATE_CREATE)) {
            statement.setString(1, fio);
            statement.setString(2, login);
            statement.setString(3, password);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public ResultSet getAllProfile() {
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement statement = conn.prepareStatement(QUERY_TEMPLATE_FIND_ALL)) {
            return statement.executeQuery();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public boolean existProfileByID(Long id) {
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(QUERY_TEMPLATE_FIND_BY_ID)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public boolean existProfileByLogin(String login) {
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(QUERY_TEMPLATE_FIND_BY_LOGIN)) {
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }
}
