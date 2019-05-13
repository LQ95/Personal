import java.lang.*;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
public class TriangoloTest
{
	public static void main(String args[])
	{
		Triangolo x = new Triangolo(10,20,25);
		Triangolo y = new Triangolo.Rettangolo(5,8);
		Triangolo z = new Triangolo.Isoscele(6,5);
		System.out.println(x.getArea());
		System.out.println(y.getArea());
		System.out.println(z.getArea());
	}
}

class Triangolo {
	double side1;
	double side2;
	double side3;
	
	static class Rettangolo extends Triangolo{
		public Rettangolo(double cateto1,double cateto2)
			{
				super(cateto1,cateto2,sqrt(pow(cateto1,2) +pow(cateto2,2)));//ipotenusa
			}
		
		@Override
		public double getArea()
			{
				return (side1*side2)/2;
			}
	}
	
	static class Isoscele extends Triangolo{
		public Isoscele(double base,double lato)
			{
				super(lato,lato,base);
				if(isTriangle(lato,lato,base))
					{
						this.side1=this.side2=lato;
						this.side3=base;
					}
			}
		
		@Override
		public double getArea()
			{
				double height=sqrt(pow(side1,2)- (pow(side2,2))/4 );//altezza
				return (side3*height)/2;
			}
	}
	
	public double getArea()
		{
			double sp=(side1+side2+side3)/2;
			return sqrt(sp*(sp-side1)*(sp-side2)*(sp-side3));
		}
	
	public boolean isTriangle(double lato1,double lato2,double lato3)
		{
			int i=0;
			double somma,lato;
			double[] lati={lato1,lato2,lato3};
			for (i=0;i<lati.length;i++)
				{
					lato=lati[i];
					somma=lati[(i+1)%3] +lati[(i+2)%3];
					if(lato>somma) return false;
				}
			return true;
		}
	
	public Triangolo(double lato1,double lato2,double lato3)
		{
			if(isTriangle(lato1,lato2,lato3)==true)
				{
					side1=lato1;
					side2=lato2;
					side3=lato3;
				}
			else throw new IllegalArgumentException("questi tre lati non formano un triangolo");
		}
}

