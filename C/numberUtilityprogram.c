#include<stdio.h>
#include <unistd.h>
#include<math.h>

int main(){
    int choice,num;char repeat;

    do{
        printf("\n-------------------Welcome to the Number Ulitility Program--------------------\n");
        printf("\nLoading");sleep(1);printf(".");sleep(1);printf(".");sleep(1);printf(".");sleep(1);printf(".");
        sleep(1);
        printf("\nDisplay Menu : \n");sleep(1);
        printf("\t1.Prime\n");
        printf("\t2.Palindrome\n");
        printf("\t3.Armstrong\n");
        printf("\t4.factorial\n");
        printf("\t5.Exit\n");



        
        
        printf("Enter the choice : ");
        scanf("%d",&choice);
        if (choice!=5){
        
            printf("Enter the number : ");
            scanf("%d",&num);


            switch (choice){
                case 1 : {
                    printf("\nLoading");sleep(1);printf(".");sleep(1);printf(".");sleep(1);printf(".");sleep(1);printf(".");
                    printf("\nPrime Number\n");sleep(1);

                    int isPrime=1;

                    if(num==1){
                        isPrime=0;
                    }
                    else{
                        for(int i = 2 ; i <=num/2 ; i++){
                        if(num%i==0){
                            isPrime = 0;
                            break;
                        }
                    }
                    }
                    
                    if(isPrime){
                        printf("its a prime number");
                    }
                    else{
                        printf("its not prime");
                    }
                    
                    break;

                }
                case 2 : {
                    printf("\nLoading");sleep(1);printf(".");sleep(1);printf(".");sleep(1);printf(".");sleep(1);printf(".");
                    printf("\nPalindrome Number Tool\n");sleep(1);
                    int res=0,last,temp=num;
                    while(temp>0){
                        last=temp%10;
                        res=res*10+last;
                        temp/=10;
                    }
                    
                    if(num == res){
                        printf("\nYes this num is a Palindrome\n");break;
                    }
                    else{
                        printf("\nits not a palindrome,dude\n");break;
                    }
                  
                }
                case 3 : {
                    printf("\nLoading");sleep(1);printf(".");sleep(1);printf(".");sleep(1);printf(".");sleep(1);printf(".");
                    printf("\nArmstong Number\n");sleep(1);
                    int sum=0,temp=num,last,count=0,product=num;
                    while(product>0){
                        count++;product/=10;
                    }
                    
                    while(temp>0){
                        last=temp%10;
                        sum=sum+(int)pow(last,count);
                        temp/=10;
                        
                    }
                    if(num == sum ){
                        printf("its a armstrong ");break;
                    }
                    else{
                        printf("its a not armstrong ");break;
                    }

                    
                    
                    
                    
                    
                    
                }
                case 4 : {
                    printf("\nLoading");sleep(1);printf(".");sleep(1);printf(".");sleep(1);printf(".");sleep(1);printf(".");
                    printf("\nFactorial Number\n");
                    int fact=1;
                    if(num<0){
                        printf("Not defined");
                    }
                    else{
                        for (int i=1;i<num+1;i++){
                        fact*=i;
                    }
                    printf("\nFactorial of %d! is %d\n",num,fact);
                    }
                    
                    
                    
                    
                    sleep(1);break;
                    
                }
                case 5 : {
                    printf("exit");
                
                    
                    
                    
                    
                    break;
                    
                }
                default : {
                    
                    printf("\ninvalid choice entered \n");break;
                }
            }
            printf("\nDo you want play more ?(Y/N) : \n");
            scanf(" %c",&repeat);


        }
    }
    while(repeat=='Y' || repeat=='y');
    printf("\nLoading");sleep(1);printf(".");sleep(1);printf(".");sleep(1);printf(".");sleep(1);printf(".");
    printf("\nThe End\n");
    printf("\n_________________________________The End_________________________________________________\n");



    






    return 0;
}