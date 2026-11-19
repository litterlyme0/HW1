import java.util.Arrays;

public class Assignment01Q04 {

    public static int[] shiftArrayCyclic(int[] array, int move, char direction) {
        int length = array.length;
        if (length == 0 || move == 0 || (direction != 'R' && direction != 'L')) {
            return array;
        }

        int rightShift;
        if (direction == 'R') {
            rightShift = move;
        } else {
            rightShift = -move;
        }

        rightShift %= length;
        if (rightShift < 0) {
            rightShift += length;
        }
        if (rightShift == 0) {
            return array;
        }

        boolean[] visited = new boolean[length];

        for (int start = 0; start < length; start++) {
            if (visited[start]) {
                continue;
            }

            int temporary = array[start];
            int current = start;

            do {
                visited[current] = true;
                int next = (current + rightShift) % length;
                int valueAtNext = array[next];
                array[next] = temporary;
                temporary = valueAtNext;
                current = next;
            } while (current != start);
        }

        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -1, 'R'))); // [2, 3, 4, 5, 1]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'R'))); // [5, 1, 2, 3, 4]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'r'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -2, 'g'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 3, 'L'))); // [4, 5, 1, 2, 3]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -3, 'L'))); // [3, 4, 5, 1, 2]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{0, 8, 9, 5, 6}, 6, 'L'))); // [8, 9, 5, 6, 0]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{}, 3, 'R'))); // []
    }
}