/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package am.developer.test;

import am.developer.MyClassForMock;
import java.util.Iterator;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author haykh
 */
public class VogellaExamples {
    @Test
    public void test1()  {
        //  create mock
        MyClassForMock test = mock(MyClassForMock.class);

        // define return value for method getUniqueId()
        when(test.getVal()).thenReturn(43l);

        // use mock in test....
        //assertEquals(test.getVal(), 43);
    }
    
    @Test
    public void testMoreThanOneReturnValue()  {
        Iterator<String> i= mock(Iterator.class);
        when(i.next()).thenReturn("Mockito").thenReturn("rocks");
        String result= i.next()+" "+i.next();
        //assert
        assertEquals("Mockito rocks", result);
    }
    
    @Test
    public void testReturnValueDependentOnMethodParameter()  {
        Comparable<String> c= mock(Comparable.class);
        when(c.compareTo("Mockito")).thenReturn(1);
        when(c.compareTo("Eclipse")).thenReturn(2);
        //assert
        assertEquals(1, c.compareTo("Mockito"));
    }
    
    @Test
    public void testReturnValueInDependentOnMethodParameter()  {
            Comparable<Integer> c= mock(Comparable.class);
            when(c.compareTo(anyInt())).thenReturn(-1);
            //assert
            assertEquals(-1, c.compareTo(9));
    }
}
