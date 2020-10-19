Attribute VB_Name = "Modulo1"
Sub Correzione_MMSI_renitenti()
Dim RowIndex As Long
Dim LastRow As Long
Dim ship_and_cargo_col As Integer
Dim signal_col As Integer
Dim MMSI_col As Integer
Dim MMSI As Long
Dim ShipAndCargo As Long
Dim MMSI_next As Long
Dim ShipAndCargo_next As Long
ship_and_cargo_col = 2
signal_col = 3
MMSI_col = 1
Sheets("Foglio1").Select
LastRow = Cells.SpecialCells(xlCellTypeLastCell).Row
Call CountUnique
For RowIndex = 2 To LastRow
If Not IsEmpty(Cells(RowIndex, MMSI_col)) Then
        MMSI = Cells(RowIndex, MMSI_col)
        MMSI_next = Cells(RowIndex + 1, MMSI_col)
        ShipAndCargo = Ship_and_cargo_load(RowIndex, ship_and_cargo_col, signal_col)
        ShipAndCargo_next = Ship_and_cargo_next_load(RowIndex, ship_and_cargo_col, signal_col)
        If MMSI = MMSI_next Then
            ' cancella ogni riga dove
            ' MMSI e ship_and_cargo_type sono uguali
            Do While ShipAndCargo = ShipAndCargo_next And MMSI = MMSI_next
                Rows(RowIndex).EntireRow.Delete
                MMSI = Cells(RowIndex, MMSI_col)
                MMSI_next = Cells(RowIndex + 1, MMSI_col)
                ShipAndCargo = Ship_and_cargo_load(RowIndex, ship_and_cargo_col, signal_col)
                ShipAndCargo_next = Ship_and_cargo_next_load(RowIndex, ship_and_cargo_col, signal_col)
            
            Loop
            ' Se è solo l'MMSI a essere uguale
            ' viene segnalato
            If MMSI = MMSI_next Then
                
                Call Ship_and_cargo_null_check(RowIndex, ship_and_cargo_col, signal_col)
                GoTo Continue
            End If
            ' altrimenti se lo ship_and_cargo_type non è valido
            ' viene segnalato
        ElseIf ShipAndCargo >= 10 Or ShipAndCargo <= 99 Then
           GoTo Continue
        Else
            Cells(RowIndex, signal_col) = "da cercare"
        End If
End If
Continue:
Next
Call CountUnique
If IsEmpty(Cells(RowIndex, MMSI_col)) Then
    Cells(RowIndex, signal_col) = ""
End If
End Sub

Private Function Ship_and_cargo_load(RowIndex As Long, ship_and_cargo_col As Integer, signal_col As Integer) As Long

If IsEmpty(Cells(RowIndex, ship_and_cargo_col)) Or StrComp(Cells(RowIndex, ship_and_cargo_col).Text, "NO CODE") = 0 Then
             Cells(RowIndex, signal_col) = "da cercare"
             Ship_and_cargo_load = 0
        Else
             Ship_and_cargo_load = Cells(RowIndex, ship_and_cargo_col)
        End If
End Function

Private Function Ship_and_cargo_next_load(RowIndex As Long, ship_and_cargo_col As Integer, signal_col As Integer) As Long

If IsEmpty(Cells(RowIndex + 1, ship_and_cargo_col)) Or StrComp(Cells(RowIndex + 1, ship_and_cargo_col).Text, "NO CODE") = 0 Then
            Cells(RowIndex + 1, signal_col) = "da cercare"
            Ship_and_cargo_next_load = 0
        Else
            Ship_and_cargo_next_load = Cells(RowIndex + 1, ship_and_cargo_col)
        End If

End Function
'
'Questa funzione presume che gli MMSI siano uguali
'
Private Sub Ship_and_cargo_null_check(RowIndex As Long, ship_and_cargo_col As Integer, signal_col As Integer)
                Dim ShipAndCargo, ShipandCargoNext As Long
                ShipAndCargo = Ship_and_cargo_load(RowIndex, ship_and_cargo_col, signal_col)
                ShipandCargoNext = Ship_and_cargo_load(RowIndex + 1, ship_and_cargo_col, signal_col)
                
                If ShipandCargoNext = 0 And ShipAndCargo > 0 Then
                    Rows(RowIndex + 1).EntireRow.Delete
                    RowIndex = RowIndex - 1
                ElseIf ShipandCargoNext > 0 And ShipAndCargo = 0 Then
                    Rows(RowIndex).EntireRow.Delete
                    RowIndex = RowIndex - 1
                Else
                    Cells(RowIndex, signal_col) = "da cercare"
                    Cells(RowIndex + 1, signal_col) = "da cercare"
                End If
End Sub

Private Sub CountUnique(Optional value_col As Integer = 1)
Dim RowIndex As Long
Dim LastRow As Long
Dim count As Integer
Dim value As Long
Dim value_prev As Long
value_prev = 999
count = 0
LastRow = Cells.SpecialCells(xlCellTypeLastCell).Row
For RowIndex = 2 To LastRow
    If Not IsEmpty(Cells(RowIndex, value_col)) Then
        value = Cells(RowIndex, value_col)
        If Not value = value_prev Then
            count = count + 1
        End If
        value_prev = value
    End If
Next

MsgBox "ci sono " & count & " valori unici"

End Sub
