import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class BowlingGameKataTest {

	private Game g;

	private void rollMany(int allRollCount, int pins) {
		for (int i = 0; i < allRollCount; i++) {
			g.roll(pins);			
		}
	}
	
	private void rollSpare() {
		g.roll(5);
		g.roll(5);
	}
	
	private void rollStrike() {
		g.roll(10);		
	}
	
	@Before
	public void setUp() {
		g = new Game();
	}
	
	@Test
	public void canRoll() throws Exception {
		g.roll(0);		
	}

	@Test
	public void gutterGame() throws Exception {		
		rollMany(20, 0);
		assertEquals(0, g.score());
	}
	
	@Test
	public void allOneGame() throws Exception {
		rollMany(20, 1);
		assertEquals(20, g.score());
	}
	
	@Test
	public void allTwoGame() throws Exception {
		rollMany(20, 2);
		assertEquals(40, g.score());
	}
		
	
	@Test
	public void oneSpareGame() throws Exception {
		rollSpare();
		g.roll(3); 
		rollMany(17, 0);
		assertEquals(16, g.score());
	}
	
	@Test
	public void oneStrikeGame() throws Exception {
		rollStrike();
		g.roll(3);
		g.roll(4);
		rollMany(16, 0);
		assertEquals(24, g.score());
	}
	
	@Test
	public void PerfectGame() throws Exception {			
		rollMany(12, 10);
		assertEquals(300, g.score());
	}
}
