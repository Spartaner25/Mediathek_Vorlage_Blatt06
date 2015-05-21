package de.uni_hamburg.informatik.swt.se2.mediathek.materialien;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.Medium;

/**
 * Mit Hilfe der Vormerkkarte wird eine Linked List einem Medium zugewiesen,
 * die alle Vormerker enthält.
 * @author veit
 *
 */

public class Vormerkkarte {
    private final LinkedList<Kunde> _vormerker;
    private final Medium _medium;
    
    /**
     * Der Konstruktor für eine Verleihkarte
     * 
     * @param vormerker Der erste Vormerker für das Medium.
     * @param medium Das Medium, für das die Vormerkkarte erstellt werden soll.
     */
    public Vormerkkarte(Kunde vormerker, Medium medium)
    {
        assert vormerker != null : "Vorbedingung verletzt: entleiher != null";
        assert medium != null : "Vorbedingung verletzt: medium != null";
        
        _vormerker = new LinkedList<Kunde>();
        _medium = medium;
        _vormerker.add(vormerker);
    }
    
    /**
     * Fügt den Kunden als Vormerker hinzu
     * 
     * @param vormerker Der übergebenen Kunde
     */
    public void addVormerker(Kunde vormerker) 
    {
    	if(_vormerker.size()<=3)
    	{
    		_vormerker.add(vormerker);
    	}
    	else 
    	{
    		JOptionPane.showMessageDialog(null, "Die Liste der Vormerker ist voll", "alert", JOptionPane.ERROR_MESSAGE); 
		}
	}
    
    /**
     * Entfernt den Kunden als Vormerker von der Liste
     * 
     * @param vormerker Der übergebenen Kunde
     * @require _vormerker.contains(vormerker)
     */
    public void removeVormerker(Kunde vormerker) {
    	assert _vormerker.contains(vormerker);
    	_vormerker.remove(vormerker);
	}
    
    /**
     * Gibt alle Entleiher als Liste zurück zurück.
     * 
     * @return die Liste aller Vormerker
     * @ensure result != null
     */
    public LinkedList<Kunde> getVormerker()
    {
    	return _vormerker;
    }
    
    /**
     * Gibt den Entleiher zurück.
     * 
     * @return den Kunden an der Position, der das Medium entliehen hat.
     * 
     * @require position <= 2 && position >=0
     * @require position < _vormerker.size()
     * @ensure result != null
     */
    public Kunde getVormerker(int position)
    {
    	assert position <= 2 && position >=0 && position < _vormerker.size();
    	return _vormerker.get(position);
    }
    
    /**
     * Gibt eine String-Darstellung der Vormerkkartekarte (enhält Zeilenumbrüche)
     * zurück.
     * 
     * @return Eine formatierte Stringrepäsentation der Vormerkkartekarte. Enthält
     *         Zeilenumbrüche.
     * 
     * @ensure result != null
     */
    public String getFormatiertenString()
    {
        String vormerker = "";
        int i = 1;
        for (Kunde kunde : _vormerker) {
			vormerker = vormerker + "\n "+ i +":" + kunde.getFormatiertenString();
			i++;
		}
        return _medium.getFormatiertenString() + "vorgemerkt von"+ vormerker;
    }
    
    /**
     * Gibt das Medium, dessen Vormerken auf der Karte vermerkt ist, zurück.
     * 
     * @return Das Medium, dessen Ausleihe auf dieser Karte vermerkt ist.
     * 
     * @ensure result != null
     */
    public Medium getMedium()
    {
        return _medium;
    }
    
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((getVormerker(0) == null) ? 0 : getVormerker(0).hashCode());
        result = prime * result + ((_medium == null) ? 0 : _medium.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        boolean result = false;
        if (obj instanceof Vormerkkarte)
        {
        	Vormerkkarte other = (Vormerkkarte) obj;

            if (IsLinkedListEqual(other.getVormerker(),_vormerker)
                    && other.getMedium().equals(_medium))
            		result = true;
        }
        return result;
    }
    
	private static boolean IsLinkedListEqual(LinkedList<Kunde> list1, LinkedList<Kunde> list2) {
		if(list1.size()==list2.size())
		{
			if(list1.equals(list2))
			{
				return true;
			}
			else return false;
		}
		else return false;
	}
    
    @Override
    public String toString()
    {
        return getFormatiertenString();
    }

}
