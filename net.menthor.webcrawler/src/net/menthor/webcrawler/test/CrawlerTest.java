package net.menthor.webcrawler.test;

import net.menthor.webcrawler.PDFCrawlerService;

public class CrawlerTest {
	
	//=============================================================
  	//TESTS
  	//=============================================================
	
  	public static void main(String[] args) throws Exception {	  
  		
  		/** Seems to be okay... */
  		crawlBrasilSus("C:\\Users\\Guerson\\Documents\\BRASIL_SUS"); 
  		
  		/** Not done yet... 
  		 *  Urls haven't the extension ".pdf". They are simply links to automatic file download. 
  		 *  I'm not sure how to approach this yet.
  		 */
  		//crawlSaudeCeGov("C:\\Users\\Guerson\\Documents\\SAUDE_CE");   		
  	}
  
  	//=============================================================
  	//BRASILSUS.COM.BR
  	//=============================================================
  	
  	public static void crawlBrasilSus(String outputDirectory){
	  	String baseurl = "http://www.brasilsus.com.br/index.php/legislacoes"; //only accept pages with this base url and start looking here 	 	
	  	String fileExtension = ".pdf";	  	  		
  		try{  			
  			/** Execute PDF Crawler */
  			PDFCrawlerService.execute(baseurl, outputDirectory, fileExtension, 6);  			
  		}catch(Exception e){
  			e.printStackTrace();
  		}
  	}
  	
	//=============================================================
  	//SAUDE.CE.GOV.BR
  	//=============================================================
  	
  	public static void crawlSaudeCeGov(String outputDirectory){
  		String baseurl = "http://www.saude.ce.gov.br/index.php/downloads/"; //only accept pages with this base url
  		String seedUrl = "http://www.saude.ce.gov.br/index.php/downloads/section/5-cib"; //start looking here
  		String fileExtension = ".pdf";  		  		
  		try{  			
  			/** Execute PDF Crawler */
  			PDFCrawlerService.execute(baseurl, seedUrl, outputDirectory, fileExtension, 6);  			
  		}catch(Exception e){
  			e.printStackTrace();
  		}
  	}
}
