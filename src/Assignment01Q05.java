public class Assignment01Q05 {
    public static int findShortestPath(int[][] m, int i, int j) {
        if (i == j) {
            return 0;
        }

        boolean[] visited = new boolean[m.length];
        visited[i] = true;
        return findShortestPath(m, i, j, visited);
    }

    private static int findShortestPath(int[][] m, int current, int target, boolean[] visited) {
        int shortest = -1;

        for (int next = 0; next < m.length; next++) {
            if (m[current][next] != 1 || visited[next]) {
                continue;
            }
            if (next == target) {
                return 1;
            }

            visited[next] = true;
            int pathLength = findShortestPath(m, next, target, visited);
            visited[next] = false;

            if (pathLength != -1) {
                pathLength++;
                if (shortest == -1 || pathLength < shortest) {
                    shortest = pathLength;
                }
            }
        }

        return shortest;
    }

    public static void main(String[] args) {
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 0, 1)); // -1
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 1, 1)); // 0
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,0}, {0,0,1,0}, {0,0,0,1}, {1,0,0,0}}, 0, 2)); // 2
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,1}, {0,0,0,1}, {0,0,0,0}, {0,0,1,0}}, 0, 2)); // 2
    }
}