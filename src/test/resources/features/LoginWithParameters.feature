Feature: Login with parameters

  Scenario: Login as librarian 11
    Given I am on the login page
    When I enter username "librarian11@library"
    And I enter password 'I61FFPPf'
    And click the sign in button
    Then dashboard should be displayed


  Scenario: Login as librarian 12
    Given I am on the login page
    When I enter username "librarian12@library"
    And I enter password 'AOYKYTMJ'
    And click the sign in button
    And there should be '2841' users
    Then dashboard should be displayed
     #number can be whatever you have there

  Scenario: Login as librarian same line
    Given I am on the login page
    When I login using 'librarian12@library' and "AOYKYTMJ"
    Then dashboard should be displayed

    #number can be whatever you have there











