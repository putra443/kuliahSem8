import java.util.*;
public class maxHeapGPT {
    private static int[] heap;
    private static int size;

    public static void main(String[] args) {
        heap = new int[100001];
        size = 0;

        Scanner scanner = new Scanner(System.in);
        String command;
        do {
            command = scanner.next();
            if (command.equals("insert")) {
                int value = scanner.nextInt();
                insert(value);
            } else if (command.equals("extract")) {
                int extractedValue = extract();
                if (extractedValue != -1) {
                    System.out.println(extractedValue);
                } else {
                    System.out.println("-");
                }
            }
        } while (!command.equals("end"));

        heapSort();

        for (int i = 1; i <= size; i++) {
            System.out.print(heap[i] + " ");
        }
    }

    private static void insert(int value) {
        size++;
        heap[size] = value;
        int current = size;
        while (current > 1 && heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    private static int extract() {
        if (size == 0) {
            return -1;
        }
        int extractedValue = heap[1];
        heap[1] = heap[size];
        size--;
        maxHeapify(1);
        return extractedValue;
    }

    private static void maxHeapify(int index) {
        int left = leftChild(index);
        int right = rightChild(index);
        int largest = index;

        if (left <= size && heap[left] > heap[largest]) {
            largest = left;
        }
        if (right <= size && heap[right] > heap[largest]) {
            largest = right;
        }
        if (largest != index) {
            swap(index, largest);
            maxHeapify(largest);
        }
    }

    private static void buildMaxHeap() {
        for (int i = size / 2; i >= 1; i--) {
            maxHeapify(i);
        }
    }

    private static void heapSort() {
        buildMaxHeap();
        int originalSize = size;
        for (int i = size; i >= 2; i--) {
            swap(1, i);
            size--;
            maxHeapify(1);
        }
        size = originalSize;
    }

    private static int parent(int index) {
        return index / 2;
    }

    private static int leftChild(int index) {
        return 2 * index;
    }

    private static int rightChild(int index) {
        return (2 * index) + 1;
    }

    private static void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
