#include "pig.h"
char *toPigLatin(char *word){
	char *newword=malloc(sizeof(char)*(strlen(word)+3));
	char first=*word;
	if(strlen(word)>1)
		{
			word++;//increase pointer to the first charachter to one position forward,effectively cutting of the first charachter of the string
			strncpy(newword,word,strlen(word));
			strncat(newword,&first,1);
		}
	else strcpy(newword,word);
	strncat(newword,"ay",2);
	printf("\n convertito in \n %s %s %c",newword,word,first);
	return newword;
}

char *fromPigLatin(char *word){
	char *newword=malloc(sizeof(char)*40);
	int length=strlen(word);
	char first=word[length-3];
	strncpy(newword,&first,1);
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
				printf("\nda convertire:%s\n\n",currentword);
				currentword=toPigLatin(currentword);
				strcat(pig,currentword);
				strcat(pig," ");
				printf("\n\ntesto convertito:\n%s\n",pig);
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