package com.lyj.test.GetImg;

import java.io.File;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

/**
 * @time:2018年3月1日下午4:17:48
 * @author:longyujia 
 * @emial: longyujia@knowlegene.com
 */

public class Tess4j_Test {
	
	
	public static void main(String[] args) throws TesseractException {
		String path = "C:/Users/Administrator/Pictures/文字识别/tmp/CheckCodeYunSuan.jpg";
		String path_2 = "C:/Users/Administrator/Pictures/文字识别/convert_im.jpg";
		String path_3 = "C:/Users/Administrator/Pictures/文字识别/captcha.bmp";
		
		File file = new File(path_3);
		ITesseract iTesseract = new Tesseract();
		
		iTesseract.setLanguage("chi_sim");           
//		iTesseract.setLanguage("eng");
//		iTesseract.setDatapath("E:\\ZY_WorkSpace\\Crawler\\tessdata");
		iTesseract.setDatapath("./tessdata");
		
		String result = iTesseract.doOCR(file);
		System.out.println("识别结果:"+result);
		
		
	}
	
}
