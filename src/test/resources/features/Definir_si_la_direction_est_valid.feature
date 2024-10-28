Feature: Definir si les direction sont valid

  Scenario Outline: Initier la direction de la tondeuse avec des valeurs valid et invalid
    Given la direction est "<direction>"
    Then la direction est au status "<status>"

    Examples:
      | direction      | status |
      | N              | true   |
      | S              | true   |
      | W              | true   |
      | W              | true   |
      | anything else! | false  |