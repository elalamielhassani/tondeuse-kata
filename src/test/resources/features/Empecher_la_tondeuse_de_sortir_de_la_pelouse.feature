Feature: Empêcher la tondeuse de sortir de la pelouse

  Scenario Outline: La tondeuse respecte les limites de la pelouse
    Given la tondeuse est orientée vers "<direction_initiale>"
    And la position de la tondeuse est en x=<x> et y=<y>
    And le coin supérieur de la pelouse est en x=<x_max> et y=<y_max>
    When la tondeuse reçoit la commande "<commande>"
    Then la nouvelle position de la tondeuse est x=<new_x> et y=<new_y>
    And la nouvelle orientation de la tondeuse est "<direction_finale>"

    Examples:
      | direction_initiale | x | y | x_max | y_max | commande | new_x | new_y | direction_finale |
      | N                  | 0 | 0 | 5     | 5     | A        | 0     | 1     | N                |
      | N                  | 0 | 5 | 5     | 5     | A        | 0     | 5     | N                |
      | S                  | 0 | 0 | 5     | 5     | A        | 0     | 0     | S                |
      | S                  | 5 | 0 | 5     | 5     | A        | 5     | 0     | S                |
      | E                  | 0 | 0 | 5     | 5     | A        | 1     | 0     | E                |
      | E                  | 5 | 5 | 5     | 5     | A        | 5     | 5     | E                |
      | W                  | 2 | 2 | 5     | 5     | A        | 1     | 2     | W                |
      | W                  | 0 | 3 | 5     | 5     | A        | 0     | 3     | W                |
