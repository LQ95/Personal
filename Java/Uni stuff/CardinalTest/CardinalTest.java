import java.lang.Math.*;

public class CardinalTest{
	public static void main(String[] args){
		Cardinal nord = Cardinal.N;
		System.out.println(nord.isOpposite(Cardinal.S));
		Cardinal nordest = Cardinal.mix(Cardinal.N, Cardinal.E);
		assert nordest==Cardinal.NE : "Errore inaspettato!";
		Cardinal nordnordest = Cardinal.mix(nordest, Cardinal.N);
		System.out.println(nordnordest);
	}
}

enum Cardinal{
N,NNE,NE,ENE,E,ESE,ES,SSE,S,SSO,SO,OSO,O,ONO,NO,NNO;

boolean isOpposite(Cardinal CardinalValue)
	{
		return (Math.abs(CardinalValue.ordinal()-this.ordinal())==8);
	}
static Cardinal mix(Cardinal Dir1,Cardinal Dir2)
	{
		int index1,index2;
		index1=Dir1.ordinal();
		index2=Dir2.ordinal();
		Cardinal[] values=Cardinal.values();
		return values[(index1+index2)/2];
	}	
}