import java.util.*;
public class RoomManager
{
	public static void main(String args[])
		{
			Room r = new Room();
			Reservation p1 = r.reserve("Pasquale Cafiero", 105, 120);
			Reservation p2 = r.reserve("Carlo Martello", 5, 20);
			Reservation p3 = r.reserve("Piero", 20, 22);
			Reservation p4 = r.reserve("Marinella", 200, 222);
			for (Reservation p: r . reservations ())
			System.out.println(p.getName());
		}
}

class Room
{
	private TreeSet<Reservation> Reservations;
	Reservation reserve(String Name,int Beginning,int End)
		{
			Reservation NewRes=new Reservation(Name,Beginning,End);
			for (Reservation p: Reservations)
			{
				if( (Beginning>p.getBeginning() && Beginning<p.getEnd() ) ||(End>p.getBeginning() && End<p.getEnd() ))
					throw new IllegalArgumentException("Conflitto cronologico,stai prenotando per una giornata già occupata.");
			}
			Reservations.add(NewRes);
			return NewRes;
		}
	TreeSet<Reservation> reservations ()
	{
		return Reservations;
	}
	public Room()
	{
		this.Reservations= new TreeSet<Reservation>();
	}
}

class Reservation implements Comparable{                //TODO,cambia hash code,così l'inserimetno è in ordine cronologgggico
	private String Name;
	private int Beginning;
	private int End;
	
	public Reservation(String name,int beginning,int end)
	{
		this.Name=name;
		this.Beginning=beginning;
		this.End=end;
	}
	
	public int getBeginning()
	{
		return this.Beginning;
	}
	public int getEnd()
	{
		return this.End;
	}
	String getName()
	{
		return this.Name;
	}
	
	public int compareTo(Object x)
	{
		Reservation OtherRes=(Reservation) x;
		if (this.Beginning==OtherRes.Beginning && this.End==OtherRes.End)
			return 0;
		else if (this.Beginning<OtherRes.Beginning)
			return -1;
		else
			return 1;
	}
	
	public int hashCode()
	{
		return (Beginning *100)+End; 
	}
}


/* Realizzare le classi Room e Reservation, che rappresentano una camera d’albergo
e una prenotazione per la camera. Il metodo reserve di Room accetta un nome, la data di
inizio e di fine prenotazione, e restituisce un oggetto di tipo Reservation. Se la camera è occupata
in una delle giornate richieste, il metodo lancia un’eccezione. Per semplicità, una data è rappresentata
da un numero intero tra 0 a 365. Il metodo reservations di Room consente di scorrere
l’elenco delle prenotazioni, in ordine cronologico.
L’implementazione deve rispettare il seguente esempio d’uso.*/

 