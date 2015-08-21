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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Set;
import java.util.regex.Pattern;

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
 */
public class MyCrawler extends WebCrawler {

  private static final Pattern OTHER_FILES = Pattern.compile(".*(\\.(css|js|mid|mp2|mp3|mp4|wav|avi|mov|mpeg|ram|m4v" + "|rm|smil|wmv|swf|wma|zip|rar|gz))$");
  private static final Pattern IMAGE_FILES = Pattern.compile(".*(\\.(bmp|gif|jpe?g|png|tiff?))$");
   
  private static String acceptOnly = "http://www.brasilsus.com.br/";
  private static String extension = ".pdf";
  private static String dir = "C:\\Users\\Guerson\\Documents\\";
  
  /**
   * You should implement this function to specify whether the given url
   * should be crawled or not (based on your crawling logic).
   */
  @Override
  public boolean shouldVisit(Page referringPage, WebURL url) {
    String href = url.getURL().toLowerCase();
    
    // Ignore the url if it has an extension that matches our defined set of image extensions.
    if (IMAGE_FILES.matcher(href).matches() && OTHER_FILES.matcher(href).matches()) {
      return false;
    }
    
    // Only accept the url if it is in the "http://www.brasilsus.com.br/" domain and protocol is "http".
    return href.startsWith(acceptOnly);
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
	    	  if (src.attr("src").contains(extension)){
	    		  downloadFileFromURL(src.attr("src"), dir+htmlParseData.getTitle()+extension);
	    	  }
	      }
	      for (Element src : slinks) {
	    	  if (src.attr("a[href]").contains(extension)){
	    		  downloadFileFromURL(src.attr("a[href]"), dir+htmlParseData.getTitle()+extension);
	    	  }
	      }
	      for (Element src : imports) {
	    	  if (src.attr("link[href]").contains(extension)){
	    		  downloadFileFromURL(src.attr("a[href]"), dir+htmlParseData.getTitle()+extension);
	    	  }
	      }
    	} catch (IOException e) {
    	  e.printStackTrace();
    	}
      
    	logger.debug("Text length: {}", text.length());
      	logger.debug("Html length: {}", html.length()); 
      	logger.debug("Number of outgoing links: {}", links.size());
    }

    Header[] responseHeaders = page.getFetchResponseHeaders();
    if (responseHeaders != null) {
      logger.debug("Response headers:");
      for (Header header : responseHeaders) {
        logger.debug("\t{}: {}", header.getName(), header.getValue());
      }
    }

    logger.debug("=============");
  }
  
  private void downloadFileFromURL(String url, String path) throws IOException{
	  URL url2 = new URL(url);
	  InputStream in = url2.openStream();
	  FileOutputStream fos = new FileOutputStream(new File(path));
	  System.out.println("Reading "+url);
	  int length = -1;
	  byte[] buffer = new byte[1024];// buffer for portion of data from
	                                  // connection
	  while ((length = in.read(buffer)) > -1) {
	      fos.write(buffer, 0, length);
	  }
	  fos.close();
	  in.close();
	  System.out.println("File downloaded.");
  }
}