package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Couleur;

public class CouleurTest {
	
	private Couleur couleur = new Couleur("Rouge",255, 0, 0);
	@Test
	public void testgetNom() { 
		assertEquals("Rouge", couleur.getNom());
	}
	@Test
	public void testgetR() {
		assertEquals(255, couleur.getR());
	}
	@Test
	public void testgetG() { 
		assertEquals(0, couleur.getG());
	}
	@Test
	public void testgetB() {
		assertEquals(0, couleur.getB());
	}
	@Test
	public void testsetNom() {
		couleur.setNom("Bleu");
		assertEquals("Bleu", couleur.getNom());
	}
	@Test
	public void testsetR() {
		couleur.setR(0);
		assertEquals(0, couleur.getR());
	}
	@Test
	public void testsetG() {
		couleur.setG(255);
		assertEquals(255, couleur.getG());
	}
	@Test
	public void testsetB() {
		couleur.setB(255);
		assertEquals(255, couleur.getB());
	}
	
}
