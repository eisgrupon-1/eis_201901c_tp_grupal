# new feature
# Tags: optional

Feature: Poner Bombas Bomberman
  # ATDD 2

    # Punto 2.i
  Scenario: Bomberman pone una bomba y destruye paredes de Melamina
    Given Como bomberman que pone bombas
    When Arrojo una bomba cerca de paredes de melamina y me muevo 5 pasos al Norte
    Then Destruyo las paredes de melamina en un radio de 3 casilleros

    # Punto 2.ii
  Scenario: Bomberman pone una bomba y destruye paredes de Melamina
    Given Como bomberman que pone bombas
    When Arrojo una bomba cerca de enemigos y me muevo 5 pasos al Norte
    Then Destruyo los enemigos en un radio de 3 casilleros

    # Punto 2.iiii
  Scenario: Bomberman pone una bomba y destruye paredes de Acero
    Given Como bomberman que pone bombas
    When Arrojo una bomba cerca de paredes de acero y me muevo 5 pasos al Norte
    Then No destruyo las paredes de acero

