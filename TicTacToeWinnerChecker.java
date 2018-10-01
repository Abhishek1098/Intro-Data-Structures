import java.io.*;
import java.util.ArrayList;
public class TicTacToeWinnerChecker{
	
	public TicTacToeWinnerChecker(){
		ArrayList<ArrayList<String>> listHolder = new ArrayList<>();

		File name = new File("input-file-tic-tac-toe.txt");
		try{
			BufferedReader input = new BufferedReader(new FileReader(name));
			
			String text;	
			while( (text=input.readLine())!= null) {
				String [] pieces = text.split(" ");
				ArrayList<String> list = new ArrayList<>();
				for(int x = 0; x < pieces.length; x++){
					list.add(pieces[x]);
				}
				listHolder.add(list);
			}
		}
		catch (IOException io) {
			System.err.println("File does not exist");
		}


		ArrayList<String> outputList = new ArrayList<>();
		while(listHolder.size()>2){

			ArrayList<ArrayList<String>> rows = new ArrayList<>();
			rows.add(listHolder.get(0));
			rows.add(listHolder.get(1));
			rows.add(listHolder.get(2));

			for(int x = 0; x < 3; x++){
				listHolder.remove(0);
			}
			
			String output="";

			for(int x = 0; x < rows.size(); x++){	
				if(rows.get(x).get(0).equals(rows.get(x).get(1)) && rows.get(x).get(1).equals(rows.get(x).get(2))){
					output = rows.get(x).get(0);
				}
			}
			
			for(int x = 0; x < rows.get(0).size(); x++){
				if((rows.get(0).get(x)).equals(rows.get(1).get(x)) && (rows.get(0).get(x)).equals(rows.get(2).get(x))){
					output = rows.get(0).get(x);
				}	
			}

			if(rows.get(0).get(0).equals(rows.get(1).get(1)) && rows.get(0).get(0).equals(rows.get(2).get(2))){
				output = rows.get(0).get(0);
			}

			if(rows.get(0).get(2).equals(rows.get(1).get(1)) && rows.get(0).get(2).equals(rows.get(2).get(0))){
				output = rows.get(0).get(2);
			}
			
			if(output.isEmpty()){
				output = "-";
			}

			outputList.add(output);
		}

		System.out.println(outputList);
		
	}

	public static void main (String [] args){
		TicTacToeWinnerChecker app = new TicTacToeWinnerChecker();
	}
}