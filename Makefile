CC=gcc
SRC=src
CFLAGS=-std=c99

default: all

all: level1 level2 impure
	mkdir -p bin/

level1:
	$(CC) $(SRC)/level1.c -o bin/level1 -lcrypto $(CFLAGS)

level2:
	$(CC) $(SRC)/level2.c -o bin/level2 $(CFLAGS)

impure:
	$(CC) $(SRC)/impure.c -o bin/impure $(CFLAGS)
