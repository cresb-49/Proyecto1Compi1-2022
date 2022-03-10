#! /bin/bash

echo "Compilado Jflex"
jflex JAVA/lexerJava.jflex

javac JAVA/LexerJava.java

#rm lexerJava.java~
rm JAVA/lexerJava.java

java JAVA/LexerJava JAVA/ejemploJava.java
