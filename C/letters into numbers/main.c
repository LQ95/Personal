#include "lib.h"

int main(){
	char input[256];
	printf("inserisci una frase\n");
	gets(input);
	convert(input);
	return 0;
}