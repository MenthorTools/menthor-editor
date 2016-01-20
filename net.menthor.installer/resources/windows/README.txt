Install Requirements

1 - launch4j: http://launch4j.sourceforge.net/

2 - Inno Setup: http://www.jrsoftware.org/isdl.php

Generate Windows Installer

1 - Compile Menthor-Editor version XXX

2 - Launch launch4j

3 - Open the configuration file: ...\branches\develop\net.menthor.installer\resources\windows\menthor.xml

4 - Update the old version to the new version in "Output file" and in "jar"

5 - Run

6 - Launch Inno Setup

7 - Open the configuration file: ...\branches\develop\net.menthor.installer\resources\windows\menthor.iss

8 - Update the old version to the new version in "MENTHOR_VERSION" at line 4

9 - Run

