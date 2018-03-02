# SudokuLanguajeComparison

## What is this?

A sudoku solver implementation using backtracking in 3 different languajes, C, Python, and Java.

## How do I use it?

-Download it in a unix system, that has gcc, java compiler, java virtual machine, python3 and Make tools.

    -For C benchmark use:  time ./SudokuSolverC/exe/sudokutest 
        - Or, try: make c-test.
        - Or, try: echo "C test:" >> benchmarks.txt; { time ./SudokuSolverC/exe/sudokutest; } 2>> benchmarks.txt;

    -For Python benchmark use: time ./SudokuSolverPy/SudokuSolver.py
        - Or, try: make py-test.
        - Or, try: echo "Python test:" >> benchmarks.txt { time ./SudokuSolverC/exe/sudokutest; } 2>> benchmarks.txt;
        
    -For Java benchmark use: move to the directory and use time java Sudoku
        - No, makefile doesn't work for this.
        - Try: echo "Java test:" >> benchmarks.txt;cd SudokuSolverJava/;{ time java Sudoku; } 2>> ../benchmarks.txt;cd ..;

## How do I redirect the "time" output to a file?

Solved Thanks to my friend Carlos Cordoba (https://github.com/CarlosCordoba96).
The command "time" writes in the stderr so you can redirect by means of using 2> or 2>>.
- Example: { time ./SudokuSolverC/exe/sudokutest; } 2>> file.txt

## How do I change the output file?

Open the file "Makefile" and change the Objective file (OFILE) value.

## Hey, the Makefile solution is giving me strange results what the heck?

You can always type it by hand.

## Which is the fastest languaje?

C > Python > Java. (">" means faster)

## Why is java code so awfull?

I don't like that languaje and I didn't want to break my head thinking how to import stuff.

## Why j-test of the makefile doesnt work?

The languaje is complete bullshit and won't run unless your on the directory, try to solve it by means of changing it in the makefile and dind't work, not gonna bother in a shitty languaje anymore. Use { time java Sudoku; } 2>> ../benchmarks.txt if you want to do it manually.

