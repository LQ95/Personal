#include "pig.h"

char *convertToPig(char *data){
	char *currentword;
	char *pig;
	const char separator=' ';
	int length;
	if(data!=NULL){
		length=strlen(data);
		pig=malloc(sizeof(char)*length);
		currentword=strtok(data,&separator);
		while(currentword!=NULL){
				strcat(pig,currentword);
				strcat(pig,&separator);
				currentword=strtok(NULL,&separator);	
			}
		
}

char *convertFromPig(char *data){
	char *currentword;
	char *converted;
	const char separator=' ';
	int length;
	if(data!=NULL)
		{
			length=strlen(data);
			converted=malloc(sizeof(char)*length);
			currentword=strtok(data,&separator);
			while(currentword!=NULL){
					strcat(converted,currentword);
					trcat(converted,&separator);					
					currentword=strtok(NULL,&separator);	
				}
}