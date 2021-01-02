package com.janliao.pro;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

/** 
* @author 作者: JanLiao
* @date 时间: 2020年8月9日 下午9:29:51
*/

public class OCRDemo {
	
	public static String filterStr(String s) {
		String regEx="[\n`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。， 、？]";
		String str = s;
		String newString = str.replaceAll(regEx,"");//不想保留原来的字符串可以直接写成 “str = str.replaceAll(regEX,aa);"
		return newString;
	}
	
	public static String filterStr1(String s) {
		String regEx="[\n`~!@#$%^&*()+=|{}':;',\\[\\].<>?~！@#￥%……&*（）——+|{}【】‘；：”“’。， 、？]";
		String str = s;
		String newString = str.replaceAll(regEx,"");//不想保留原来的字符串可以直接写成 “str = str.replaceAll(regEX,aa);"
		return newString;
	}
	
	public static String tests(String path) throws Exception {
		Tesseract instance = new Tesseract();
		BufferedImage imgfile = ImageIO.read(new File(path));
		int w = imgfile.getWidth();
		int h = imgfile.getHeight();
		char c = (char)10;
		//ImageIO.scanForPlugins();
		String result1 = instance.doOCR(imgfile, new Rectangle(0, 0, w / 3, h / 2));
		result1 = result1.trim();
		String[] s = result1.split("" + c);
		String id = "";
		if(s.length > 0) {
			id = filterStr(s[0]);
		}
		//System.out.println(result1);
		//ImageIO.scanForPlugins();
		result1 = instance.doOCR(imgfile, new Rectangle(2 * w / 3, 0, w / 3, 350));
		//result1 = instance.doOCR(imgfile, new Rectangle(w / 2, 1585, 415, 234));
		System.out.println("date = " + result1);
		s = result1.trim().split("" + c);
		String dt = "";
		if(s.length > 0) {
			dt = filterStr1(s[0]).replaceAll("/", "-");
		}
		//ImageIO.scanForPlugins();
		result1 = instance.doOCR(imgfile, new Rectangle(2 * w / 3, h - 350, w / 3, 350));
		s = result1.trim().split("" + c);
		String lr = "";
		if(s.length > 0) {
			if("R".equals(s[0])) {
				lr = "R";
			} else {
				lr = "L";
			}
		}
		if(!"".equals(id) || !"".equals(dt) || !"".equals(lr)) {
			return id + "_" + dt + "_" + lr;
		}
		return "";
	}
	
    public static String imageUrl(String destUrl) throws Exception {
        
        Tesseract instance = new Tesseract();
        //instance.setTessVariable("user_defined_dpi", "300");
        //如果未将tessdata放在根目录下需要指定绝对路径
//        instance.setDatapath("tessdata");
 
        //如果需要识别英文之外的语种，需要指定识别语种，并且需要将对应的语言包放进项目中
        //instance.setLanguage("chi_sim");
        File imageFile = new File("E:\\兼职\\程伟靖\\需求4\\所有图片混在一个文件中\\tmp\\222.jpg");
        BufferedImage image = ImageIO.read(imageFile);
        //long startTime = System.currentTimeMillis();
        String result = instance.doOCR(image);
        System.out.println(result);
        return result;
    }
	
	public static void process() throws TesseractException {
		ITesseract instance = new Tesseract();
		String path = "E:\\兼职\\程伟靖\\需求4\\所有图片混在一个文件中\\tmp\\222.jpg";
		File imageFile = new File(path);
		String result1 = instance.doOCR(imageFile, new Rectangle(0, 0, 800, 800));
//		//System.out.println(result1.trim());
//		String[] s = result1.trim().split(" ");
//		System.out.println(s.length);
//		System.out.println(s[0] + " = " + s[0].length());
//		System.out.println();
//		System.out.println(s[1] + " = " + s[1].length());
//		System.out.println((int)s[1].charAt(9));
//		char c = s[1].charAt(9);
//		System.out.println(c - 'a');
		System.out.println(result1.trim());
		result1 = instance.doOCR(imageFile, new Rectangle(817, 0, 817, 817));
		System.out.println(result1.trim());
		char cc = (char)10;
		String[] ss = result1.trim().split("" + cc);
		System.out.println(ss.length + ", " + ss[0]);
		System.out.println(ss[1]);
		result1 = instance.doOCR(imageFile);
		instance.setLanguage("chi_sim");
		System.out.println(result1);
	}
	
	public static void main(String[] args) throws Exception {
		//imageUrl("");
		//process();
		
//		for(int i = 0; i < 3; i++) {
//			System.out.println(i);
//			test(i);
//		}
		String path = "E:\\兼职\\程伟靖\\需求4\\所有图片混在一个文件中\\tmp\\32.jpg";
		String s = tests(path);
		System.out.println(s);
		
		String dt = "sdf-=123";
		dt = dt.replaceAll("[a-zA-Z]", "");
		System.out.println(dt);
	}
	
	public static void test(int i) {
		try {
			int a = 10;
			int c = a / i;
			System.out.println(c);
		} catch(Exception e) {
			System.out.println("exception");
			e.printStackTrace();
		}
	}
}
