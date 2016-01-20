package net.menthor.antipattern.wizard;

import net.menthor.antipattern.application.AntipatternOccurrence;

public abstract class AntiPatternAction <T extends AntipatternOccurrence> {
	
	protected T ap;
	protected Enum<?> code;
	
	public abstract void run();	

	public AntiPatternAction(T ap)
	{
		this.ap = ap;
	}
	
	public T getAp()
	{
		return ap;
	}

	public Enum<?> getCode(){
		return code;
	}
}
