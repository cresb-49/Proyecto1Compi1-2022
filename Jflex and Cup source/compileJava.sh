#! /bin/bash

echo "Compilado Jflex"
jflex JAVA/LexerJava.jflex
#javac JAVA/LexerJava.java
#rm lexerJava.java~
#rm JAVA/lexerJava.java
#java JAVA/LexerJava JAVA/ejemploJava.java
mv JAVA/LexerJava.java ../ServidorProyecto1/src/main/java/com/cresb49/servidorproyecto1/analizardorjava

echo "Compilado CUP"
cup JAVA/ParserJava.cup

mv ParserJava.java ../ServidorProyecto1/src/main/java/com/cresb49/servidorproyecto1/analizardorjava
mv ParserJavaSym.java ../ServidorProyecto1/src/main/java/com/cresb49/servidorproyecto1/analizardorjava



