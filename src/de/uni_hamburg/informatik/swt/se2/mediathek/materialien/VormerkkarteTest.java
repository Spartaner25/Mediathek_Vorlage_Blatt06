package de.uni_hamburg.informatik.swt.se2.mediathek.materialien;

import static org.junit.Assert.*;

import org.junit.Test;

import de.uni_hamburg.informatik.swt.se2.mediathek.fachwerte.Kundennummer;
import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.CD;
import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.Medium;

public class VormerkkarteTest {
    
    private Vormerkkarte _karte;
    private Kunde _kunde;
    private Kunde _kunde2;
    private Medium _medium;
	
	public VormerkkarteTest()
    {
        _kunde = new Kunde(new Kundennummer(123456), "ich", "du");
        _kunde2 = new Kunde(new Kundennummer(654321), "hci", "ud");
        _medium = new CD("bar", "baz", "foo", 123);
        _karte = new Vormerkkarte(_kunde, _medium);
    }

	@Test
    public void testeaddVormerker() throws Exception
    {
		_karte.addVormerker(_kunde2);
		assertEquals(_kunde2, _karte.getVormerker(1));
    }
	
	@Test
    public void testeremoveVormerker() throws Exception
    {
		assertFalse(_karte.getVormerker().contains(_kunde2));
		_karte.addVormerker(_kunde2);
		assertEquals(_kunde2, _karte.getVormerker(1));
		_karte.removeVormerker(_kunde2);
		assertFalse(_karte.getVormerker().contains(_kunde2));
    }
	
	@Test
    public void testegetFormatiertenString() throws Exception
    {
        assertNotNull(_karte.getFormatiertenString());
    }

    @Test
    public void testeKonstruktor() throws Exception
    {
        assertEquals(_kunde, _karte.getVormerker(0));
        assertEquals(_medium, _karte.getMedium());
    }
}
