def swap(arr,i,min):
    temp = arr[min]
    arr[min]=arr[i]
    arr[i] = temp     
def printArr(arr):
    for i in range(0,len(arr)-1):
        print(arr[i],end=" ")       
# seletion sort 
def selectionSort(arr):
    n = len(arr)
    for i in range(0,n-2):
        min = i 
        for j in range(i,n-1):
            if(arr[j]<arr[min]):
                min = j 
        # arr[min],arr[i] = arr[i],arr[min]
        swap(arr,i,min)
# bubble sort
def bubbleSort(arr):
    n=len(arr)
    for i in range(n-1,0,-1):
        for j in range(0,i):
            if(arr[j]>arr[j+1]):
                swap(arr,j,j+1)
# insertion sort
def insertionSort(arr):
    n=len(arr)
    for i in range(0,n-1):
        j=i
        while(j>0 and arr[j-1]>arr[j]):
            swap(arr,j,j-1)
            j-=1
        
#__main__

arr = [90,4,32,45,11,0,3]
print("Unsorted Array: ",end=" ")
printArr(arr)
print()
print("Sorted Array: ",end=" ")
insertionSort(arr)
printArr(arr)
