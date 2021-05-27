WinWaitActive("Open", "", 10)

ControlFocus("Open", "","Edit1")

ControlSetText("Open", "","Edit1",$CmdLine[1])

ControlClick("Open","", "Button1")