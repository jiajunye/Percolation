
public class PercolationStats 
{
	private int N;
	private int times;
	double[] a;
	private Percolation test;
	
	// perform T independent experiments on an N-by-N grid
	public PercolationStats(int N, int T)
	{
		this.test = new Percolation(N);
		this.N = N;
		this.times = T;
		this.a = new double[times];
	}
	
	// sample mean of percolation threshold
	public double mean()
	{
		int count = 0;
		for(int i = 0; i < times; i++)
		{
			// stop loop when system percolates
			while(!test.percolates())
			{
				// randomly choose (row, column) site to open
				int row = StdRandom.uniform(N) + 1;
				int column = StdRandom.uniform(N) + 1;
				if(!test.isOpen(row, column))
				{
					test.open(row, column);
					count++;
				}
			}
			a[i] = (double)count / (N * N);
		}
		return StdStats.mean(a);
	}
	
	// sample standard deviation of percolation threshold
	public double stddev()
	{
		return StdStats.stddev(a);
	}

	public static void main(String[] args) 
	{	
		PercolationStats result = new PercolationStats(200, 10000);
		System.out.println(result.mean());
		System.out.println(result.stddev());
	}
}
