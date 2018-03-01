DIRSRC = src/
DIRHEA = include/
DIREXE = exe/

PNAME = $(DIRSRC)main.c
ONAME = $(DIREXE)sudokutest

CC = gcc
CFLAGS = -Wall -I$(DIRHEA)

default:
	$(CC) $(CFLAGS) $(PNAME) -o $(ONAME) 

exec:
	./$(ONAME)

clean:
	rm $(DIREXE)*