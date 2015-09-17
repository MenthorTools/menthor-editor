package net.menthor.ontouml2infouml.impl;

public class Log
{
	// Number of additions in one transformation operation
	private static int numAdditions;
	// Number of removals in one transformation operation
	private static int numRemovals;
	
	public Log()
	{
		reset();
	}
	
	public static void reset()
	{
		// Initialize additions and removals made so far
		numAdditions = 0;
		numRemovals = 0;
	}
	
	public static void addition()
	{
		numAdditions++;
	}
	
	public static void removal()
	{
		numRemovals++;
	}
	
	public static String message ()
	{
		String extraText = "";
		
		extraText += " (";
		
		if (numAdditions == 0 && numRemovals == 0)
		{
			extraText += "no changes";
		}
		else
		{
			if (numAdditions != 0)
			{
				extraText += numAdditions + " addition" + (numAdditions == 1 ? "" : "s");
				if (numRemovals != 0)
					extraText += ", ";
			}
			if (numRemovals != 0)
				extraText += numRemovals + " removal" + (numRemovals == 1 ? "" : "s");
		}
		
		extraText += ")";
		
		return extraText;
	}
}
