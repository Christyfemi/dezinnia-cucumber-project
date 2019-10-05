package com.dezlearn.test_runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@CucumberOptions(
		features= {"features"},
		glue= {"com.dezlearn.step_defs"},
		plugin= {"pretty","html:Reports1"},
		monochrome= true,
		dryRun= true,
		strict = false,
		tags = {"@P3"}
		//name = {"Arts"}
		)

/*
 * tags = {"@P1","@P0"} AND tags = {"@T1 and @T2"} => Execute scenarios that HAVE both P0 and P1 tags
 * tags = {"@P1, @P0"} AND tags = {"@T1 or @T2"}  => Execute all P0s and P1s
 */

/*
 * Order of Execution
 * 
 * 1. Scenario Specific Before Hook 
 * 
 * 2. Global Before Hook
 * 
 * 3. Global After Hook
 * 
 * 4. Scenario Specific After Hook 
 * 
 */

//test update from prajwal

@RunWith(Cucumber.class)
public class TestRunner2 {

}
