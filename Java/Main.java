import java.util.Arrays;

public class Main {
   public static void main(String[] args) throws Exception {
      int[] ary = {1,2,3,4,5,6};
      int[] ary1 = {1,2,3,4,5,6};
      int[] ary2 = {1,2,3,4};
      System.out.println(ary==ary1);
      System.out.println(ary==ary2);
      System.out.println((ary.equals(ary1)));
      System.out.println((ary.equals(ary2)));
      System.out.println(Arrays.equals(ary, ary1));
      System.out.println(Arrays.equals(ary, ary2));
   }
}