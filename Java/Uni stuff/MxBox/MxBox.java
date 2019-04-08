
import java.util.*;
import javax.activation.*;
public class MxBox{
		public static void main(String[] args) throws UnsupportedDataTypeException
		{
			MaxBox<Integer> bb3 = new MaxBox<Integer>();
			MaxBox<String> bb1 = new MaxBox<String>();
			MaxBox<String> bb2 = new MaxBox<String>(new Comparator<String>() {
				public int compare(String a, String b)
				{
						return a.length() - b.length();
				}
			});
			bb1.insert ("dodici");
			bb1.insert ("sette");
			bb2.insert ("dodici");
			bb2.insert ("sette");
			System.out.println(bb1.getMax());
			System.out.println(bb2.getMax());
		}
	
}
class MaxBox <T> {

	private T Content;
	private Comparator<T> TypeComparator;
	public T getMax()
		{
			return Content;
		}
	public void insert(T element) throws UnsupportedDataTypeException //Substitutes the element within if it's less than what is passed
		{
			if (this.Content == null)
				this.Content=element;
			else if(this.TypeComparator!=null)
				{
					if (this.TypeComparator.compare(element,this.Content)>0)
					this.Content=element;
				}
			else if (element instanceof Comparable)
				{ 
					Comparable<T> TComp=(Comparable<T>) element ;
					if (TComp.compareTo(this.Content) >0)
					this.Content=element;
					return;
				}
			else throw new UnsupportedDataTypeException("Uncompatible data type inserted ");
		}

	public MaxBox()
		{
			Content=null;
		}
		
	public MaxBox(T content)throws UnsupportedDataTypeException
		{
			if (content instanceof Comparable)	
				this.Content=content;
			else throw new UnsupportedDataTypeException("Uncompatible data type inserted ");
		}
			
	public MaxBox(Comparator<T> Comp,T content)
		{
			Content=content;
			this.TypeComparator=Comp;
		}	
	public MaxBox(Comparator<T> Comp)
		{
			this.TypeComparator=Comp;
		}
}