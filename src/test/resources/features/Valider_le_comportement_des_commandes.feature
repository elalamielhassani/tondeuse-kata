Feature: Déplacement de la tondeuse


  Scenario Outline: La tondeuse tourne et avance en fonction des commandes
    Given la tondeuse est orientée vers "<direction_initiale>"
    And la position de la tondeuse est en x=<x> et y=<y>
    And le coin supérieur de la pelouse est en x=5 et y=5
    When la tondeuse reçoit la commande "<commande>"
    Then la nouvelle orientation de la tondeuse est "<direction_finale>"
    And la nouvelle position de la tondeuse est x=<new_x> et y=<new_y>

    Examples:
      | direction_initiale | x | y | commande | direction_finale | new_x | new_y |
      | N                  | 0 | 0 | D        | E                | 0     | 0     |
      | N                  | 0 | 0 | G        | W                | 0     | 0     |
      | N                  | 0 | 0 | A        | N                | 0     | 1     |
      | E                  | 1 | 1 | D        | S                | 1     | 1     |
      | E                  | 1 | 1 | G        | N                | 1     | 1     |
      | E                  | 1 | 1 | A        | E                | 2     | 1     |
      | S                  | 2 | 2 | D        | W                | 2     | 2     |
      | S                  | 2 | 2 | G        | E                | 2     | 2     |
      | S                  | 2 | 2 | A        | S                | 2     | 1     |
      | W                  | 3 | 3 | D        | N                | 3     | 3     |
      | W                  | 3 | 3 | G        | S                | 3     | 3     |
      | W                  | 3 | 3 | A        | W                | 2     | 3     |