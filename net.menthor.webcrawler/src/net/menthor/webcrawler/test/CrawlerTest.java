package net.menthor.webcrawler.test;

import net.menthor.webcrawler.PDFCrawlerService;

public class CrawlerTest {
	
	//=============================================================
	//TEST
	//=============================================================
	
  	public static void main(String[] args) throws Exception {	  
  		
  		String url = "http://www.brasilsus.com.br/index.php/legislacoes";
  		String fileExtension = ".pdf";
  		String outputDirectory = "C:\\Users\\Guerson\\Documents\\BRASIL_SUS";
  		
  		try{
  			
  			/** Execute PDF Crawler */
  			PDFCrawlerService.execute(url, outputDirectory, fileExtension, 1);
  			
  		}catch(Exception e){
  			e.printStackTrace();
  		}
  	}
  	
  	
}
