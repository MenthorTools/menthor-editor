package net.menthor.common.transformation;

public enum DestinationEnum {
	APP, /** open the result by calling another application */
	TAB, /** visualize the result in an embedded text editor (a new tab in the current application) */
	FILE /** write the result in a file */
}
