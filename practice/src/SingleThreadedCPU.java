import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


/*

You are given n tasks labeled from 0 to n - 1 represented by a 2D integer array tasks, where tasks[i] = [enqueueTime[i], processingTime[i]] means that the ith task will be available to process at enqueueTime[i] and will take processingTime[i] to finish processing.

You have a single-threaded CPU that can process at most one task at a time and will act in the following way:

If the CPU is idle and there are no available tasks to process, the CPU remains idle.
If the CPU is idle and there are available tasks, the CPU will choose the one with the shortest processing time. If multiple tasks have the same shortest processing time, it will choose the task with the smallest index.
Once a task is started, the CPU will process the entire task without stopping.
The CPU can finish a task then start a new one instantly.
Return the order in which the CPU will process the tasks.



Example 1:

Input: tasks = [[1,2],[2,4],[3,2],[4,1]]
Output: [0,2,3,1]
Explanation: The events go as follows:
- At time = 1, task 0 is available to process. Available tasks = {0}.
- Also at time = 1, the idle CPU starts processing task 0. Available tasks = {}.
- At time = 2, task 1 is available to process. Available tasks = {1}.
- At time = 3, task 2 is available to process. Available tasks = {1, 2}.
- Also at time = 3, the CPU finishes task 0 and starts processing task 2 as it is the shortest. Available tasks = {1}.
- At time = 4, task 3 is available to process. Available tasks = {1, 3}.
- At time = 5, the CPU finishes task 2 and starts processing task 3 as it is the shortest. Available tasks = {1}.
- At time = 6, the CPU finishes task 3 and starts processing task 1. Available tasks = {}.
- At time = 10, the CPU finishes task 1 and becomes idle.
Example 2:

Input: tasks = [[7,10],[7,12],[7,5],[7,4],[7,2]]
Output: [4,3,2,0,1]
Explanation: The events go as follows:
- At time = 7, all the tasks become available. Available tasks = {0,1,2,3,4}.
- Also at time = 7, the idle CPU starts processing task 4. Available tasks = {0,1,2,3}.
- At time = 9, the CPU finishes task 4 and starts processing task 3. Available tasks = {0,1,2}.
- At time = 13, the CPU finishes task 3 and starts processing task 2. Available tasks = {0,1}.
- At time = 18, the CPU finishes task 2 and starts processing task 0. Available tasks = {1}.
- At time = 28, the CPU finishes task 0 and starts processing task 1. Available tasks = {}.
- At time = 40, the CPU finishes task 1 and becomes idle.


Constraints:

tasks.length == n
1 <= n <= 105
1 <= enqueueTime[i], processingTime[i] <= 109
 */


public class SingleThreadedCPU {
    public int[] getOrder1(int[][] tasks) {
        PriorityQueue<Integer> queue1 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if (tasks[a][0] == tasks[b][0] &&  Math.abs(tasks[a][1] - tasks[a][0]) - Math.abs(tasks[b][1] - tasks[b][0]) == 0) {
                    return a -b;
                } else {
                    int val = Math.abs(tasks[a][1] - tasks[a][0]) - Math.abs(tasks[b][1] - tasks[b][0]);
                    System.out.println(a + "    " + b+ "    " + val);
                    return val;
                }
            }
        });
        PriorityQueue<Integer> queue = new PriorityQueue<>( (a, b) -> Math.abs(tasks[a][1] - tasks[a][0]) - Math.abs(tasks[b][1] - tasks[b][0]) == 0  ? a -b :  Math.abs(tasks[a][1] - tasks[a][0]) - Math.abs(tasks[b][1] - tasks[b][0]));

        for (int i=0; i<tasks.length; i++) {
            queue.add(i);
        }
        int[] result = new int[tasks.length];
        int index = 0;
        while (!queue.isEmpty()) {
            result[index] = queue.poll();
            index++;
        }
        return result;
    }


    public int[] getOrder(int[][] tasks) {

        // Sort based on min task processing time or min task index.
        // Store enqueue time, processing time, task index.
        PriorityQueue<int[]> nextTask = new PriorityQueue<int[]>((a, b) -> (a[1] != b[1] ? (a[1] - b[1]) : (a[2] - b[2])));

        // Store task enqueue time, processing time, index.
        int[][] sortedTasks = new int[tasks.length][3];
        for (int i = 0; i < tasks.length; ++i) {
            sortedTasks[i][0] = tasks[i][0];
            sortedTasks[i][1] = tasks[i][1];
            sortedTasks[i][2] = i;
        }

        Arrays.sort(sortedTasks, (a, b) -> Integer.compare(a[0], b[0]));
        int[] tasksProcessingOrder = new int[tasks.length];

        long currTime = 0;
        int taskIndex = 0;
        int ansIndex = 0;

        // Stop when no tasks are left in array and heap.
        while (taskIndex < tasks.length || !nextTask.isEmpty()) {
            if (nextTask.isEmpty() && currTime < sortedTasks[taskIndex][0]) {
                // When the heap is empty, try updating currTime to next task's enqueue time.
                currTime = sortedTasks[taskIndex][0];
            }

            // Push all the tasks whose enqueueTime <= currtTime into the heap.
            while (taskIndex < tasks.length && currTime >= sortedTasks[taskIndex][0]) {
                nextTask.add(sortedTasks[taskIndex]);
                ++taskIndex;
            }

            int processTime = nextTask.peek()[1];
            int index = nextTask.peek()[2];
            nextTask.remove();

            // Complete this task and increment currTime.
            currTime += processTime;
            tasksProcessingOrder[ansIndex++] = index;
        }

        return tasksProcessingOrder;
    }


    public static void main(String[] args) {
        SingleThreadedCPU cpu = new SingleThreadedCPU();
        int[][] input = new int[][]{{1,2},{2,4},{3,2},{4,1}};
        int[][] input2 = new int[][]{{7,10},{7,12},{7,5},{7,4},{7,2}};
        System.out.println(Arrays.toString(cpu.getOrder(input)));
        System.out.println(Arrays.toString(cpu.getOrder(input2)));
    }
}


