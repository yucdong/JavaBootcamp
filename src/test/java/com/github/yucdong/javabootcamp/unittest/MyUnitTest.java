package com.github.yucdong.javabootcamp.unittest;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

public class MyUnitTest {

    @Test
    public void testConcatenate() {
        MyUnit myUnit = new MyUnit();
        String result = myUnit.concatenate("one", "two");
        assertEquals("onetwo", result);
    }

    @Test
    public void testWithMatchers() {
        assertThat("this string", is("this string"));
        assertThat(123, not( is(345) ));
    }
}