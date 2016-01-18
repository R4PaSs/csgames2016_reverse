CC=gcc
SRC=src
CFLAGS=-g -Wall -std=c99

default: all

all: level1
	mkdir -p bin/

level1:
	$(CC) $(SRC)/level1.c -o bin/level1 -lcrypto $(CFLAGS)
