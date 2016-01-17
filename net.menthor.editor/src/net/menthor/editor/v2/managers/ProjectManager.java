package net.menthor.editor.v2.managers;

import net.menthor.editor.ui.DiagramManager;
import net.menthor.editor.ui.ProjectBrowser;

public class ProjectManager {

	public static ProjectBrowser browser;
	public static DiagramManager diagramManager;
	
	public static void setup(DiagramManager mg, ProjectBrowser pb){
		browser = pb;
		diagramManager = mg;
	}
}
