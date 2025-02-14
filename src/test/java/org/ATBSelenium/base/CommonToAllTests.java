package org.ATBSelenium.base;

import org.ATBSelenium.driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonToAllTests {


    public class CommonToAllTest {

        @BeforeMethod
        public void setUp() {
            DriverManager.init();
        }

        @AfterMethod
        public void tearDown() {
            DriverManager.down();
        }

    }
}
