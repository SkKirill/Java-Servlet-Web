package com.flower.repository;

import com.flower.entity.Flower;
import com.flower.exception.DBException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.flower.constants.FlowerSQLQuery.*;

public class FlowerRepository {

    public List<Flower> findAllFlowers(Long id) {
        try (Connection conn = DBUtils.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(QUERY_TEMPLATE_FIND_BY_PROFILE_ID);
            ps.setLong(1, id);
            List<Flower> flowers = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                flowers.add(mapFlower(rs));
            }
            return flowers;
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    private Flower mapFlower(ResultSet rs) throws SQLException {
        return new Flower(rs.getLong("id"),
                rs.getLong("id_profile"),
                rs.getString("description"),
                rs.getString("name"));
    }

    public boolean existsFlowerById(Long id) {
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(QUERY_TEMPLATE_FIND_BY_ID)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public void addFlower(Long profileId, String description, String name) {
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(QUERY_TEMPLATE_CREATE)) {
            ps.setLong(2, profileId);
            ps.setString(3, description);
            ps.setString(1, name);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public void deleteFlower(Long id) {
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(QUERY_TEMPLATE_DELETE)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public void updateFlower(Long profileId, String description, String name) {
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(QUERY_TEMPLATE_UPDATE)) {
            ps.setLong(3, profileId);
            ps.setString(2, description);
            ps.setString(1, name);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public Flower findFlowerById(Long id) {
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(QUERY_TEMPLATE_FIND_BY_ID)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapFlower(rs);
            }
            return null;
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }
}
