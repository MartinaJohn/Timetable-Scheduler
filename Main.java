import java.util.*;

public class Main {

	public static void main(String[] args) 
	{
		//Comment
		int room_no[]= {101,115,200,511,811};
		int room_size[]= {25,100,250,200,70};
		String[] courses= {"cs101","cs102","cs120","cs220","cs412","cs430","cs612","cs630"};
		String[] time= {"MWF9","MWF10","MWF11","MWF2","TT9","TT10:30","TT2","TT3:30"};

		String[] course_enroll= {"cs101","cs412","cs612","cs630"};
		int course_cap[]= {100,80,35,40};
		String[][] preferences= {{"MWF9","MWF10","MWF11","TT9"},{"MWF9","TT9","TT10:30"},{"MWF10","MWF11","MWF9","TT9"},{"TT2","MWF2","MWF11","TT9"}};
		
		
		//RoomAllotment.bestFit(room_size, room_size.length, course_cap, course_cap.length);
		RoomAllotment obj = new RoomAllotment();
    	int pos[] = obj.bestFit(room_size, room_size.length, course_cap, course_cap.length);
		
	}

}
