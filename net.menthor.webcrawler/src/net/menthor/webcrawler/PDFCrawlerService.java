package net.menthor.webcrawler;

public class PDFCrawlerService {

	public static void execute(String baseUrl, String seedUrl, String outputDirectory, String fileExtension, int numberOfCrawlers) throws Exception{
  		SingleCrawler.acceptUrlStartingWith = baseUrl;
  		SingleCrawler.extension = fileExtension;
  		SingleCrawler.outputDirectory = outputDirectory;  		 		
		CrawlerService.execute(
			SingleCrawler.class, 
			outputDirectory, 
			numberOfCrawlers, 
			new String[]{seedUrl}
		);  		
  	}
	
	public static void execute(String baseUrl, String outputDirectory, String fileExtension, int numberOfCrawlers) throws Exception{
  		SingleCrawler.acceptUrlStartingWith = baseUrl;
  		SingleCrawler.extension = fileExtension;
  		SingleCrawler.outputDirectory = outputDirectory;  		 		
		CrawlerService.execute(
			SingleCrawler.class, 
			outputDirectory, 
			numberOfCrawlers, 
			new String[]{baseUrl}
		);  		
  	}
}
