package controllers;

import java.io.IOException;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Task;
import utils.DBUtil;

@WebServlet("/new")
public class NewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public NewServlet() {
        super();

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em=DBUtil.createEntityManager();

        Task s=new Task();

        String title="shin";
        s.setTitle(title);


        String content="hello";
        s.setContent(content);

        Timestamp currentTime=new Timestamp(System.currentTimeMillis());
           s.setCreated_at(currentTime);
            s.setUpdated_at(currentTime);

            em.getTransaction().begin();
            em.persist(s);
            em.getTransaction().commit();

            response.getWriter().append(Integer.valueOf(s.getId()).toString());

            em.close();
    }

}
