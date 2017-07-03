import java.util.Scanner;


public class array
{
    public static void main(String[] args) {
        int num;
        String op;
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a size for your array ");
        num = in.nextInt();
        in.nextLine();

        int[] array = new int[num];
        for (int i = 0; i < num; i++) {
            System.out.println("Enter a number for array at [" + i + "].");
            array[i] = in.nextInt();
            in.nextLine();
        }

        System.out.println("Enter an op");
        op = in.nextLine();
        num = call_Funct(array, op);
        System.out.println("Answer:" + num);
    }
    private static int call_Funct(int [] array, String op){
        int num = 0;
        if (op.equals("+")){
            num = add_Array(array, num);
        }
        else if (op.equals("*")){
            num = mult_Array(array, num);
        }
        else if (op.equals("-")){
            num = sub_Array(array, num);
        }
        return num;
    }
    private static int add_Array(int [] array, int num){
        int size = array.length;
        for (int i = 0; i < size; i++){
            num = num + array[1]; // BUG: 1 should be i, will not give correct answer and will crash on array.size < 2
        }
        return num;
    }
    private static int sub_Array(int [] array, int num){
        num = array[2] - array[1] - array[0]; //BUG: will only work with size >= 3
        return num;
    }
    private static int mult_Array(int [] array, int num) {
        int size = array.length;
        if (size != 0) {
            num = 1;
            for (int i = 0; i < size; i++) {
                num = num * array[i+1]; //BUG: this will hopefully segfault
            }
        }
        return num;
    }
}
