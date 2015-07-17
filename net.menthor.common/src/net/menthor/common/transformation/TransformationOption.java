package net.menthor.common.transformation;

public class TransformationOption {

	private DestinationEnum destination;
	private String outputAbsolutePath;
	private MappingType mappingType;
	private AxiomsEnforcement axiomsEnforcement;
	private MappingsEnforcement mappingEnforcements;
	
	public DestinationEnum getDestination() { return destination; }
	public String getPath() { return outputAbsolutePath; }
	public MappingType getMappingType() { return mappingType; }

	public TransformationOption(MappingType mapping, DestinationEnum dest, String outputAbsolutePath){
		this.destination = dest;
		this.outputAbsolutePath = outputAbsolutePath;
		this.mappingType = mapping;
	}
	
	public void setAxiomsEnforcement(AxiomsEnforcement ae) { this.axiomsEnforcement = ae; }
	public AxiomsEnforcement getAxiomsEnforcement() { return axiomsEnforcement; }
	
	public void setMappingsEnforcement(MappingsEnforcement me) { this.mappingEnforcements = me; }
	public MappingsEnforcement getMappingsEnforcement() { return mappingEnforcements; }
}
