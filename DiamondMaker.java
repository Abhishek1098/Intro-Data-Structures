import java.lang.*;
import java.io.*;
import java.util.ArrayList;
public class DiamondMaker{
	
	public DiamondMaker(){
		
		readFile("input-file-diamond.txt");
	}
	
	public void readFile(String file){
	
		File name = new File(file);
	
		ArrayList<ArrayList<Integer>> listHolder = new ArrayList<>();

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

			System.out.println("**********DIAMONDMAKER********");

			for(int x = 0; x < listHolder.size(); x++){
				int rowCount = listHolder.get(x).get(0);
				int columnCount = listHolder.get(x).get(1);
				int sideLength = listHolder.get(x).get(2);
				int topPointRow = listHolder.get(x).get(3);
				int topPointColumn = listHolder.get(x).get(4);
				makeDiamond(rowCount, columnCount, sideLength, topPointRow, topPointColumn);
				
				for(int y = 0; y < columnCount; y++){
					System.out.print("*");
				}
				System.out.println("");
			}
		}
		catch (IOException io) {
			System.err.println("File does not exist");
		}
	
	}

	public void makeDiamond(int rowCount, int columnCount, int sideLength, int topPointRow, int topPointColumn){	
		for(int rows = 0; rows < rowCount; rows++){
			for(int columns = 0; columns < columnCount; columns++){
				if(rows < topPointRow+(sideLength*2)){
					if(topPointRow <= rows){
						int distFromTop = Math.abs(rows - topPointRow);

						if(distFromTop < sideLength){
							if(Math.abs(columns-topPointColumn) <= (distFromTop)){
								System.out.print("x");
							}else if(columns == topPointColumn && rows == topPointRow){
								System.out.print("x");
							}else{
								System.out.print("o");
							}
						}else{
				
							int distFromMid = Math.abs(rows - (sideLength-1));
							if(Math.abs(columns-topPointColumn) <= Math.abs(sideLength-distFromMid)){
								System.out.print("x");
							}else if(columns == topPointColumn && rows == topPointRow){
								System.out.print("x");
							}else{
								System.out.print("o");
							}
						}
					}else{
						System.out.print("o");
					}
				}else{
					System.out.print("o");
				}		
			}
			System.out.println();
		}
	}

	public static void main (String [] args){
		DiamondMaker app = new DiamondMaker();
	}
}