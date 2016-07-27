package net.menthor.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class SWTTest {

	public static void main(String[] args){
		SWTConfigurer.execute("1.1.6");		
		helloworld();		
	}
	
	public static void helloworld(){
		//Display display = new Display ();
		Shell shell = new Shell(Display.getDefault());
		
		Text helloWorldTest = new Text(shell, SWT.NONE);
		helloWorldTest.setText("Hello World SWT");
		helloWorldTest.pack();
		
		shell.pack();
		shell.open ();
		while (!shell.isDisposed ()) {
			if (!Display.getDefault().readAndDispatch ()) Display.getDefault().sleep ();
		}
		Display.getDefault().dispose ();
	}
}
