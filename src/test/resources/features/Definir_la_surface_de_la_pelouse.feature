Feature: Definir si les coordonnées du coint supérieurs droit sont valid
  Scenario Outline: Validation de la position du coint supérieurs
    When le coin supérieur est en x=<x_max> et y=<y_max>
    Then la position est <result>

    Examples:
      | x_max | y_max | result  |
      | 5     | 5     | valid   |
      | -5    | 5     | invalid |
      | 5     | -5    | invalid |
      | 0     | 0     | valid |
      | -5    | -5    | invalid |
