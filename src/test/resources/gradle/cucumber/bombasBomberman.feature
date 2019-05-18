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

    # Punto 2.iii
  Scenario: Bomberman pone una bomba y destruye paredes de Acero
    Given Como bomberman que pone bombas
    When Arrojo una bomba cerca de paredes de acero y me muevo 5 pasos al Norte
    Then No destruyo las paredes de acero

 # ATDD 3

    # Punto 3.
  Scenario: Bomberman suelta una bomba y muere Bagulaa
    Given Como bomberman que pone bombas
    When Arroja una bomba cerca de bagulaa y lo mata
    Then Bomberman obtiene poder lanza bombas

# ATDD 4

    # Punto 4.
  Scenario: Bomberman suelta una bomba y muere ProtoMaxJr
    Given Como bomberman que pone bombas
    When Arroja una bomba cerca de ProtoMaxJr y lo mata
    Then Bomberman obtiene poder SaltarTodoTipoDePared


# ATDD 5

    # Punto 5.
  Scenario: Bomberman suelta una bomba y muere ProtoMaxUnits
    Given Como bomberman que pone bombas
    When Arroja una bomba cerca de ProtoMaxUnits y lo mata
    Then Bomberman obtiene poder SaltarOlanzarBombas


