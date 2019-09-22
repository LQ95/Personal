#include "pig.h"
char *toPigLatin(char *word){
	char *newword;
	char first=word[0];
	word++;//increase pointer to the first charachter to one position forward,effectively cutting of the first charachter of the string
	strcat(newword,word);
	strcat(newword,&first);
	strcat(newword,"ay");
	return newword;
}

char *fromPigLatin(char *word){
	char *newword;
	int length=strlen(word);
	char first=word[length-2];
	strcat(newword,&first);
	strncat(newword,word,length-3); //cut off the 'ay' and the misplaced first charachter;
	return newword;
}

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
				currentword=toPigLatin(currentword);
				strcat(pig,currentword);
				strcat(pig,&separator);
				currentword=strtok(NULL,&separator);	
			}
		}
	return pig;
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
					currentword=fromPigLatin(currentword);
					strcat(converted,currentword);
					strcat(converted,&separator);					
					currentword=strtok(NULL,&separator);	
				}
	
		}
		return converted;
}