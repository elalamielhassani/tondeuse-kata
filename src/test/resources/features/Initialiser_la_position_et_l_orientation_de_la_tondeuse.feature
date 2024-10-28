Feature: Initialiser la position et l'orientation de la tondeuse

  Scenario Outline: Configuration de la position initiale de la tondeuse
    Given une tondeuse avec l'id <id>
    When les coordonnées initiales de la tondeuse sont <coord_validity>
    And la direction initiale est <dir_validity>
    Then la configuration est <result>

    Examples:
      | id | coord_validity | dir_validity | result  |
      | 1  | valid          | valid        | valid   |
      | 1  | invalid        | valid        | invalid |
      | 1  | valid          | invalid      | invalid |