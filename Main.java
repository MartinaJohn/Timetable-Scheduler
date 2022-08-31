import java.util.*;

public class Main {

	public static void main(String[] args) {
		// Comment
		int room_no[] = { 101, 115, 200, 511, 811 };
		int room_size[] = { 25, 100, 250, 200, 70 };
		String[] courses = { "cs101", "cs102", "cs120", "cs220", "cs412", "cs430", "cs612", "cs630" };
		String[] time = { "MWF9", "MWF10", "MWF11", "MWF2", "TT9", "TT10:30", "TT2", "TT3:30" };

		String[] course_enroll = { "cs101", "cs412", "cs612", "cs630" };
		int course_cap[] = { 100, 80, 35, 40 };
		String[][] preferences = { { "MWF9", "MWF10", "MWF11", "TT9" }, { "MWF9", "TT9", "TT10:30" },
				{ "MWF10", "MWF11", "MWF9", "TT9" }, { "TT2", "MWF2", "MWF11", "TT9" } };

		// RoomAllotment.bestFit(room_size, room_size.length, course_cap,
		// course_cap.length);
		int a[] = new int[time.length];
		for (int i = 0; i < time.length; i++) {
			a[i] = 0;
		}
		int time_allot[][] = new int[preferences.length][preferences.length];
		String alloted_time_to_course[] = new String[preferences.length];
		for (int i = 0; i < preferences.length; i++) {
			for (int j = 0; j < preferences.length; j++) {
				time_allot[i][j] = 0;
			}
		}
		RoomAllotment obj = new RoomAllotment();
		int pos[] = obj.bestFit(room_size, room_size.length, course_cap, course_cap.length);
		for (int i = 0; i < preferences.length; i++) {
			for (int j = 0; j < preferences.length; j++) {
				for (int k = 0; k < time.length; k++) {
					if (preferences[i][j] == time[k]) {
						if (a[k] != 1) {
							a[k] = 1;
							time_allot[i][j] = 1;
							alloted_time_to_course[i] = preferences[i][j];
							break;
						}
					}
				}
				if (time_allot[i][j] == 1) {
					break;
				}
			}
		}
		// for(int i = 0; i < preferences.length; i++)
		// {
		// for(int j = 0; j < preferences.length; j++)
		// {
		// System.out.println(time_allot[i][j]);
		// }
		// }
		// for (int i = 0; i < time.length; i++) {
		// System.out.println(a[i]);

		// }
		System.out.println("courses\t\t\trooms\t\t\ttime");
		for (int i = 0; i < 4; i++) {
			System.out.println(course_enroll[i] + "\t\t\t" + room_no[i] + "\t\t\t" + alloted_time_to_course[i]);
		}
	}

}
