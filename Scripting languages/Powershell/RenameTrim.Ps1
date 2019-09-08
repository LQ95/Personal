#Renames every file in a directory,trimming it in the process.
#I'm going to refactor this into a proper function someday.

$newname= ""
$combersomestring="windows-xp-desktop-background-wallpaper-"
$combersomestring2="-800x600"
$workingdir=Get-Location
$filepath= ""
#ForEach-Object loop is fed an array of files from Get-ChildItem
Get-ChildItem -Path $workingdir | ForEach-Object{
$newname=$_.Name
$filepath=$_.FullName
$newname= $newname.replace($combersomestring,"")  #replace cumbersome strings
$newname= $newname.replace($combersomestring2,"")
Rename-Item $filepath $newname #rename to new name 
}
