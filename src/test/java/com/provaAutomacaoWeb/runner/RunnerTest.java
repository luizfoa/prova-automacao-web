package com.provaAutomacaoWeb.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        tags = " ",
        glue = {"com.provaAutomacaoWeb.steps", "com.provaAutomacaoWeb.Hooks"},
        plugin = {"json:target/report/CucumberReports.json", "pretty"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class RunnerTest {

}
