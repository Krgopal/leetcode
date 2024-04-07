class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        for (int i=0; i<equations.size(); i++) {
            String dividend = equations.get(i).get(0);
            String divisor = equations.get(i).get(1);
            double quotient = values[i];
            if (!graph.containsKey(dividend)) {
                graph.put(dividend,new HashMap<>());
            }
            if (!graph.containsKey(divisor)) {
                graph.put(divisor,new HashMap<>());
            }
            graph.get(dividend).put(divisor, quotient);
            graph.get(divisor).put(dividend, 1 / quotient);
        }
        double[] result = new double[queries.size()];
        for (int i=0; i<queries.size(); i++) {
            String dividend = queries.get(i).get(0);
            String divisor = queries.get(i).get(1);
            if (!graph.containsKey(dividend) || !graph.containsKey(divisor)) {
                result[i] = -1.0;
            } else  if (dividend == divisor) {
                result[i] = 1.0;
            } else {
                Set<String> visited = new HashSet<>();
                result[i] = backtracking(graph, dividend, divisor, 1, visited);
            }
        }
        return result;
    }

    public double backtracking(HashMap<String, HashMap<String, Double>> graph, String currNode, String target, double accProduct, Set<String> visited) {
        visited.add(currNode);
        double response = -1.0;
        Map<String, Double> neighbours = graph.get(currNode);
        if (neighbours.containsKey(target)) {
            response = accProduct * neighbours.get(target);
        } else {
            for (Map.Entry<String, Double> pair : neighbours.entrySet()) {
                if (visited.contains(pair.getKey())) {
                    continue;
                }
                response = backtracking(graph, pair.getKey(), target, accProduct * pair.getValue(), visited);
                if (response != -1.0) {
                    break;
                }
            }
        }
        visited.remove(currNode);
        return response;
    }
}