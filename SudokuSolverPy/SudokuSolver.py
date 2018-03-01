#!/usr/bin/python3

from Sudoku import *
import sys

def main():

    su_tab = [[0 for x in range(9)] for y in range(9)]
    su_tab[0][0] = 8
    su_tab[2][1] = 7
    su_tab[3][1] = 5
    su_tab[8][1] = 9
    su_tab[1][2] = 3
    su_tab[6][2] = 1
    su_tab[7][2] = 8
    su_tab[2][3] = 6
    su_tab[5][3] = 1
    su_tab[7][3] = 5
    su_tab[2][4] = 9
    su_tab[4][4] = 4
    su_tab[3][5] = 7
    su_tab[4][5] = 5
    su_tab[2][6] = 2
    su_tab[4][6] = 7
    su_tab[8][6] = 4
    su_tab[5][7] = 3
    su_tab[6][7] = 6
    su_tab[7][7] = 1
    su_tab[6][8] = 8

    sudoku = Sudoku(su_tab)

    '''
    for line in sudoku.tablero:
        print(line)

    if sudoku.solve():
        print("printing solution...")
        for line in sudoku.tablero:
            print(line)
    else:
        print("No possible solution")
    '''
    sudoku.solve()
    return 0


if __name__ == "__main__":
    sys.exit(int(main() or 0))