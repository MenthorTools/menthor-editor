
==============================================================
How to run Menthor from the source code.
==============================================================

Requirements:
   - Eclipse Modeling Tools (Juno or superior recommended) with Maven installed.
   - Java 7
   - Git Client application (GitHub, Tortoise, Source Tree, etc)

-------------------------------------------------------------- 
Step 1. Import Menthor's source code into your machine/Eclipse

1.1 Checkout the source code from the github account using a Git Client application such as GitHub or Tortoise.
1.2 Open the Eclipse and choose your appropriate workspace (we recommend using the very same folder you checked out your code)
1.3 Go to File->Import->General->Existing Project into Workspace
1.4 Click in "Browse..." and choose the root folder where you can find all the source code you checked out
1.5 Select all the projects and click "Finish"

---------------------------------------------------------------
Step 2. Configure SWT according to your OS

Each OS will require a different version of the SWT library. 
You'll need to set a variable to point to the version of SWT that matches with your operating system.

2.1 Open Eclipse>Preferences..
2.2 Select Java>Build Path>Classpath Variables
2.3 Click on New..
2.4 Name: OS_SPECIFIC_SWT
2.5 To set the path, click on File... and find in your net.menthor.common/lib folder the correct .swt for your environment.

---------------------------------------------------------------
Step 3. Running Menthor

If your're using Mac you need to disable the "XstartOnFirstThread" option.

3.1 Go to net.menthor.editor.ui.MenthorEditor.java file and Right Click -> Run As -> Run Configurations -> Arguments Tab
3.2 Click and disable the checkbox "XstartOnFirstThread".
3.3 For MacOS, add -Xdock:name="Menthor Editor" to the VM arguments
3.4 To run the application go to Main.java -> Right Click -> Run As -> Java Application

==============================================================
How to generate Executable JAR
==============================================================

1. Change the attribute MENTHOR_VERSION in MenthorEditor.java to point to the version you're building.
   Ex: String MENTHOR_VERSION = "0.9.32";
   See more instructions commented in that attribute

2. Change the attribute USE_LOG_FILE in MenthorEditor.java to tell whether or not you're going to use the log file.
   In this case, change the attribute to true.
   ex: boolean USE_LOG_FILE = true;
   
3. Right click on MenthorEditor.java, go to Export -> Runnable Jar.
   Rename the jar to "menthor-"+MENTHOR_VERSION".jar, where MENTHOR_VERSION is your build version.

4. 	Select Library handling at the checkbox: "Package required libraries into generated JAR"
    We need to choose to package the libraries instead of extract them. You do not need to generate an ANT build script also.
   
5. After generating the jar, open it with WinRAR/Unzip and delete the "swt.jar" files on the root of the jar, they are among the other libraries. 
   This swt.jar" is specific of Winx64 platform and we used it only in the development process. We don't need it at runtime.
   
6. Double click on the jar file created or type in a console java -jar menthor-editor-+MENTHOR_VERSION+.jar to execute Menthor Editor.

=) 

Freddy - Updated: 22 April 2015
John - Updated: 10 July 2015
