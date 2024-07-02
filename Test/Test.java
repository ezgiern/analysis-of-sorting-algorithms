import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;

public class Test {

    public static void main(String[] args) {
        
        File inputFile = new File("AlgoInput.txt");
        try {
            
            Scanner scanner = new Scanner(inputFile);
            //long startTime = System.currentTimeMillis();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                int[] arr = parseArray(line);              
                testAlgorithms(arr);
            }
            
           // long endtime = System.currentTimeMillis();
            //long executiontime = (endtime - startTime);
            //System.out.println("EXECUTION TIME(ms):"+executiontime );
            scanner.close();

            
        } catch (FileNotFoundException e) {
            System.err.println("Input file not found: " + e.getMessage());

        }
        
    }

    private static int[] parseArray(String line) {

        String[] tokens = line.split(", ");
        int[] arr = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            arr[i] = Integer.parseInt(tokens[i]);
        }
        return arr;
    }




    private static void testAlgorithms(int[] arr) {

        System.out.println("Input Array: " + Arrays.toString(arr));

        // Testing Insertion Sort
        testAlgorithm("Insertion Sort", InsertionSort.findMiddleElement(arr));

        // Testing Merge Sort
        //testAlgorithm("Merge Sort", MergeSort.findNthElement(arr));

        // Testing Quick Sort
        //testAlgorithm("Quick Sort", QuickSort.findNthElement(arr));

        // Testing Max Heap
        //testAlgorithm("Max Heap", MaxHeap.findNthElement(arr));

        // Testing Quick Select
        int k = (int) Math.ceil(arr.length / 2.0);
        //testAlgorithm("Quick Select (First Pivot)", QuickSelect1.findNthElement(arr, k));

        // Testing Quick Select with Median-of-Three Pivot Selection
        //testAlgorithm("Quick Select (Median-of-Three Pivot)", QuickSelect2.findNthElement(arr, k));

        // Testing Quick Select with Median-of-Medians Pivot Selection
        //testAlgorithm("Quick Select (Median-of-Medians Pivot)", QuickSelect3.nthSmallest(arr,k));

        System.out.println();
        
    }

    private static void testAlgorithm(String algorithm, int result) {
        long startTime = System.nanoTime();

        System.out.println("Algorithm which is used: " + algorithm );
        System.out.print("Result: " + result);

        long endtime = System.nanoTime();
        long executiontime = (endtime - startTime);
        System.out.println();
        System.out.println("EXECUTION TIME(nanosecond):"+executiontime );

    }
}
