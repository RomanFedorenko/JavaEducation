package servlets;

import models.Department;
import services.implementations.EmployeeDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class EmployeesServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        request.setAttribute("employees", EmployeeDAO.getAllEmployess());
        RequestDispatcher RequestDispatcherObj =request.getRequestDispatcher("/employees.jsp");
        RequestDispatcherObj.forward(request, response);

    }


        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            Department depToAdd = new Department(req.getParameter("name"));



    }

}


