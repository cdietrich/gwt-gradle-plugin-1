package org.wisepersist.gradle.plugins.gwt.internal;

import org.junit.Assert;
import org.junit.Test;
import org.wisepersist.gradle.plugins.gwt.internal.GwtVersion;

public class GwtVersionTest {

    @Test
    public void valid() {
        GwtVersion v = GwtVersion.parse("2.5");
        
        Assert.assertEquals(2, v.getMajor());
        Assert.assertEquals(5, v.getMinor());
        Assert.assertEquals("2.5.0", v.toString());
    }
    
    @Test
    public void patch() {
        GwtVersion v = GwtVersion.parse("2.5.1-ABC");

        Assert.assertEquals("1-ABC", v.getPatch());
        Assert.assertEquals("2.5.1-ABC", v.toString());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void invalid() {
        GwtVersion.parse("0");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void notNumeric() {
        GwtVersion.parse("a.b");
    }
    
    @Test
    public void empty() {
        Assert.assertNull(GwtVersion.parse(""));
        Assert.assertNull(GwtVersion.parse(" \t"));
    }
    
    @Test
    public void isNull() {
        Assert.assertNull(GwtVersion.parse(null));
    }
}
