# If the first argument is "run"...
ifeq (run,$(firstword $(MAKECMDGOALS)))
  # use the rest as arguments for "run"
  RUN_ARGS := $(wordlist 2,$(words $(MAKECMDGOALS)),$(MAKECMDGOALS))
  # ...and turn them into do-nothing targets
  $(eval $(RUN_ARGS):;@:)
endif

### VARIABLES ###

JC := javac
JCFLAGS := -encoding UTF-8 -implicit:none
JVM := java
JVMFLAGS :=

SRCDIR := ./src/GridSolver
OUTDIR := ./out
DOCDIR := ./doc
SRC := $(wildcard $(SRCDIR)/*.java)
OFILES := $(SRC:$(SRCDIR)/%.java=$(OUTDIR)/%.class)

### REGLES ESSENTIELLES ###

$(OUTDIR)/%.class : $(SRCDIR)/%.java
	@mkdir -p $(@D)
	${JC} ${JCFLAGS} -cp $(SRCDIR) -d $(OUTDIR) $<


### REGLES OPTIONNELLES ###

run : $(OFILES)
	${JVM} ${JVMFLAGS} -cp $(OUTDIR) Main $(RUN_ARGS)

clean :
	-rm -rf $(OUTDIR)
	-rm -rf $(DOCDIR)

doc :
	javadoc -d $(DOCDIR) $(SRC)

### BUTS FACTICES ###

.PHONY : run clean doc

### FIN ###
