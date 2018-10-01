import java.util.ArrayList;
import java.io.*;
public class DayFinder{
	
	public DayFinder(){
		File name = new File("input-file-day-finder.txt");

		ArrayList<ArrayList<String>> listHolder = new ArrayList<>();

		try{
			BufferedReader input = new BufferedReader(new FileReader(name));
			
			String text;	
			while( (text=input.readLine())!= null) {
				ArrayList<String> list = new ArrayList<>();
				String [] pieces = text.split(" ");
				for(int x = 0; x < pieces.length; x++){
					list.add(pieces[x]);
				}
				listHolder.add(list);
			}
		}
		catch (IOException io) {
			System.err.println("File does not exist");
		}

		System.out.println(listHolder);
		
		while(listHolder.size()>0){
			ArrayList<String> currentLine = listHolder.get(0);
			listHolder.remove(0);

			boolean ifLeapYear = (currentLine.get(0).equals("1"));
			int firstDay = Integer.parseInt(currentLine.get(1));
			int targetMonth = Integer.parseInt(currentLine.get(2));
			int targetDay = Integer.parseInt(currentLine.get(3));
			
			int currentMonth = 1;
			int dayCount = 0;
			while(currentMonth < targetMonth){
				if(currentMonth == 2){
					if(ifLeapYear){
						dayCount+=29;
					}else{
						dayCount+=28;
					}
				}else if(currentMonth < 8){
					if(currentMonth%2 == 0){
						dayCount+=30;
					}else{
						dayCount+=31;
					}
				}else if(currentMonth == 8){
					dayCount+=31;
				}else{
					if(currentMonth%2 == 0){
						dayCount+=31;
					}else{
						dayCount+=30;
					}
				}
				currentMonth++;
			}
			dayCount+=targetDay;

			int dayOfWeek = ((dayCount+(firstDay-1)) % 7);
			switch(dayOfWeek){
				case 0:
					System.out.println(currentLine.toString() + "Saturday");
					break;
				case 1: 
					System.out.println(currentLine.toString() + "Sunday");
					break;
				case 2: 
					System.out.println(currentLine.toString() + "Monday");
					break;
				case 3: 
					System.out.println(currentLine.toString() + "Tuesday");
					break;
				case 4: 
					System.out.println(currentLine.toString() + "Wednesday");
					break;
				case 5: 
					System.out.println(currentLine.toString() + "Thursday");
					break;
				case 6: 
					System.out.println(currentLine.toString() + "Friday");
					break;
			}
				
		}


		

	}

	public static void main (String [] args){
		DayFinder app = new DayFinder();
	}
}