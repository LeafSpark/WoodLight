package com.woodlight;

import com.woodlight.math.Random;

public class InitializationTest {
    public InitializationTest() throws InterruptedException {
        String toLowerCaseTest = "WOODLIGHT";
        String toUpperCaseTest = "woodlight";

        long longVarTest = 983759048637863L;
        int intVarTest = 1020202;
        float floatVarTest = 63656.968F;

        boolean toLowerCaseTestPassed = false;
        boolean toUpperCaseTestPassed = false;
        boolean longVarTestPassed = false;
        boolean intVarTestPassed = false;
        boolean floatVarTestPassed = false;

        // test checks start

        if (toLowerCaseTest.toLowerCase().equals("woodlight")) {
            toLowerCaseTestPassed = true;
            System.out.println("ToLowerCase test was successful.");
        } else {
            System.out.println("Test \"toLowerCaseTest\" has failed.");
        }

        if (toUpperCaseTest.toUpperCase().equals("WOODLIGHT")) {
            toUpperCaseTestPassed = true;
            System.out.println("ToUpperCase test was successful.");
        } else {
            System.out.println("Test \"toUpperCaseTest\" has failed.");
        }

        if (longVarTest == 983759048637863L) {
            longVarTestPassed = true;
        }
        if (intVarTest == 1020202) {
            intVarTestPassed = true;
        }
        if (floatVarTest == 63656.968F) {
            floatVarTestPassed = true;
        }

        System.out.println("Tests completed.");

    }
}
