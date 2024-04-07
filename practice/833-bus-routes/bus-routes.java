import java.awt.Point;
class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> targets = new HashSet<>();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<routes.length; i++) {
            graph.add(new ArrayList<>());
            Arrays.sort(routes[i]);
        }
        Queue<Point> queue = new ArrayDeque();
        for (int i=0; i<routes.length; i++) {
            for (int j=i +1; j<routes.length; j++) {
                if (intersect(routes[i], routes[j])) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        for (int i=0; i<routes.length; i++) {
            if (Arrays.binarySearch(routes[i], source) >= 0) {
                visited.add(i);
                queue.offer(new Point(i, 0));
            }
            if (Arrays.binarySearch(routes[i], target) >= 0) {
                targets.add(i);
            }
        }
        while (!queue.isEmpty()) {
            Point info = queue.poll();
            int node = info.x;
            int depth = info.y;
            if (targets.contains(node)) {
                return depth + 1;
            }
            List<Integer> neighbours = graph.get(node);
            for (Integer neighbour : neighbours) {
                if (visited.contains(neighbour)) {
                    continue;
                }
                visited.add(neighbour);
                queue.offer(new Point(neighbour, depth + 1));
            }
        }
        return -1;
    }

    private boolean intersect(int[] list1, int[] list2) {
        int i=0; int j=0;
        while (i <list1.length && j < list2.length) {
            if (list1[i] == list2[j]) {
                return true;
            } else if (list1[i] > list2[j]){
                j++;
            } else {
                i++;
            }
        }
        return false;
    }
}