; -- Menthor.iss --

#define MyAppName "Menthor Editor"
;#define MyAppVersion "1.0"
#define MyAppVersion "1.0"
#define MyAppPublisher "Menthor"
#define MyAppURL "www.menthor.net"
#define MyAppExeName "menthor-editor-"
#define MyIcon "menthor.ico"
#define MyIconFile "menthorFile.ico"
#define MyKey "menthorFile"
#define javaVersion "1.7"
#define intallerBaseName "menthor-editor-"

[Setup]
AppName={#MyAppName}
AppVersion={#MyAppVersion}
DefaultDirName={pf}\{#MyAppName}
DefaultGroupName={#MyAppName}
UninstallDisplayIcon={app}\{#MyIcon}
Compression=lzma2
SolidCompression=yes
OutputBaseFilename="{#intallerBaseName}{#MyAppVersion}-setup"
OutputDir="Output"
AppPublisherURL={#MyAppURL}
AppPublisher={#MyAppPublisher}
Uninstallable=yes
SetupIconFile="..\{#MyIcon}"
WizardSmallImageFile=..\menthor-logo.bmp
WizardImageFile=..\menthor-lateral-bar.bmp
AllowNoIcons=yes
UninstallDisplayName={#MyAppName} 
UninstallRestartComputer=no    
LicenseFile=..\license.txt
;InfoBeforeFile=..\before.txt
;InfoAfterFile=..\after.txt
              
[Files]
Source: "{#MyAppExeName}{#MyAppVersion}.exe"; DestDir: "{app}"; 
Source: "..\alloy4.2.jar"; DestDir: "{app}"
;Source: "..\alloy4.2.jar"; DestDir: "{app}\lib"
Source: "..\{#MyIcon}"; DestDir: "{app}"
Source: "..\{#MyIconFile}"; DestDir: "{app}"

[Icons]
Name: "{group}\{#MyAppName}"; Filename: "{app}\{#MyAppExeName}{#MyAppVersion}.exe"; IconFilename:"{app}\{#MyIcon}"; Tasks: startmenuicon 
;Name: "{app}\{#MyAppName}"; Filename: "{app}\{#MyAppExeName}"; IconFilename:"{app}\{#MyIcon}"; 
Name: "{commondesktop}\{#MyAppName}"; Filename: "{app}\{#MyAppExeName}{#MyAppVersion}.exe"; IconFilename:"{app}\{#MyIcon}"; Tasks: desktopicon 
;Name: "{userappdata}\Microsoft\Internet Explorer\Quick Launch\User Pinned\TaskBar\{#MyAppName}"; Filename: "{app}\{#MyAppExeName}"; Tasks: quicklaunchicon

[Tasks]
Name: startmenuicon; Description: "Create a &Start Menu icon"; GroupDescription: "Additional icons:"; 
Name: desktopicon; Description: "Create a &Desktop icon"; GroupDescription: "Additional icons:"; 
;Name: quicklaunchicon; Description: "Create a &Quick Launch icon"; GroupDescription: "Additional icons:"; Flags: unchecked

[Registry]
Root: HKCR; Subkey: ".menthor"; ValueType: string; ValueName: ""; ValueData: "{#MyKey}"; Flags: uninsdeletevalue
Root: HKCR; Subkey: "{#MyKey}"; ValueType: string; ValueName: ""; ValueData: "{#MyAppName} Project"; Flags: uninsdeletekey
Root: HKCR; Subkey: "{#MyKey}\DefaultIcon"; ValueType: string; ValueName: ""; ValueData: "{app}\{#MyIconFile}"
Root: HKCR; Subkey: "{#MyKey}\shell\open\command"; ValueType: string; ValueName: ""; ValueData: """{app}\{#MyAppExeName}{#MyAppVersion}.exe"" ""%1"""
Root: HKCU; Subkey: "Software\{#MyAppPublisher}"; Flags: uninsdeletekeyifempty
Root: HKCU; Subkey: "Software\{#MyAppPublisher}\{#MyAppName}"; Flags: uninsdeletekey
;Root: HKLM64; Subkey: "SOFTWARE\{#MyAppPublisher}"; Flags: uninsdeletekeyifempty
;Root: HKLM64; Subkey: "SOFTWARE\{#MyAppPublisher}\{#MyAppName}"; Flags: uninsdeletekey
;Root: HKLM64; Subkey: "SOFTWARE\{#MyAppPublisher}\{#MyAppName}"; ValueType: string; ValueName: "InstallPath"; ValueData: "{app}"
;Root: HKLM64; Subkey: "SOFTWARE\{#MyAppPublisher}\{#MyAppName}"; ValueType: string; ValueName: "Version"; ValueData: "{#MyAppVersion}"
;Root: HKLM64; Subkey: "SOFTWARE\{#MyAppPublisher}\{#MyAppName}"; ValueType: string; ValueName: "UninstallPath"; ValueData: "{app}\unins000.exe"
Root: HKLM; Subkey: "SOFTWARE\{#MyAppPublisher}"; Flags: uninsdeletekeyifempty
Root: HKLM; Subkey: "SOFTWARE\{#MyAppPublisher}\{#MyAppName}"; Flags: uninsdeletekey
Root: HKLM; Subkey: "SOFTWARE\{#MyAppPublisher}\{#MyAppName}"; ValueType: string; ValueName: "InstallPath"; ValueData: "{app}"
Root: HKLM; Subkey: "SOFTWARE\{#MyAppPublisher}\{#MyAppName}"; ValueType: string; ValueName: "UninstallPath"; ValueData: "{app}\unins000.exe"
Root: HKLM; Subkey: "SOFTWARE\{#MyAppPublisher}\{#MyAppName}"; ValueType: string; ValueName: "CurrentVersion"; ValueData: "{#MyAppVersion}"
;Root: HKCR; Subkey: ".jar"; ValueType: string; ValueName: ""; ValueData: "jarfile"; Flags: uninsdeletevalue
;Root: HKCR; Subkey: "jarfile\shell\open\command"; ValueType: string; ValueName: ""; ValueData: """C:\Program Files (x86)\Java\jre1.8.0_31\bin\javaw.exe"" -jar ""%1"" %*"""

[Code]
function GetUninstallPath: string;
var
  sUnInstPath: string;
  sInstallPath: String;
begin
  Result := '';
  sUnInstPath := ExpandConstant('SOFTWARE\{#MyAppPublisher}\{#MyAppName}'); //Your App GUID/ID
  sInstallPath := '';
  if not RegQueryStringValue(HKLM, sUnInstPath, 'UninstallPath', sInstallPath) then
    RegQueryStringValue(HKCU, sUnInstPath, 'UninstallPath', sInstallPath);
  Result := sInstallPath;
end;

function IsUpgrade: Boolean;
begin
  Result := (GetUninstallPath() <> '');
end;

function verifyJavaVersion: Boolean;
var
  JavaInstalled : Boolean;
	callJavaPage : Boolean;
	javaVersion: String;
  ErrorCode: Integer;
		  		
begin
  //verificacao da versao do java
  if RegQueryStringValue(HKLM, 'SOFTWARE\JavaSoft\Java Runtime Environment', 'CurrentVersion', javaVersion) then
  begin
    if StrToFloat(javaVersion) < {#javaVersion} then
    begin
        JavaInstalled := false;
    end else
    begin
        JavaInstalled := true;
    end
  end else
  begin
    JavaInstalled := false;
  end;

  if JavaInstalled = false then
  begin
    callJavaPage := MsgBox('This tool requires Java Runtime Environment version {#javaVersion} or newer to run. Please download and install the JRE and run this setup again. Do you want to download it now?', mbConfirmation, MB_YESNO) = idYes;
    if callJavaPage = true then
    begin
      ShellExec('open','http://www.oracle.com/technetwork/java/javase/downloads/index.html','','',SW_SHOWNORMAL,ewNoWait,ErrorCode);
    end;      
  end; 	         

  
  Result := JavaInstalled;
end;

function uninstallDifVersion: Boolean;
var
  menthorVersion: String;  
  iResultCode: Integer;
  sInstallPath: string;  
begin
  Result := true;
  if RegQueryStringValue(HKLM, 'SOFTWARE\{#MyAppPublisher}\{#MyAppName}', 'CurrentVersion', menthorVersion) then  //Your App GUID/ID
  begin
    if StrToFloat(menthorVersion) <> {#MyAppVersion} then        
    begin
      Result := MsgBox('Hey! The version ' + menthorVersion + ' of {#MyAppName} was detected. Do you want to uninstall it and install the version {#MyAppVersion}?', mbConfirmation, MB_YESNO) = idYes;
      if Result then
      begin
        sInstallPath := GetUninstallPath();
        sInstallPath :=  RemoveQuotes(sInstallPath);
        Exec(sInstallPath, '/SILENT /NORESTART /SUPPRESSMSGBOXES', '', SW_SHOW, ewWaitUntilTerminated, iResultCode);
        Result := True; //if you want to proceed after uninstall
                  //Exit; //if you want to quit after uninstall
      end
    end else
    begin
      MsgBox('This tool is already installed in you computer in the version ' + menthorVersion + '.', mbInformation, MB_OK);
      Result := false;
    end;       
  end; 
end;

function InitializeSetup(): Boolean;
	var
		JavaInstalled : Boolean;
    uninstalDifVersion: Boolean;
	begin
    JavaInstalled := verifyJavaVersion();
    if JavaInstalled = false then
    begin
      Result := false;
      exit;
    end;

    uninstalDifVersion := uninstallDifVersion();   
    if uninstalDifVersion = false then
    begin
      Result := false;
      exit;
    end;

    Result := true;
    
	end;       
end.

