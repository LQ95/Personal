#include "lib.h"
char *toLowerCase(char *data)
{
	int i=0;
	while(data[i]!='\0')
		{
			if(data[i]>64 && data[i]<91)
				data[i]+=32;
			i++;
		}
	return data;
}
//convert from letters to numbers
void convert(char *data)
{
	int i=0;
	data=toLowerCase(data);
	while(data[i]!='\0')
	{
		if(data[i]>96)
			{
				printf(" %d ",data[i]-96);
			}
		i++;
	}
}