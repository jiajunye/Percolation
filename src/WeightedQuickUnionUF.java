import java.util.Arrays;

public class WeightedQuickUnionUF 
{
	private int[] id;
	private int[] sz;
	
	public WeightedQuickUnionUF(int N)
	{
		id = new int[N];
		for(int i = 0; i < N; i++)
		{
			id[i] = i;
		}
		
		sz = new int[N];
		Arrays.fill(sz, 1);
	}
	
	private void validate(int p) {
        int N = id.length;
        if (p < 0 || p >= N) {
            throw new IndexOutOfBoundsException("index " + p + " is not between 0 and " + N);
        }
    }
	
	// find the root of i
	public int find(int i)
	{
		validate(i);
		while(i != id[i]) i = id[i];  // id[i] == i means reached the root
		return i;  // return i's root
	}
	
	// check if p's root is the same as q's root, if so, they are connected
	public boolean connected(int p, int q)
	{
		return find(p) == find(q);
	}
	
	// connect the smaller tree's root to the bigger tree's root, then update the size of the new tree
	public void union(int p, int q)
	{
		int i = find(p); 
		int j = find(q);
		if(i == j) return;  // if the roots of i and j are same, means they are already connected
		if(sz[i] < sz[j]) {id[i] = j; sz[j] += sz[i];}
		else {id[j] = i; sz[i] += sz[j];}
	}
}