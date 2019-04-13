all :
	java -cp javacc.jar javacc Jagger.jj
	javac *.java

check :
	echo "tests qui réussissent :"
	java Jagger < ./tests/pass/testPrint
	java Jagger < ./tests/pass/testString
	java Jagger < ./tests/pass/testIfThenElse
	java Jagger < ./tests/pass/testIfThenElse2
	java Jagger < ./tests/pass/testLetInEnd
	java Jagger < ./tests/pass/testLetInEnd1
	java Jagger < ./tests/pass/testLetInEnd2
	java Jagger < ./tests/pass/testLetInEnd3
	java Jagger < ./tests/pass/testWhile
	java Jagger < ./tests/pass/testFor
	echo "tests qui ratent :"
	java Jagger < ./tests/fail/failString2
	java Jagger < ./tests/fail/failString
	java Jagger < ./tests/fail/failLetInEnd
	java Jagger < ./tests/fail/failLetInEnd3
	java Jagger < ./tests/fail/failFor
