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
Dim MMSI_col As Integer
Dim ship_and_cargo_col As Integer
MMSI_col = 3
ship_and_cargo_col = 16
'
    Sheets("tabella MMSI").Select
    LastRow = Cells.SpecialCells(xlCellTypeLastCell).Row
    For i = 2 To LastRow
            name = Cells(i, 1).Value
            num = Cells(i, 2).Value
            If Not d.Exists(name) Then
                d.Add name, num
            End If
    Next
    
    Sheets("dati dinamici ").Select
    LastRow = Cells.SpecialCells(xlCellTypeLastCell).Offset(1, 0).Row
    For i = 1 To LastRow
        If IsEmpty(Cells(i, ship_and_cargo_col)) And Not IsEmpty(Cells(i, MMSI_col)) Then
            name = Cells(i, MMSI_col).Value
            Cells(i, ship_and_cargo_col).Value = d(name)
        End If
        
    Next
    
End Sub
