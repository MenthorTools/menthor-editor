; -- Menthor.iss --

#define MyAppName "Menthor Editor"
#define MENTHOR_VERSION "1.0.2"
#define MyAppPublisher "Menthor"
#define MyAppURL "www.menthor.net"
#define MyAppExeName "menthor"
#define MyIcon "menthor.ico"
#define MyIconFile "menthor-file-windows.ico"
#define MyKey "menthorFile"
#define javaVersion "1.7"
#define intallerBaseName "menthor-"

[Setup]
AppName={#MyAppName}
AppVersion={#MENTHOR_VERSION}
DefaultDirName="{pf}\Menthor\{#MyAppName}"
DefaultGroupName={#MyAppName}
UninstallDisplayIcon={app}\{#MyIcon}
Compression=lzma2
SolidCompression=yes
OutputBaseFilename="{#intallerBaseName}{#MENTHOR_VERSION}-setup"
OutputDir=..\..\..\build\installer\windows\
AppPublisherURL={#MyAppURL}
AppPublisher={#MyAppPublisher}
Uninstallable=yes
SetupIconFile="..\icons\{#MyIcon}"
WizardSmallImageFile=..\images\menthor-logo.bmp
WizardImageFile=..\images\menthor-lateral-bar.bmp
AllowNoIcons=yes
UninstallDisplayName={#MyAppName} 
UninstallRestartComputer=no    
LicenseFile=..\texts\license.txt
;InfoBeforeFile=..\before.txt
;InfoAfterFile=..\after.txt
              
[Files]
Source: "..\..\..\build\exe\{#MyAppExeName}-{#MENTHOR_VERSION}.exe"; DestDir: "{app}"; DestName: "{#MyAppExeName}.exe"
Source: "..\..\..\build\alloy4.2.jar"; DestDir: "{app}"
;Source: "..\alloy4.2.jar"; DestDir: "{app}\lib"
Source: "..\icons\{#MyIcon}"; DestDir: "{app}"
Source: "..\icons\{#MyIconFile}"; DestDir: "{app}"

[Icons]
Name: "{group}\{#MyAppName}"; Filename: "{app}\{#MyAppExeName}.exe"; IconFilename:"{app}\{#MyIcon}"; Tasks: startmenuicon 
Name: "{commondesktop}\{#MyAppName}"; Filename: "{app}\{#MyAppExeName}.exe"; IconFilename:"{app}\{#MyIcon}"; Tasks: desktopicon\common 
Name: "{userdesktop}\{#MyAppName}"; Filename: "{app}\{#MyAppExeName}.exe"; IconFilename:"{app}\{#MyIcon}"; Tasks: desktopicon\user 
Name: "{userappdata}\Microsoft\Internet Explorer\Quick Launch\User Pinned\TaskBar\Menthor Editor"; Filename: "{app}\{#MyAppExeName}.exe"; IconFilename:"{app}\{#MyIcon}"; Tasks: quicklaunchicon 

[Tasks]
Name: startmenuicon; Description: "Create a &Start Menu icon"; GroupDescription: "Additional icons:"; 
Name: desktopicon; Description: "Create a &Desktop icon"; GroupDescription: "Additional icons:"; 
Name: desktopicon\user; Description: "For the current user only"; GroupDescription: "Additional icons:";Flags: exclusive
Name: desktopicon\common; Description: "For all users"; GroupDescription: "Additional icons:"; Flags: exclusive unchecked
;Name: quicklaunchicon; Description: "Create a &Quick Launch icon"; GroupDescription: "Additional icons:"

[Registry]
Root: HKCR; Subkey: ".menthor"; ValueType: string; ValueName: ""; ValueData: "{#MyKey}"; Flags: uninsdeletevalue
Root: HKCR; Subkey: "{#MyKey}"; ValueType: string; ValueName: ""; ValueData: "{#MyAppName} Project"; Flags: uninsdeletekey
Root: HKCR; Subkey: "{#MyKey}\DefaultIcon"; ValueType: string; ValueName: ""; ValueData: "{app}\{#MyIconFile}"; AfterInstall: myAfterInstall
Root: HKCR; Subkey: "{#MyKey}\shell\open\command"; ValueType: string; ValueName: ""; ValueData: """{app}\{#MyAppExeName}.exe"" ""%1"""
Root: HKCU; Subkey: "Software\{#MyAppPublisher}"; Flags: uninsdeletekeyifempty
Root: HKCU; Subkey: "Software\{#MyAppPublisher}\{#MyAppName}"; Flags: uninsdeletekey
;Root: HKLM64; Subkey: "SOFTWARE\{#MyAppPublisher}"; Flags: uninsdeletekeyifempty
;Root: HKLM64; Subkey: "SOFTWARE\{#MyAppPublisher}\{#MyAppName}"; Flags: uninsdeletekey
;Root: HKLM64; Subkey: "SOFTWARE\{#MyAppPublisher}\{#MyAppName}"; ValueType: string; ValueName: "InstallPath"; ValueData: "{app}"
;Root: HKLM64; Subkey: "SOFTWARE\{#MyAppPublisher}\{#MyAppName}"; ValueType: string; ValueName: "Version"; ValueData: "{#MENTHOR_VERSION}"
;Root: HKLM64; Subkey: "SOFTWARE\{#MyAppPublisher}\{#MyAppName}"; ValueType: string; ValueName: "UninstallPath"; ValueData: "{app}\unins000.exe"
Root: HKLM; Subkey: "SOFTWARE\{#MyAppPublisher}"; Flags: uninsdeletekeyifempty
Root: HKLM; Subkey: "SOFTWARE\{#MyAppPublisher}\{#MyAppName}"; Flags: uninsdeletekey
Root: HKLM; Subkey: "SOFTWARE\{#MyAppPublisher}\{#MyAppName}"; ValueType: string; ValueName: "InstallPath"; ValueData: "{app}"
Root: HKLM; Subkey: "SOFTWARE\{#MyAppPublisher}\{#MyAppName}"; ValueType: string; ValueName: "UninstallPath"; ValueData: "{app}\unins000.exe"
Root: HKLM; Subkey: "SOFTWARE\{#MyAppPublisher}\{#MyAppName}"; ValueType: string; ValueName: "CurrentVersion"; ValueData: "{#MENTHOR_VERSION}"
;Root: HKCR; Subkey: ".jar"; ValueType: string; ValueName: ""; ValueData: "jarfile"; Flags: uninsdeletevalue
;Root: HKCR; Subkey: "jarfile\shell\open\command"; ValueType: string; ValueName: ""; ValueData: """C:\Program Files (x86)\Java\jre1.8.0_31\bin\javaw.exe"" -jar ""%1"" %*"""

[Code]
procedure myAfterInstall();
var
  ErrorCode: Integer;
begin
  if not ShellExec('', ExpandConstant('ie4uinit.exe -ClearIconCache'), '', '', SW_SHOW, ewNoWait, ErrorCode) then
  begin
    // handle failure if necessary
  end;
end;

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
  regExist: Boolean;		  		
begin
  regExist := RegQueryStringValue(HKLM, 'SOFTWARE\JavaSoft\Java Runtime Environment', 'CurrentVersion', javaVersion);
  if regExist = false then    
  begin
    regExist := RegQueryStringValue(HKLM64, 'SOFTWARE\JavaSoft\Java Runtime Environment', 'CurrentVersion', javaVersion);
  end;

  //verificacao da versao do java
  if regExist then
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
    if menthorVersion <> '{#MENTHOR_VERSION}' then        
    begin
      Result := MsgBox('Hey! The version ' + menthorVersion + ' of {#MyAppName} was detected. Do you want to uninstall it and install the version {#MENTHOR_VERSION}?', mbConfirmation, MB_YESNO) = idYes;
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

