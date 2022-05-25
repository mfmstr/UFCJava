package simpleVariableTask5;

public class Variable {
	public static void main(String[] args) {
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				System.out.println(i + " " + j);
			}
		}
		
		if(10 > 5) {
			int j = 10;
			int i = j / 2;
			j = i / 2;
		}
		
		//System.out.println(i + " " + j); 
		// --> i cannot be resolved to a variable
		// --> j cannot be resolved to a variable
		
		int i;
		int j;
		// System.out.println(i); --> Output: The local variable i may not have been initialized;
		i = 10;
		j = 2*i;
		i = i%j;
		
		System.out.println(i + " " + j); 
		
		// {martivi cvladebi punkcionireben im uaxloesi blokis farglebshi(da mat shignit, tumca ara garet) romlebshic sheikmnen};
		// tumca tu cvladi sheikmna gare blokshi, mis shignit igive saxelze agdebs duplicate-errors,
		// magalitad int i = 10; for(int i = 5; --> duplicate); tumca tu jer for ikneba mashin ara.
	}
}
