package net.menthor.webcrawler;

/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.IOException;
import java.util.regex.Pattern;

import org.apache.commons.io.FilenameUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.url.WebURL;

/**
 * @author Yasser Ganjisaffar
 * @author John Guerson
 */
public class SingleCrawler extends WebCrawler {

	private static final Pattern OTHER_FILES = Pattern.compile(".*(\\.(css|js|mid|mp2|mp3|mp4|wav|avi|mov|mpeg|ram|m4v" + "|rm|smil|wmv|swf|wma|zip|rar|gz))$");
	private static final Pattern IMAGE_FILES = Pattern.compile(".*(\\.(bmp|gif|jpe?g|png|tiff?))$");
   
	public static String acceptUrlStartingWith = new String();
	public static String outputDirectory = new String();
	public static String extension = new String();
  
	/**
	 * You should implement this function to specify whether the given url
	 * should be crawled or not (based on your crawling logic).
	 */
	@Override
	public boolean shouldVisit(Page referringPage, WebURL url) {
		String href = url.getURL().toLowerCase();    
		if (IMAGE_FILES.matcher(href).matches() && OTHER_FILES.matcher(href).matches()) {
			return false;
		}    
		return href.startsWith(acceptUrlStartingWith) && !href.contains("page&print");
	}
	
	/**
	 * This function is called when a page is fetched and ready to be processed
	 * by your program.
	 */
	@Override
	public void visit(Page page) {
		String url = page.getWebURL().getURL();
		logger.info("URL: {}", url);		      
		try{
			Document doc = Jsoup.connect(url).ignoreContentType(true).get();			
			Elements slinks = doc.select("a[href]");
			Elements medias = doc.select("[src]");
			Elements imports = doc.select("link[href]");
			for (Element src : medias) {
				final String srcUrl = src.attr("src");				
				download(srcUrl);
			}
			for (Element src : slinks) {
				final String ahefUrl = src.attr("a[href]");								
				download(ahefUrl);
			}
			for (Element src : imports) {
				final String lhefUrl = src.attr("link[href]");								    
				download(lhefUrl)	;	
			}
		}catch(java.net.SocketTimeoutException e){
			logger.info("Connection Timed Out: "+url);
		}catch (IOException e){
			e.printStackTrace();
		}		
	}  
	
	//=============================================
	
	private void download(final String srcUrl){
		final String baseName = FilenameUtils.getBaseName(srcUrl);
		if (srcUrl.contains(extension)){					
			Thread t = new Thread(new Runnable() {						
				@Override
				public void run() {
					try {
						Util.downloadFileFromURL(srcUrl, outputDirectory+"\\",Util.replaceInvalidCharacteres(baseName)+extension);
					} catch (IOException e) {
						e.printStackTrace();
					}		
				}
			});
			t.start();
		}
	}
}