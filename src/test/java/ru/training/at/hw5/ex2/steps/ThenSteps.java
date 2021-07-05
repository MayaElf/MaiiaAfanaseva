package ru.training.at.hw5.ex2.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import java.util.List;
import org.testng.Assert;

public class ThenSteps extends AbstractStep {

    @Then("{string} page should be opened")
    public void getTitle(String title) {
        Assert.assertEquals(indexPage.getTitles(), title);
    }

    @And("{string} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void sixDropDowns(String size) {
        Assert.assertEquals(indexPage.quantityOfDropdowns(), Integer.parseInt(size));
    }

    @And("{string} Usernames should be displayed on Users Table on User Table Page")
    public void sixUserNames(String size) {
        Assert.assertEquals(indexPage.userNamesQuantity(), Integer.parseInt(size));
    }

    @And("{string} Description texts under images should be displayed on Users Table on User Table Page")
    public void sixUserDescriptions(String size) {
        Assert.assertEquals(indexPage.userDescriptionQuantity(), Integer.parseInt(size));
    }

    @And ("{string} checkboxes should be displayed on Users Table on User Table Page")
    public void sixCheckBoxes(String size) {
        Assert.assertEquals(indexPage.userCheckBoxQuantity(), Integer.parseInt(size));
    }

    @And("User table should contain following values:")
    public void userTable(DataTable table) {
        List<List<String>> rows = table.subTable(1, 0).asLists(String.class);
        Assert.assertEquals(indexPage.getUserDetails().toArray(), rows.toArray());
    }

    @And("droplist should contain values in column Type for user Roman")
    public void dropDown(DataTable table) {
        List<String> row = table.subTable(1, 0).asList();
        Assert.assertEquals(indexPage.getSelectOptions().toArray(), row.toArray());
    }

}
