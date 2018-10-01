import java.lang.*;
import java.io.*;
import java.util.ArrayList;
public class GuitarTranslator{

	ArrayList<String[][]> measureList;
	
	public GuitarTranslator(){	
		measureList = new ArrayList<>();
		readFile("input-file-guitar.txt");
 
		System.out.println();

		String [][] notePositions = { 
			{"E","A","D","G", "B", "E"},
    			{"F","A#","D#","G#", "C", "F"},	
			{"F#","B","E","A", "C#", "F#"},
    			{"G","C","F","A#", "D", "G"},
			{"G#","C#","F#","C", "D#", "G#"}
		};

		String [][] outputPositions = {
			{"30", "25", "20", "15", "10", "5"},
			{"29", "24", "19", "14", "9", "4"},
			{"28", "23", "18", "13", "8", "3"},
			{"27", "22", "17", "12", "7", "2"},
			{"26", "21", "16", "11", "6", "1"}		
		};

		String [][] output = new String [1+(notePositions.length*notePositions[0].length)][measureList.size()+1];
		for(int rows = 0; rows < output.length; rows++){
			for(int cols = 0; cols < output[0].length; cols++){
				output[rows][cols]="";
			}	
		}
		int outputRow = 1;
		for(int cols = (notePositions[0].length) -1; cols >= 0; cols--){
			for(int rows = notePositions.length-1; rows >=0; rows--){
				output[outputRow][0] = notePositions[rows][cols];
				outputRow++;
			}	
		}

		for(int cols = 1; cols < measureList.size()+1; cols++){
			output[0][cols]=cols+"";
		}

		int index=1;
		for(String [][] measure: measureList){
			for(int rows = 0; rows < measure.length; rows++){
				for(int cols = 0; cols < measure[0].length; cols++){
					String mark = measure[rows][cols];
					if(mark.equals("*") || mark.equals("o")){
						outputRow  = Integer.parseInt(outputPositions[rows][cols]);
						output[outputRow][index] = "0"; 
					}
				}
			}
			index++;
		}
		
		for(int rows = 0; rows < output.length; rows++){
			System.out.print("\t");
			for(int cols = 0; cols < output[0].length; cols++){
				System.out.print(output[rows][cols]+"\t");
			}	
			System.out.println();
		}
	}
	
	public void readFile(String file){
	
		File name = new File(file);

		try{
			BufferedReader input = new BufferedReader(new FileReader(name));

			String text;
			int rowCount = 0;
			while( (text=input.readLine())!= null) {
				String[] arr = text.split(",");
				if(rowCount == 0){
					for(int measure = 0; measure < arr.length; measure++){
						measureList.add(new String[5][6]);
					}
				}
				for(int i=0; i < arr.length; i++){
					String [] notes = arr[i].split("");
					String [][] currMeasure  = measureList.get(i);
					for(int j = 0; j < notes.length; j++){
						currMeasure[rowCount][j] = notes[j];
					}
					measureList.set(i, currMeasure);
				}
				rowCount++;
			}
		}
		catch (IOException io) {
			System.err.println("File does not exist");
		}
	
	}

	public static void main (String [] args){
		GuitarTranslator app = new GuitarTranslator();
	}
}