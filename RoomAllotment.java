import java.util.*;
//import java.util.HashMap;

public class RoomAllotment {
    public static ArrayList<ArrayList<String>>alloted_rooms = new ArrayList<ArrayList<String>>();
//bestfit algo code in java
    
    public static void bestFit(int blockSize[], int m, int processSize[], int n)
{
	// Stores block id of the block allocated to a
	// process
	int allocation[] = new int[n];
	int flag[]=new int[n]; 
	
	// Initially no room is assigned to any course
	for (int i = 0; i < allocation.length; i++) {
	allocation[i] = -1;
	flag[i]=0;
	}
	// pick each process and find suitable blocks
	// according to its size ad assign to it
	for (int i=0; i<n; i++)
	{
		if(flag[i]==1) {
			continue;
		}
	// Find the best fit block for current process
	int bestIdx = -1;
	for (int j=0; j<m; j++)
	{
	if (blockSize[j] >= processSize[i])
	{
	if (bestIdx == -1)
	bestIdx = j;
	else if (blockSize[bestIdx] > blockSize[j])
	bestIdx = j;
	}
	}
	
	// If we could find a block for current process
	if (bestIdx != -1)
	{
	// allocate block j to p[i] process
	allocation[i] = bestIdx;
	
	// Reduce available memory in this block.
	blockSize[bestIdx] -= processSize[i];
	flag[bestIdx]=1;
	// 
	}
	}

	for (int i = 0; i < n; i++)
	{
	System.out.print("   " + (i+1) + "\t\t" + processSize[i] + "\t\t");
	if (allocation[i] != -1)
	System.out.print(allocation[i]);
	else
	System.out.print("Not Allocated");
	System.out.println();
	}
}
        }
  
