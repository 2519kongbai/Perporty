package com.company.controller;

import com.company.comm.Const;
import com.company.service.factory.ServiceFactory;
import com.company.service.iservice.IBuildingService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ScheduledFuture;

@WebServlet( urlPatterns = "/upload")
@MultipartConfig(maxFileSize = 1024*1024*10,maxRequestSize = 1024*1024*20)
public class BuildingUploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String buildingNum = request.getParameter("buildingNum");
        Part file = request.getPart("mypic");

        // 上传的文件路径
        String spath = "E:/nginx/html";
        File path = new File(spath);
        if (!path.exists()){
            path.mkdirs();
        }

        // 加上时间戳的文件名
        String filename = System.currentTimeMillis()+file.getSubmittedFileName();
        String uploadFilePath = spath+File.separator+filename;
        file.write(uploadFilePath);
        IBuildingService buildingService = (IBuildingService) ServiceFactory.getInstance(Const.BUILDING);
        Properties props = new Properties();
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("server.properties");props.load(in);

        // 往数据库存相对数据
        int flag = buildingService.updatePic(buildingNum,filename);

        // 拼装远程访问路径
        String picPath = props.getProperty("file.server")+filename;
        if (flag > 0){
            request.setAttribute("buildingNum",buildingNum);
            request.setAttribute("picPath",picPath);
            request.getRequestDispatcher("/detail.jsp").forward(request,response);
        }else{
            response.sendRedirect(request.getContextPath()+"/error.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
