import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class ExplorerSearchTest {
    @Test
    public void testReachableArea_someUnreachable() {
        int[][] island = {
                { 1, 1, 1, 3, 1, 1 },
                { 3, 2, 3, 1, 3, 1 },
                { 1, 1, 1, 1, 3, 3 },
                { 3, 1, 2, 1, 0, 1 },
                { 1, 1, 1, 2, 1, 1 },
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(14, actual);
    }

    // Add more tests here!
    // Come up with varied cases

    // ExplorerLocation tests:
    @Test
    public void testExplorerLocation_centerOfGrid() {
        int[][] island = {
                { 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1 },
                { 1, 1, 0, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1 },
        };
        int[] expected = { 2, 2 };
        assertArrayEquals(expected, ExplorerSearch.explorerLocation(island));
    }

    @Test
    public void testExplorerLocation_RightCornerGrid() {
        int[][] island = {
                { 1, 1, 1, 1, 1, 0 },
                { 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1 },
        };
        int[] expected = { 0, 5 };
        assertArrayEquals(expected, ExplorerSearch.explorerLocation(island));
    }

    @Test
    public void testExplorerLocation_SurroundedByWater() {
        int[][] island = {
                { 2, 2, 2, 2, 2, 2 },
                { 2, 2, 2, 2, 2, 2 },
                { 2, 2, 0, 2, 2, 2 },
                { 2, 2, 2, 2, 2, 2 },
                { 2, 2, 2, 2, 2, 2 },
        };
        int[] expected = { 2, 2 };
        assertArrayEquals(expected, ExplorerSearch.explorerLocation(island));
    }

    @Test
    public void testExplorerLocation_throwsException() {
        int[][] island = {
                { 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1 },
        };
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ExplorerSearch.explorerLocation(island);
        });
        assertEquals("No explorer is present", exception.getMessage());
    }

    // PossibleMoves tests:
    @Test
    public void testPossibleMoves_noMovesAllDirectionsBlocked() {
        int[][] island = {
                { 2, 2, 2 },
                { 2, 0, 2 },
                { 2, 2, 2 },
        };
        int[] location = { 1, 1 };
        List<int[]> moves = ExplorerSearch.possibleMoves(island, location);
        assertTrue(moves.isEmpty());
    }

    @Test
    public void testPossibleMoves_allDirectionsOpen() {
        int[][] island = {
                { 1, 1, 1 },
                { 1, 0, 1 },
                { 1, 1, 1 },
        };
        int[] location = { 1, 1 };
        List<int[]> moves = ExplorerSearch.possibleMoves(island, location);
        Set<String> moveSet = toSet(moves);

        assertEquals(4, moves.size());
        assertTrue(moveSet.contains("0,1")); // up
        assertTrue(moveSet.contains("2,1")); // down
        assertTrue(moveSet.contains("1,0")); // left
        assertTrue(moveSet.contains("1,2")); // right
    }

    @Test
    public void testPossibleMoves_topLeftCorner() {
        int[][] island = {
                { 0, 1, 1 },
                { 1, 1, 1 },
                { 1, 1, 1 },
        };
        int[] location = { 0, 0 };
        List<int[]> moves = ExplorerSearch.possibleMoves(island, location);
        Set<String> moveSet = toSet(moves);

        assertEquals(2, moves.size());
        assertTrue(moveSet.contains("0,1")); // down
        assertTrue(moveSet.contains("1,0")); // right
    }

    @Test
    public void testPossibleMoves_oneOpenMove() {
        int[][] island = {
                { 2, 3, 2 },
                { 3, 0, 2 },
                { 2, 1, 3 },
        };
        int[] location = { 1, 1 };
        List<int[]> moves = ExplorerSearch.possibleMoves(island, location);
        Set<String> moveSet = toSet(moves);

        assertEquals(1, moves.size());
        assertTrue(moveSet.contains("2,1")); // down
    }

    @Test
    public void testPossibleMoves_singlePieceOfLandIsland() {
        int[][] island = {
                { 0 },
        };
        int[] location = { 0, 0 };
        List<int[]> moves = ExplorerSearch.possibleMoves(island, location);
        assertTrue(moves.isEmpty());
    }

    private Set<String> toSet(List<int[]> list) {
        Set<String> set = new HashSet<>();
        for (int[] arr : list) {
            set.add(arr[0] + "," + arr[1]);
        }
        return set;
    }
}
