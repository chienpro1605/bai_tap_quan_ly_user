package controller;

import dao.BlogDAO;
import dao.IBlogDAO;
import model.Blog;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "BlogServlet", value = "/blogs")
public class BlogServlet extends HttpServlet {
    private IBlogDAO iBlogDAO = new BlogDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("blog/list.jsp");
        try {
            List<Blog> blogs = iBlogDAO.findAll();
            request.setAttribute("blogs", blogs);
            requestDispatcher.forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      RequestDispatcher requestDispatcher = request.getRequestDispatcher("blog/list.jsp");
        try {
            List<Blog> blogs = iBlogDAO.findAll();
            request.setAttribute("blogs", blogs);
            requestDispatcher.forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
