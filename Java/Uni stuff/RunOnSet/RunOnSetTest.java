import java.util.*;
public class RunOnSetTest
{
	public static void main(String[] args)
	{
		Collection<Integer> s = new HashSet<Integer>();
		s.add(3); s.add(13); s.add(88);
		RunnableWithArg<Integer> r = new RunnableWithArg<Integer>() {
		public void run(Integer i) {
			System.out.println(i/2);
			}
		};
		Thread t = new RunOnSet<Integer>(r, s);
		t.start();
	}
}

class RunOnSet<T> extends Thread{
	RunnableWithArg<T> LocalRunnable;
	Collection<T> LocalCol;
	public void run(){
		for(T I:LocalCol)
		{
			LocalRunnable.run(I);
		}
	}
	RunOnSet(RunnableWithArg<T> r, Collection<T> col)
	{
		this.LocalRunnable=r;
		this.LocalCol=col;
	}
}

interface RunnableWithArg<T> {
void run(T x);
}