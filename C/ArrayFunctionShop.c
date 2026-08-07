#include<stdio.h>
#include<limits.h>


void DisplayArray(int size,int arr[]);
void CreateArray(int size ,int arr[]);
void ReverseArray(int size,int arr[]);
int MaximumElement(int size , int arr[]);
int MinimumElement(int size , int arr[]);
int SumOfArray(int size,int arr[]);
void Average(int size,int arr[]);
float percentage(int size , int arr[]);
int GreateSecondInt(int size,int arr[]);
void reversingSwap(int size,int arr[]);
int LinearSearch(int size, int arr[],int key);
void ReverseByParts(int arr[],int si,int ei);
int PalindromeCheck(int size,int arr[]);
void CheckDuplicate(int size,int arr[]);

int main(){
    printf("\n__________ WELCOME TO ARRAY SHOP __________\n");

    int size,choice,created=0;
    float grade;

    printf("Enter size of array: ");
    scanf("%d",&size);

    int arr[size];
    char ask;

    do{
        printf("\nMENU:\n");
        printf("1. Create Array\n2. Display Array\n3. Reverse Array\n");
        printf("4. Maximum Element\n5. Minimum Element\n6. Sum\n");
        printf("7. Average\n8. Percentage\n9. Grade\n");
        printf("10. Second Largest\n11. Reverse (Swap)\n");
        printf("12. Linear Search\n13. Shift Array\n");
        printf("14. Palindrome Check\n15. Check Duplicate\n");

        printf("Enter choice: ");
        scanf("%d",&choice);

        if(choice!=1 && created==0){
            printf("⚠ First create the array!\n");
        }
        else{
            switch(choice){

            case 1:
                CreateArray(size,arr);
                created=1;
                break;

            case 2:
                DisplayArray(size,arr);
                break;

            case 3:
                ReverseArray(size,arr);
                break;

            case 4:
                printf("Max = %d\n",MaximumElement(size,arr));
                break;

            case 5:
                printf("Min = %d\n",MinimumElement(size,arr));
                break;

            case 6:
                printf("Sum = %d\n",SumOfArray(size,arr));
                break;

            case 7:
                Average(size,arr);
                break;

            case 8:
                printf("Percentage = %.2f\n",percentage(size,arr));
                break;

            case 9:
                grade = percentage(size,arr);

                if(grade > 90) printf("Grade A+\n");
                else if(grade > 80) printf("Grade A\n");
                else if(grade > 70) printf("Grade B+\n");
                else if(grade > 60) printf("Grade B\n");
                else if(grade > 50) printf("Grade C\n");
                else if(grade > 40) printf("Grade D\n");
                else if(grade >= 33) printf("Grade E\n");
                else printf("Fail\n");

                break;

            case 10:
                printf("Second Largest = %d\n",GreateSecondInt(size,arr));
                break;

            case 11:
                reversingSwap(size,arr);
                break;

            case 12:{
                int key;
                printf("Enter value to search: ");
                scanf("%d",&key);

                int pos = LinearSearch(size,arr,key);

                if(pos == -1)
                    printf("Not Found\n");
                else
                    printf("Found at index %d\n",pos);
                break;
            }

            case 13:{
                int k;
                printf("Enter shift steps: ");
                scanf("%d",&k);

                k = k % size;

                ReverseByParts(arr,0,size-1);
                ReverseByParts(arr,0,k-1);
                ReverseByParts(arr,k,size-1);

                DisplayArray(size,arr);
                break;
            }

            case 14:
                if(PalindromeCheck(size,arr))
                    printf("Palindrome\n");
                else
                    printf("Not Palindrome\n");
                break;

            case 15:
                printf("Duplicates: ");
                CheckDuplicate(size,arr);
                break;

            default:
                printf("Invalid choice!\n");
            }
        }

        printf("\nContinue? (Y/N): ");
        scanf(" %c",&ask);

    }while(ask=='Y' || ask=='y');

    return 0;
}

// ================= FUNCTIONS =================

void CreateArray(int size ,int arr[]){
    for(int i=0;i<size;i++){
        printf("Enter element %d: ",i+1);
        scanf("%d",&arr[i]);

        // validation
        if(arr[i] < 0 || arr[i] > 100){
            printf("Invalid marks! Re-enter\n");
            i--;
        }
    }
}

void DisplayArray(int size,int arr[]){
    printf("Array: ");
    for(int i=0;i<size;i++){
        printf("%d ",arr[i]);
    }
    printf("\n");
}

void ReverseArray(int size,int arr[]){
    printf("Reverse: ");
    for(int i=size-1;i>=0;i--){
        printf("%d ",arr[i]);
    }
    printf("\n");
}

int MaximumElement(int size , int arr[]){
    int max = INT_MIN;
    for(int i=0;i<size;i++){
        if(arr[i] > max)
            max = arr[i];
    }
    return max;
}

int MinimumElement(int size , int arr[]){
    int min = INT_MAX;
    for(int i=0;i<size;i++){
        if(arr[i] < min)
            min = arr[i];
    }
    return min;
}

int SumOfArray(int size,int arr[]){
    int sum = 0;
    for(int i=0;i<size;i++){
        sum += arr[i];
    }
    return sum;
}

void Average(int size,int arr[]){
    printf("Average = %.2f\n",(float)SumOfArray(size,arr)/size);
}

float percentage(int size , int arr[]){
    return (float)SumOfArray(size,arr)/(size*100)*100;
}

int GreateSecondInt(int size,int arr[]){
    int max = INT_MIN, smax = INT_MIN;

    for(int i=0;i<size;i++){
        if(arr[i] > max){
            smax = max;
            max = arr[i];
        }
        else if(arr[i] > smax && arr[i] != max){
            smax = arr[i];
        }
    }
    return smax;
}

void reversingSwap(int size,int arr[]){
    for(int i=0,j=size-1;i<j;i++,j--){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    DisplayArray(size,arr);
}

int LinearSearch(int size, int arr[],int key){
    for(int i=0;i<size;i++){
        if(arr[i] == key)
            return i;
    }
    return -1;
}

void ReverseByParts(int arr[],int si,int ei){
    for(int i=si,j=ei;i<j;i++,j--){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

int PalindromeCheck(int size,int arr[]){
    for(int i=0;i<size;i++){
        if(arr[i] != arr[size-1-i])
            return 0;
    }
    return 1;
}

void CheckDuplicate(int size,int arr[]){
    for(int i=0;i<size;i++){
        for(int j=i+1;j<size;j++){
            if(arr[i] == arr[j]){
                printf("%d ",arr[i]);
                break;
            }
        }
    }
    printf("\n");
}