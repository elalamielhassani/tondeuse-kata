Feature: Definir si les coordonnées du coint supérieurs droit sont valid
  Scenario: Les coordonnées du coin supérieur droit sont supérieur à 0
    When le coin supérieur est en x=5 et y=5
    Then les coordonées du coin supérieur droit sont valid

  Scenario: Au moin un des coordonées du coint supérieur droit est supérieur à 0
    When le coin supérieur est en x=5 et y=0
    Then les coordonées du coin supérieur droit sont valid

  Scenario: Au moin un des coordonées du coint supérieur droit est inférieur à 0
    When le coin supérieur est en x=5 et y=-1
    Then les coordonées du coin supérieur droit sont invalid