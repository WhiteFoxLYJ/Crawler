package com.lyj.test.webmagic;

import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @time:2018年2月27日下午3:07:39
 * @author:longyujia 
 * @emial: longyujia@knowlegene.com
 */

public class WebMagic_Test implements PageProcessor {

	//抓取重试次数，时间间隔，编码等
	private Site site = Site.me().setRetryTimes(3).setSleepTime(100);
	
	private static int count = 0;
	
	public Site getSite() {
		
		// TODO Auto-generated method stub
		/**
		 * @time:2018年2月27日下午3:08:39
		 * @author:longyujia 
		 * @emial: longyujia@knowlegene.com
		 */
		
		return site;
	}

	public void process(Page page) {
		// TODO Auto-generated method stub
		/**
		 * @time:2018年2月27日下午3:08:39
		 * @author:longyujia 
		 * @emial: longyujia@knowlegene.com
		 */
		
		if(!page.getUrl().regex("http://www.cnblogs.com/[a-z 0-9 -]+/p/[0-9]{7}.html").match()){
			page.addTargetRequests(
						page.getHtml().xpath("//*[@id=\"post_list\"]/div/div[@class='post_item_body']/h3/a/@href").all()
					);
			System.out.println(page.getHtml().xpath("//*[@id='post_list']/div[1]/div[2]/h3/text()").get());
		}else{
			System.out.println(
					
					"Get the content:"+
//					page.getHtml().xpath("//*[@class=\"postTitle\"]/text()").get()
					page.getHtml().xpath("//html/head/title/text()").get()
					);
			count++;
		}
		/*List<String> links = page.getHtml().links().regex("http://my\\.oschina\\.net/flashsword/blog/\\d+").all();
		System.out.println(links);
		page.addTargetRequests(links);
        page.putField("title", page.getHtml().xpath("//div[@class='BlogEntity']/div[@class='BlogTitle']/h1").toString());
        page.putField("content", page.getHtml().$("div.content").toString());
        page.putField("tags",page.getHtml().xpath("//div[@class='BlogTags']/a/text()").all());*/
        
	}
	
	public static void main(String[] args) {
		
		long startTime,endTime;
		System.out.println("BEGIN...");
		startTime = System.currentTimeMillis();
		Spider.create(new WebMagic_Test()).addUrl("https://www.cnblogs.com/").thread(5).run();
//		Spider.create(new WebMagic_Test()).run();
		endTime = System.currentTimeMillis();
		System.out.println("END，耗时约" + ((endTime - startTime) / 1000) + "秒，抓取了"+count+"条记录");
		
	}
	
}
