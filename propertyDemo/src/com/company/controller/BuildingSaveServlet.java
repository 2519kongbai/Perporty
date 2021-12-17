package com.company.controller;

import com.company.comm.Const;
import com.company.dao.entity.Building;
import com.company.service.factory.ServiceFactory;
import com.company.service.iservice.IBuildingService;
import javafx.util.BuilderFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(urlPatterns = "/building/build_save")
public class BuildingSaveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String buildingNum = request.getParameter("buildingNum");
        String name = request.getParameter("name");
        int roomNum = Integer.parseInt(request.getParameter("roomNum"));
        String buildingDesc = request.getParameter("buildingDesc");
        Date buildHiredate = null;
        try {
            buildHiredate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("buildHiredate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int cid = Integer.parseInt(request.getParameter("cid"));
        String pic = request.getParameter("pic");
        Building building = new Building(buildingNum,name,roomNum,buildingDesc,buildHiredate,cid,pic);
        IBuildingService buildingService = (IBuildingService) ServiceFactory.getInstance(Const.BUILDING);
        int flag = buildingService.save(building);
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
