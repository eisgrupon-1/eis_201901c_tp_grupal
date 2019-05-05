# new feature
# Tags: optional

Feature: Movimientos Bomberman
  # ATDD 1

    # Punto 1.i
    Scenario: Bomberman se puede mover a una celda vacia
        Given Como bomberman en una celda
        When Me intento mover a una celda vacia
        Then Sigo vivo y ahora estoy en la celda

    # Punto 1.ii
    Scenario: Bomberman no se puede mover a una celda con una pared de Melamina
        Given Como bomberman en una celda
        When Me intento mover a una celda con una pared de Melamina
        Then No me movi a la celda de la pared de Melamina y sigo en mi misma celda

    Scenario: Bomberman no se puede mover a una celda con una pared de Acero
        Given Como bomberman en una celda
        When Me intento mover a una celda con una pared de Acero
        Then No me movi a la celda de la pared de Acero y sigo en mi misma celda

    # Punto 1.iii
    Scenario: Bomberman muere al moverse a una celda con un enemigo
        Given Como bomberman en una celda
        When Me intento mover a una celda con un enemigo
        Then Muero