#! /bin/bash

echo "Compilado Jflex"
jflex JAVA/lexerJava.jflex
#javac JAVA/LexerJava.java
#rm lexerJava.java~
#rm JAVA/lexerJava.java
#java JAVA/LexerJava JAVA/ejemploJava.java
mv JAVA/lexerJava.java ../Server/src/main/java/com/cresb49/server/AnalizadorJava
echo "Compilado CUP"
cup JAVA/ParserJava.cup

mv ParserJava.java ../Server/src/main/java/com/cresb49/server/AnalizadorJava
mv ParserJavaSym.java ../Server/src/main/java/com/cresb49/server/AnalizadorJava



