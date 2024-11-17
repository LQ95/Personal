
#Add windows Forms
Add-Type -AssemblyName System.Windows.Forms
#Create a new form
$global:NegativesForm = New-Object system.Windows.forms.Form
#Settig up the folder browser dialog
$global:NegativesFolderBrowser = New-Object System.Windows.Forms.FolderBrowserDialog -Property @{
    SelectedPath = Get-Location
}

$NegativesFolderBrowser.ShowNewFolderButton = $false

#Define size.title and background color
$NegativesForm.ClientSize = "640,480"
$NegativesForm.text ="Photo renamer"
$NegativesForm.BackColor = "#0077cc"

#adding label
$TitleLabel = New-Object system.Windows.forms.Label
$TitleLabel.text = "Insert all necessary data"
$TitleLabel.AutoSize = $true
$TitleLabel.Font = "Microsoft Sans Serif,24"

#Other smaller labels
$PathLabel = New-Object System.Windows.forms.Label
$global:TrailingAChoice = New-Object System.Windows.Forms.CheckBox
$ChoiceLabel = New-Object System.Windows.Forms.Label
$global:NegativesPath = New-Object System.Windows.Forms.TextBox
$PrefixLabel = New-Object System.Windows.Forms.Label
$global:PrefixBox = New-Object System.Windows.Forms.TextBox
$NumberLabel = New-Object System.Windows.Forms.Label
$global:NumberBox = New-Object System.Windows.Forms.TextBox

$PathLabel.text = "Photo folder:"
$PathLabel.AutoSize = $true
$PathLabel.width =100
$PathLabel.height =100
$PathLabel.Font = "Microsoft Sans Serif,12"

#$TrailingAChoice.Text		= "Sì"
$TrailingAChoice.Size		= New-Object System.Drawing.Size("49","40")
$TrailingAChoice.Checked	= $False
$TrailingAChoice.Font = "Microsoft Sans Serif,12"

$ChoiceLabel.text = "Does there need to be a trailing A at the end of every filename?:"
$ChoiceLabel.AutoSize = $true
$ChoiceLabel.width = 100
$ChoiceLabel.height = 100
$ChoiceLabel.Font = "Microsoft Sans Serif,12"

$NegativesPath.AutoSize = $false
$NegativesPath.width = 600
$NegativesPath.height = 24
$NegativesPath.Font = "Microsoft Sans Serif,12"

$PrefixLabel.text = "Choose a prefix"
$PrefixLabel.AutoSize = $true
$PrefixLabel.width = 100
$PrefixLabel.height = 100
$PrefixLabel.Font = "Microsoft Sans Serif,12"

$PrefixBox.AutoSize = $false
$PrefixBox.width = 100
$PrefixBox.height = 24
$PrefixBox.Font = "Microsoft Sans Serif,12"

$NumberLabel.text = "File enumeration starts with this number:"
$NumberLabel.AutoSize = $true
$NumberLabel.width = 100
$NumberLabel.height = 100
$NumberLabel.Font = "Microsoft Sans Serif,12"

$NumberBox.AutoSize = $false
$NumberBox.width = 100
$NumberBox.height = 24
$NumberBox.Font = "Microsoft Sans Serif,12"
$NumberBox.Text = "0"

#button handling
$RenameButton = New-Object System.Windows.Forms.Button
$RenameButton.BackColor = "#a4ba67"
$RenameButton.text = "Rename"
$RenameButton.width = 90 
$RenameButton.height= 30
$RenameButton.Font= "Microsoft Sans Serif,10"

$BrowseForPathButton = New-Object System.Windows.Forms.Button
$BrowseForPathButton.BackColor = "#a4ba67"
$BrowseForPathButton.text = "Browse..."
$BrowseForPathButton.width = 90 
$BrowseForPathButton.height= 30
$BrowseForPathButton.Font= "Microsoft Sans Serif,10"

#Positioning 
$TitleLabel.location=New-Object System.Drawing.Point(0,0);
$PathLabel.location=New-Object System.Drawing.Point(0,50);
$NegativesPath.location=New-Object System.Drawing.Point(0,75);
$BrowseForPathButton.location=New-Object System.Drawing.Point(430,125);

$PrefixLabel.location=New-Object System.Drawing.Point(0,150);
$PrefixBox.location=New-Object System.Drawing.Point(0,175);

$NumberLabel.location=New-Object System.Drawing.Point(0,225);
$NumberBox.location=New-Object System.Drawing.Point(0,250);

$ChoiceLabel.location=New-Object System.Drawing.Point(0,350);
$TrailingAChoice.location=New-Object System.Drawing.Point(395,340);
$RenameButton.location=New-Object System.Drawing.Point(320,400);

#Add elements to form
$NegativesForm.controls.AddRange(@($TitleLabel,$PathLabel,$NegativesPath,$PrefixLabel,$PrefixBox,$NumberLabel,$ChoiceLabel,$NumberBox,$TrailingAChoice,$RenameButton,$BrowseForPathButton)) 


#renaming function
function rename(){
	$FilePath=$NegativesPath.Text
	
	#does the file path exist and is it valid?
	if(!$FilePath){
		[System.Windows.Forms.MessageBox]::Show("Please insert a path")
	return
	}
	if((Test-Path -Path $FilePath) -eq $false){
		[System.Windows.Forms.MessageBox]::Show("Invalid path")
	return
	}
	
	$Filenames= Get-ChildItem -Path $FilePath -Name
	
	if($TrailingAChoice.Checked -eq $true)
	{
		$TrailingA="A"
	}else{
		$TrailingA=""
	}
	#Has the prefix been set?
	$Prefix=$PrefixBox.Text
	if(!$Prefix){
		[System.Windows.Forms.MessageBox]::Show("Please set a prefix")
	return
	}
	
	try {
	$Number=[int]$NumberBox.Text
	if(!$NumberBox.Text){
		$NumberBox.Text="0"
	}
	if($Number -lt (-1)){
		$NumberBox.Text="-1"
		$Number=-1
	}
	}catch {
    [System.Windows.Forms.MessageBox]::Show("Error: Cannot convert input text to an integer.")
	return
	}
	
	foreach($name in $Filenames){
		$Tokens=$name.split('.')
		$Extension=$Tokens[$Tokens.Length-1]
		$NumberConverted=$Number.ToString()
		if($Number -lt 0)
		{
			$NumberConverted="@"
		}
		$newname=$Prefix + $NumberConverted + $TrailingA +"."+ $Extension
		
		Rename-Item -Path $FilePath"\"$Name -NewName $newname
		$Number= $Number +1
	}
	
}

function get_folder_path(){
	$NegativesFolderBrowser.ShowDialog()
    $NegativesPath.Text = $NegativesFolderBrowser.SelectedPath
	$PathTokens=$NegativesFolderBrowser.SelectedPath.split("\")
	$PrefixBox.Text=$PathTokens[$PathTokens.Length-1];
}
#link functions to buttons
$RenameButton.Add_Click({rename})
$BrowseForPathButton.Add_Click({get_folder_path})
#show the form
[void]$NegativesForm.ShowDialog()