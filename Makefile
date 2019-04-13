all :
	java -cp javacc.jar javacc Jagger.jj
	javac *.java

check :
	echo "tests qui réussissent :"
	java Jagger < ./pass/testPrint
	java Jagger < ./pass/testString
	java Jagger < ./pass/testIfThenElse
	java Jagger < ./pass/testIfThenElse2
	java Jagger < ./pass/testLetInEnd
	java Jagger < ./pass/testLetInEnd1
	java Jagger < ./pass/testLetInEnd2
	java Jagger < ./pass/testLetInEnd3
	java Jagger < ./pass/testWhile
	java Jagger < ./pass/testFor
	echo "tests qui ratent :"
	java Jagger < ./fail/failString
	java Jagger < ./fail/failString2
	java Jagger < ./fail/failLetInEnd
	java Jagger < ./fail/failLetInEnd3
	java Jagger < ./fail/failFor
