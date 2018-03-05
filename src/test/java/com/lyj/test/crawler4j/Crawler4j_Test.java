package com.lyj.test.crawler4j;

import java.util.Set;
import java.util.regex.Pattern;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

/**
 * @time:2018年2月27日下午4:58:59
 * @author:longyujia 
 * @emial: longyujia@knowlegene.com
 */

public class Crawler4j_Test extends WebCrawler {

	/*
	 * 匹配指定的后缀文件
	 */
	private static final Pattern IMAGE_EXTENSIONS = Pattern.compile(".*\\.(bmp|gif|jpg|png)$");
	private final static Pattern FILETERS = Pattern.compile(".*(\\.(css|js|gif|jpg"
                                                           + "|png|mp3|mp3|zip|gz))$");
	
	
	@Override
	public boolean shouldVisit(Page referringPage, WebURL url) {
		
		String href = url.getURL().toLowerCase();//获取小写的url
		
		if (IMAGE_EXTENSIONS.matcher(href).matches()) {
            return false;
        }
		
//		return !FILETERS.matcher(href).matches() //正则表达式匹配去掉我们不需要的文件 
//				&& href.startsWith("http://www.cnblogs.com/"); //url必须是""里开头的，规定站点
//		return href.startsWith("http://www.ics.uci.edu/");
//		return href.startsWith("http://www.sgs.gov.cn/notice/notice/view?uuid=EQY4QLgDKsfDot0MRYZdjw5P1IgqBGta&tab=01");
		return href.startsWith("http://www.sgs.gov.cn/");
	}

	/*
	 * Page封装了所有页面的信息
	 * 
	 * (non-Javadoc)
	 * @see edu.uci.ics.crawler4j.crawler.WebCrawler#visit(edu.uci.ics.crawler4j.crawler.Page)
	 */
	@Override
	public void visit(Page page) {
		
		int docid = page.getWebURL().getDocid();
		String url = page.getWebURL().getURL(); // 获取url
		System.out.println("get page url:" + url);
		
		if(page.getParseData() instanceof HtmlParseData){ //判断是否是html 数据
			/*HtmlParseData data = (HtmlParseData) page.getParseData();
			System.out.println("get page title:" + data.getTitle());
			System.out.println("get page text:" + data.getText());
		}else {
			System.out.println("---》page :" + page.getParseData());*/
			HtmlParseData htmlParseData = (HtmlParseData) page.getParseData(); // 强制类型转换，获取html数据对象
			String title = htmlParseData.getTitle();//获取title
            String text = htmlParseData.getText();  // 获取页面纯文本（无html标签）
            String html = htmlParseData.getHtml();  // 获取页面Html
            Set<WebURL> links = htmlParseData.getOutgoingUrls();  // 获取页面输出链接

            System.out.println("docid："+docid);
            System.out.println("title：" + title );
            System.out.println("纯文本长度: " + text.length());
            System.out.println("html长度: " + html.length());
            System.out.println("输出链接个数: " + links.size());
            for(WebURL link_url : links){
            	System.out.println("---"+link_url);
            }
//            System.out.println("文本："+text.substring(0, 300));
		}
		
	}
	
	
	
	
}
