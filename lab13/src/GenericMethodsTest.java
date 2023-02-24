import static org.junit.Assert.*;

public class GenericMethodsTest {
    Integer[] testIntArray;
    Double[] testDoubleArray;

    @org.junit.Before
    public void setUp() {
        testIntArray = new Integer[]{1, 2, 3, 4};
        testDoubleArray = new Double[]{23.5, 3.543, 90.234};
    }

    @org.junit.Test
    public void maxMinTest() {
        assertEquals(4, GenericMethods.maxMin(testIntArray).getKey(), 0);
        assertEquals(1, GenericMethods.maxMin(testIntArray).getValue(), 0);
        assertEquals(90.234, GenericMethods.maxMin(testDoubleArray).getKey(), 0);
        assertEquals(3.543, GenericMethods.maxMin(testDoubleArray).getValue(), 0);
    }

    @org.junit.Test
    public void avgSumTest() {
        assertEquals(2.5, GenericMethods.avgSum(testIntArray).getKey(), 0);
        assertEquals(10, GenericMethods.avgSum(testIntArray).getValue(), 0);
        assertEquals(39.09, GenericMethods.avgSum(testDoubleArray).getKey(), 0.1);
        assertEquals(117.277, GenericMethods.avgSum(testDoubleArray).getValue(), 0.001);
    }
}