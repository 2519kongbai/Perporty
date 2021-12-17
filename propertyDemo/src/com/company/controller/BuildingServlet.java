package com.company.controller;

import com.company.comm.Const;
import com.company.dao.entity.Building;
import com.company.service.factory.ServiceFactory;
import com.company.service.iservice.IBuildingService;
import com.mysql.jdbc.StringUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/building")
public class BuildingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IBuildingService buildingService = (IBuildingService) ServiceFactory.getInstance(Const.BUILDING);
        List<Building> buildings = buildingService.findAll();
        request.setAttribute("buildings",buildings);

        request.getRequestDispatcher("WEB-INF/views/buildings.jsp").forward(request,response);
//        request.getRequestDispatcher("/buildings.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
