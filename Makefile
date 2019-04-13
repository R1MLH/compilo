all :
	java -cp javacc.jar javacc Jagger.jj
	javac *.java

check :
	java Jagger < test1.txt
	java Jagger < test2.txt
	java Jagger < test3.txt
