public class MaxPQC {
    public static int heapSize = 0;
    public static int treeArraySize;
    public static int INF = Integer.MAX_VALUE;

    // function to get right child of a node of a tree
    public void getHeapSize(int i) {
        heapSize = i;
    }

    public static int getRightChild(Customer A[], int index) {
        if ((((2 * index) + 1) < A.length && (index >= 1)))
            return (2 * index) + 1;
        return -1;
    }

    // function to get left child of a node of a tree
    public static int getLeftChild(Customer A[], int index) {
        if (((2 * index) < A.length && (index >= 1)))
            return 2 * index;
        return -1;
    }

    // function to get the parent of a node of a tree
    public static int getParent(Customer A[], int index) {
        if ((index > 1) && (index < A.length)) {
            return index / 2;
        }
        return -1;
    }

    public static void maxHeapify(Customer A[], int index) {
        int leftChildIndex = getLeftChild(A, index);
        int rightChildIndex = getRightChild(A, index);

        // finding largest among index, left child and right child
        int largest = index;

        if ((leftChildIndex <= heapSize) && (leftChildIndex > 0)) {
            if (A[leftChildIndex].priority > A[largest].priority) {
                largest = leftChildIndex;
            } else if (A[leftChildIndex].priority == A[largest].priority) {
                if (A[leftChildIndex].wait > A[largest].wait) {
                    largest = leftChildIndex;
                }
            }

        }

        if ((rightChildIndex <= heapSize && (rightChildIndex > 0))) {
            if (A[rightChildIndex].priority > A[largest].priority) {
                largest = rightChildIndex;
            }

            else if (A[rightChildIndex].priority == A[largest].priority) {
                if (A[rightChildIndex].wait > A[largest].wait) {
                    largest = rightChildIndex;
                }
            }

        }

        // largest is not the node, node is not a heap
        if (largest != index) {
            Customer temp;
            // swapping
            temp = A[largest];
            A[largest] = A[index];
            A[index] = temp;
            maxHeapify(A, largest);
        }
    }

    public static void buildMaxHeap(Customer A[]) {
        for (int i = heapSize / 2; i >= 1; i--) {
            maxHeapify(A, i);
        }
    }

    public static int maximum(int A[]) {
        return A[1];
    }

    public static Customer extractMax(Customer A[]) {
        Customer maxm = A[1];
        A[1] = A[heapSize - 1];
        heapSize--;
        maxHeapify(A, 1);
        return maxm;
    }

    public static void increaseKey(Customer A[], int index, Customer key) {
        A[index] = key;
        while ((index > 1) && (A[getParent(A, index)].priority < A[index].priority)) {
            Customer temp;
            temp = A[getParent(A, index)];
            A[getParent(A, index)] = A[index];
            A[index] = temp;
            index = getParent(A, index);
        }
    }

    public static void decreaseKey(Customer A[], int index, Customer key) {
        A[index] = key;
        maxHeapify(A, index);
    }

    public void insert(Customer A[], Customer key) {
        heapSize++;
        A[heapSize].priority = -1 * INF;
        increaseKey(A, heapSize, key);
    }

    public static void printHeap(Customer A[]) {
        for (int i = 1; i <= heapSize - 1; i++) {
            System.out.print(A[i].priority + " ");
        }
        System.out.println("");
    }
}
