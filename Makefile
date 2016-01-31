CC=gcc
SRC=src
CFLAGS=-std=c99
RELEASE_PATH=bin

default: all

all: bin1 bin2 bin3 java1 rle
	mkdir -p bin/

bin1:
	$(CC) $(SRC)/bin1/bin1.c -o $(RELEASE_PATH)/bin1 -lcrypto $(CFLAGS)

bin2:
	$(CC) $(SRC)/bin2/bin2.c -o $(RELEASE_PATH)/bin2 $(CFLAGS)

bin3:
	$(CC) $(SRC)/bin3/bin3.c -o $(RELEASE_PATH)/bin3 $(CFLAGS)
	strip $(RELEASE_PATH)/bin3

java1:
	cd src/java1/src && javac org/csgames/Java1.java && jar -cvfm ../../../$(RELEASE_PATH)/Java1.jar ../META-INF/MANIFEST.MF org/csgames/*.class

rle:
	cp $(SRC)/rle/rle.c $(RELEASE_PATH)/encoding.c

