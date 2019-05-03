# new feature
# Tags: optional

Feature: Movimientos Bomberman
  # ATDD 1

    Scenario: Bomberman se puede mover a una celda vacia
        Given Como bomberman
        When Veo una celda vacia
        Then Me puedo mover a esa celda

    Scenario: Bomberman no se puede mover a una celda con una pared
        Given Como bomberman
        When Veo una celda con una pared
        Then No me puedo mover a esa celda

    Scenario: Bomberman muere al moverse a una celda con un enemigo
        Given Como bomberman
        When Veo una celda con un enemigo
        And Me muevo a esa celda
        Then Muero

