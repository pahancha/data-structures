import java.util.Iterator;

@SuppressWarnings("unchecked") //tells the compiler that the programmer believes the code to be safe and won't cause unexpected exceptions. (Annoying Generics in Java :()

public class DynamicArray<T> implements Iterable<T>{

    private T[] arr; //Internal Static Array.
    private int len = 0; //Length of the array according to the user.
    private int capacity = 0; //Actual length of the array.

    public DynamicArray(){
        this(16); // Giving the size of the array to 16.
    }

    public DynamicArray(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Illegal Capacity of: " + capacity);
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public int size(){
        return len; //Outputting the length of the array.
    }

    public T get(int index) {
        return arr[index];
    }

    public void set(int index, T element){
        arr[index] = element;
    }

    public void clear(){
        for(int i = 0; i < capacity; i++){
            arr[i] = null;
            len = 0;
        }
    }

    public void add(T element){
        //Resizing the array,
        if(len + 1 >= capacity){
            if(capacity == 0){
                capacity = 1;
            }else{
                capacity = capacity * 2; //Doubling the size of the static array.
            }
            T[] newArr = (T[]) new Object[capacity];
            for(int i = 0; i < len; i++){ //copying all the elements back into a new Array.
                newArr[i] = arr[i];
            }
            arr = newArr; // array with extra nulls to fill the rest of the array
        }
        arr[len++] = element;
    }

    //Removes and element at the specific index in the list.
    public T removeAt(int remove_index){
        if(remove_index >= len && remove_index < 0) throw new IndexOutOfBoundsException();
        T data = arr[remove_index];
        T[] newArr = (T[]) new Object[len-1];
        for(int i = 0, j= 0; i < len; i++, j++){
            if(i == remove_index){
                j--;
            }else{
                newArr[j] = arr[i];
            }
        }
        arr = newArr;
        capacity = --len;
        return data;
    }

    public boolean remove(Object obj){
        for(int i = 0; i < len; i++){
            if(arr[i].equals(obj)){
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    public int indexOf(Object obj){
        for(int i = 0; i < len; i++){
            if(arr[i].equals(obj)){
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Object obj){
        return indexOf(obj) != -1;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < len;
            }

            @Override
            public T next() {
                return arr[index++];
            }
        };
    }

    @Override
    public String toString() {
        if(len == 0) return "[]";
        else{
            StringBuilder stringBuilder = new StringBuilder(len).append("[");
            for(int i = 0; i < len-1; i++){
                stringBuilder.append(arr[i] + ", ");
            }
            return stringBuilder.append(arr[len-1] + "]").toString();

        }
    }
}
