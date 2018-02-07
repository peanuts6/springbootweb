package xqy.msa.springbootweb;

import org.junit.Test;

/**
 * Created by xqy on 18/1/11.
 */
public class TestJunit {
    int count = 0;

    @Test
    public void testInc1(){
        System.out.println(count++);
    }

    @Test
    public void testInc2(){
        System.out.println(count++);
    }

    @Test
    public void testInc3(){
        System.out.println(count++);
    }
}
