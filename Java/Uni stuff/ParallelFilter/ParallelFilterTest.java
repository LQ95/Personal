import java.util.*;
public class ParallelFilterTest{
	public static void main(String[] args){
		Set<Integer> x = new HashSet<Integer>();
		x.add(1); x.add(2); x.add(5);
		Predicate<Integer> isOdd = new Predicate<Integer>() {
		public boolean test(Integer n) {
		return (n%2 != 0);
		}
		};
		Set<Integer> y = concurrentFilter(x, isOdd);
		for (Integer n: y)
		System.out.println(n);
	}
	
	static <T> Set<T> concurrentFilter(Set<T> S,Predicate<T> P)
	{
	Set<T> Result= S;
	class FilteringThread<T> extends Thread
		{
			Predicate<T> LocalPred;
			T LocalElement;
			Set<T> LocalResult;
			public synchronized void run()
				{
					if(LocalPred.test(LocalElement)==false)
						LocalResult.remove(LocalElement);
				}
			FilteringThread(T element,Predicate<T> P,Set<T> Result)
			{
				LocalPred=P;
				LocalElement=element;
				LocalResult=Result;
			}
		}
	FilteringThread<T> LocalFilter;
	HashSet<FilteringThread> threads=new HashSet<FilteringThread>();
	for(T element: S)
		{
		LocalFilter=new FilteringThread<T>(element,P,Result);
		threads.add(LocalFilter);
		}
	for(FilteringThread LocalThread:threads)
		{
			LocalThread.start();
		}
	for(FilteringThread LocalThread:threads)
		{
			try
			{
				LocalThread.join();
			}
			catch (InterruptedException e)
			{
				return Result;
			}
		}
	return Result;
	}
}

interface Predicate<T> {
boolean test(T x);
}