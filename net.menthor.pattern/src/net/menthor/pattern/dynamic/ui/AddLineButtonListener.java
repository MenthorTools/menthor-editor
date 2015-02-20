package net.menthor.pattern.dynamic.ui;

import net.menthor.pattern.ui.manager.DynamicManagerWindow;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

public class AddLineButtonListener implements SelectionListener {

	DynamicManagerWindow dym;
	String className;
	String[] stereotypes;
	String dataValue;
	
	public AddLineButtonListener(DynamicManagerWindow d, String dataValue, String className, String[] stereotypes) {
		dym = d;
		this.className = className;
		this.stereotypes = stereotypes;
		this.dataValue = dataValue;
	}
	
	@Override
	public void widgetDefaultSelected(SelectionEvent arg0) {
		widgetSelected(arg0);
	}

	@Override
	public void widgetSelected(SelectionEvent arg0) {
		dym.addTableLine(dataValue, className, stereotypes);
	}

}
