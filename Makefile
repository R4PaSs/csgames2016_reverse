CC=gcc
SRC=src
CFLAGS=-std=c99

default: all

all: level1 level2 java1 rle
	mkdir -p bin/

level1:
	$(CC) $(SRC)/bin1/bin1.c -o bin/bin1 -lcrypto $(CFLAGS)

level2:
	$(CC) $(SRC)/bin2/bin2.c -o bin/bin2 $(CFLAGS)

java1:
	cd src/java1/src && javac org/csgames/Java1.java && jar -cvfm ../../../bin/Java1.jar ../META-INF/MANIFEST.MF org/csgames/*.class

rle:
	cp $(SRC)/rle/rle.c bin/encoding.c

