import java.util.HashMap;
import java.util.*;

public class Main {

	public static void main(String[] args) {
//		HashMap<Integer, Integer> rooms = new HashMap<>() {{
//			put(101,25);
//			put(115,100);
//			put(200,250);
//			put(511,200);
//			put(811,70);
//		}};   
		int room_no[]= {101,115,200,511,811};
		int room_size[]= {25,100,250,200,70};
		String[] courses= {"cs101","cs102","cs120","cs220","cs412","cs430","cs612","cs630"};
		String[] time= {"MWF9","MWF10","MWF11","MWF2","TT9","TT10:30","TT2","TT3:30"};
//		HashMap<String, Integer> course_enroll = new HashMap<>() {{
//			put("cs101",180);
//			put("cs412",80);
//			put("cs612",35);
//			put("cs630",40);
//		}}; 
		String[] course_enroll= {"cs101","cs412","cs612","cs630"};
		int course_cap[]= {100,80,35,40};
		String[][] preferences= {{"MWF9","MWF10","MWF11","TT9"},{"MWF9","TT9","TT10:30"}};
		
		
		RoomAllotment.bestFit(room_size, room_size.length, course_cap, course_cap.length);
	}

}
