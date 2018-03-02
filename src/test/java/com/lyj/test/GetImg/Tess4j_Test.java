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
		
//		String result = iTesseract.doOCR(file);
//		System.out.println("识别结果:"+result);
		
		
		StringBuilder builder = new StringBuilder();
		for(int i = 0 ; i < 6 ; i+=2){
			file = new File("C:/Users/Administrator/Pictures/文字识别/tmp/train/temp_"+i+".jpg");
			builder.append(iTesseract.doOCR(file));
		}
//		File file2 = new File("C:/Users/Administrator/Pictures/文字识别/tmp/train/temp_4.jpg");
//		String res = iTesseract.doOCR(file2);
//		System.out.println(res);
		System.out.println("识别结果:"+builder.toString().replaceAll("\n|\r| ", ""));
		
		
		/*
		 * 用于比对验证码中的信息
		 */
		int[] shuzi = {1,2,3,4,5,6,7,8,9,0};
		String[] chi = {"一","二","三","四","五","六","七","八","九","十","零"};
		String[] chi_f = {"壹","贰","叄","肆","伍 ","陆","柒","捌","玖","拾","零"};
		String[] fuhao = {"加","减","乘","除","+","-","×","÷"};
		
		
	}
	
}
