class Sudoku:

    def __init__(self, tablero):

        self.tablero = tablero

    def getCuadrante(self, posx, posy):

        cuadrante = [[0 for x in range(3)] for y in range(3)]
        idcuadrante = []

        if(posx < 3):
            idcuadrante.append(0)
        if(posx > 2 and posx < 6):
            idcuadrante.append(1)
        if(posx > 5):
            idcuadrante.append(2)

        if(posy < 3):
            idcuadrante.append(0)
        if(posy > 2 and posy < 6):
            idcuadrante.append(1)
        if(posy > 5):
            idcuadrante.append(2)

        for i in range(0, 3):
            for j in range(0, 3):
                cuadrante[i][j] = self.tablero[i + (idcuadrante[0] * 3)][j + (idcuadrante[1] * 3)]
        
        return cuadrante

    def isValid(self, number, posx, posy):

        # No coincide en la horizontal
        for j in range(0, len(self.tablero[posx])):
            if self.tablero[posx][j] == number:
                return 0

        # No coincide en la vertical
        for i in range(0, len(self.tablero)):
            if(self.tablero[i][posy] == number):
                return 0
        
        # No coincide en el mismo cuadrante
        for line in self.getCuadrante(posx, posy):
            for z in line:
                if(z == number):
                    return 0

        return 1

    def isSolved(self):

        for i in self.tablero:
            for j in i:
                if j is 0:
                    return False
        return True

    def solve(self):

         # Caso base
        if self.isSolved():
            print("Solution achieved")
            return True

        # Caso general
        else:
            for a in range(0,9):
                for b in range(0,9):
                    if(self.tablero[a][b] == 0):
                        i = a
                        j = b
            for z in range(1, 10):
                if self.isValid(z,i,j):
                    self.tablero[i][j] = z
                    if self.solve():
                        return True
                    self.tablero[i][j] = 0
        return False