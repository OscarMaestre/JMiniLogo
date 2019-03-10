JFLEX=/home/usuario/jflex-1.7.0/bin/jflex

JAR=JMiniLogo-1.0.jar

all: lexer grammar

lexer:
	cd JMiniLogo; cd src; cd io; cd github; cd oscarmaestre ; cd jminilogo ;\
	$(JFLEX) Lexer.es 

grammar:
	java -jar java-cup-11b.jar -interface -parser Parser  JMiniLogo/src/io/github/oscarmaestre/jminilogo/Grammar.es  ;
	sed -i -e 's/public class Parser extends java_cup.runtime.lr_parser/public abstract class Parser extends java_cup.runtime.lr_parser/' Parser.java
	mv *.java JMiniLogo/src/io/github/oscarmaestre/jminilogo

jar: lexer grammar
	jar -cvfe $(JAR) io.github.oscarmaestre.jminilogo.Main -C JMiniLogo/build/classes . -C JMiniLogo/lib/ .



clean:
	rm JMiniLogo/src/io/github/oscarmaestre/jminilogo/Grammar_antlr*.java ;rm JMiniLogo/src/io/github/oscarmaestre/jminilogo/*.interp; rm JMiniLogo/src/io/github/oscarmaestre/jminilogo/*.tokens;
