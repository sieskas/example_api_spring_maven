package com.example.springboot.functionals;

import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("com/example/springboot/functionals")
@ConfigurationParameter(
		key = Constants.GLUE_PROPERTY_NAME,
		value = "com.example.springboot.functionals")
public class RunCucumberTests {}
