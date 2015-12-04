package com.technobrain.trips.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * This is a servlet that diplays the content of a report to a user
 * 
 */
 
public class ReportDisplayServlet extends HttpServlet {
    
    public ReportDisplayServlet(){
    }

    /**
     * It reads contents (ReportResult) from request and write it back to the page
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, 
                         HttpServletResponse response) throws ServletException, IOException {

        //Retrieve ReportResult object from request
//        ReportResult reportResult = (ReportResult)request.getAttribute("ReportResult");
//        if(null == reportResult){
//            //do nothing
//        }else
        {

//            response.setContentType(reportResult.getReportContentType());
            ServletOutputStream out = response.getOutputStream();
//            out.write(reportResult.getReportBytes());
            out.flush();
            out.close();
        }
            
    }
    
    protected void doPost(HttpServletRequest httpServletRequest, 
                          HttpServletResponse httpServletResponse) throws ServletException, IOException {
       
    }
}
