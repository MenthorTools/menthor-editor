package net.menthor.editor.transformation;

public class TransformationOption {

	private DestinationEnum dest;
	private String outputAbsolutePath;
	private MappingType mapping;
	
	public DestinationEnum getDestination() { return dest; }
	public String getPath() { return outputAbsolutePath; }
	public MappingType getMappingType() { return mapping; }

	public TransformationOption(MappingType mapping, DestinationEnum dest, String outputAbsolutePath){
		this.dest = dest;
		this.outputAbsolutePath = outputAbsolutePath;
		this.mapping = mapping;
	}
}
