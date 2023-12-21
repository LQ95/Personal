VERSION 1.0 CLASS
BEGIN
  MultiUse = -1  'True
END
Attribute VB_Name = "Form_Aggiorna D"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = True
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Option Compare Database
Function EliminaPuntoInterrogativo(elemento)
  If Trim(elemento & vbNullString) <> "" Then
                elemento = Replace(Replace(Replace(Replace(elemento, ChrW(8236), ""), ChrW(8234), ""), ChrW(8207), ""), ChrW(8206), "")
            End If
   EliminaPuntoInterrogativo = elemento

End Function

Private Sub Carica_Metadati_aggiorna_Click()
On Error GoTo Err_Carica_Metadati_aggiorna_Click


'ritrova la pagina attiva, e il nome del file dal form appropriato'
  Dim pagina As Form
  Set pagina = Screen.ActiveForm
  pagina.s.SetFocus
  Dim nomefile As Variant
  Dim nomefiletest As String
  nomefiletest = pagina.s.Text
    If Trim(nomefiletest & vbNullString) = "" Then
        MsgBox ("nome file vuoto")
        Exit Sub
    End If
  nomefile = pagina.s.Text & ".jpg"
  nomefile_alt = pagina.s.Text & ".jpeg"
  
  'cerca il file'
  Dim file
  Set fs = Application.FileSearch
   
    
    With fs
        fs.lookin = 'you directory name here'
            fs.SearchSubFolders = True
            fs.filename = nomefile
            If fs.Execute(SortBy:=msoSortbyFileName, SortOrder:=msoSortOrderAscending) > 0 Then
                file = fs.foundfiles(1)
            End If
    End With
    
    'trova i metadati e inserisce nel punto giusto'
    'setup'
    Dim macchina, obiettivo, formato, larghezza, altezza, ris_oriz, ris_vert, profond, rapp_colore
    Dim F_number, esposizione, sensib_iso, distanza_focale, flash, modo_esposizione
    Dim data, ora
    Dim fileFolderPath As String
    Dim fileFolder As Object
    Dim folderItem As Object
    Dim myShell
    
    'creo variabili che fanno riferimento al file e alla cartella dove sta'
    Set myShell = CreateObject("Shell.Application")
    fileFolderPath = Left(file, Len(file) - Len(nomefile))
    Set fileFolder = myShell.NameSpace(CStr(fileFolderPath))
    Set folderItem = fileFolder.ParseName(nomefile)
    ' Set folderItem = fileFolder.ParseName(filename) per trovare i nomi dei campi dei metadati'
    
   
    macchina = fileFolder.GetDetailsOf(folderItem, 30)
    
    formato = fileFolder.GetDetailsOf(folderItem, 255)
    
    larghezza = fileFolder.GetDetailsOf(folderItem, 176)
    larghezza = EliminaPuntoInterrogativo(larghezza)
    
    altezza = fileFolder.GetDetailsOf(folderItem, 178)
    altezza = EliminaPuntoInterrogativo(altezza)
            
    ris_oriz = fileFolder.GetDetailsOf(folderItem, 175)
    ris_oriz = EliminaPuntoInterrogativo(ris_oriz)
            
    ris_vert = fileFolder.GetDetailsOf(folderItem, 177)
    ris_vert = EliminaPuntoInterrogativo(ris_vert)
            
    profond = fileFolder.GetDetailsOf(folderItem, 174)
    rapp_colore = fileFolder.GetDetailsOf(folderItem, 251)
    F_number = fileFolder.GetDetailsOf(folderItem, 260)
    
    esposizione = fileFolder.GetDetailsOf(folderItem, 259)
    esposizione = EliminaPuntoInterrogativo(esposizione)
            
    sensib_iso = fileFolder.GetDetailsOf(folderItem, 264)
    sensib_iso = EliminaPuntoInterrogativo(sensib_iso)
    If Not sensib_iso = vbNullString Then
    sensib_iso = Split(sensib_iso, "-")(1)
    End If
    
    
    distanza_focale = fileFolder.GetDetailsOf(folderItem, 262)
    distanza_focale = EliminaPuntoInterrogativo(distanza_focale)
    
    flash = fileFolder.GetDetailsOf(folderItem, 261)
    modo_esposizione = fileFolder.GetDetailsOf(folderItem, 258)
    data = fileFolder.GetDetailsOf(folderItem, 12)
    data = EliminaPuntoInterrogativo(data)
    ora = Split(data)(1)
    data = Split(data)(0)
    
