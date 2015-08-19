package net.menthor.common.transformation;

import net.menthor.common.settings.owl.OWL2Approach;
import net.menthor.common.settings.owl.OWL2Destination;

public class TransformationOption {

	private OWL2Destination destination;
	private String outputAbsolutePath;
	private OWL2Approach mappingType;
	private AxiomsEnforcement axiomsEnforcement;
	private MappingsEnforcement mappingEnforcements;
	
	public OWL2Destination getDestination() { return destination; }
	public String getPath() { return outputAbsolutePath; }
	public OWL2Approach getMappingType() { return mappingType; }

	public TransformationOption(OWL2Approach mapping, OWL2Destination dest, String outputAbsolutePath){
		this.destination = dest;
		this.outputAbsolutePath = outputAbsolutePath;
		this.mappingType = mapping;
	}
	
	public void setAxiomsEnforcement(AxiomsEnforcement ae) { this.axiomsEnforcement = ae; }
	public AxiomsEnforcement getAxiomsEnforcement() { return axiomsEnforcement; }
	
	public void setMappingsEnforcement(MappingsEnforcement me) { this.mappingEnforcements = me; }
	public MappingsEnforcement getMappingsEnforcement() { return mappingEnforcements; }
}
