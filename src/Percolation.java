
public class Percolation 
{
	private WeightedQuickUnionUF UF;
	private int N;
	private int[] opened;

	public Percolation(int Ngrid)
	{
		this.N = Ngrid;
		this.UF = new WeightedQuickUnionUF(N * N + 2);
		opened = new int[N * N + 2];
		opened[0] = 1;
		opened[N * N + 1] = 1;
		for(int i = 1; i <= N * N; i++)
		{
			opened[i] = 0;
		}
	}
	
	// translate 2D points to 1D numbers
	private int xyTo1D(int x, int y)
	{
		int num = (x - 1) * N + y;
		return num;
	}
	
	public void open(int row, int column)
	{
		int index = xyTo1D(row, column);
		if(opened[index] == 1) return;  // return if the site has already opened
		// five different conditions as follow:
		if(index % N == 0)  // the last column
		{
			if(opened[index - 1] == 1) UF.union(index, index - 1);
			if(opened[index - N] == 1) UF.union(index, index - N);
			if(index == N * N) UF.union(N * N, N * N + 1);
			else if(opened[index + N] == 1) UF.union(index, index + N);
		}
		else if((index - 1) % N == 0)  // the first column
		{
			if(opened[index + 1] == 1) UF.union(index, index + 1);
			if(opened[index + N] == 1) UF.union(index, index + N);
			if(index == 1) UF.union(1, 0);
			else if(opened[index - N] == 1) UF.union(index, index - N);
		}
		else if(index > 1 && index < N)  // the first row except the first and the last sites(already included in previous conditions)
		{
			UF.union(index, 0);
			if(opened[index - 1] == 1) UF.union(index, index - 1);
			if(opened[index + 1] == 1) UF.union(index, index + 1);
			if(opened[index + N] == 1) UF.union(index, index + N);
		}
		else if(index > N * N - N + 1 && index < N * N)  //the last row except the first and the last sites(already included in previous conditions)
		{
			UF.union(index, N * N + 1);
			if(opened[index - 1] == 1) UF.union(index, index - 1);
			if(opened[index + 1] == 1) UF.union(index, index + 1);
			if(opened[index - N] == 1) UF.union(index, index - N);
		}
		else  // all other sites(internal sites)
		{
			if(opened[index - 1] == 1) UF.union(index, index - 1);
			if(opened[index + 1] == 1) UF.union(index, index + 1);
			if(opened[index - N] == 1) UF.union(index, index - N);
			if(opened[index + N] == 1) UF.union(index, index + N);
		}
		opened[index] = 1;  // mark this site as opened
	}
	
	// check if the site is opened
	public boolean isOpen(int i, int j)
	{
		return opened[xyTo1D(i, j)] == 1;
	}
	
	// check if the first row and (i, j) are connected
	public boolean isFull(int i, int j)
	{
		return UF.connected(0, xyTo1D(i, j));
	}
	
	// check if the system is percolated(if 0 and N * N + 1 are connected)
	public boolean percolates()
	{
		return UF.connected(0, N * N + 1);
	}
}
