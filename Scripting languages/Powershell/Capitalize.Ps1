#Capitalize every first letter in every filename in the current folder
#I'm going to refactor this into a proper function someday.

$newname= ""
$workingdir=Get-Location
$filepath= ""
$LocalTextInfo=(Get-Culture).TextInfo
#ForEach-Object loop is fed an array of files from Get-ChildItem
Get-ChildItem -Path $workingdir | ForEach-Object{
$newname=$_.Basename
$filepath=$_.FullName
$newname=$LocalTextInfo.ToTitleCase($newname)  #capitalize
$newname=$newname +$_.Extension
Rename-Item $filepath $newname #rename to new name 
}
powershell