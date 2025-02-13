package org.ATBSelenium.base.sampleTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;

public class TestsSample {
    @Description("Sample TC 1")
    @Test
    public void testSample0(){
        Assert.assertTrue(true);
    }

    @Description("Sample TC 1")
    @Test
    public void testSample1(){
        Assert.assertTrue(true);
    }
}
