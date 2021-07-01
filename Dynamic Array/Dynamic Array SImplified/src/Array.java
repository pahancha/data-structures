import java.util.Arrays;

public class Array {
    private int[] items;
    private int count;

    public Array(int length){
        items = new int[length];
    }

    public void print(){
        for (int i = 0; i < count; i++){
            System.out.print(items[i] + " ");
        }
    }

    public void insert(int item){
        //If the array is full, resize it
        if (items.length == count){
            //create new Array (twice the size)
            int [] newItems = new int[count * 2];
            //copy all the existing elements
            for (int i = 0; i < count; i++){
                newItems[i] = items[i];
            }
            //set items to this new array
            items = newItems;
        }
        // Add the new item at the end
        items[count] = item;
        count ++;
    }

    public void removeAt(int index){
        //validate the index. make sure the index is in the right range
        if (index < 0 || index >= count){
            throw new IllegalArgumentException();
        }
        //Shift the items to the left to fill the array
        for (int i = index; i < count; i++){
            items[i] = items[i + 1];
        }
        count--;
    }

    public int indexOf(int item){
        //If finds the items, return the index
        for (int i = 0; i < count; i++){
            if (items[i] == item){
                return i;
            }
        }
        //If not found, return -1
        return -1;
    }

    //Method to find the largest element of an array
    public int max(){
        int max = items[0];
        for (int i = 1; i < items.length; i++){
            if (items[i] > max){
                max = items[i];
            }
        }
        return max;
    }

    //Returning the common items of this array and another array.
    public void intersect(int [] nums){
        int commonCount = 0;
        for (int item : items) {
            for (int num : nums) {
                if (item == num) {
                    System.out.print(item + " ");
                    commonCount++;
                }
            }

        }
        System.out.println("\nThere are " + commonCount + " common items.");    }


    //Reversing the array
    public int[] reverse(){

        for (int i = 0; i < items.length/2; i++){
            int temp = items[i];
            items[i] = items[items.length - i - 1];
            items[items.length - i - 1] = temp;
        }
        return items;
    }

    //Method to add an element in a given index of an array.
    public int[] insertAt(int item, int index){
        if (index < 0 || index > count ){
            throw new IllegalArgumentException();
        }

        //creating a new Array with an additional space for the new element
        int [] newItems = new int[count + 1];

        for (int i = 0; i < newItems.length; i++){
            if (i < index){
                newItems[i] = items[i];
            }else if (i == index){
                newItems[i] = item;
            }else{
            newItems[i] = items[i - 1];
            }
        }
        return newItems;
    }

}
