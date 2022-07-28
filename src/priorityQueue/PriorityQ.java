package priorityQueue;

import java.util.Queue;

public class PriorityQ {

    public void getMaxHeapQueue(){
        // can use the comparison to construct maxheap
        Queue<Integer> q = new java.util.PriorityQueue<>((a,b) -> b - a );
//        q.add(Integer.valueOf(20));
//        q.add(Integer.valueOf(1));
//        q.add(Integer.valueOf(17));
//        q.add(Integer.valueOf(35));
//        q.add(Integer.valueOf(60));
//
//        System.out.println(q.poll());
//        System.out.println(q.poll());
//        System.out.println(q.poll());
//        System.out.println(q.poll());

        int a[] = new int[]{10,5,6,2};
        int b[] = new int[]{12,7,9};

        for(int i =0;i<a.length;i++){
            q.add(Integer.valueOf(a[i]));
        }
        for(int i =0;i<b.length;i++){
            q.add(Integer.valueOf(b[i]));
        }

        while(!q.isEmpty()){
            System.out.println(q.poll());
        }
    }

//    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
//        //
//
//
//    }
}
