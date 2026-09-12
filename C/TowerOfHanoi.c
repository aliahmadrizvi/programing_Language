#include<stdio.h>
int main(void)
{
    int n = 1;
    towerOfHanoi(n,'S','H','D');
    return 0 ;
}
static void towerOfHanoi(int n,char src,char helper,char dest)
{
    if(n==1){
        printf("transfer disk %d from %c to %c",n,src,dest);
        return;


    }
    towerOfHanoi(n-1,src,dest,helper);
    printf("transfer disk %d from %c to %c",n,src,dest);
    towerOfHanoi(n-1,helper,src,dest);


}