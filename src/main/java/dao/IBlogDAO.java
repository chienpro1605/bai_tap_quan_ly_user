package dao;

import model.Blog;

import java.sql.SQLException;
import java.util.List;

public interface IBlogDAO {
    public void insert(Blog blog) throws SQLException;
    public Blog findByID(int id);
    public List<Blog> findAll() throws SQLException, ClassNotFoundException;
    public boolean delete(int id) throws SQLException;
    public boolean update(Blog blog) throws SQLException;



}
