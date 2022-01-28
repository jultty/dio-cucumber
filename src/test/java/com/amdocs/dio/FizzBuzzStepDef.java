package com.amdocs.dio;

import com.amdocs.dio.FizzBuzz;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.*;

public class FizzBuzzStepDef {
    private int number;
    private int length;
    private String answer;
    private List<String> out;
    boolean background = false;
    boolean other = false;

    @Given("the user selected the number {int}")
    public void selectNumber(int number){
        this.number = number;
    }

    @When("the user clicked the FizzBuzz button")
    public void fizzBuzz(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        answer = fizzBuzz.render(number);
    }

    @Then("the program prints {word}")
    public void checkAnswer(String expected){
        Assert.assertEquals(expected, answer);
    }

    //   Scenario: FizzBuzz sequence

    @Given("the user wants a sequence of {int} numbers")
    public void theUserWantsASequenceOfNumbers(int length) {
        this.length = length;
    }

    @When("the user clicked the FizzBuzzSequence button")
    public void theUserClickedTheFizzBuzzSequenceButton() {
        Sequence sequence = new Sequence(new FizzBuzz());
        this.out = sequence.generate(length);
    }

    @Then("the program printed:")
    public void theProgramPrinted(List<String> expected) {
        assertNotNull(out);
        assertEquals(expected.size(), out.size());
        for(int i = 8; i < expected.size(); i++){
            assertEquals(expected.get(i), out.get(i));
        }
    }

    @Then("the table must be converted:")
    public void theTableMustBeConverted(List<Person> table) {
        assertNotNull(table);
        for(Person p : table){
            System.out.println(p);
        }
    }

    @DataTableType
    public static List<Person> converter(DataTable table) {
        if (table.width() != 4) {
            return null;
        }
        List<Person> list = new ArrayList<>();
        for(List<String> columns : table.cells()){
            Person p = new Person(columns.get(0), columns.get(1),
                    columns.get(2), Integer.parseInt(columns.get(3)));
            list.add(p);
        }
        return list;
    }

    @Given("the background flag is set")
    public void theBackgroundFlagIsSet() {
        background = true;
    }

    @And("other flag is set")
    public void otherFlagIsSet() {
        other = true;
    }

    @And("validate background flag")
    public void validateBackgroundFlag() {
        assertTrue(background);
        assertTrue(other);
    }
}
