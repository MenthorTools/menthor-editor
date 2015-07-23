package net.menthor.ontouml2infouml.decision;

public class HistoryDecision implements Decision
{
	private static final long serialVersionUID = -582351433775987751L;
	
	public boolean past;
	public boolean present;
	
	public HistoryDecision()
	{
		past = true;
		present = true;
	}
	
	public boolean requiresAttribute ()
	{
		return past && present;
	}
}
