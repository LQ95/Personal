<?php
if($_POST["userin"]=="barbie")
{
header("location: /Nuovo.html");
exit;
};
if($_POST["azione"]=="n"){
echo "Lunghezza: ".strlen($_POST["userin"])." caratteri";
	}elseif($_POST["azione"]=="m"){
echo "La parola al contrario:  ".strrev($_POST["userin"]);
	}else{
echo"Terza opzione selezionata";
}
?>