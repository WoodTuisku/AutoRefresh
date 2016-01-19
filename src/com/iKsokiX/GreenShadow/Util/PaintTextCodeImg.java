package com.iKsokiX.GreenShadow.Util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class PaintTextCodeImg {
	BufferedImage image;
	String imgUrl = "/usr/local/tomcat/webapps/WebSiteManager/PassImg/Pass.jpg";
	 void createImage(String fileLocation) {
	  try {
	   FileOutputStream fos = new FileOutputStream(fileLocation);
	   BufferedOutputStream bos = new BufferedOutputStream(fos);
	   JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(bos);
	   encoder.encode(image);
	   bos.close();
	  } catch (Exception e) {
	   e.printStackTrace();
	  }
	 }

	 public void graphicsGeneration(String NewPass) {

	  int imageWidth = 100;// 图片的宽度

	  int imageHeight = 20;// 图片的高度

	  image = new BufferedImage(imageWidth, imageHeight,
	    BufferedImage.TYPE_INT_RGB);
	  Graphics graphics = image.getGraphics();
	  graphics.setColor(Color.WHITE);
	  graphics.fillRect(0, 0, imageWidth, imageHeight);
	  graphics.setColor(Color.BLACK);
	  graphics.setFont(new Font("宋体",Font.PLAIN,18));
	  graphics.drawString(NewPass,10,17);

	  // 改成这样:
	  BufferedImage bimg = null;
	  try {
	   bimg = javax.imageio.ImageIO.read(new java.io.File(imgUrl));
	  } catch (Exception e) {
	  }

	  if (bimg != null)
	   graphics.drawImage(bimg, 230, 0, null);
	  graphics.dispose();

	  createImage(imgUrl);

	 }
}
