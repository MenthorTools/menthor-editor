package net.menthor.editor;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class SplashScreen extends JFrame {

 private JLabel statusLabel = new JLabel("Loading");
 private JLabel versionLabel;

 public SplashScreen(String MENTHOR_VERSION, String MENTHOR_COMPILATION_DATE) {
	 versionLabel = new JLabel("Version "+MENTHOR_VERSION+" ( "+MENTHOR_COMPILATION_DATE+" )");
	
	 
  setLayout(new GridBagLayout());

  statusLabel.setFont(new Font(Font.SERIF, Font.BOLD, 11));
  versionLabel.setFont(new Font(Font.SERIF, Font.BOLD, 11));
  
  GridBagConstraints gc = new GridBagConstraints();

  gc.fill = GridBagConstraints.NONE;

  setSize(600, 315);
  
  gc.gridx = 0;
  gc.weightx = 1;
  gc.gridy = 1;
  gc.weighty = 1;
  add(statusLabel, gc);
  gc.gridx = 1;
  gc.weightx = 10;
  gc.gridy = 1;
  gc.weighty = 10;
  add(versionLabel, gc);
  
  
  //setDefaultCloseOperation(EXIT_ON_CLOSE);
  setLocationRelativeTo(null);
  setVisible(true);
 }

 private void runInEdt(final Runnable runnable) {
    if (SwingUtilities.isEventDispatchThread())
        runnable.run();
    else
        SwingUtilities.invokeLater(runnable);
}
 
 public void close() {
	    runInEdt(new Runnable() {
	        public void run() {
	            setVisible(false);
	            dispose();
	        }
	    });
	}
 
 private void start() {
	 SwingWorker<Boolean, Integer> worker = new SwingWorker<Boolean, Integer>() {
		 @Override
		 protected Boolean doInBackground() throws Exception {
		  // Simulate doing something useful.
		  for (int i = 0; i <= 10; i++) {
		   Thread.sleep(1000);

		   // The type we pass to publish() is determined
		   // by the second template parameter.
		   publish(i);
		  }

		  // Here we can return some object of whatever type
		  // we specified for the first template parameter.
		  // (in this case we're auto-boxing 'true').
		  return true;
		 }

		 // Can safely update the GUI from this method.
		 protected void done() {

		  boolean status;
		  try {
		   // Retrieve the return value of doInBackground.
		   status = get();
		   statusLabel.setText("Completed with status: " + status);
		  } catch (InterruptedException e) {
		   // This is thrown if the thread's interrupted.
		  } catch (ExecutionException e) {
		   // This is thrown if we throw an exception
		   // from doInBackground.
		  }
		 }

		 @Override
		 // Can safely update the GUI from this method.
		 protected void process(List<Integer> chunks) {
		  // Here we receive the values that we publish().
		  // They may come grouped in chunks.
		  int mostRecentValue = chunks.get(chunks.size()-1);

		  statusLabel.setText(Integer.toString(mostRecentValue));
		 }

		};

		worker.execute();
 }
//
// public static void main(String[] args) {
//  SwingUtilities.invokeLater(new Runnable() {
//
//   @Override
//   public void run() {
//    new SplashScreen("SwingWorker Demo");
//   }
//  });
// }
 
 public void setStatusLabel(String status) {
		this.statusLabel.setText(status);
	}
}