import java.util.*;
public class BinRelTest
{
	public static void main(String args[])
	{
		BinRel<String> rel = new BinRel<>();
		rel .addPair("a", "albero");
		rel .addPair("a", "amaca");
		System.out.println( rel .isSymmetric());
		rel .addPair("albero", "a");
		rel .addPair("amaca", "a");
		System.out.println( rel .isSymmetric());
		System.out.println( rel .areRelated("a", "amaca"));
	}
}
class BinRel<T>
{
	private HashMap<T,HashSet<T>> pairs;

        // Ugualmente inefficiente, ma più semplice:
        // private List<Pair<T>> Pairs;

        // Più efficiente:
        // private Map<T,Set<T>> pairs;
        // add diventa costante
        // isSymmetric diventa lineare
        // areRelated diventa costante
	//TODO finisci la nuova implmentazione
	public void addPair(T el1,T el2)
	{
		HashSet<T> LocalSet;
		if (this.pairs.containsKey(el1))
		LocalSet=pairs.get(el1);
		else LocalSet=new HashSet<T>();
		LocalSet.add(el2);
		this.pairs.put(el1,LocalSet);
	}
	
	public boolean areRelated(T el1,T el2) // costante? 
	{
		boolean result=false;
		HashSet<T> LocalSet;
		if (this.pairs.containsKey(el1))
		{
			LocalSet=pairs.get(el1);
			return LocalSet.contains(el2);
		}
		return result;
	}
	
	public boolean isSymmetric() // lineare O(n)?
	{
		T element1;
		HashSet<T> element2;
		for(T key:pairs.keySet())
		{
			element1=key;
			element2=pairs.get(key);
			for(T element:element2)
				{
				if( (areRelated(element,element1))!=true )
				return false;	 
				}
			return true;
		}
	return false;	 
	}
	public BinRel(){
		this.pairs=new HashMap<T,HashSet<T>>();
	}
}

/*Realizzare la classe BinRel, che rappresenta una relazione binaria tra un insieme e se stesso. Il
metodo addPair aggiunge una coppia di oggetti alla relazione. Il metodo areRelated verifica se una
data coppia di oggetti appartiene alla relazione. Il metodo isSymmetric verifica se la relazione è
simmetrica.*/
