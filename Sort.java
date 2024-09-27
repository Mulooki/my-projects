public class Sort{
 public static void main( String[] args){
    //assigning variable numbers.
    int numbers={5,3,8,1,2};
    //sort the array in ascending order.
    Arrays.sort(numbers);
    //Reverse the sorted array.(descending order)
    for(int i=0;i<numbers.length/2;i++){
        int temp=numbers[i];
            numbers[i]=numbers[numbers.length-1-i];
numbers[numbers.length-1-i]=temp;
    }
    //print sorted array.
system.out.println("Sorted array in descending order:"+Arrays.toString(numbers)  );

    }
}