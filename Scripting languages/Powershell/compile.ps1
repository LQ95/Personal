

#Add windows Forms
Add-Type -AssemblyName System.Windows.Forms

#Create a new form
$global:CompileForm = New-Object system.Windows.forms.Form

#Define size.title and background color
$CompileForm.ClientSize = "600,400"
$CompileForm.text ="Compilation"
$CompileForm.BackColor = "#0077cc"

#adding label
$TitleLabel = New-Object system.Windows.forms.Label
$TitleLabel.text = "Please select a file path and a compiler."
$TitleLabel.AutoSize = $true


#Positioning label
$TitleLabel.Font = "Microsoft Sans Serif,24"

#Other smaller labels
$PathLabel = New-Object System.Windows.forms.Label
$Compiler = New-Object System.Windows.Forms.ComboBox
$CompilerLabel = New-Object System.Windows.Forms.Label
$global:CompPath = New-Object System.Windows.Forms.TextBox

$PathLabel.text = "Path:"
$PathLabel.AutoSize = $true
$PathLabel.width =100
$PathLabel.height =100
$PathLabel.Font = "Microsoft Sans Serif,12"

$Compiler.AutoSize = $true
$Compiler.Font = "Microsoft Sans Serif,12"

$CompilerLabel.text = "Compiler:"
$CompilerLabel.AutoSize = $true
$CompilerLabel.width = 100
$CompilerLabel.height = 100
$CompilerLabel.Font = "Microsoft Sans Serif,12"

$CompPath.AutoSize = $false
$CompPath.width = 600
$CompPath.height = 24
$CompPath.Font = "Microsoft Sans Serif,12"

#Add compilers and select the default one
@("C (gcc)","C++ (g++)")|ForEach-Object{[void]$Compiler.Items.Add($_)}
$Compiler.SelectedIndex = 0

#button handling
$CompileButton = New-Object System.Windows.Forms.Button
$CompileButton.BackColor = "#a4ba67"
$CompileButton.text = "Compile"
$CompileButton.width = 90 
$CompileButton.height= 30
$CompileButton.Font= "Microsoft Sans Serif,10"
#Positioning 
$TitleLabel.location=New-Object System.Drawing.Point(0,0);
$PathLabel.location=New-Object System.Drawing.Point(0,75);
$CompPath.location=New-Object System.Drawing.Point(0,100);
$CompilerLabel.location=New-Object System.Drawing.Point(0,200);
$Compiler.location=New-Object System.Drawing.Point(75,200);
$CompileButton.location=New-Object System.Drawing.Point(250,300);

#Add elements to form
$CompileForm.controls.AddRange(@($TitleLabel,$PathLabel,$CompPath,$CompilerLabel,$Compiler,$CompileButton)) 

#Compile function
function Compile(){

$Text=$CompPath.Text
$DropDown= $Compiler.SelectedItem
if($Text -eq $null -or $Text -eq "")
{
	return;
}
if((Test-Path -Path $Text -PathType leaf) -eq $False)
	{
		[System.Windows.Forms.MessageBox]::Show('Invalid Path ')
	}
else {
    if($DropDown -eq "C (gcc)")
           {
	           gcc -o test.exe $Text
	       }
    else {
            g++ -o test.exe $Text
        }
    }
}

$CompileButton.Add_Click({ Compile })
#Display the form
[void]$CompileForm.ShowDialog()
