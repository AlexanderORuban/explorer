import java.util.ArrayList;
import java.util.List;

public class ExplorerSearch {

    /**
     * Returns how much land area an explorer can reach on a rectangular island.
     * 
     * The island is represented by a rectangular int[][] that contains
     * ONLY the following nunbers:
     * 
     * '0': represents the starting location of the explorer
     * '1': represents a field the explorer can walk through
     * '2': represents a body of water the explorer cannot cross
     * '3': represents a mountain the explorer cannot cross
     * 
     * The explorer can move one square at a time: up, down, left, or right.
     * They CANNOT move diagonally.
     * They CANNOT move off the edge of the island.
     * They CANNOT move onto a a body of water or mountain.
     * 
     * This method should return the total number of spaces the explorer is able
     * to reach from their starting location. It should include the starting
     * location of the explorer.
     * 
     * For example
     * 
     * @param island the locations on the island
     * @return the number of spaces the explorer can reach
     */
    public static int reachableArea(int[][] island) {
        // Implement your method here!
        // Please also make more test cases
        // I STRONGLY RECOMMEND testing some helpers you might make too
        return -1;
    }

    public static int[] explorerLocation(int[][] island) {
        for (int r = 0; r < island.length; r++) {
            for (int c = 0; c < island[r].length; c++) {
                if (island[r][c] == 0) {
                    return new int[]{r, c};
                }
            }
        }
        throw new IllegalArgumentException("No explorer is present");
    }

    public static List<int[]> possibleMoves(int[][] island, int[] current) {
        int currentRow = current[0];
        int currentColumn = current[1];

        List<int[]> moves = new ArrayList<>();

        // Moving UP
        int newRow = currentRow - 1;
        int newColumn = currentColumn;

        if (newRow >= 0 && island[newRow][newColumn] != 2 && island[newRow][newColumn] != 3) {
            moves.add(new int[]{newRow, newColumn});
        }

        // Moving DOWN
        newRow = currentRow + 1;
        newColumn = currentColumn;

        if (newRow < island.length && island[newRow][newColumn] != 2 && island[newRow][newColumn] != 3) {
            moves.add(new int[]{newRow, newColumn});
        }

        // Moving LEFT
        newRow = currentRow;
        newColumn = currentColumn - 1;

        if (newColumn >= 0 && island[newRow][newColumn] != 2 && island[newRow][newColumn] != 3) {
            moves.add(new int[]{newRow, newColumn});
        }

        // Moving RIGHT
        newRow = currentRow;
        newColumn = currentColumn + 1;

        if (newColumn < island[0].length && island[newRow][newColumn] != 2 && island[newRow][newColumn] != 3) {
            moves.add(new int[]{newRow, newColumn});
        }

        return moves;
    }
}
