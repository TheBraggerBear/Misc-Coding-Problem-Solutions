import java.util.Arrays;
import java.util.Scanner;

public class Katiss2048 {
    public enum Direction {
        LEFT(0),
        UP(1),
        RIGHT(2),
        DOWN(3);

        private final int value;

        Direction(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static Direction fromValue(int value) {
            for (Direction direction : Direction.values()) {
                if (direction.value == value) {
                    return direction;
                }
            }
            throw new IllegalArgumentException("Invalid direction value: " + value);
        }
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int[][] arr = new int[4][4];
        for (int i = 0; i < 4; i++) {
            String hold = s.nextLine();
            String[] sarr = hold.split(" ");
            for (int x = 0; x < 4; x++) {
                arr[i][x] = Integer.valueOf(sarr[x]);
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int y = 0; y < arr[i].length - 1; y++) {
                if (arr[i][y] == 0) {
                    arr[i][y] = arr[i][y + 1];
                    arr[i][y + 1] = 0;
                }
            }
        }

        Direction move = Direction.fromValue(Integer.valueOf(s.nextLine()));
        switch (move) {
            case LEFT:
                pushLeft(arr);
                printArray(arr);
                break;
            case UP:
                printArray(arr);
                break;
            case RIGHT:
                pushRight(arr);
                printArray(arr);
                break;
            case DOWN:
                printArray(arr);
                break;
            default:
                break;
        }
    }

    private static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void pushLeft(int[][] arr) {
        for (int i = 0; i < 4; i++) {
            int[] newRow = new int[4];
            int index = 0;

            // Shift non-zero elements to the left
            for (int j = 0; j < 4; j++) {
                if (arr[i][j] != 0) {
                    newRow[index++] = arr[i][j];
                }
            }

            // Combine adjacent equal elements

            for (int j = 3; j > 0; j--) {
                if (newRow[j] != 0 && newRow[j] == newRow[j - 1]) {
                    newRow[j - 1] *= 2;
                    newRow[j] = 0;
                }
            }

            // Shift non-zero elements to the left again after combining
            index = 0;
            for (int j = 0; j < 4; j++) {
                if (newRow[j] != 0) {
                    arr[i][index++] = newRow[j];
                } else {
                    arr[i][index++] = 0;
                }
            }
        }
    }

    public static void pushUp(int[][] arr) {
        boolean left = false;
        boolean center = false;
        boolean right = false;
        for (int i = 0; i < 4; i++) {
            for (int y = arr[i].length - 2; y > 0; y--) {
                left = false;
                center = false;
                right = false;
                if (arr[i][y] == 0) {
                    center = true;
                }
                if (arr[i][y - 1] == 0) {
                    left = true;
                }
                if (arr[i][y + 1] == 0) {
                    right = true;
                }
                if (left && center && right) {
                    break;
                }
                if (left && center) {
                    arr[i][y - 1] = arr[i][y + 1];
                    arr[i][y + 1] = 0;
                    break;
                }
                if (center && right) {
                    break;
                }
                if (left && right) {
                    arr[i][y - 1] = arr[i][y];
                    arr[i][y] = 0;
                    break;
                }
                if (left) {
                    arr[i][y - 1] = arr[i][y];
                    arr[i][y] = arr[i][y + 1];
                    arr[i][y] = 0;
                    arr[i][y + 1] = 0;
                    break;
                }
                if (center) {
                    arr[i][y] = arr[y][y + 1];
                    arr[y][y + 1] = 0;
                    break;
                }
                if (right) {
                    break;
                }
            }
        }
    }

    public static void pushRight(int[][] arr) {
        boolean left = false;
        boolean center = false;
        boolean right = false;
        for (int i = 0; i < 4; i++) {
            for (int y = 0; y < arr[i].length - 2; y++) {
                left = false;
                center = false;
                right = false;
                if (arr[i][y] == 0) {
                    center = true;
                }
                if (arr[i][y - 1] == 0) {
                    left = true;
                }
                if (arr[i][y + 1] == 0) {
                    right = true;
                }
                if (left && center && right) {
                    break;
                }
                if (left && center) {
                    break;
                }
                if (center && right) {
                    break;
                }
                if (left && right) {
                    arr[i][y - 1] = arr[i][y];
                    arr[i][y] = 0;
                    break;
                }
                if (left) {
                    arr[i][y - 1] = arr[i][y];
                    arr[i][y] = arr[i][y + 1];
                    arr[i][y] = 0;
                    arr[i][y + 1] = 0;
                    break;
                }
                if (center) {
                    arr[i][y] = arr[y][y + 1];
                    arr[y][y + 1] = 0;
                    break;
                }
                if (right) {
                    break;
                }
            }
        }
    }

    public static void pushDown(int[][] arr) {
        boolean left = false;
        boolean center = false;
        boolean right = false;
        for (int i = 0; i < 4; i++) {
            for (int y = arr[i].length - 2; y > 0; y--) {
                left = false;
                center = false;
                right = false;
                if (arr[i][y] == 0) {
                    center = true;
                }
                if (arr[i][y - 1] == 0) {
                    left = true;
                }
                if (arr[i][y + 1] == 0) {
                    right = true;
                }
                if (left && center && right) {
                    break;
                }
                if (left && center) {
                    arr[i][y - 1] = arr[i][y + 1];
                    arr[i][y + 1] = 0;
                    break;
                }
                if (center && right) {
                    break;
                }
                if (left && right) {
                    arr[i][y - 1] = arr[i][y];
                    arr[i][y] = 0;
                    break;
                }
                if (left) {
                    arr[i][y - 1] = arr[i][y];
                    arr[i][y] = arr[i][y + 1];
                    arr[i][y] = 0;
                    arr[i][y + 1] = 0;
                    break;
                }
                if (center) {
                    arr[i][y] = arr[y][y + 1];
                    arr[y][y + 1] = 0;
                    break;
                }
                if (right) {
                    break;
                }
            }
        }
    }
}