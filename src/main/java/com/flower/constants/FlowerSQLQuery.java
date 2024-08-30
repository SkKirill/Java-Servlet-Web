package com.flower.constants;

public class FlowerSQLQuery {
    public static final String QUERY_TEMPLATE_FIND_BY_ID = "SELECT * FROM flower WHERE id = ?";
    public static final String QUERY_TEMPLATE_CREATE = "INSERT INTO flower (name, id_profile, description) VALUES (?, ?, ?)";
    public static final String QUERY_TEMPLATE_DELETE = "DELETE FROM flower WHERE id = ?";
    public static final String QUERY_TEMPLATE_UPDATE = "UPDATE flower SET name = ?, description = ? WHERE id = ?";
    public static final String QUERY_TEMPLATE_FIND_ID_PROFILE_NAME_DESCRIPTION_BY_ID = "SELECT id_profile, name, description FROM flower WHERE id = ?";
    public static final String QUERY_TEMPLATE_FIND_BY_PROFILE_ID = "SELECT * FROM flower WHERE id_profile = ?";
}