'  MsgBox "macchina:" & macchina & " obiettivo:" & obiettivo & " larghezza:" & larghezza & " altezza:" & altezza & " formato:" & formato
'    MsgBox " risoluzione:" & ris_oriz & " per " & ris_vert & " profondit�:" & profond & " rappresentazione colore:" & rapp_colore
'   MsgBox "F-number:" & F_number & " esposizione:" & esposizione & " sensibilit�:" & sensib_iso & " distanza focale:" & distanza_focale
'    MsgBox "flash:" & flash & " modo esposizione:" & modo_esposizione & " data :" & data & " ora :" & ora
'    Dim stringa As String
'    stringa = " "
'     For i = 308 To 330
'           stringa = stringa & "indice :" & i & " valore: " & fileFolder.getDetailsOf(folderItem, i) & vbNewLine
'       Next
'    MsgBox stringa

'sezione riguardante la lente e le interazioni coi parametri EXIF'
  Dim Lens
  Dim WSH As IWshRuntimeLibrary.WshShell
  Dim sOut, Exec
  Dim cmd
cmd = "exiftool -LensID " & """" & file & """"
Set WSH = CreateObject("WScript.Shell")

Set Exec = WSH.Exec(cmd)

Do While Exec.Status = 0
     
Loop

Set sOut = Exec.StdOut
If Not sOut.AtEndOfStream Then
Lens = sOut.ReadLine
Lens = Trim(Split(Lens, ":")(1))
Else
Lens = ""
End If


obiettivo = Lens


'metto i metadati dove devono andare'
pagina.data.SetFocus
pagina.data.Text = data
pagina.ora.SetFocus
pagina.ora.Text = ora
pagina.macchina_fotografica.SetFocus
pagina.macchina_fotografica.Text = macchina
pagina.obiettivo.SetFocus
pagina.obiettivo.Text = obiettivo
pagina.larghezza.SetFocus
pagina.larghezza.Text = Split(larghezza)(0)
pagina.altezza.SetFocus
pagina.altezza.Text = Split(altezza)(0)
pagina.risoluzione_orizzontale.SetFocus
pagina.risoluzione_orizzontale.Text = Split(ris_oriz)(0)
pagina.risoluzione_verticale.SetFocus
pagina.risoluzione_verticale.Text = Split(ris_vert)(0)
pagina.profondit�.SetFocus
pagina.profondit�.Text = profond
pagina.esposizione.SetFocus
pagina.esposizione.Text = Split(esposizione)(0)
pagina.sensibilit�.SetFocus
pagina.sensibilit�.Text = sensib_iso
pagina.distanza_focale.SetFocus
pagina.distanza_focale.Text = Split(distanza_focale)(0)
pagina.flash.SetFocus
pagina.flash.Text = flash
pagina.F_number.SetFocus
pagina.F_number.Text = Replace(Replace(F_number, ".", ","), "f/", "")
Dim modo_esp_finale As String
modo_esp_finale = Switch(modo_esposizione = "Normale", "P", modo_esposizione = "Priorit� diaframmi", "A", modo_esposizione = "Manuale", "M", modo_esposizione = "Priorit� tempi", "S")
pagina.modo_esposizione.SetFocus
pagina.modo_esposizione.Text = modo_esp_finale


    
    








Exit_Carica_Metadati_aggiorna_Click:
    Exit Sub

Err_Carica_Metadati_aggiorna_Click:
    MsgBox Err.Description
    Resume Exit_Carica_Metadati_aggiorna_Click
    
End Sub
