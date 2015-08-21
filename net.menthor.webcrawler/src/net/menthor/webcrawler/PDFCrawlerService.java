package net.menthor.webcrawler;

public class PDFCrawlerService {

	public static void execute(String url, String outputDirectory, String fileExtension, int numberOfCrawlers) throws Exception{
  		SingleCrawler.acceptUrlStartingWith = url;
  		SingleCrawler.extension = fileExtension;
  		SingleCrawler.outputDirectory = outputDirectory;
  		String[] seedsUrls = new String[]{
  			url
  		};  		
		CrawlerService.execute(
			SingleCrawler.class, 
			outputDirectory, 
			numberOfCrawlers, 
			seedsUrls
		);  		
  	}
}
