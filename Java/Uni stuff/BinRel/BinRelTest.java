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
	private int currentNextKey;
	private class Pair<T>{
		private T elem1;
		private T elem2;
		Pair(T el1,T el2)
		{
			this.elem1=el1;
			this.elem2=el2;
		}
		
		T getFirst()
		{
			return this.elem1;
		}
		
		T getSecond()
		{
			return this.elem2;
		}
		
		public boolean equals(Object o)
		{
			if(o instanceof Pair)
				{
					Pair<T> Other=(Pair<T>)o;
					return this.elem1.equals(Other.elem1) && elem2.equals(Other.elem2);
				}
			else return false;
		}
		public int hashCode()
		{
			return elem1.hashCode()^(elem2.hashCode()*2);
		}
	};
	
	private HashMap<Integer,Pair<T>> Pairs;
	
	public void addPair(T el1,T el2)
	{
		Pair<T> P=new Pair<T>(el1,el2);
		this.Pairs.put(new Integer(currentNextKey),P );
		currentNextKey++;
	}
	
	public boolean areRelated(T el1,T el2)
	{
		Pair<T> P=new Pair<T>(el1,el2);
		return this.Pairs.containsValue(P);
	}
	
	public boolean isSymmetric()
	{
		T element1,element2;
		for(Pair<T> P:Pairs.values())
		{
		element1=P.getFirst();
		element2=P.getSecond();
		 if( (areRelated(element1,element2) && areRelated(element2,element1))!=true )
		return false;	 
		}
		return true;
	}
	
	public BinRel()
	{
		currentNextKey=0;
		this.Pairs=new HashMap<Integer,Pair<T>>();
	}
}

/*Realizzare la classe BinRel, che rappresenta una relazione binaria tra un insieme e se stesso. Il
metodo addPair aggiunge una coppia di oggetti alla relazione. Il metodo areRelated verifica se una
data coppia di oggetti appartiene alla relazione. Il metodo isSymmetric verifica se la relazione è
simmetrica.*/