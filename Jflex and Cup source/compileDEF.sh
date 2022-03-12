#! /bin/bash

echo "Compilado Jflex"
jflex DEF/LexerDef.jflex

#javac DEF/LexerDef.java
#rm lexerJava.java~
#rm DEF/LexerDef.java
#java DEF/LexerDef DEF/ejemploHTML.html
mv DEF/LexerDef.java ../AppCliente/src/main/java/com/cresb49/appcliente/analizadores/def

echo "Compilado CUP"
cup DEF/ParserDef.cup

mv ParserDef.java ../AppCliente/src/main/java/com/cresb49/appcliente/analizadores/def
mv ParserDefSym.java ../AppCliente/src/main/java/com/cresb49/appcliente/analizadores/def


