package com.tjcloud.face.api.component;

import com.baidu.aip.util.Base64Util;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class ImageUtils {
	
	public static String getBase64ByImgUrl(String url){
        String suffix = url.substring(url.lastIndexOf(".") + 1);
        try {
            URL urls = new URL(url);
            ByteArrayOutputStream  baos = new ByteArrayOutputStream();
            Image image = Toolkit.getDefaultToolkit().getImage(urls);
            BufferedImage  biOut = toBufferedImage(image);
            ImageIO.write(biOut, suffix, baos);
            String base64Str = new String(Base64.decodeBase64(baos.toByteArray()));
            return base64Str;
        } catch (Exception e) {
            return "";
        }
        
    }
    
    public static BufferedImage toBufferedImage(Image image) {  
        if (image instanceof BufferedImage) {  
            return (BufferedImage) image;  
        }  
        // This code ensures that all the pixels in the image are loaded  
        image = new ImageIcon(image).getImage();  
        BufferedImage bimage = null;  
        GraphicsEnvironment ge = GraphicsEnvironment  
                .getLocalGraphicsEnvironment();  
        try {  
            int transparency = Transparency.OPAQUE;  
            GraphicsDevice gs = ge.getDefaultScreenDevice();  
            GraphicsConfiguration gc = gs.getDefaultConfiguration();  
            bimage = gc.createCompatibleImage(image.getWidth(null),  
                    image.getHeight(null), transparency);  
        } catch (HeadlessException e) {  
            // The system does not have a screen  
        }  
        if (bimage == null) {  
            // Create a buffered image using the default color model  
            int type = BufferedImage.TYPE_INT_RGB;  
            bimage = new BufferedImage(image.getWidth(null),  
                    image.getHeight(null), type);  
        }  
        // Copy image to buffered image  
        Graphics g = bimage.createGraphics();  
        // Paint the image onto the buffered image  
        g.drawImage(image, 0, 0, null);  
        g.dispose();  
        return bimage;  
    }  
    
    /**
     * ???????????????url???????????????base64?????????
     * @param imgUrl    ??????url
     * @return    ????????????base64????????????
     */
    public static String image2Base64(String imgUrl) {  
        URL url = null;  
        InputStream is = null;   
        ByteArrayOutputStream outStream = null;  
        HttpURLConnection conn = null;  
        try{  
            url = new URL(imgUrl);  
            conn = (HttpURLConnection) url.openConnection();  
            //?????????????????????5???
			conn.setConnectTimeout(30 * 1000);
			conn.connect();  
			conn.getInputStream();  
            is = conn.getInputStream();            
            outStream = new ByteArrayOutputStream();  
            //????????????Buffer?????????  
            byte[] buffer = new byte[1024];  
            //??????????????????????????????????????????-1???????????????????????????  
            int len = 0;  
            //????????????????????????buffer????????????????????????  
            while( (len=is.read(buffer)) != -1 ){  
                //???????????????buffer???????????????????????????????????????????????????????????????len?????????????????????  
                outStream.write(buffer, 0, len);  
            }  
            // ???????????????Base64??????  
            String base64 = Base64Util.encode(outStream.toByteArray());
            System.out.println("????????????[{}]?????????base64?????????:[{}]"+url.toString()+base64);
            return base64;
        }catch (Exception e) {  
            e.printStackTrace();  
        }  
        finally{  
            if(is != null)  
            {  
                try {  
                    is.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
            if(outStream != null)  
            {  
                try {  
                    outStream.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
            if(conn != null)  
            {  
            		conn.disconnect();  
            }  
        }  
        return imgUrl;  
    }
}
