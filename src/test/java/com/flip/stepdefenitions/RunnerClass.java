package com.flip.stepdefenitions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(features = "src//test//resources//Features//TelevisionValidation.feature",
                  glue = "com.flip.stepdefenitions",
                  plugin = "html : target",
                  monochrome = true,
                  dryRun = false,
                  tags = {"~@map"})

public class RunnerClass {

	
}
