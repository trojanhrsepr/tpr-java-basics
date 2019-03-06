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
    Arrays.binarySearch(array, key)
    Collections.binarySearch(array, key)

    int[] arr = { 13, 7, 6, 45, 21, 9, 2, 100 };

     Sort subarray from index 1 to 4, i.e.,
     only sort subarray {7, 6, 45, 21} and
     keep other elements as it is.
     Arrays.sort(arr, 1, 5);
     */

    /*
    Insertion sort
    Insertion sort is where every element is picked up and sorted one by one.

    How to find time complexity?
    In the best case, where the array was already sorted, no element will need to be moved, so the algorithm will
    just run through the array once and return the sorted array. The running time would be directly proportional to
    the size of the input, so we can say it will take N time.

    However, we usually focus on the worst-case running time (computer scientists are pretty pessimistic). The worst
    case for Insertion Sort occurs when the array is in reverse order. To insert each number, the algorithm will have
    to shift over that number to the beginning of the array. Sorting the entire array of N numbers will therefore take
    1+2+..N-1 operations, which is N(N-1)/2 (almost N^2). Computer scientists just round that up
    (pick the dominant term)
    to N^2 and say that Insertion Sort is an " time" algorithm.

    1 4 3 5 6 2
    1 3 4 5 6 2
    1 3 4 5 6 2
    1 3 4 5 6 2
    1 2 3 4 5 6
    */
    static void insertionSort(int n, int[] arr) {
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

    /*
    Bubble Sort
    Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent
    elements if they are in wrong order.

    Ends with n-i-1 because last element is continuously sorted and pushed to last in every iteration
    Bubble sort has worst-case and average complexity both О(n2)
    Performance of bubble sort over an already-sorted list (best-case) is O(n).
     */

    static void bubbleSort(int n, int[] arr) {
        int temp;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n-i-1; j++) {
                if(arr[j]>arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    /*
    Selection sort
    The selection sort algorithm sorts an array by repeatedly finding the minimum element
    (considering ascending order) from unsorted part and putting it at the beginning.

    Selection sort has worst-case and average complexity both О(n2)
    Performance of bubble sort over an already-sorted list (best-case) is O(n).
     */

    static void selectionSort(int n, int[] arr) {
        int temp;
        for(int i=0; i<n; i++) {
            int min = i;
            for(int j=i+1; j<n; j++) {
                if(arr[j]<arr[min]) {
                    min=j;
                }
            }
            temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    /*
    Binary Search

    List needs to be sorted for this to work. If not, results will be undefined

    This method runs in log(n) time for a “random access” list like ArrayList.
    If the specified list does not implement the RandomAccess interface and is large, this method
    will do an iterator-based binary search that performs O(n) link traversals and O(log n) element comparisons.
     */

    static int binarySearch(int[] arr, int start, int end, int key) {
        if(end>=1) {
            int mid = start + (end+start)/2;

            // Found case
            if(arr[mid]==key)
                return mid;
            if(arr[mid]>key)
                return binarySearch(arr,start,mid,key);
            return binarySearch(arr, mid+1, end, key);
        }
        // Not found
        return -1;
    }
}
