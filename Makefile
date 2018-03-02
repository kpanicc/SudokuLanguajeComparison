OFILE = benchmarks.txt

all:
	make c-test
	make py-test

c-test:
	echo "C test:" >> $(OFILE)
	{ time ./SudokuSolverC/exe/sudokutest; } 2>> $(OFILE)

py-test:
	echo "Python test:" >> $(OFILE)
	{ time ./SudokuSolverC/exe/sudokutest; } 2>> $(OFILE)

j-test:
	echo "Java test:" >> $(OFILE)
	cd SudokuSolverJava/
	{ time java Sudoku; } 2>> ../$(OFILE)
	cd ..

reset:
	rm $(OFILE)
