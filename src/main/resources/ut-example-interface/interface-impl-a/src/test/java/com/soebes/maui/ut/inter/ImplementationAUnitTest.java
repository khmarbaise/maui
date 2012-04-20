package com.soebes.maui.ut.inter;

import org.junit.BeforeClass;

import com.soebes.maui.ut.inter.ImplementationA;
import com.soebes.maui.ut.inter.ImplementationUnitTest;

// START SNIPPET: start
public class ImplementationAUnitTest extends ImplementationUnitTest {

    @BeforeClass
    public static void beforeClass() {
        function = new ImplementationA();
    }

}
// END SNIPPET: start