package dao;

import model.Blog;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BlogDAO implements IBlogDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/demo";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";


    protected Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);

        return connection;
    }
    @Override
    public void insert(Blog blog) throws SQLException {

    }

    @Override
    public Blog findByID(int id) {
        return null;
    }

    @Override
    public List<Blog> findAll() throws SQLException, ClassNotFoundException {
        List<Blog> blogs = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from blogs");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()){
            int id = rs.getInt("id");
            String title = rs.getString("title");
            String content = rs.getString("content");
            int user_id = rs.getInt("user_id");
            blogs.add(new Blog(id, title, content, user_id));
        }
        return blogs;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Blog blog) throws SQLException {
        return false;
    }
}
