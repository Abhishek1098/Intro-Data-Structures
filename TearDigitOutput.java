import java.lang.*;
import java.io.*;
import java.util.ArrayList;

public class TearDigitOutput{

	ArrayList<ArrayList<Integer>> listHolder;

	public TearDigitOutput(){
		readFile("input.txt");

		for(int x = 1; x <= listHolder.size(); x++){
			int outputSum = getTearSum(listHolder.get(x-1).get(0), listHolder.get(x-1).get(1));
			System.out.println("Output #"+x+ ": "+outputSum);
		}
	}

	public int getTearSum(int splitNumb, int targetNumb){
		int outputSum=0;
		
		if(splitNumb < targetNumb){
			outputSum = splitNumb;
		}
		if(splitNumb > 999){

			int firstFourth = splitNumb % 10;
			int endThreeFourths = splitNumb / 10;
			
			int firstHalf = splitNumb % 100;
			int secondHalf = splitNumb / 100;
			
			int firstThreeFourths = splitNumb % 1000;
			int lastFourth = splitNumb / 1000;

			int middleTwoNumb = (splitNumb%1000)/10;

			int secondFourth = (splitNumb % 100 )/ 10;
			int thirdFourth = (splitNumb % 1000 )/ 100;

			int sum = firstFourth+endThreeFourths;
			if(sum <= targetNumb){
				outputSum = sum;
			}


			sum = firstHalf + secondHalf;
			if(sum <= targetNumb){	
				if(sum > outputSum){
					outputSum = sum;
				}	
			}
				

			sum = firstThreeFourths + lastFourth;
			if(sum <= targetNumb){
				if(sum > outputSum){
					outputSum = sum;
				}	
			}
						
			sum = firstFourth + middleTwoNumb + lastFourth;
			if(sum <= targetNumb){
				if(sum > outputSum){
					outputSum = sum;
				}	
			}

			sum = firstFourth + secondFourth + secondHalf;
			if(sum <= targetNumb){
				if(sum > outputSum){
					outputSum = sum;
				}	
			}

			sum = firstHalf + thirdFourth+lastFourth;
			if(sum <= targetNumb){
				if(sum > outputSum){
					outputSum = sum;
				}	
			}
			
		}else if(splitNumb > 99){
			int firstThird = splitNumb % 10;
			int secondThird = (splitNumb % 100)/10;
			int lastThird = splitNumb/100;
			int firstTwoThirds = splitNumb%100;
			int secondTwoThirds = splitNumb/10;

			int sum = firstThird+secondThird+lastThird;
			if(sum <= targetNumb){
				outputSum = sum;
			}

			sum = firstThird+secondTwoThirds;
			if(sum <= targetNumb){
				outputSum = sum;
			}

			sum = firstTwoThirds+lastThird;
			if(sum <= targetNumb){
				outputSum = sum;
			}

		}else if(splitNumb > 9){
			int firstNumb = splitNumb%10;
			int secondNumb = splitNumb/10;
			int sum = firstNumb + secondNumb;
			if(sum <= targetNumb){
				outputSum = sum;
			}	
		}
		return outputSum;
	}

	public void readFile(String file){
	
		File name = new File(file);
	
		listHolder = new ArrayList<>();

		try{
			BufferedReader input = new BufferedReader(new FileReader(name));
			
			String text;	
			while( (text=input.readLine())!= null) {
				ArrayList<Integer> list = new ArrayList<>();
				String [] pieces = text.split(" ");
				for(int x = 0; x < pieces.length; x++){
					list.add(Integer.valueOf(pieces[x]));
				}
				listHolder.add(list);
			}
		}
		catch (IOException io) {
			System.err.println("File does not exist");
		}
	}

	public static void main (String [] args){
		TearDigitOutput app = new TearDigitOutput();
	}

}