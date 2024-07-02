import java.util.PriorityQueue;

public class MaxHeap {

    public static int findNthElement(int[] arr) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int num : arr) {
            maxHeap.offer(num);
        }
        for (int i = 0; i < arr.length / 2; i++) {
            maxHeap.poll();
        }
        return maxHeap.peek();
    }

}
