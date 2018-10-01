import java.io.*;
import java.util.ArrayList;

public class SpiralMaker{

	public SpiralMaker(){

		ArrayList<Integer> inputList = readFile("input-file-spiral-maker.txt");
		ArrayList<String [][]> spiralHolder = new ArrayList<>();
		for(Integer i: inputList){
			spiralHolder.add(getArray(i));
		}

		for(String [][] spiral: spiralHolder){
			for(int rows = 0; rows < spiral.length; rows++){
				for(int cols = 0; cols < spiral[0].length; cols++){
					System.out.print(spiral[rows][cols]);
				}
				System.out.println();
			}
			System.out.println();
		}
	}

	public String[][] getArray(int dimensions){
		String [][] output = new String[dimensions][dimensions];
		
		for(int rows = 0; rows < output.length; rows++){
			for(int cols = 0; cols < output[0].length; cols++){
				output[rows][cols] = "-\t";
			}
		}

		int currentRow = 0, currentCol = 0;
		int roundCount = 0;
		int lastRow = dimensions/ 2, lastCol = dimensions / 2;

		while(roundCount < Math.ceil(dimensions / 4.0)){
			if(currentRow != lastRow || currentCol != lastCol){
				while(currentCol < output[0].length - (roundCount*2)){
					output[currentRow][currentCol] = "*\t";
					currentCol++;
				}currentCol--;
			}

			if(currentRow != lastRow || currentCol != lastCol){
				while(currentRow < output.length - (roundCount*2)){
					output[currentRow][currentCol] = "*\t";
					currentRow++;
				}currentRow--;
			}

			if(currentRow != lastRow || currentCol != lastCol){
				while(currentCol >= (roundCount*2)){
					output[currentRow][currentCol] = "*\t";
					currentCol--;
				}currentCol++;
			}

			if(currentRow != lastRow || currentCol != lastCol){
				while(currentRow > 1+(roundCount*2)){
					output[currentRow][currentCol] = "*\t";
					currentRow--;
				}currentRow++;
			}

			roundCount++;
		}

		if(dimensions == 1){
			output[0][0] = "*";
		}

		return output;
	}

	public ArrayList<Integer> readFile(String file){	
		ArrayList<Integer> output = new ArrayList<>();
		File name = new File(file);
		try{
			BufferedReader input = new BufferedReader(new FileReader(name));
			
			String text;	
			while( (text=input.readLine())!= null) {
				output.add(Integer.valueOf(text));
			}
		}
		catch (IOException io) {
			System.err.println("File does not exist");
		}
		return output;
	}

	public static void main (String [] args){
		SpiralMaker app = new SpiralMaker();
	}
}