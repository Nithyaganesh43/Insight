import java.util.Arrays;

public class main {

    public static int[] findDistinctNumbers(int[] arr) {
        int xorResult = 0;

       
        for (int num : arr) {
            xorResult ^= num;
        }

        
        int setBit = xorResult & -xorResult;  
        int num1 = 0, num2 = 0;

        
        for (int num : arr) {
            if ((num & setBit) != 0) {
                num1 ^= num;  
            } else {
                num2 ^= num;  
            }
        }

        
        int[] result = new int[]{Math.min(num1, num2), Math.max(num1, num2)};
        return result;
    }

    public static void main(String[] args) {
        
        int[] arr1 = {1, 2, 3, 2, 1, 4};
        System.out.println(Arrays.toString(findDistinctNumbers(arr1)));  

    }
}
