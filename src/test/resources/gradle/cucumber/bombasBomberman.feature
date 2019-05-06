# new feature
# Tags: optional

Feature: Poner Bombas Bomberman
  # ATDD 2

    # Punto 2.i
  Scenario: Bomberman pone una bomba y destruye paredes de Melamina
    Given Como bomberman que pone bombas
    When Arrojo una bomba cerca de paredes de melamina y me muevo 5 pasos al Norte
    Then Destruyo las paredes de melamina en un radio de 3 casilleros

