package com.company.controller;

import com.company.comm.Const;
import com.company.dao.entity.Building;
import com.company.service.factory.ServiceFactory;
import com.company.service.iservice.IBuildingService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/building/delete")
public class BuildingDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer bid = Integer.parseInt(request.getParameter("bid"));
        IBuildingService buildingService = (IBuildingService) ServiceFactory.getInstance(Const.BUILDING);
        Building building = new Building();
        building.setBid(bid);
        int flag = buildingService.delete(building);
        if (flag > 0){
            request.getRequestDispatcher("/buildings").forward(request,response);
        }else{
            response.sendRedirect(request.getContextPath()+"/error.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
