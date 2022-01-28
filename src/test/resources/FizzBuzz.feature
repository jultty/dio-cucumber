@FizzBuzz
Feature: FizzBuzz
  Print a sequence of N numbers,
  but for multiples of 3 print Fizz
  and for multiples of 5 print Buzz
  and for multiples of 3 and 5 print FizzBuzz

  Background: run in all scenarios
    Given the background flag is set
    And other flag is set

  @SingleNumber
  Scenario Outline: FizzBuzz a number
    Given the user selected the number <Number>
    When the user clicked the FizzBuzz button
    And validate background flag
    Then the program prints <Result>
    Examples:
    | Number | Result   |
    | 2      | 2        |
    | 3      | Fizz     |
    | 6      | Fizz     |
    | 5      | Buzz     |
    | 10     | Buzz     |
    | 15     | FizzBuzz |

  @NumberSequence
  Scenario: FizzBuzz sequence
    Given the user wants a sequence of 15 numbers
    When the user clicked the FizzBuzzSequence button
    And validate background flag
    Then the program printed:
    | 1        |
    | 2        |
    | Fizz     |
    | 4        |
    | Buzz     |
    | Fizz     |
    | 7        |
    | 8        |
    | Fizz     |
    | Buzz     |
    | 11       |
    | Fizz     |
    | 13       |
    | 14       |
    | FizzBuzz |


  Scenario: Table Advanced
    And validate background flag
    Then the table must be converted:
    | Test  | Address  | test@test.com  | 23 |
    | Test2 | Address2 | test2@test.com | 41 |
    | Test3 | Address3 | test3@test.com | 26 |
    | Test4 | Address4 | test4@test.com | 88 |