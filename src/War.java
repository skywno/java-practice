public class War {
      public static int warOfNumbers(int[]numbers){
          int evenSum = 0;
          int oddSum = 0;
          for (int num: numbers){
              if (num%2==0)
                  evenSum += num;
              else
                  oddSum += num;
          }
          return Math.abs(evenSum-oddSum);
      }

}
