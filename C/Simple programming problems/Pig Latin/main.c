#include "pig.h"

int main(){
	char *pig,*normal;
	pig=convertToPig("I am testing my converter to and from Pig Latin");
	printf("%s",pig);
	normal=convertToPig(pig);
	printf("%s",normal);
}
