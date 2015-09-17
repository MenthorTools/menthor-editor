package net.menthor.ontouml2infouml.ui.tab;

import net.menthor.ontouml2infouml.decision.DecisionHandler;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import RefOntoUML.util.RefOntoUMLModelAbstraction;

public interface Tab
{
	public String getName();
	public Control getControl(Composite parent, RefOntoUMLModelAbstraction ma, final DecisionHandler dh);
}
