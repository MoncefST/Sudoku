DOCDIR := ./doc
SRCDIR := ./src
SRC := $(wildcard $(SRCDIR)/*.java)
OUTDIR := ./build


GridMaker : 
	java GridMaker

GridSolver :
	java GridSolver

GridMaker.class : Window.class HomeView.class
	javac GridMaker.java Window.java HomeView.java

GridSolver.class : Window.class HomeView.class
	javac GridSolver.java Window.java HomeView.java

Button.class :
	javac Button.java

CongratulationsDialog.class : 
	javac CongratulationsDialog.java

DialogManager.class : 
	javac DialogManager.java

GMCase.class : GMGrid.class GMCaseKeyListener.class GMCaseMouseListener.class
	javac GMCase.java GMGrid.java GMCaseKeyListener.java GMCaseMouseListener.java

GMCaseKeyListener.class : GMCase.class GMGrid.class
	javac GMCaseKeyListener.java GMCase.java GMGrid.java

GMCaseMouseListener.class : GMCase.class
	javac GMCaseMouseListener.java GMCase.java

GMChecker.class : GMGrid.class
	javac GMChecker.java GMGrid.java

GMGrid.class : GMCase.class
	javac GMGrid.java GMCase.java

GMHowToCreateController.class : GMHowToCreateDialogManager.class 
	javac GMHowToCreateController.java GMHowToCreateDialogManager.java

GMHowToCreateDialogManager.class : GMHowToCreateView.class
	javac GMHowToCreateDialogManager.java GMHowToCreateView.java

GMHowToCreateView.class : 
	javac GMHowToCreateView.java

GMImport.class : GMGrid.class 
	javac GMImport.java GMGrid.java

GMResetGrid.class : GMGrid.class 
	javac GMResetGrid.java GMGrid.java

GMRules.class : 
	javac GMRules.java

GMSaver.class : GMGrid.class GMChecker.class
	javac GMSaver.java GMGrid.java GMChecker.java

GMSaverActionListener.class : Window.class GMGrid.class GMSaver.class
	javac GMSaverActionListener.java Window.java GMGrid.java GMSaver.java

GMUserInterfaceController.class : Window.class
	javac GMUserInterfaceController.java Window.java

GMUserInterfaceView.class : GMGrid.class Window.class GMResetGrid.class GMImport.class GMSaverActionListener.class GMHowToCreateController.class GMRules.class
	javac GMGrid.java Window.java GMResetGrid.java GMImport.java GMSaverActionListener.java GMHowToCreateController.java GMRules.java

GSCase.class : GSGrid.class GSCaseMouseListener.class GSTest.class
	javac GSCase.java GSGrid.java GSCaseMouseListener.java GSTest.java

GSCaseMouseListener.class : GSCase.class
	javac GSCaseMouseListener.java GSCase.java

GSGrid.class : GSCase.class GSTest.class
	javac GSGrid.java GSCase.java GSTest.java

GSImport.class : Window.class
	javac GSImport.java Window.java

GSMenu.class : Window.class Title.class Button.class
	javac GSMenu.java Window.java Button.java

GSMenuController.class : GSMenu.class Window.class GSGrid.class GSMenu.class GSImport.class GSPlay.class GSPlayController.class GSSolver.class
	javac GSMenu.class Window.java GSGrid.java GSMenu.java GSImport.java GSPlay.java GSPlayController.java GSSolver.java 

GSPlay.class : GSGrid.class Button.class Window.class GSPlayController.class
	javac GSPlay.java GSGrid.java Button.java Window.java GSPlayController.java

GSPlayController.class : GSPlay.class GSWin.class
	javac GSPlayController.java GSPlay.java GSWin.java

GSSolver.class : GSGrid.class Window.class
	javac GSSolver.java GSGrid.java Window.java

GSTest.class : GSGrid.class 
	javac GSTest.java GSGrid.java

GSWin.class : 
	javac GSWin.java

HomeButtonClickListener.class : Window.class GSMenu.class GSMenuController.class GMUserInterfaceView.class DialogManager.class
	javac HomeButtonClickListener.java Window.java GSMenu.java GSMenuController.java GMUserInterfaceView.java DialogManager.java

HomeView.class : MusicButton.class Window.class Title.class HomeButtonClickListener.class Button.class
	javac HomeView.java MusicButton.java Window.java Title.java HomeButtonClickListener.java Button.java

MusicButton.class : MusicPlayer.class
	javac MusicButton.java MusicPlayer.java

MusicPlayer.class :
	javac MusicPlayer.java

RulesDialogManager.class : RulesSudoku.class
	javac RulesDialogManager.java RulesSudoku.java

RulesSudoku.class : Title.class
	javac RulesSudoku.java Title.java

Title.class : 
	javac Title.java

Window.class : 
	javac Window.java

doc :
	javadoc -d $(DOCDIR) $(SRC)

clean :
	-rm -rf $(OUTDIR)
	-rm -rf $(DOCDIR)

.PHONY : run clean doc


#JC := javac
#JCFLAGS := -encoding UTF-8 -implicit:none
#JVM := java
#JVMFLAGS :=

#SRCDIR := ./src
#OUTDIR := ./build
#DOCDIR := ./doc
#SRC := $(wildcard $(SRCDIR)/*.java)
#OFILES := $(SRC:$(SRCDIR)/%.java=$(OUTDIR)/%.class)

### REGLES ESSENTIELLES ###

#$(OUTDIR)/%.class : $(SRCDIR)/%.java
#	@mkdir -p $(@D)
#	${JC} ${JCFLAGS} -cp $(SRCDIR) -d $(OUTDIR) $<


### REGLES OPTIONNELLES ###

#GridMaker : $(OFILES)
#	${JVM} ${JVMFLAGS} -cp $(OUTDIR) GridMaker $(RUN_ARGS)

#GridSolver : $(OFILES)
#	${JVM} ${JVMFLAGS} -cp $(OUTDIR) GridSolver $(RUN_ARGS)

#clean :
#	-rm -rf $(OUTDIR)
#	-rm -rf $(DOCDIR)

#doc :
#	javadoc -d $(DOCDIR) $(SRC)

#default:

### BUTS FACTICES ###

#.PHONY : run clean doc

### FIN ###