Attribute VB_Name = "Modulo1"

Sub prova()
Attribute prova.VB_ProcData.VB_Invoke_Func = " \n14"
'
' prova Macro
'
Dim d As Scripting.Dictionary
Set d = New Scripting.Dictionary
Dim i As Long
Dim LastRow As Long
Dim name As String
Dim num As Long
'
    Sheets("Foglio2").Select
    LastRow = Cells.SpecialCells(xlCellTypeLastCell).Row
    For i = 2 To LastRow
            name = Cells(i, 1).Value
            num = Cells(i, 3).Value
            d.Add name, num
        
    Next
    
    Sheets("Foglio1").Select
    LastRow = Cells.SpecialCells(xlCellTypeLastCell).Offset(1, 0).Row
    For i = 1 To LastRow
        If IsEmpty(Cells(i, 3)) And Not IsEmpty(Cells(i, 1)) Then
            name = Cells(i, 1).Value
            Cells(i, 3).Value = d(name)
        End If
        
    Next
    
End Sub
