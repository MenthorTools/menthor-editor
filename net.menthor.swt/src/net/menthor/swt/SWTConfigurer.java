package net.menthor.swt;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;

public class SWTConfigurer {
				
	public static void execute(File tempdir, String menthorVersion){
		try{	
			loadSwt(menthorVersion);		
			extractTo(tempdir);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/** Add and load the appropriate SWT jar to the classpath according to the operating system. */
	private static void loadSwt(String menthorVersion) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		final URL[] urls = new URL[1];
		URL swtJarURL = addSwtToClasspath(menthorVersion);
        urls[0] = swtJarURL;
        if(Util.onMac()){
	        com.apple.concurrent.Dispatch.getInstance().getNonBlockingMainQueueExecutor().execute( new Runnable(){        	
				@Override
				public void run() {
					try { loadSwtJar(urls); } catch (Exception e) { e.printStackTrace(); }
				}
			});        
        }else{
        	try { loadSwtJar(urls); } catch (Exception e) { e.printStackTrace(); }
        }
	}
	
	/** Load the SWT binaries (*.dlls, *.jnilib, *.so) according to the appropriate Operating System.  
	 * @throws IOException */
	private static void extractTo(File dir) throws LoadingException, URISyntaxException, IOException{
		BinaryLoader.load(dir);
	}
	
	/** Add the correct SWT Jar to the classpath according to the Operating System*/
	private static URL addSwtToClasspath(String menthorVersion) 
	{
		String swtFileName = "<empty>";
	    try {	    	
	        swtFileName = Util.getSwtFileName();	        	        	        
	        URLClassLoader classLoader = (URLClassLoader) SWTConfigurer.class.getClassLoader();
	        Method addUrlMethod = URLClassLoader.class.getDeclaredMethod ("addURL", URL.class);
	        addUrlMethod.setAccessible (true);	        	        
	        URL swtFileUrl = null;
	        try{
	        	swtFileUrl = new URL("rsrc:"+swtFileName);
	        }catch(MalformedURLException e){
	        	String workingDir = getSwtWorkingDir();
	        	if(workingDir.lastIndexOf("\\") < workingDir.lastIndexOf(".")){
        			int lastBar = workingDir.lastIndexOf("/");
        			workingDir = workingDir.substring(0, lastBar+1);
        		}	        	
	        	File file = new File(workingDir.concat(swtFileName));
	        	if(!file.exists()) { 
	        		// check subfolder "/menthor-x.x.x_lib" first	        		
	        		workingDir = workingDir.concat("\\menthor-"+menthorVersion+"_lib\\");
	        		file = new File(workingDir.concat(swtFileName));
	        		if(!file.exists()){
		        		//extract swtFile jar to "/menthor-x.x.x_lib"	        		
		        		Util.extract(swtFileName, new File(workingDir));
		        		file = new File(workingDir.concat(swtFileName));
		        	}
	        	}	        	
	        	swtFileUrl = file.toURI().toURL();
	        	if (!file.exists ()) System.err.println("Can't locate SWT Jar File" + file.getAbsolutePath());
	    	}	    	
	        System.out.println("Adding to classpath: " + swtFileUrl);            
            addUrlMethod.invoke (classLoader, swtFileUrl);            
            return swtFileUrl;
	    }catch(Exception e) {
	        System.err.println("Unable to add the swt jar to the class path: "+swtFileName);
	        e.printStackTrace();
	    }	    
	    return null;
	}

	/** SWT working directory. 
	 *  At runtime this is the jar's directory, otherwise if at development in eclipse this is the path of the swt library folder. */
	private static String getSwtWorkingDir()
	{
		String dir = System.getProperty("user.dir");
		if (dir.contains("net.menthor.editor")) dir = dir.replace("net.menthor.editor","net.menthor.swt").concat(File.separator).concat("src"+File.separator);			
		else dir = SWTConfigurer.class.getProtectionDomain().getCodeSource().getLocation().getPath();	
		return dir;
	}
	
	/** Load the correct SWT Jar to the classpath according to the OS */
	@SuppressWarnings({ "unchecked", "unused", "rawtypes", "resource" })
	private static void loadSwtJar(URL[] swtJarURLs) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{		
		ClassLoader parent = SWTConfigurer.class.getClassLoader();			
		ClassLoader cl = new URLClassLoader(swtJarURLs,parent);
		Class classToLoad=null;
		try {
			classToLoad = cl.loadClass("org.eclipse.swt.widgets.Display");
			if(classToLoad!=null) System.out.println("SWT loaded from org.eclipse.swt.widgets.Display in "+swtJarURLs[0]);						        
		} catch (ClassNotFoundException exx) {
			System.err.println("Launch failed: Failed to load SWT class from jar: " + swtJarURLs[0]);
			throw new RuntimeException(exx);
		}
		Method method = classToLoad.getDeclaredMethod ("getDefault");
		Object instance = classToLoad.newInstance();
		Object result = method.invoke (instance);
	}
	
}
