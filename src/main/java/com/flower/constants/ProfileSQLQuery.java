package com.flower.constants;

public class ProfileSQLQuery {
    public static final String QUERY_TEMPLATE_FIND_BY_LOGIN_PASSWORD = "select * from profile where login = ? and password = ?";
    public static final String QUERY_TEMPLATE_FIND_BY_LOGIN = "SELECT * FROM profile WHERE login = ?";
    public static final String QUERY_TEMPLATE_FIND_BY_ID = "SELECT * FROM profile WHERE id = ?";
    public static final String QUERY_TEMPLATE_CREATE = "INSERT INTO profile (fio, login, password) VALUES (?, ?, ?)";
    public static final String QUERY_TEMPLATE_FIND_ALL = "SELECT * FROM profile";
    public static final String QUERY_TEMPLATE_DELETE = "DELETE FROM profile WHERE id = ?";
    public static final String QUERY_TEMPLATE_UPDATE = "UPDATE profile SET login=?, password=? WHERE id=?";
    public static final String QUERY_TEMPLATE_FIND_LOGIN_PASSWORD_BY_ID = "SELECT login, password FROM profile WHERE id = ?";
}
