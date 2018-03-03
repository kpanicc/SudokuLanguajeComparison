OFILE = benchmarks.txt

all:
	make c-test
	make py-test
	make j-test

c-test:
	echo "C test:" >> $(OFILE)
	{ time ./SudokuSolverC/exe/sudokutest; } 2>> $(OFILE)

py-test:
	echo "Python test:" >> $(OFILE)
	{ time ./SudokuSolverC/exe/sudokutest; } 2>> $(OFILE)

j-test:
	echo "Java test:" >> $(OFILE)
	{ time java -cp SudokuSolverJava/ Sudoku; } 2>> $(OFILE)

reset:
	rm $(OFILE)
