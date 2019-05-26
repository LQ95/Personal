import java.util.*;
public class Inversion
{
	public static void main(String[] args)
	{
		Inverter Inv=new Inverter();
		//testing
		List<Integer> List1= new LinkedList<Integer>();
		List1.add(new Integer(50));
		List1.add(new Integer(5000));
		PrintList(List1);
		List<Object> List2= new ArrayList<Object>();
		List2.add(new Boolean(true));
		List2.add(new Thread());
		PrintList(List2);
		List<Exception> List3= new LinkedList<Exception>();
		List3.add(new IllegalArgumentException());
		List3.add(new ClassCastException());
		PrintList(List3);
		List<String> List4= new ArrayList<String>();
		List4.add("Sofferenza");
		List4.add("Java");
		PrintList(List4);
		List1=Inv.<Integer>reverseList(List1);
		PrintList(List1);
		List2=Inv.<Object>reverseList(List2);
		PrintList(List2);
		List3=Inv.<Exception>reverseList(List3);
		PrintList(List3);
		List4=Inv.<String>reverseList(List4);
		PrintList(List4);
	}
	
	static <T> void  PrintList(List<T> L)
	{
		Iterator<T> i=L.iterator();
		for(T element:L)
			{
			System.out.println(element);
			}
	}
}

class Inverter
{
		<T> List<T> reverseList(List<T> L)
		{
		T temp;
		int size=L.size();
		for(int j=0;j<size;j++)
			{
				temp=L.remove(j); //remove from current position and add to head
				L.add(0,temp);
			}
		return L;
		}
}
/*Il metodo reverseList accetta una lista e restituisce una nuova lista, che contiene gli stessi elementi
della prima, ma in ordine inverso.*/