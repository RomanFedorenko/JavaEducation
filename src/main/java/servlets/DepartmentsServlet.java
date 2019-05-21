package servlets;

import models.Department;
import services.implementations.DepartmentDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;


//TODO interfaces for DAO and services and folder impl
public class DepartmentsServlet extends HttpServlet { //todo doget, dopost, dodelete for crud

    @Override
    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws IOException, ServletException {

        httpServletRequest.setAttribute("departments", DepartmentDAO.getAllDepartments());
        httpServletRequest.setAttribute("test", "OOOOO");
        RequestDispatcher RequestDispatcherObj =httpServletRequest.getRequestDispatcher("/deps.jsp");
        RequestDispatcherObj.forward(httpServletRequest, httpServletResponse);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String deleteParameter = req.getParameter("action");

        if (deleteParameter != null && !deleteParameter.isEmpty()){
            if (deleteParameter.equals("delete"))
            doDelete(req, resp);}

        else {

            DepartmentDAO.addDepartment(new Department(req.getParameter("name")));
            doGet(req, resp);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DepartmentDAO.deleteDepartmentByName(req.getParameter("deleteName"));
        doGet(req,resp);

    }


}


