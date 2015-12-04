package com.technobrain.trips.servlets;

import com.technobrain.trips.core.bean.ProductImageBean;
import com.technobrain.trips.core.delegate.ReferenceCodeDelegate;
import com.technobrain.trips.util.WebConstants;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * This is a servlet that reads contents of a file(Image) and write that back to the page.
 * 
 * @since $Date: 2/2/2009 5:35:08 AM$
 * @version $Revision: 9$
 * @author $Author: Howard Hill$
 * 
 * $Log[1]:
 *  9    TRIPS2    1.8         2/2/2009 5:35:08 AM    Howard Hill     change
 *       log10 to log1
 * $
 */

public class ViewImage extends HttpServlet {

    private ReferenceCodeDelegate refDelegate;
    
    public ViewImage(){
        refDelegate = new ReferenceCodeDelegate();
    }

    /**
     * It reads contents (ProductImageBean) from session and write it back to the page
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, 
                         HttpServletResponse response) throws ServletException, IOException {

        //Retrieve ProductImageBean object from session
        ProductImageBean piBean = (ProductImageBean)request.getSession().getAttribute(WebConstants.SessionVariable.FILE_STORE);
        if(null == piBean){
            //do nothing
        }else{
            byte[] image = piBean.getContents();
            BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(image));
            int size[] = calculateImageSize(bufferedImage);
            int height = size[0];
            int width = size[1];
            BufferedImage resizedImage = resizeImage(bufferedImage,width,height);

            response.setContentType(piBean.getFileType());
            ServletOutputStream sout = response.getOutputStream();
            int index = piBean.getFileType().indexOf("/");
            String outputFormat = piBean.getFileType().substring(index+1,piBean.getFileType().length());
            ImageIO.write(resizedImage,outputFormat,sout);
            sout.flush();
            sout.close();
            //Clear ProductImageBean object from session
            request.getSession().removeAttribute(WebConstants.SessionVariable.FILE_STORE);
        }
            
    }

    /**
     * It resizes the image proportionally using calculated height and width passed as parameters.
     * @param originalImage
     * @param width
     * @param height
     * @return Resized Image
     */
    private BufferedImage resizeImage(Image originalImage, int width, int height) {  
        BufferedImage resizedBI = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
        Graphics2D g = resizedBI.createGraphics();  
        g.setComposite(AlphaComposite.Src);  
        g.drawImage(originalImage, 0, 0, width, height, null);  
        g.dispose();  
        return resizedBI;  
    }

    /**
     * It calculates new height and width proportionally for the image to be resized based 
     * on the actual height and width of the image and constants defined for height and width.
     * @param originalImage        
     * @return Image height & width as int array
     */
    private int[] calculateImageSize(BufferedImage originalImage){
        int size[] = new int[2];
        double width = originalImage.getWidth() ;
        double height  = originalImage.getHeight();
        double heightConstant = 350;
        double widthConstant = 450;
        double heightRatio = height/heightConstant;
        double widthRatio = width/widthConstant;
        if(height == width){
            height = 350;
            width = 350;
        }else{
            if(width > widthConstant || height > heightConstant){
                if(heightRatio > 1){
                    height = height / heightRatio;
                }else{
                    height = height * heightRatio;
                }
                if(widthRatio > 1){
                    width = width / widthRatio;
                }
                else{
                    width = width * widthRatio;
                }
            }
        }
        size[0] =(int)height;
        size[1] =(int)width;
        return size;
    }
 
}
