; -- Menthor.iss --

#define MyAppName "Menthor Editor"
#define MyAppVersion "1.0"
#define MyAppPublisher "Menthor"
#define MyAppURL "www.menthor.net"
#define MyAppExeName "menthor-editor.exe"
#define MyIcon "menthor.ico"
#define MyIconFile "menthorFile.ico"
#define MyKey "menthorFile"
#define javaVersion "9"

[Setup]
AppName={#MyAppName}
AppVersion={#MyAppVersion}
DefaultDirName={pf}\{#MyAppName}
DefaultGroupName={#MyAppName}
UninstallDisplayIcon={app}\{#MyIcon}
Compression=lzma2
SolidCompression=yes
OutputBaseFilename="menthor-editor-{#MyAppVersion}-setup"
OutputDir="Output"
AppPublisherURL={#MyAppURL}
AppPublisher={#MyAppPublisher}
Uninstallable=yes
SetupIconFile="..\{#MyIcon}"
WizardSmallImageFile=..\menthor-logo.bmp
WizardImageFile=..\menthor-lateral-bar.bmp
AllowNoIcons=yes
UninstallIconFile={#MyIcon}
UninstallDisplayName={#MyAppName}     
LicenseFile=..\license.txt
;InfoBeforeFile=..\before.txt
;InfoAfterFile=..\after.txt
              
[Files]
Source: "{#MyAppExeName}"; DestDir: "{app}"
Source: "..\alloy4.2.jar"; DestDir: "{app}"
;Source: "..\alloy4.2.jar"; DestDir: "{app}\lib"
Source: "..\{#MyIcon}"; DestDir: "{app}"
Source: "..\{#MyIconFile}"; DestDir: "{app}"

[Icons]
Name: "{group}\{#MyAppName}"; Filename: "{app}\{#MyAppExeName}"; IconFilename:"{app}\{#MyIcon}"; Tasks: startmenuicon 
;Name: "{app}\{#MyAppName}"; Filename: "{app}\{#MyAppExeName}"; IconFilename:"{app}\{#MyIcon}"; 
Name: "{commondesktop}\{#MyAppName}"; Filename: "{app}\{#MyAppExeName}"; IconFilename:"{app}\{#MyIcon}"; Tasks: desktopicon 
;Name: "{userappdata}\Microsoft\Internet Explorer\Quick Launch\User Pinned\TaskBar\{#MyAppName}"; Filename: "{app}\{#MyAppExeName}"; Tasks: quicklaunchicon

[Tasks]
Name: startmenuicon; Description: "Create a &Start Menu icon"; GroupDescription: "Additional icons:"; 
Name: desktopicon; Description: "Create a &Desktop icon"; GroupDescription: "Additional icons:"; 
;Name: quicklaunchicon; Description: "Create a &Quick Launch icon"; GroupDescription: "Additional icons:"; Flags: unchecked

[Registry]
Root: HKCR; Subkey: ".menthor"; ValueType: string; ValueName: ""; ValueData: "{#MyKey}"; Flags: uninsdeletevalue
Root: HKCR; Subkey: "{#MyKey}"; ValueType: string; ValueName: ""; ValueData: "{#MyAppName} Project"; Flags: uninsdeletekey
Root: HKCR; Subkey: "{#MyKey}\DefaultIcon"; ValueType: string; ValueName: ""; ValueData: "{app}\{#MyIconFile}"
Root: HKCR; Subkey: "{#MyKey}\shell\open\command"; ValueType: string; ValueName: ""; ValueData: """{app}\{#MyAppExeName}"" ""%1"""
Root: HKCU; Subkey: "Software\{#MyAppPublisher}"; Flags: uninsdeletekeyifempty
Root: HKCU; Subkey: "Software\{#MyAppPublisher}\{#MyAppName}"; Flags: uninsdeletekey
Root: HKLM64; Subkey: "SOFTWARE\{#MyAppPublisher}"; Flags: uninsdeletekeyifempty
Root: HKLM64; Subkey: "SOFTWARE\{#MyAppPublisher}\{#MyAppName}"; Flags: uninsdeletekey
Root: HKLM64; Subkey: "SOFTWARE\{#MyAppPublisher}\{#MyAppName}"; ValueType: string; ValueName: "InstallPath"; ValueData: "{app}"
Root: HKLM64; Subkey: "SOFTWARE\{#MyAppPublisher}\{#MyAppName}"; ValueType: string; ValueName: "Version"; ValueData: "{#MyAppVersion}"
Root: HKLM32; Subkey: "SOFTWARE\{#MyAppPublisher}"; Flags: uninsdeletekeyifempty
Root: HKLM32; Subkey: "SOFTWARE\{#MyAppPublisher}\{#MyAppName}"; Flags: uninsdeletekey
Root: HKLM32; Subkey: "SOFTWARE\{#MyAppPublisher}\{#MyAppName}"; ValueType: string; ValueName: "InstallPath"; ValueData: "{app}"
Root: HKLM32; Subkey: "SOFTWARE\{#MyAppPublisher}\{#MyAppName}"; ValueType: string; ValueName: "Version"; ValueData: "{#MyAppVersion}"
;Root: HKCR; Subkey: ".jar"; ValueType: string; ValueName: ""; ValueData: "jarfile"; Flags: uninsdeletevalue
;Root: HKCR; Subkey: "jarfile\shell\open\command"; ValueType: string; ValueName: ""; ValueData: """C:\Program Files (x86)\Java\jre1.8.0_31\bin\javaw.exe"" -jar ""%1"" %*"""

[Code]
function InitializeSetup(): Boolean;
  var
    ErrorCode: Integer;
    JavaInstalled : Boolean;
    Result1 : Boolean;
    Versions: TArrayOfString;
    I: Integer;
  begin
    if RegGetSubkeyNames(HKLM, 'SOFTWARE\JavaSoft\Java Runtime Environment', Versions) then
    begin
      for I := 0 to GetArrayLength(Versions)-1 do
        if JavaInstalled = true then
        begin
          //do nothing
        end else
        begin
          if ( Versions[I][2]='.' ) and ( ( StrToInt(Versions[I][1]) > 1 ) or ( ( StrToInt(Versions[I][1]) = 1 ) and ( StrToInt(Versions[I][3]) >= {#javaVersion} ) ) ) then
          begin
            JavaInstalled := true;
          end else
          begin
            JavaInstalled := false;
          end;
        end;
      end else
      begin
        JavaInstalled := false;
      end;
      
     //JavaInstalled := RegKeyExists(HKLM,'SOFTWARE\JavaSoft\Java Runtime Environment\1.9');
     if JavaInstalled then
     begin
      Result := true;
     end else
     begin
        Result1 := MsgBox('This tool requires Java Runtime Environment version 1.7 or newer to run. Please download and install the JRE and run this setup again. Do you want to download it now?', mbConfirmation, MB_YESNO) = idYes;
        if Result1 = false then
        begin
          Result:=false;
        end else
        begin
          Result:=false;
          ShellExec('open','http://www.java.com/getjava/','','',SW_SHOWNORMAL,ewNoWait,ErrorCode);
        end;
     end;
  end;
end.

