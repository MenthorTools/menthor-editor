package net.menthor.editor.v2.util;

import java.awt.Component;
import java.io.File;

public abstract class FileReader extends FileHandler {

	protected boolean canRead(Component component, File file) {		
		return true;
	}
}
