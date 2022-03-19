#! /bin/bash

echo "Compilado Jflex"
jflex JAVA/LexerJava.jflex
#javac JAVA/LexerJava.java
#rm lexerJava.java~
#rm JAVA/lexerJava.java
#java JAVA/LexerJava JAVA/ejemploJava.java
mv JAVA/LexerJava.java ../ServerProyecto1/src/main/java/com/cresb49/serverproyecto1/analizarjava



echo "Compilado CUP"
cup JAVA/ParserJava.cup

mv ParserJava.java ../ServerProyecto1/src/main/java/com/cresb49/serverproyecto1/analizarjava
mv ParserJavaSym.java ../ServerProyecto1/src/main/java/com/cresb49/serverproyecto1/analizarjava



