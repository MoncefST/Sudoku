JC := javac
JCFLAGS := -encoding UTF-8 -implicit:none
JVM := java
JVMFLAGS :=

SRCDIR := ./src
OUTDIR := ./build
DOCDIR := ./doc
SRC := $(wildcard $(SRCDIR)/*.java)
OFILES := $(SRC:$(SRCDIR)/%.java=$(OUTDIR)/%.class)

### REGLES ESSENTIELLES ###

$(OUTDIR)/%.class : $(SRCDIR)/%.java
	@mkdir -p $(@D)
	${JC} ${JCFLAGS} -cp $(SRCDIR) -d $(OUTDIR) $<


### REGLES OPTIONNELLES ###

all: 

GridMaker : $(OFILES)
	${JVM} ${JVMFLAGS} -cp $(OUTDIR) GridMaker $(RUN_ARGS)

GridSolver : $(OFILES)
	${JVM} ${JVMFLAGS} -cp $(OUTDIR) GridSolver $(RUN_ARGS)

clean :
	-rm -rf $(OUTDIR)
	-rm -rf $(DOCDIR)

doc :
	javadoc -d $(DOCDIR) $(SRC)

### BUTS FACTICES ###

.PHONY: all GridMaker GridSolver clean doc

### FIN ###