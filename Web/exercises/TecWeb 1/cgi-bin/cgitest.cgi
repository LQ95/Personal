#!"C:\xampp\perl\bin\perl.exe"
my $string=$ENV{QUERY_STRING};
my $name;
my $surname;
my $litri;
my $data;
my $genere;
@couples= split('&',$string);

if($string){
@couple= split('=',$couples[0]);
$name= $couple[1];
@couple= split('=',$couples[1]);
$surname= $couple[1] ;
@couple= split('=',$couples[2]);
$litri= $couple[1];
@couple= split('=',$couples[3]);
$data= $couple[1];
$data=~ s/%2F/-/g;
@couple= split('=',$couples[4]);
$genere= $couple[1];
$genere=~ s/\+/ /g;
}
print "Content-Type: text/html\n\n";
print '<html>';
print '<head>';
print '<title>CGI TEST</title>';
print '</head>';
print '<body>';
if($data && $genere)
{
print "Ti chiami ".$name." ".$surname."<br/>";
print "Emetti ".$litri." litri di pianto annuali<br/>";
print "Sei ".$genere." classe ".$data;
}
else{
print  '<form method="GET" action="/cgi-bin/cgitest.cgi">';
print  '<input type="hidden" name="nome" value="'.$name.'"><br>';
print  '<input type="hidden" name="cognome" value="'.$surname.'">';
print  '<input type="hidden" name="litri" value="'.$litri.'">';
print  '<label for="data">Inserisci la tua data di nascita:</label><br>';
print  '<input type="text" name="data"><br>';
print  '<label for="genere">Inserisci il tuo genere:</label><br>';
print  '<input type="text" name="genere">';
print 	'<input type="submit" value="invia">';
print  '</form>';
}
print '</body>';
print '</html>';
  