#include "pig.h"

int main(){
	char *pig,*normal;
	char message[]="I am testing my converter to and from Pig Latin";
	pig=convertToPig(message);
	printf("Pig Latin\n%s\n",pig);
	normal=convertFromPig(pig);
	printf("Normal:\n%s",normal);
}
