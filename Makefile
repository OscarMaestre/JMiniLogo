JFLEX=/home/usuario/jflex-1.7.0/bin/jflex

all: lexer grammar

lexer:
	cd JMiniLogo; cd src; cd io; cd github; cd oscarmaestre ; cd jminilogo ;\
	$(JFLEX) Lexer.es 

grammar:
	java -jar java-cup-11b.jar -interface -parser Parser  JMiniLogo/src/io/github/oscarmaestre/jminilogo/Grammar.es  ;
	mv *.java JMiniLogo/src/io/github/oscarmaestre/jminilogo

antlr:
	java -cp antlr-4.7.2-complete.jar org.antlr.v4.Tool JMiniLogo/src/io/github/oscarmaestre/jminilogo/Grammar_antlr.es  ;

test: antlr
	java -cp antlr-4.7.2-complete.jar org.antlr.v4.gui.TestRig 

clean:
	rm JMiniLogo/src/io/github/oscarmaestre/jminilogo/Grammar_antlr*.java ;rm JMiniLogo/src/io/github/oscarmaestre/jminilogo/*.interp; rm JMiniLogo/src/io/github/oscarmaestre/jminilogo/*.tokens;
