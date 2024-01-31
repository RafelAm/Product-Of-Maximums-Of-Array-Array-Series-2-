import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;
import java.util.*;

public class ProductOfMaximumsOfArray
{
    @Test
    public void Return_Maximum_Product()
    {
        assertEquals(20, Solution.maxProduct(new int[]{4,3,5}, 2));
        assertEquals(720, Solution.maxProduct(new int[]{10,8,7,9}, 3));
        assertEquals(288, Solution.maxProduct(new int[]{8,6,4,6}, 3));
    }
    @Test
    public void Checks_Larger_Vector_Size()
    {
        assertEquals(9600, Solution.maxProduct(new int[]{10,2,3,8,1,10,4}, 5));
        assertEquals(247895375, Solution.maxProduct(new int[]{13,12,-27,-302,25,37,133,155,-14}, 5));
    }
    @Test
    public void Checks_Negative_Values()
    {
        assertEquals(4, Solution.maxProduct(new int[]{-4,-27,-15,-6,-1}, 2));
        assertEquals(136, Solution.maxProduct(new int[]{-17,-8,-102,-309}, 2));
    }
    @Test
    public void Checks_Mixture_Values()
    {
        assertEquals(-30, Solution.maxProduct(new int[]{10,3,-27,-1}, 3));
        assertEquals(-253344, Solution.maxProduct(new int[]{14,29,-28,39,-16,-48}, 4));
    }
    @Test
    public void Random_Tests()
    {
        for (int i = 0; i < 100; i++)
        {
            int[] a = new int[(int)(Math.random() * 200) + 3];
            Arrays.setAll(a, j -> (int)(Math.random() * 201) - 100);
            int n = (int)(Math.random() * a.length);
            assertEquals(solution(a, n), Solution.maxProduct(a, n));
        }
    }
    public static long solution(int[] numbers, int sub_size)
    {
        Arrays.sort(numbers);
        long product = 1;
        for (int i = 0; i < sub_size; i++) product *= numbers[numbers.length-i-1];
        return product;
    }
}



public class Solution
{
    public static long maxProduct(int[] numbers, int sub_size){
      
    long res = 1;
      
      for(int i = 0; i < numbers.length-1; i++){
        for(int j = 0; j < numbers.length-1-i; j++){
          if(numbers[j]<numbers[j + 1]){
           int temp = numbers[j]; 
            numbers[j] = numbers[j+1];
            numbers[j+1] = temp;
          }
        }
      }
      for(int j = 0; j < sub_size; j++){
        
          res =  res*numbers[j]; 
        
      }
      
        return res;
    }
}
