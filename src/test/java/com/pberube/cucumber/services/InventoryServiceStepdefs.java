package com.pberube.cucumber.services;

import com.pberube.cucumber.services.InventoryService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class InventoryServiceStepdefs {

    InventoryService inventoryService;

    @Given("I use the inventory service")
    public void iUseTheInventoryService() {
        inventoryService = new InventoryService();
    }

    @And("I have {int} copies in stock of {string}")
    public void iHaveCopiesInStockOfEldenRing(int arg0, String arg1) {
        inventoryService.addToInventory(arg1, arg0);
    }

    @And("I have a small inventory")
    public void iHaveASmallInventory() {
        inventoryService = new InventoryService();
        inventoryService.addToInventory("Elden ring", 4);
        inventoryService.addToInventory("Kof XV", 2);
        inventoryService.addToInventory("Yoga Coach", 1);
    }

    @When("A customer buys {string}")
    public void iBuySomething(String arg0) {
        inventoryService.buy(arg0);
    }

    @Then("I still have {int} {string}")
    public void myInventoryHasChanged(int arg0, String arg1) {
        assertThat(inventoryService.getQty(arg1)).isEqualTo(arg0);
    }


}
