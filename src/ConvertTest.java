/**
 * Andrew Dibble
 * ConvertTest.java
 * TCSS 371 - Winter 2022
 * 1/12/2022
 * Assignment 1
 */

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConvertTest {

    @Test
    public void testNegative2sComp() {
        char[] data = {'1', '0', '1', '0', '0'};
        assertEquals(-12, Convert.convert2sCompToDecimal(data));
    }

    @Test
    public void testPositive2sComp() {
        char[] data = {'0', '1', '1', '0', '1','1','0'};
        assertEquals(54, Convert.convert2sCompToDecimal(data));
    }

    @Test
    public void testNegativeDecimal(){
        char[] data = {'1', '0', '1', '1', '0','1','1'};
        assertArrayEquals(data,Convert.convertDecimalTo2sComp(-37));
    }

    @Test
    public void testPositiveDecimal(){
        char[] data = {'0', '1', '0', '1', '0','0','1','0'};
        assertArrayEquals(data,Convert.convertDecimalTo2sComp(82));
    }

    @Test
    public void testBigNum2sComp(){
        char[] data = {'0', '1', '1', '1', '0','0','1','0','1','1','0','1','0','1','0'};
        assertEquals(14698, Convert.convert2sCompToDecimal(data));
    }

    @Test
    public void testBigNumDecimal(){
        char[] data = {'1', '0', '0', '0', '1','0','1','1','1','0','1','0','1','0','0','0'};
        assertArrayEquals(data, Convert.convertDecimalTo2sComp(-29784));
    }



}
