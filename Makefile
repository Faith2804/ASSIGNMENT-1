#MAKEFILE for Assignment1
#Faith Katabwa(KTBFAI002)


JAVAC=/usr/bin/javac
.SUFFIXES:.java.class


CLASSES:Serial.class MedianFilter.class ParallelMedianFilter.class


default: $(CLASSES)

clean:
	rm *.class

