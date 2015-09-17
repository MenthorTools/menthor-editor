package net.menthor.ontouml2infouml.decision;

public class TimeDecision implements Decision
{
	private static final long serialVersionUID = -3355726825180675250L;
	
	public boolean start;
	public boolean end;
	public boolean duration;
	
	public TimeDecision()
	{
		start = true;
		end = true;
		duration = true;
	}
}
