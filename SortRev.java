package sunita;

import java.util.Scanner;

public class SortRev {
   public SortRev() {
   }

   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      System.out.print("n = ");
      int count = scan.nextInt();
      int[] arr = new int[count];

      // for(int n = 0; n < count; ++n) {
      // arr[n] = scan.nextInt();
      // System.out.print(arr[n] + " ");
      // }
      System.out.print("\n");

      for (int i = 0; i < count - 1; ++i) {
         for (int j = 0; j < count - i - 1; ++j) {
            if (arr[j] > arr[j + 1]) {
               int temp = arr[j];
               arr[j] = arr[j + 1];
               arr[j + 1] = temp;
            }
         }
      }

      int index = 0;
      System.out.print("st = ");
      int mode = scan.nextInt();
      if (mode == 1) {
         index = 0;
      } else if (mode == 2) {
         index = -(count - 1);
      }

      while (count != 0) {
         System.out.print(arr[Math.abs(index)] + " ");
         ++index;
         --count;
      }

      scan.close();
   }
}
