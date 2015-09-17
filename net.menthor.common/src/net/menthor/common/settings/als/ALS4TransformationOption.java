package net.menthor.common.settings.als;


public class ALS4TransformationOption {
	
	private ALS4Destination destination;
	private String outputAbsolutePath;
	private ALS4Approach mappingType;
	
	
	public ALS4Destination getDestination() { return destination; }
	public String getPath() { return outputAbsolutePath; }
	public ALS4Approach getMappingType() { return mappingType; }

	public ALS4TransformationOption(ALS4Approach mapping, ALS4Destination dest, String outputAbsolutePath){
		this.destination = dest;
		this.outputAbsolutePath = outputAbsolutePath;
		this.mappingType = mapping;
	}
}
