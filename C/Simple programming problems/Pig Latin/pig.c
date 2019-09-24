#include "pig.h"
char *toPigLatin(char *word){
	char *newword=malloc(sizeof(char)*(strlen(word)+2));
	char first=word[0];
	if(strlen(word)>1)
		{
			word++;//increase pointer to the first charachter to one position forward,effectively cutting of the first charachter of the string
			strcpy(newword,word);
			strncat(newword,&first,1);
		}
	else strcpy(newword,word);
	strncat(newword,"ay",2);
	return newword;
}

char *fromPigLatin(char *word){
	char *newword=calloc(strlen(word)-2,sizeof(char));
	int length=strlen(word);
	char first=word[length-3];//find former first charachter and put it back in it's place
	strncpy(newword,&first,1);
	if((length-3)>0)
		{
			word[length-3]='\0';//cut off the 'ay' and the misplaced first charachter;
			strcat(newword,word); 
		}
	else newword[1]='\0';//one letter word string terminator
	return newword;
}

char *convert(char *data,bool pigMode){
	char *currentword;
	char *converted;
	int length;
	if(data!=NULL){
		length=strlen(data);
		converted=calloc(length,sizeof(char));
		currentword=strtok(data," ");
		while(currentword!=NULL){ 
				if(pigMode==true)
					currentword=toPigLatin(currentword);
				else currentword=fromPigLatin(currentword);
				strcat(converted,currentword);
				strcat(converted," ");
				currentword=strtok(NULL," ");	
			}
		}
	return converted;
}

