## 1. What is Menthor Editor?

Menthor Editor is a platform for people who wants to build high quality ontologies in less time. 
Its goal is to enable you to develop meaningful, rich and accurate ontology faster than you could if you were building your OWL/RDF from scracth,
by focusing on conceptual modeling with OntoUML and an automatic validation and codification tookit which emcompasses OWL generation, visual simulation, semantic anti-patterns detection and SBVR documentation.
Menthor Editor lets you not only build diagrammatically your ontology but garantees you not only built the right ontology but also build the ontology right.

## 2. License

Under MIT license.

## 3. Download & Installation Details

Please visit our download page at our website: [here](http://www.menthor.net/menthor-editor.html)

## 4. Running through Java Code

You need the following tools:
* Java 7 or superior
* Eclipse Modeling Tools (Juno or superior recommended) with MAVEN installed.
* Git Client application (GitHub, Tortoise, Source Tree, etc)

We use in particular Java 8, Eclipse Mars and Tortoise Git, so you can't go wrong with them. 
After installing these...

### 4.1 Import Code on Eclipse

* Checkout "menthor-editor" github repository on your computer using one of the Git Client Applications, let's say Tortoise Git. This means you'll have on your computer a folder with all Menthor Editor's java source code.
* On Eclipse click at: "File" -> "Import" -> "General" -> "Existing Project into Workspace" -> "Browse..."
* Choose your local folder with all Menthor Editor's source code in it.
* Select all projects and click "Finish"

### 4.2 Correct SWT JAR dependency

Menthor's code requires at development time a SWT JAR library that matches with you operating system (Mac, Linux or Windows). Follow these steps to configure a ClassPath Variable on Eclipse that will point to the right SWT JAR dependency:

* Click at: "Eclipse" -> "Preferences.." -> "Java" -> "Build Path" -> "Classpath Variables" -> "New"
* Set the variable name to "OS_SPECIFIC_SWT"
* Click on "File..." and at "net.menthor.common/lib" find the correct "swt.jar" of your OS.

### 4.3 Run in MacOSx

If your're using Mac you need to disable the "XstartOnFirstThread" option, follow this steps:

* Right click at "MenthorEditor.java" -> "Run As" -> "Run Configurations" -> "Arguments Tab"
* Disable "XstartOnFirstThread".
* Add -Xdock:name="Menthor Editor" to the VM arguments
* Then click at "Main.java" -> "Right Click" -> "Run As" -> "Java Application"
