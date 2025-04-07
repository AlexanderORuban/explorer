import static org.junit.Assert.*;
import org.junit.Test;

public class ExplorerSearchTest {
    @Test
    public void testReachableArea_someUnreachable() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,0,1},
            {1,1,1,2,1,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(14, actual);
    }

    // Add more tests here!
    // Come up with varied cases

    // ExplorerLocation tests:
    @Test
    public void testSalamanderLocation_centerOfGrid() {
        int[][] island = {
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
            {1,1,0,1,1,1},
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
        };
        int[] expected = {2, 2};
        assertArrayEquals(expected, ExplorerSearch.explorerLocation(island));
    }

    @Test
    public void testSalamanderLocation_RightCornerGrid() {
        int[][] island = {
            {1,1,1,1,1,0},
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
        };
        int[] expected = {0, 5};
        assertArrayEquals(expected, ExplorerSearch.explorerLocation(island));
    }

    @Test
    public void testSalamanderLocation_SurroundedByWater() {
        int[][] island = {
            {2,2,2,2,2,2},
            {2,2,2,2,2,2},
            {2,2,0,2,2,2},
            {2,2,2,2,2,2},
            {2,2,2,2,2,2},
        };
        int[] expected = {2, 2};
        assertArrayEquals(expected, ExplorerSearch.explorerLocation(island));
    }

    @Test
    public void testSalamanderLocation_throwsException() {
        int[][] island = {
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
        };
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ExplorerSearch.explorerLocation(island);
        });
        assertEquals("No explorer is present", exception.getMessage());
    }

}
