package com.windrift.cucumber;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by gary on 8/09/14.
 */
@RunWith(Cucumber.class)
@Cucumber.Options(format = "pretty",
        tags = {"~@Ignore"},
        features = "src/test/resources")
public class TestCukes {
}
