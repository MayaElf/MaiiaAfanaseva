Feature: Different Elements Page test

  Scenario:
    Given I open JDI GitHub site
    And I login as user 'Roman Iovlev'
    And I click on "Service" button in Header
    And I click on "Different Elements" button in Service dropdown
    When I select 'Wind' and 'Water' checkboxes
    And I select 'Selen' in radio buttons
    And I select 'Yellow' in dropdown
    Then Log rows are displayed and checkbox name and its status are corresponding to selected
    And Log rows are displayed and radio button name and it status is corresponding to selected
    And Log rows are displayed dropdown name and selected value is corresponding to selected

