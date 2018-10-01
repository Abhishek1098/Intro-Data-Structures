import java.util.ArrayList;
import java.io.*;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;
import java.lang.*;
import java.io.*;

public class TimeTravelCalc{

	ArrayList<ArrayList<Integer>> listHolder;

	public TimeTravelCalc(){	

		listHolder = new ArrayList<>();

		readFile("input-file-time-travel.txt");

		int tripCount = 0;

		while(listHolder.size() > 0){
			
			tripCount++;
			ArrayList<Integer> dateList = listHolder.get(0);
			listHolder.remove(0);

			int timeTravelDays = dateList.get(0);
			int timeTravelHours = dateList.get(1);
			int timeTravelMinutes = dateList.get(2);
	
			LocalDateTime now = LocalDateTime.now();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm a MM/dd/yyyy"); 
			System.out.println("Trip "+ tripCount +": \n\t Departure Date and Time:"+ dtf.format(now));

			now = now.plusDays(timeTravelDays);
			now = now.plusHours(timeTravelHours);
			now = now.plusMinutes(timeTravelMinutes);

			
			System.out.println("\n\t Arrival Date and Time:"+ dtf.format(now));	
	
		}
	}

	public void readFile(String file){
		
		File name = new File(file);
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
	
		TimeTravelCalc app = new TimeTravelCalc();		
	
	}


}