#include <stdio.h>

struct point {
    int x;
    int y;
};

void printSudoku(int sudoku[9][9]){
    int i, j;
    for(i = 0; i < 9; i++){
        for(j = 0; j < 9; j++){
            printf("%d, ", sudoku[i][j]);
        }
        printf("\n");
    }
}

void getNextPoint(int sudoku[9][9], struct point *nextPoint){
    int i, j;

    for(i = 0; i < 9; i++) {
        for(j = 0; j < 9; j++) {
            if(sudoku[i][j] == 0) {
                nextPoint->x = j;
                nextPoint->y = i;
                return;
            }
        }
    }

}

int checkRow(int sudoku[9][9], struct point p, int tocheck){
    int i;

    for(i = 0; i < 9; i++){
        if(sudoku[p.y][i] == tocheck) {
            return 0;
        }
    }

    return 1;
}

int checkColumn(int sudoku[9] [9], struct point p, int tocheck) {
    int i;

    for(i = 0; i < 9; i++){
        if(sudoku[i][p.x] == tocheck) {
            return 0;
        }
    }

    return 1;
}

int checkGrid(int sudoku[9][9], struct point p, int tocheck){
    
    int i, j;

    for(i = (p.x / 3) * 3; i < (p.x / 3) * 3 + 3; i++){
        for(j = (p.y / 3) * 3; j < (p.y / 3) * 3 + 3 ;j++){
            if(sudoku[j][i] == tocheck) {
                return 0;
            }
        }
    }

    return 1;
}

int solved(int sudoku[9][9]){
    int i, j;
    for(i = 0; i < 9; i++){
        for(j = 0; j < 9; j++){
            if(sudoku[i][j] == 0){
                return 0;
            }
        }
    }
    return 1;
}

int validMovement(int sudoku[9][9], struct point p, int tocheck){
    return (checkColumn (sudoku, p, tocheck)   && 
            checkRow    (sudoku, p, tocheck)   &&
            checkGrid   (sudoku, p, tocheck));  
}

int solveBacktracking(int sudoku[9][9]) {

    if(solved(sudoku)){
        return 1;
    }

    struct point nextPoint;
    int n;

    getNextPoint(sudoku, &nextPoint);

    for(n = 1; n < 10; n++){
        if(validMovement(sudoku, nextPoint, n)){
            sudoku[nextPoint.y][nextPoint.x] = n;
            if (solveBacktracking(sudoku)){
                return 1;
            }
            sudoku[nextPoint.y][nextPoint.x] = 0;
        }
    }
    return 0;
}
