## 1. What is Menthor Editor?

Menthor Editor is a platform for people who wants to build high quality ontologies in less time. 
Its goal is to enable you to develop good ontologies faster than you could if you were building your OWL/RDF from scracth. By focusing on conceptual modeling with OntoUML and an automatic validation and codification tookit which emcompasses a set of features such as OWL generation, visual simulation, semantic anti-patterns detection and SBVR documentation, Menthor Editor lets you not only build diagrammatically your ontology but garantees you not only built the right ontology but built the ontology right.

## 2. License & Scientific Contribution

Distributed under MIT license, Menthor Editor is the subject of many scientific contributions found in the following [list of publications](http://www.menthor.net/publications.html)

## 3. Acknowledgments

We  would like  to thank all [NEMO Research Group](http://nemo.inf.ufes.br/) members who have contributed to the precursor of Menthor called [OLED](http://www.inf.ufes.br/~gguizzardi/edoc2015_camera_ready.pdf) in some very important features such as the OntoUML metamodel, OWL codifications and the portuguese text generator. In particular, we thank Roberto Carraretto, Antognoni Albuquerque, Veruska Zamborlini, Vinicius Sobral, Cásssio  Reginato, Victor Amorim, Pedro Paulo Barcelos and Diorbert Correa. 

## 4. Download & Installation

Instalation and download details can be found [here](http://www.menthor.net/menthor-editor.html)

## 5. Source Code

In order to run ME with the source code, you'll need the following tools:
* Java 7 or superior
* Eclipse Modeling Tools (Juno or superior recommended) with MAVEN installed.
* Git Client application (GitHub, Tortoise, Source Tree, etc)

We use in particular Java 8, Eclipse Mars and Tortoise Git (just to mention). After installing these...

### 5.1 Import Code on Eclipse

* Checkout "menthor-editor" github repository on your computer using one of the Git Client Applications (let's say Tortoise Git). This means you'll have on your computer a folder with all Menthor Editor's java source code.
* On Eclipse click at: "File" -> "Import" -> "General" -> "Existing Project into Workspace" -> "Browse..."
* Choose your local folder with all Menthor Editor's source code in it.
* Select all projects and click "Finish"

### 5.2 SWT JAR dependency

Menthor's code requires at development a SWT JAR library that matches with you operating system (Mac, Linux or Windows). Follow these steps to configure a ClassPath Variable on Eclipse that will point to the right SWT JAR dependency:

* Click at: "Eclipse" -> "Preferences.." -> "Java" -> "Build Path" -> "Classpath Variables" -> "New"
* Set the variable name to "OS_SPECIFIC_SWT"
* Click on "File..." and at "net.menthor.common/lib" find the correct "swt.jar" of your OS.

### 5.3 Run in Mac OSx

If your're using Mac you need to disable the "XstartOnFirstThread" option in order to run the editor, follow these steps:

* Right click at "MenthorEditor.java" -> "Run As" -> "Run Configurations" -> "Arguments Tab"
* Disable "XstartOnFirstThread".
* Add -Xdock:name="Menthor Editor" to the VM arguments
* Then click at "Main.java" -> "Right Click" -> "Run As" -> "Java Application"

### 5.4 Executable JAR

If you want to deploy the editor into an executable JAR file, do the following:

* Open "MenthorEditor.java" -> Change value of "MENTHOR_VERSION" to tell which version you're building.
* Open "MenthorEditor.java" -> Change value of "USE_LOG_FILE" to tell whether or not you're going to use the log file.
* Right click at "MenthorEditor.java" -> "Export" -> "Runnable Jar".
* Rename file path to "menthor-"+MENTHOR_VERSION+".jar", where MENTHOR_VERSION is the version you're building
* Select "Copy required libraries into a sub-folder next to generated JAR" checkbox
* Open folder "/menthor_lib" and delete the "swt.jar" file
  Remember this file was attached on development and is specific to your OS, that's why you need to delete it.
* Try executing the JAR via command line
