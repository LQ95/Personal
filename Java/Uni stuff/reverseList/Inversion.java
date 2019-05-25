import java.util.*;
public class Inversion
{
	public static void main(String[] args)
	{
		Inverter Inv=new Inverter();
		List<Integer> List1= new LinkedList<Integer>();
		List<Object> List2= new ArrayList<Object>();
		List<Exception> List3= new LinkedList<Exception>();
		List<String> List4= new ArrayList<String>();
		List1=Inv.<Integer>reverseList(List1);
		List2=Inv.<Object>reverseList(List2);
		List3=Inv.<Exception>reverseList(List3);
		List4=Inv.<String>reverseList(List4);
	}
	

}

class Inverter
{
		<T> List<T> reverseList(List<T> L)
		{
		T temp;
		int size=L.size();
		Iterator<T> i=L.iterator();
		for(int j=0;j<size;j++)
			{
				temp=i.next();
				i.remove();
				L.add(temp);
			}
		return L;
		}
}
/*Il metodo reverseList accetta una lista e restituisce una nuova lista, che contiene gli stessi elementi
della prima, ma in ordine inverso.*/