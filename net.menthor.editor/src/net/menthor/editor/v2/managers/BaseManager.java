package net.menthor.editor.v2.managers;

import org.tinyuml.umldraw.shared.DiagramElementFactoryImpl;

import net.menthor.editor.ui.DiagramManager;
import net.menthor.editor.ui.InfoManager;
import net.menthor.editor.ui.ProjectBrowser;

public class BaseManager {

	private static BaseManager instance = new BaseManager();
	public static BaseManager get() { return instance; }
		
	protected ProjectBrowser browser;
	protected DiagramManager diagramManager;
	protected DiagramElementFactoryImpl factory;
	protected InfoManager infoManager;
	
	public void setup(DiagramManager mg, ProjectBrowser pb, InfoManager im){
		browser = pb;
		diagramManager = mg;
		factory = mg.getElementFactory();
		infoManager = im;
	}
}
