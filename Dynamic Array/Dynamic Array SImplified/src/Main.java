import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Array numbers = new Array(8);
        numbers.insert(2);
        numbers.insert(1);
        numbers.insert(3);
        numbers.insert(5);
        numbers.insert(8);
        numbers.insert(9);
        numbers.insert(2);
        numbers.insert(12);

        // PLAY GROUND!




    }

    private static void printingReturningArray(int[] array) {
        for (int i = 0; i < array.length; i++){
            System.out.println(array[i] + " ");
        }
    }
}
