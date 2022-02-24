package com.pberube.cucumber.endpoints.rest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/com/pberube/cucumber/endpoints/rest/rest-api.feature")
public class CucumberIntegrationTest {

}
