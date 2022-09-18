public class MaxValueWhile {
  public static int max(int[] m) {
    int max_value = m[0];
    int i = 0;
    while(i<m.length){
        if(max_value < m[i]){
            max_value = m[i];
        }
        i++;
    }
    return max_value;
  }
  public static void main(String[] args) {
     int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};      
     System.out.println(max(numbers));
  }
}