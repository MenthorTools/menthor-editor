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
import java.util.Set;
import java.util.regex.Pattern;

import org.apache.commons.io.FilenameUtils;
import org.apache.http.Header;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
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
		return href.startsWith(acceptUrlStartingWith);
	}

	/**
	 * This function is called when a page is fetched and ready to be processed
	 * by your program.
	 */
	@Override
	public void visit(Page page) {
		int docid = page.getWebURL().getDocid();
		String url = page.getWebURL().getURL();
		String domain = page.getWebURL().getDomain();
		String path = page.getWebURL().getPath();
		String subDomain = page.getWebURL().getSubDomain();
		String parentUrl = page.getWebURL().getParentUrl();
		String anchor = page.getWebURL().getAnchor();
		logger.debug("Docid: {}", docid);
		logger.info("URL: {}", url);
		logger.debug("Domain: '{}'", domain);
		logger.debug("Sub-domain: '{}'", subDomain);
		logger.debug("Path: '{}'", path);
		logger.debug("Parent page: {}", parentUrl);
		logger.debug("Anchor text: {}", anchor);    
		if (page.getParseData() instanceof HtmlParseData) {
			HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
			String text = htmlParseData.getText();
			String html = htmlParseData.getHtml();
			Set<WebURL> links = htmlParseData.getOutgoingUrls();      
			try{
				Document doc = Jsoup.connect(url).get();
				Elements slinks = doc.select("a[href]");
				Elements medias = doc.select("[src]");
				Elements imports = doc.select("link[href]");
				for (Element src : medias) {
					String srcUrl = src.attr("src");
					String baseName = FilenameUtils.getBaseName(srcUrl);				    
					if (srcUrl.contains(extension)){
						Util.downloadFileFromURL(srcUrl, outputDirectory+"\\"+Util.replaceInvalidCharacteres(baseName)+extension);
					}
				}
				for (Element src : slinks) {
					String ahefUrl = src.attr("a[href]");
					String baseName = FilenameUtils.getBaseName(ahefUrl);				    
					if (ahefUrl.contains(extension)){
						Util.downloadFileFromURL(ahefUrl, outputDirectory+"\\"+Util.replaceInvalidCharacteres(baseName)+extension);
					}
				}
				for (Element src : imports) {
					String lhefUrl = src.attr("link[href]");
					String baseName = FilenameUtils.getBaseName(lhefUrl);				    
					if (lhefUrl.contains(extension)){
						Util.downloadFileFromURL(lhefUrl, outputDirectory+"\\"+Util.replaceInvalidCharacteres(baseName)+extension);
					}
				}
			}catch (IOException e){
				e.printStackTrace();
			}      
			logger.debug("Text length: {}", text.length());
			logger.debug("Html length: {}", html.length()); 
			logger.debug("Number of outgoing links: {}", links.size());
		}
		Header[] responseHeaders = page.getFetchResponseHeaders();
		if(responseHeaders != null) {
			logger.debug("Response headers:");
			for(Header header : responseHeaders) {
				logger.debug("\t{}: {}", header.getName(), header.getValue());
			}
		}
		logger.debug("=============");
	}  
}