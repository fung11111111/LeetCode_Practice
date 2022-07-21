package priorityQueue;

import java.util.PriorityQueue;
import java.util.Queue;

public class priorityQueue {

    public void getMaxHeapQueue(){
        // can use the comparison to construct maxheap
        Queue<Integer> q = new PriorityQueue<>((a, b) -> b -a);
        q.add(Integer.valueOf(20));
        q.add(Integer.valueOf(1));
        q.add(Integer.valueOf(17));
        q.add(Integer.valueOf(35));
        q.add(Integer.valueOf(60));

        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
    }
}
