package com.lyj.test.crawler4j;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

/**
 * @time:2018年2月27日下午5:21:01
 * @author:longyujia 
 * @emial: longyujia@knowlegene.com
 */

public class Crawler4j_Controller {
	
	public static void main(String[] args) throws Exception {
		
		String crawlStorageFolder = "/data/crawl/root"; //定义数据存储位置
		int num_crawlers = 7 ; //定义爬虫的个数，也就是线程的个数
		
		CrawlConfig config = new CrawlConfig(); //定义爬虫配置
		
		config.setCrawlStorageFolder(crawlStorageFolder); //设置爬虫文件存储的位置
		/*
	     * Be polite: Make sure that we don't send more than 1 request per
	     * second (1000 milliseconds between requests).
	     */
		config.setPolitenessDelay(1000);
		/*
	     * You can set the maximum crawl depth here. The default value is -1 for
	     * unlimited depth
	     */
		config.setMaxDepthOfCrawling(2);
		/*
	     * You can set the maximum number of pages to crawl. The default value
	     * is -1 for unlimited number of pages
	     */
		config.setMaxPagesToFetch(1000);
		/*
         * Do you want crawler4j to crawl also binary data ?
         * example: the contents of pdf, or the metadata of images etc
         */
		config.setIncludeBinaryContentInCrawling(false);
		/*
	     * This config parameter can be used to set your crawl to be resumable
	     * (meaning that you can resume the crawl from a previously
	     * interrupted/crashed crawl). Note: if you enable resuming feature and
	     * want to start a fresh crawl, you need to delete the contents of
	     * rootFolder manually.
	     */
		config.setResumableCrawling(false);
		
		/*
		 * 实例化爬虫控制器
		 */
		PageFetcher fetcher = new PageFetcher(config); //实例化页面获取器
		RobotstxtConfig config2 = new RobotstxtConfig(); //实例化爬虫机器人配置 比如可以设置user-agent
		
		//实例化爬虫机器人对目标服务器的配置，每个网站的robots.txt
		RobotstxtServer robotstxtServer = new RobotstxtServer(config2, fetcher);
		//实例化爬虫控制器
		CrawlController controller = new CrawlController(config, fetcher, robotstxtServer);
		
		
		/*
		 * 配置种子页面，可设置多个
		 */
		controller.addSeed("http://www.sgs.gov.cn/");
		controller.addSeed("http://www.sgs.gov.cn/notice/notice/view?uuid=EQY4QLgDKsfDot0MRYZdjw5P1IgqBGta&tab=01");
		
//		controller.addSeed("http://www.java1234.com/");
//        controller.addSeed("http://www.java1234.com/a/kaiyuan/");
//        controller.addSeed("http://www.java1234.com/a/bysj/");
		
		controller.start(Crawler4j_Test.class, num_crawlers);
		
		
	}
	
}
