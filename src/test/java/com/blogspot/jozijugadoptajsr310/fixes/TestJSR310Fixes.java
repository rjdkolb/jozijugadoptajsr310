package com.blogspot.jozijugadoptajsr310.fixes;

import javax.time.LocalDateTime;
import junit.framework.Assert;
import org.junit.Test;

public class TestJSR310Fixes {

    /**
     * Date date = new Date(2007, 12, 13, 16, 40);//Issue 1
     * year 2007 needs to be (2007 -1900)
     */
    @Test
    public void testFix1() {
        LocalDateTime TEST_2007_07_15_12_30_40_987654321 = LocalDateTime.of(2007, 7, 15, 12, 30, 40, 987654321);
        Assert.assertEquals("Year must be 2007", 2007,
                TEST_2007_07_15_12_30_40_987654321.getYear());
    }
    /**
     * Date date = new Date(2007, 12, 13, 16, 40);//Issue 2
     * month 12 needs 11, because months are zero based
     */
    @Test
    public void testFix2() {
        LocalDateTime TEST_2007_07_15_12_30_40_987654321 = LocalDateTime.of(2007, 7, 15, 12, 30, 40, 987654321);
        Assert.assertEquals("Month must be 7", 7,
                TEST_2007_07_15_12_30_40_987654321.getMonthValue());

    }
    /**
     * TimeZone zone = TimeZone.getInstance("Asia/HongKong");//Issue 3
     * Does not conform to ISO standard, wants Asia/Hong_Kong
     */
    @Test
    public void testFix3(){
        DateTimeZone.forID("Asia/HongKong");
    }

}
