package com.weirdo.rough;


import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.weirdo.testcases.BaseTest;
import com.weirdo.utilities.TaggedException;

import java.util.ArrayList;
import java.util.List;

public class TestScript2 extends BaseTest {

    private ThreadLocal<List<TaggedException>> errors = ThreadLocal.withInitial(ArrayList::new);

    @Test
    public void launchGoogle(ITestResult result) {
        System.out.println("Running test: launchGoogle");
        try {
            // Simulate an error
            throw new TaggedException("Google not launched", "LaunchError");
        } catch (TaggedException e) {
            errors.get().add(e);
        }

        // Check for errors at the end of the test
        if (!errors.get().isEmpty()) {
            result.setAttribute("errors", errors.get());
            for (TaggedException error : errors.get()) {
                System.err.println("Caught error: " + error.getMessage());
            }
        }
    }

    @Test
    public void launchZoho(ITestResult result) {
        System.out.println("Running test: launchZoho");
        try {
            // Simulate an error
            throw new TaggedException("Zoho not launched", "LaunchError");
        } catch (TaggedException e) {
            errors.get().add(e);
        }

        // Check for errors at the end of the test
        if (!errors.get().isEmpty()) {
            result.setAttribute("errors", errors.get());
            for (TaggedException error : errors.get()) {
                System.err.println("Caught error: " + error.getMessage());
            }
        }
    }
}
