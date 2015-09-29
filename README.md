# Percolation Simulation
A Java program to estimate the value of the percolation threshold via Monte Carlo simulation and draw pixel images.

<ul>
<li>Wrote a Java program to estimate the value of the percolation threshold via Monte Carlo simulation and draw pixel images</li>
<li>Modeled an N-by-N sites percolation system. Created a data type Percolation using the Weighted Quick-Union algorithm with various Java APIs.</li>
<li>Perform a series of computational experiments, calculated mean and standard deviation of percolation threshold.</li>
<li>Took precode text files as inputs to draw pixel images dynamically by utilizing percolation system.</li>
</ul>
<p>
Download the zip file. Extract and open all .java files in src directory using an IDE (Eclipse, Xcode, etc).<br><br>
Compile and run PercolationStats.java to calculate mean and standard deviation of percolation threshold.<br><br>
Choose text file from draw directory to be the input file for PercolationVisualizer.java's main method. Compile and run PercolationVisualizer to draw pixel images dynamically.<br><br>
Run InteractivePercolationVisualizer.java to open a size N grid window to allow user repeatedly clicks sites to open with the mouse. After each site is opened, it draws full sites in light blue, open sites (that aren't full) in white, and blocked sites in black.
</p>
