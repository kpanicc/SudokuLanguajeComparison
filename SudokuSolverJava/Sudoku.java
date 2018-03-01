public class Sudoku {

    public class Point{
        int x;
        int y;
    }

    protected int[][] _grid;

    public Sudoku(int[][] grid) {
        this._grid = grid;
    }

    public void print() {

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++){
                System.out.printf("%d, ", this._grid[i][j]);
            }
            System.out.printf("\n");
        }

    }

    private boolean checkRow(Point p, int tocheck) {

        for(int i =0; i < 9; i++){
            if(this._grid[p.y][i] == tocheck) {
                return false;
            }
        }
        return true;
    }

    private boolean checkColumn(Point p, int tocheck) {

        for(int i =0; i < 9; i++){
            if(this._grid[i][p.x] == tocheck) {
                return false;
            }
        }
        return true;
    }

    private boolean checkSubGrid(Point p, int tocheck) {

        for(int i = (p.x / 3) * 3; i < (p.x / 3) * 3 + 3; i++){
            for(int j = (p.y / 3) * 3; j < (p.y / 3) * 3 + 3 ;j++){

                if(this._grid[j][i] == tocheck) {
                    return false;
                }

            }
        }

        return true;
    }

    private boolean isValidMovement(Point p, int tocheck) {
        return checkColumn(p, tocheck) && checkRow(p, tocheck) && checkSubGrid(p, tocheck);
    }

    

    private boolean isSolved() {

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(this._grid[j][i] == 0){
                    return false;
                }
            }
        }

        return true;
    }
    
    private Point getNextPoint() {

        Point p = new Point();

        for (int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(this._grid[i][j] == 0){
                    p.x = j;
                    p.y = i;
                    return p;
                }
            }
        }
        return null;
    }

    public boolean solveBactracking() {

        if(this.isSolved()){
            return true;
        }

        Point p = getNextPoint();
        for(int n = 1; n < 10; n++){
            if(this.isValidMovement(p, n)){
                this._grid[p.y][p.x] = n;               
                if(this.solveBactracking()) {return true;}
                this._grid[p.y][p.x] = 0;
            }
        }

        return false;
    }

    public static void main(String[] args){

		int[][] grid = {    
			{8, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 3, 6, 0, 0, 0, 0, 0},
			{0, 7, 0, 0, 9, 0, 2, 0, 0},
			{0, 5, 0, 0, 0, 7, 0, 0, 0},
			{0, 0, 0, 0, 4, 5, 7, 0, 0},
			{0, 0, 0, 1, 0, 0, 0, 3, 0},
			{0, 0, 1, 0, 0, 0, 0, 6, 8},
			{0, 0, 8, 5, 0, 0, 0, 1, 0},
			{0, 9, 0, 0, 0, 0, 4, 0, 0}, 
		};
		
		Sudoku s = new Sudoku(grid);
        s.solveBactracking();
        
        /*
        System.out.printf("El punto es [%d][%d]\n", p.x, p.y);
        s._grid[p.y][p.x] = 1;
        p = s.getNextPoint();
		s.print();
        System.out.printf("El punto es [%d][%d]\n", p.x, p.y);
		*/
    }
    
}