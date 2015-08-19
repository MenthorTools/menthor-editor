package net.menthor.common.settings.als;

import net.menthor.common.transformation.AxiomsEnforcement;
import net.menthor.common.transformation.MappingsEnforcement;

public class ALS4TransformationOption {
	
	private ALS4Destination destination;
	private String outputAbsolutePath;
	private ALS4Approach mappingType;
	private AxiomsEnforcement axiomsEnforcement;
	private MappingsEnforcement mappingEnforcements;
	
	public ALS4Destination getDestination() { return destination; }
	public String getPath() { return outputAbsolutePath; }
	public ALS4Approach getMappingType() { return mappingType; }

	public ALS4TransformationOption(ALS4Approach mapping, ALS4Destination dest, String outputAbsolutePath){
		this.destination = dest;
		this.outputAbsolutePath = outputAbsolutePath;
		this.mappingType = mapping;
	}
	
	public void setAxiomsEnforcement(AxiomsEnforcement ae) { this.axiomsEnforcement = ae; }
	public AxiomsEnforcement getAxiomsEnforcement() { return axiomsEnforcement; }
	
	public void setMappingsEnforcement(MappingsEnforcement me) { this.mappingEnforcements = me; }
	public MappingsEnforcement getMappingsEnforcement() { return mappingEnforcements; }
	

}
