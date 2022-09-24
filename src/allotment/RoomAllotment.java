import java.util.*;

public class RoomAllotment {
	public static ArrayList<ArrayList<String>> alloted_rooms = new ArrayList<ArrayList<String>>();

	// bestfit algo code in java
	public int[] bestFit(int part_size[], int part, int pro_size[], int pro) {
		int temp_part_size[] = new int[part];
		int pos[] = new int[pro];
		int frag_size[] = new int[pro];
		for (int i = 0; i < part; i++) {
			temp_part_size[i] = part_size[i];
		}
		for (int i = 0; i < pro; i++)
			pos[i] = -1;
		int alloted[] = new int[part];
		for (int i = 0; i < part; i++)
			alloted[i] = 0;
		for (int i = 0; i < pro; i++) {
			int bestIdx = -1;
			for (int j = 0; j < part; j++) {
				if (alloted[j] == 0) {
					if (part_size[j] >= pro_size[i]) {
						if (bestIdx == -1) {
							bestIdx = j;
							alloted[j] = 1;
						} else if (part_size[bestIdx] > part_size[j]) {
							alloted[bestIdx] = 0;
							bestIdx = j;
							alloted[j] = 1;
						}
					}
				}
			}

			if (bestIdx != -1) {
				pos[i] = bestIdx;
				frag_size[i] = part_size[bestIdx] - pro_size[i];
				temp_part_size[bestIdx] -= pro_size[i];
			}
		}

		return pos;

	}
}
