package com.lyj.test.uuid;

import java.util.Random;
import java.util.UUID;

/**
 * @time:2018年2月28日下午2:56:09
 * @author:longyujia 
 * @emial: longyujia@knowlegene.com
 */

public class UUID_Test {
	/**
	 * @time:2018年2月28日下午2:56:09
	 * @author:longyujia 
	 * @emial: longyujia@knowlegene.com
	 */
	
	public static void main(String[] args) {
		//http://www.sgs.gov.cn/notice/notice/view?uuid=EQY4QLgDKsfDot0MRYZdjw5P1IgqBGta&tab=01
		//http://www.sgs.gov.cn/notice/notice/view?uuid=mS4bNUXI170Wl92wmXHBxZwpBTMhJR8W&tab=01
		//EQY4QLgDKsfDot0MRYZdjw5P1IgqBGta
		//c183d46de2084f6b9603476ad9255719
//		UUID uuid = UUID.randomUUID();
//		System.out.println(uuid.toString().replaceAll("-", "").toUpperCase());
		
		/**
		 * 可以生成随机大小写的32位随机字符串
		 */
		char strAll[] = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		StringBuilder builder = new StringBuilder();
		Random random = new Random();
		builder.append("http://www.sgs.gov.cn/notice/notice/view?uuid=");
		for (int i = 0; i < 32; i++){
			builder.append(strAll[random.nextInt(strAll.length)]);
		}
		builder.append("&tab=01");
		System.out.println(builder.toString());
		
		
		
	}
	
}
