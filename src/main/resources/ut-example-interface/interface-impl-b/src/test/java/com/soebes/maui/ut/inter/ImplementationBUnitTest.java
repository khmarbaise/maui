package com.soebes.maui.ut.inter;

import org.junit.BeforeClass;

import com.soebes.maui.ut.inter.ImplementationB;
import com.soebes.maui.ut.inter.ImplementationUnitTest;

//START SNIPPET: start
public class ImplementationBUnitTest extends ImplementationUnitTest {

    @BeforeClass
    public static void beforeClass() {
        function = new ImplementationB();
    }

}
// END SNIPPET: start
