#include "pig.h"

int main(){
	char *pig,*normal;
	char message[]="I am testing my converter to and from Pig Latin";
	pig=convert(message,true);
	printf("\n\nPig Latin\n%s\n",pig);
	normal=convert(pig,false);
	printf("\nNormal:\n%s\n\n",normal);
}
