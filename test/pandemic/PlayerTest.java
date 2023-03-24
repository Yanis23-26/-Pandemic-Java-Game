package pandemic;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;




import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;

import pandemic.action.Action;
import pandemic.action.BuildAction;
import pandemic.action.MoveAction;
import pandemic.action.TreateDiseaseAction;

class PlayerTest {
	
	private Player player;
	
	@BeforeEach
	void setUp() throws Exception {
		player = new Player("Alice", City.ATLANTA) {
			@Override
			public Action initRoll() {
				return new MoveAction();
			}
		};
	}

	@Test
	void testGetCity() {
		assertEquals(City.ATLANTA, player.getCity());
	}

	@Test
	void testGetName() {
		assertEquals("Alice", player.getName());
	}

	@Test
	void testAddCard() {
		Card card = new Card(City.CHICAGO, CardType.CITY);
		player.addCard(card);
		assertTrue(player.getCards().contains(card));
	}

	@Test
	void testSetCity() {
		player.setCity(City.CHICAGO);
		assertEquals(City.CHICAGO, player.getCity());
	}

	@Test
	void testEqualsObject() {
		Player other = new Player("Alice", City.ATLANTA) {
			@Override
			public Action initRoll() {
				return new MoveAction();
			}
		};
		assertTrue(player.equals(other));
		
		Player different = new Player("Bob", City.CHICAGO) {
			@Override
			public Action initRoll() {
				return new TreateDiseaseAction();
			}
		};
		assertFalse(player.equals(different));
		
		assertFalse(player.equals(new Object()));
		assertFalse(player.equals(null));
	}

	@Test
	void testToString() {
		assertEquals("name of player is Alice and his city is ATLANTA", player.toString());
	}

	@Test
	void testRole() {
		assertEquals(MoveAction.class, player.actionWithRelation.getClass());
		player.role();
		// here you can check if the move action has been executed correctly
	}

	@Test
	void testInitAllActions() {
		player.initAllActions();
		assertEquals(4, player.actions.size());
		assertTrue(player.actions.stream().anyMatch(a -> a instanceof MoveAction));
		assertTrue(player.actions.stream().anyMatch(a -> a instanceof BuildAction));
		assertTrue(player.actions.stream().anyMatch(a -> a instanceof TreateDiseaseAction));
		assertTrue(player.actions.stream().anyMatch(a -> a instanceof FindCureAction));
	}

}