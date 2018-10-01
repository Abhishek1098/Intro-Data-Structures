import java.math.BigInteger; 
import java.io.*;
public class LucasNumberCalc{
	
	public LucasNumberCalc(){
		File name = new File("input-file-lucas.txt");

		try{
			BufferedReader input = new BufferedReader(new FileReader(name));
			
			String text;	
			while( (text=input.readLine())!= null) {
				System.out.println(generateNumber(BigInteger.valueOf(1), BigInteger.valueOf(2), 1, Integer.parseInt(text)));
			}
		}
		catch (IOException io) {
			System.err.println("File does not exist");
		}
	}

	public static void main(String [] args){
		LucasNumberCalc app=new LucasNumberCalc();
	}

	public BigInteger generateNumber(BigInteger value, BigInteger lastValue, int currentIndex, int desiredIndex){
		if(currentIndex == desiredIndex){
			return value;
		}
		
		BigInteger temp = value;
		value = value.add(lastValue);
		lastValue = temp;
		currentIndex++;
		return generateNumber(value, lastValue, currentIndex, desiredIndex);
	}
}