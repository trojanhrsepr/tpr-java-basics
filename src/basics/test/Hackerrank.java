package basics.test;

public class Hackerrank {
    static void miniMaxSum(int[] arr) {
        int min=Integer.MAX_VALUE;
        int max=0;
        int sum=0;
        for(int i=0; i<5; i++) {
            if(max<arr[i]) {
                max=arr[i];
            }
            if(min>arr[i]) {
                min = arr[i];
            }
            sum+=arr[i];
        }
        System.out.println((sum-max)+" "+(sum-min));
    }

    static String timeConversion(String s) {
        String[] s1= s.split(":");
        System.out.println(s1);
        String apm=s1[2].substring(2);
        s1[2]=s1[2].substring(0,2);
        int h = Integer.parseInt(s1[0]);
        if(apm.contains("PM")) {
            if(h==12)
                s1[0]="12";
            else {
                h+=12;
                s1[0]=Integer.toString(h);
            }
        }
        if(apm.contains("AM")&&(h==12)) {
            s1[0]="00";
        }
        return s1[0]+":"+s1[1]+":"+s1[2];
    }

    /*
    Java’s Arrays.sort method uses Quicksort for arrays of primitives and merge sort for arrays of objects.
    Arrays.sort(arr); applicable for list using Collections.sort(al);
    Arrays.sort(arr, Collections.reverseOrder());

    int[] arr = { 13, 7, 6, 45, 21, 9, 2, 100 };

     Sort subarray from index 1 to 4, i.e.,
     only sort subarray {7, 6, 45, 21} and
     keep other elements as it is.
     Arrays.sort(arr, 1, 5);
     */

    // Insertion sort is where every element is picked up and sorted one by one.
    /*
    1 4 3 5 6 2
    1 3 4 5 6 2
    1 3 4 5 6 2
    1 3 4 5 6 2
    1 2 3 4 5 6
    */
    static void insertionSort2(int n, int[] arr) {
        int temp;
        for(int i=0;i<n;i++) {
            for(int j=i; j>0;j--) {
                if(arr[j]<arr[j-1]) {
                    temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
            }
            if(i>0) {
                for(int num: arr) {
                    System.out.printf(num+" ");
                }
                System.out.println("");
            }
        }
    }
}
