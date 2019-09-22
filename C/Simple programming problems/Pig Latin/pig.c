#include "pig.h"
char *toPigLatin(char *word){
	char *newword=malloc(sizeof(char)*40);
	char first=word[0];
	if(strlen(word)>1) 
		word++;//increase pointer to the first charachter to one position forward,effectively cutting of the first charachter of the string
	strcat(newword,word);
	if(strlen(word)>1)
		strcat(newword,&first);
	strcat(newword,"ay");
	return newword;
}

char *fromPigLatin(char *word){
	char *newword="";
	int length=strlen(word);
	char first=word[length-3];
	strcat(newword,&first);
	if((length-4)>1)strncat(newword,word,length-4); //cut off the 'ay' and the misplaced first charachter;
	return newword;
}

char *convertToPig(char *data){
	char *currentword;
	char *pig;
	int length;
	if(data!=NULL){
		length=strlen(data);
		pig=calloc(length,sizeof(char));
		currentword=strtok(data," ");
		printf("arriva qui?%s",currentword);
		while(currentword!=NULL){ 
				currentword=toPigLatin(currentword);
				printf("\narriva qui?\n%s",currentword);
				strcat(pig,currentword);
				strcat(pig," ");
				currentword=strtok(NULL," ");	
			}
		}
	return pig;
}

char *convertFromPig(char *data){
	char *currentword;
	char *converted;
	int length;
	if(data!=NULL)
		{
			length=strlen(data);
			converted=calloc(length,sizeof(char));
			currentword=strtok(data," ");
			while(currentword!=NULL){
					currentword=fromPigLatin(currentword);
					strcat(converted,currentword);
					strcat(converted," ");					
					currentword=strtok(NULL," ");	
				}
	
		}
		return converted;
}