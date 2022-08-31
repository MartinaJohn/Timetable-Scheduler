import java.util.*;
//import java.util.HashMap;

public class RoomAllotment 
{
	public static ArrayList<ArrayList<String>> alloted_rooms = new ArrayList<ArrayList<String>>();
	// bestfit algo code in java

	public static void bestFit(int part_size[], int part, int pro_size[], int pro) 
	{
		// // Stores block id of the block allocated to a
		// // process
		// int allocation[] = new int[n];
		// int flag[] = new int[n];

		// // Initially no room is assigned to any course
		// for (int i = 0; i < allocation.length; i++) 
		// {
		// 	allocation[i] = -1;
		// 	flag[i] = 0;
		// }
		// // pick each process and find suitable blocks
		// // according to its size ad assign to it
		// for (int i = 0; i < n; i++) 
		// {
		// 	if (flag[i] == 1) 
		// 	{
		// 		continue;
		// 	}
		// 	// Find the best fit block for current process
		// 	int bestIdx = -1;
		// 	for (int j = 0; j < m; j++) 
		// 	{
		// 		if (blockSize[j] >= processSize[i]) 
		// 		{
		// 			if (bestIdx == -1)
		// 				bestIdx = j;
		// 			else if (blockSize[bestIdx] > blockSize[j])
		// 				bestIdx = j;
		// 		}
		// 	}

		// 	// If we could find a block for current process
		// 	if (bestIdx != -1) 
		// 	{
		// 		// allocate block j to p[i] process
		// 		allocation[i] = bestIdx;

		// 		// Reduce available memory in this block.
		// 		blockSize[bestIdx] -= processSize[i];
		// 		flag[bestIdx] = 1;
		// 		//
		// 	}
		// }

		// for (int i = 0; i < n; i++) 
		// {
		// 	System.out.print("   " + (i + 1) + "\t\t" + processSize[i] + "\t\t");
		// 	if (allocation[i] != -1)
		// 		System.out.print(allocation[i]);
		// 	else
		// 		System.out.print("Not Allocated");
		// 	System.out.println();
		// }

        int temp_part_size[] = new int[part];
        int pos[] = new int[pro];
        int frag_size[] = new int[pro]; 
		for(int i = 0; i < part; i++)
        {
            temp_part_size[i] = part_size[i];
        }
        for (int i = 0; i < pro; i++)
            pos[i] = -1;
        int alloted[] = new int[part];
        for (int i = 0; i < part; i++)
            alloted[i] = 0;
        for (int i = 0; i < pro; i++)
        {
            int bestIdx = -1;
            for (int j = 0; j < part; j++)
            {
                if(alloted[j] == 0)
                {
                    if (part_size[j] >= pro_size[i])
                    {
                        if (bestIdx == -1)
                        {
                            bestIdx = j;
                            alloted[j] = 1;
                        }
                        else if (part_size[bestIdx] > part_size[j])
                        {
                            alloted[bestIdx] = 0;    
                            bestIdx = j;
                            alloted[j] = 1;
                        }
                    }
                }
            }
        
            if (bestIdx != -1)
            {
                pos[i] = bestIdx;
                frag_size[i] = part_size[bestIdx] - pro_size[i];
                temp_part_size[bestIdx] -= pro_size[i];
            }
        }
        
        System.out.println("\nProcess No.\tProcess Size\tBlock no.\tBlock Size\tFragment Size");
        for (int i = 0; i < pro; i++)
        {
            System.out.print(" " + (i+1) + "\t\t" + pro_size[i] + "\t\t");
            if (pos[i] != -1)
                System.out.print((pos[i]) + "\t\t" + part_size[pos[i]] + "\t\t" + frag_size[i]);
            else
                System.out.print("Not Allocated" + "\t" + "Not Alloted" + "\t" + "Not Alloted");
            System.out.println();
        }
	}
}
