#include "util.h"
#include <stdio.h>
#include <stdlib.h>

int main() {
    Map map;
    init(&map);
    //READ FROM FILE
    FILE* input;
    const char filename[]="file.txt";
    input=fopen(filename ,"r");
    if(input==NULL) {
        printf("There is no such file\n"); }
    else {
        char str[WORD_BUFFER_SIZE];
        while(fscanf(input,"%s",str)==1){
            int num=get(&map,str);

            set(&map,str,num+1); 
        }
    }
    fclose(input);
    

    char str[]="orange";
    Pair* pair=find(&map, str);
    if(pair==NULL) printf("Element was not found\n");
    else  printf("%s and %d\n",pair->str , pair->num); 

    
    print(&map);



    dest(&map);

 return 0;
}