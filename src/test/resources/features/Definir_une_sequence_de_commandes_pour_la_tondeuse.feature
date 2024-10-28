Feature: Definir si les commandes sont valid

  Scenario Outline: Valider la liste des commandes
    Given la commande est "<commande>"
    Then la commande est au status "<status>"

    Examples:
      | commande       | status |
      | G              | true   |
      | D              | true   |
      | A              | true   |
      | anything else! | false  |



  Scenario: Ajouter et retirer des éléments de la file de commandes
    Given La file de commande est vide
    When j'ajoute "A" dans la file
    And j'ajoute "G" dans la file
    And j'ajoute "D" dans la file
    Then la file contient 3 éléments

  Scenario: Retirer un élément de la file de commandes
    Given La file de commande est vide
    When j'ajoute "D" dans la file
    And j'ajoute "G" dans la file
    And j'ajoute "A" dans la file
    When je retire un élément de la file
    Then l'élément retiré est "D"
    And la file contient 2 éléments
    And le premier élément de la file est "G"

  Scenario: Retirer tous les éléments de la file de commande
    Given La file de commande est vide
    When j'ajoute "D" dans la file
    And j'ajoute "G" dans la file
    And j'ajoute "A" dans la file
    When je retire un élément de la file
    And je retire un élément de la file
    And je retire un élément de la file
    Then la file est vide