#include "lib.h"

int main(){
	char input[256];
	printf("Insert some words(alphanumeric chachters only,max 256 letters)\n");
	gets(input);
	convert(input);
	return 0;
}