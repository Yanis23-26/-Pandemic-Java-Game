package pandemic.actions;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import pandemic.Board.City;
import pandemic.Board.GameBoard;
import pandemic.Roles.Player;

public class MoveActionTest {

    private GameBoard board;
    private Player player;

    @Before
    public void setUp() throws Exception {
        // create a game board and a player to test MoveAction
        board = new GameBoard();
        City city1 = new City("City1");
        City city2 = new City("City2");
        City city3 = new City("City3");
        city1.addNeighbor(city2);
        city1.addNeighbor(city3);
        city2.addNeighbor(city1);
        city3.addNeighbor(city1);
        board.addCity(city1);
        board.addCity(city2);
        board.addCity(city3);
        player = new Player("Player1", city1);
        city1.addPlayer(player);
    }

    @Test
    public void testActOn() {
        // create a MoveAction for the player to move to city2
        MoveAction moveAction = new MoveAction() {
            @Override
            public int getChoice() {
                // simulate player choosing city2
                return 1;
            }
        };
        // perform the move action
        moveAction.actOn(player);
        // check that the player is in city2
        assertEquals("City2", player.getCity().getName());
        // check that city1 no longer has the player
        assertFalse(board.getCity("City1").hasPlayer(player));
        // check that city2 has the player
        assertTrue(board.getCity("City2").hasPlayer(player));
    }

    @Test
    public void testIsPossible() {
        // create a MoveAction for the player to move to city3
        MoveAction moveAction = new MoveAction() {
            @Override
            public int getChoice() {
                // simulate player choosing city3
                return 2;
            }
        };
        // check that the move is possible
        assertTrue(moveAction.isPossible(player));
        // move the player to city3
        moveAction.actOn(player);
        // create a MoveAction for the player to move back to city1
        moveAction = new MoveAction() {
            @Override
            public int getChoice() {
                // simulate player choosing city1
                return 1;
            }
        };
        // check that the move is not possible (city1 is not a neighbor of city3)
        assertFalse(moveAction.isPossible(player));
    }

}
