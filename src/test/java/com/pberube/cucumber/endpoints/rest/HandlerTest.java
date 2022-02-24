package com.pberube.cucumber.endpoints.rest;

import com.pberube.cucumber.services.InventoryService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.text.MessageFormat;

import static org.assertj.core.api.Assertions.assertThat;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HandlerTest {

    @Autowired
    Handler handler;

    @Autowired
    InventoryService inventoryService;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    protected void callGetQty(String gameName){
        String url = new StringBuilder().append("http://localhost:").append(port).append("/rest-api/getQty/").append(gameName).toString();
        latestResponse = this.restTemplate.getForObject(url, InventoryQuestionDTO.class);
    }

    protected InventoryQuestionDTO latestResponse;

    @Given("The store has {int} copies in stock of {string}")
    public void iHaveIntCopiesInStockOfString(int arg0, String arg1) {
        inventoryService.addToInventory(arg1, arg0);
    }

    @When("A customer ask i have {string}")
    public void aCustomerAskIHaveASpecificGame(String gameName) {
        callGetQty(gameName);
    }

    @Then("The game is in stock")
    public void theGameIsInStock() {
        assertThat(latestResponse.getQtyInStock()).isGreaterThan(0);
    }

}