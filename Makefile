### VARIABLES ###

DOCDIR := ./doc
SRCDIR := ./src
SRC := $(wildcard $(SRCDIR)/*.java)
OUTDIR := ./build
JCFLAGS := -encoding UTF-8 -implicit:none
JC = javac
JVM = java
JVMFLAGS = 

### REGLES ESSENTIELLES ###

${OUTDIR}/GridMaker.class : ${SRCDIR}/GridMaker.java ${OUTDIR}/Window.class ${OUTDIR}/HomeView.class
    ${JC} ${JCFLAGS} ${SRCDIR}/GridMaker.java -d $(OUTDIR)

${OUTDIR}/GridSolver.class : ${SRCDIR}/GridSolver.java ${OUTDIR}/Window.class ${OUTDIR}/HomeView.class
    ${JC} ${JCFLAGS} ${SRCDIR}/GridSolver.java -d $(OUTDIR)

${OUTDIR}/Window.class : ${SRCDIR}/Window.java
	${JC} ${JCFLAGS} ${SRCDIR}/Window.java -d $(OUTDIR)

${OUTDIR}/Title.class : ${SRCDIR}/Title.java
	${JC} ${JCFLAGS} ${SRCDIR}/Title.java -d $(OUTDIR)

${OUTDIR}/Button.class : ${SRCDIR}/Button.java
	${JC} ${JCFLAGS} ${SRCDIR}/Button.java -d $(OUTDIR)

${OUTDIR}/CongratulationsDialog.class : ${SRCDIR}/CongratulationsDialog.java
	${JC} ${JCFLAGS} ${SRCDIR}/CongratulationsDialog.java -d $(OUTDIR)

${OUTDIR}/DialogManager.class : ${SRCDIR}/DialogManager.java
	${JC} ${JCFLAGS} ${SRCDIR}/DialogManager.java -d $(OUTDIR)

${OUTDIR}/GMCase.class : ${SRCDIR}/GMCase.java ${OUTDIR}/GMGrid.class ${OUTDIR}/GMCaseKeyListener.class ${OUTDIR}/GMCaseMouseListener.class
	${JC} ${JCFLAGS} ${SRCDIR}/GMCase.java -d $(OUTDIR)

${OUTDIR}/GMCaseKeyListener.class : ./GMCaseKeyListener.java ${OUTDIR}/GMCase.class ${OUTDIR}/GMGrid.class
	${JC} ${JCFLAGS} ${SRCDIR}/GMCaseKeyListener.java -d $(OUTDIR)

${OUTDIR}/GMCaseMouseListener.class : ./GMCaseMouseListener.java ${OUTDIR}/GMCase.class
	${JC} ${JCFLAGS} ${SRCDIR}/GMCaseMouseListener.java -d $(OUTDIR)

${OUTDIR}/GMChecker.class : ${SRCDIR}/GMChecker.java ${OUTDIR}/GMGrid.class
	${JC} ${JCFLAGS} ${SRCDIR}/GMChecker.java -d $(OUTDIR)

${OUTDIR}/GMGrid.class : ${SRCDIR}/GMGrid.java ${OUTDIR}/GMCase.class
	${JC} ${JCFLAGS} ${SRCDIR}/GMGrid.java -d $(OUTDIR)

${OUTDIR}/GMHowToCreateController.class : ${SRCDIR}/GMHowToCreateController.java ${OUTDIR}/GMHowToCreateDialogManager.class 
	${JC} ${JCFLAGS} ${SRCDIR}/GMHowToCreateController.java -d $(OUTDIR)

${OUTDIR}/GMHowToCreateDialogManager.class : ${SRCDIR}/GMHowToCreateDialogManager.java ${OUTDIR}/GMHowToCreateView.class 
	${JC} ${JCFLAGS} ${SRCDIR}/GMHowToCreateDialogManager.java -d $(OUTDIR)

${OUTDIR}/GMHowToCreateView.class : ${SRCDIR}/GMHowToCreateView.java
	${JC} ${JCFLAGS} ${SRCDIR}/GMHowToCreateView.java -d $(OUTDIR)

${OUTDIR}/GMImport.class : ${SRCDIR}/GMImport.java ${OUTDIR}/GMGrid.class 
	${JC} ${JCFLAGS} ${SRCDIR}/GMImport.java -d $(OUTDIR)

${OUTDIR}/GMResetGrid.class : ${SRCDIR}/GMResetGrid.java ${OUTDIR}/GMGrid.class 
	${JC} ${JCFLAGS} ${SRCDIR}/GMResetGrid.java -d $(OUTDIR)

${OUTDIR}/${OUTDIR}/Rules.class : ${SRCDIR}/Rules.java
	${JC} ${JCFLAGS} ${SRCDIR}/Rules.java -d $(OUTDIR)

${OUTDIR}/GMSaver.class : ${SRCDIR}/GMSaver.java ${OUTDIR}/GMGrid.class ${OUTDIR}/GMChecker.class
	${JC} ${JCFLAGS} ${SRCDIR}/GMSaver.java -d $(OUTDIR)

${OUTDIR}/GMSaverActionListener.class : ${SRCDIR}/GMSaverActionListener.java ${OUTDIR}/Window.class ${OUTDIR}/GMGrid.class ${OUTDIR}/GMSaver.class
	${JC} ${JCFLAGS} ${SRCDIR}/GMSaverActionListener.java -d $(OUTDIR)

${OUTDIR}/GMUserInterfaceController.class : ${SRCDIR}/GMUserInterfaceController.java ${OUTDIR}/Window.class
	${JC} ${JCFLAGS} ${SRCDIR}/GMUserInterfaceController.java -d $(OUTDIR)

${OUTDIR}/GMUserInterfaceView.class : ${SRCDIR}/GMUserInterfaceView.java ${OUTDIR}/GMGrid.class ${OUTDIR}/Window.class ${OUTDIR}/GMResetGrid.class ${OUTDIR}/GMImport.class ${OUTDIR}/GMSaverActionListener.class ${OUTDIR}/GMHowToCreateController.class ${OUTDIR}/Rules.class
	${JC} ${JCFLAGS} ${SRCDIR}/GMUserInterfaceView.java -d $(OUTDIR)

${OUTDIR}/GSCase.class : ${SRCDIR}/GSCase.java ${OUTDIR}/GSGrid.class ${OUTDIR}/GSCaseMouseListener.class ${OUTDIR}/GSTest.class
	${JC} ${JCFLAGS} ${SRCDIR}/GSCase.java -d $(OUTDIR)

${OUTDIR}/GSCaseMouseListener.class : ${SRCDIR}/GSCaseMouseListener.java ${OUTDIR}/GSCase.class
	${JC} ${JCFLAGS} ${SRCDIR}/GSCaseMouseListener.java -d $(OUTDIR)

${OUTDIR}/GSGrid.class : ${SRCDIR}/GSGrid.java ${OUTDIR}/GSCase.class ${OUTDIR}/GSTest.class
	${JC} ${JCFLAGS} ${SRCDIR}/GSGrid.java -d $(OUTDIR)

${OUTDIR}/GSImport.class : ${SRCDIR}/GSImport.java ${OUTDIR}/Window.class
	${JC} ${JCFLAGS} ${SRCDIR}/GSImport.java -d $(OUTDIR)

${OUTDIR}/GSMenu.class : ${SRCDIR}/GSMenu.java ${OUTDIR}/Title.class ${OUTDIR}/Button.class ${OUTDIR}/Window.class
	${JC} ${JCFLAGS} ${SRCDIR}/GSMenu.java -d $(OUTDIR)

${OUTDIR}/GSMenuController.class : ${SRCDIR}/GSMenuController.java ${OUTDIR}/GSMenu.class ${OUTDIR}/Window.class ${OUTDIR}/GSGrid.class ${OUTDIR}/GSMenu.class ${OUTDIR}/GSImport.class ${OUTDIR}/GSPlay.class ${OUTDIR}/GSPlayController.class ${OUTDIR}/GSSolver.class
	${JC} ${JCFLAGS} ${SRCDIR}/GSMenuController.java -d $(OUTDIR)

${OUTDIR}/GSPlay.class : ${SRCDIR}/GSPlay.java ${OUTDIR}/GSGrid.class ${OUTDIR}/Button.class ${OUTDIR}/Window.class ${OUTDIR}/GSPlayController.class
	${JC} ${JCFLAGS} ${SRCDIR}/GSPlay.java -d $(OUTDIR)

${OUTDIR}/GSPlayController.class : ${SRCDIR}/GSPlayController.java ${OUTDIR}/GSPlay.class ${OUTDIR}/GSWin.class
	${JC} ${JCFLAGS} ${SRCDIR}/GSPlayController.java -d $(OUTDIR)

${OUTDIR}/GSSolver.class : ${SRCDIR}/GSSolver.java ${OUTDIR}/GSGrid.class ${OUTDIR}/Window.class
	${JC} ${JCFLAGS} ${SRCDIR}/GSSolver.java -d $(OUTDIR)

${OUTDIR}/GSTest.class : ${SRCDIR}/GSTest.java ${OUTDIR}/GSGrid.class 
	${JC} ${JCFLAGS} ${SRCDIR}/GSTest.java -d $(OUTDIR)

${OUTDIR}/GSWin.class : ${SRCDIR}/GSWin.java
	${JC} ${JCFLAGS} ${SRCDIR}/GSWin.java -d $(OUTDIR)

${OUTDIR}/HomeButtonClickListener.class : ${SRCDIR}/HomeButtonClickListener.java ${OUTDIR}/Window.class ${OUTDIR}/GSMenu.class ${OUTDIR}/GSMenuController.class ${OUTDIR}/GMUserInterfaceView.class ${OUTDIR}/DialogManager.class
	${JC} ${JCFLAGS} ${SRCDIR}/HomeButtonClickListener.java -d $(OUTDIR)

${OUTDIR}/HomeView.class : ${SRCDIR}/HomeView.java ${OUTDIR}/MusicButton.class ${OUTDIR}/Window.class ${OUTDIR}/Title.class ${OUTDIR}/HomeButtonClickListener.class ${OUTDIR}/Button.class
	${JC} ${JCFLAGS} ${SRCDIR}/HomeView.java -d $(OUTDIR)

${OUTDIR}/MusicPlayer.class : ${SRCDIR}/MusicPlayer.java
    ${JC} ${JCFLAGS} ${SRCDIR}/MusicPlayer.java -d $(OUTDIR)

${OUTDIR}/MusicButton.class : ${SRCDIR}/MusicButton.java ${OUTDIR}/MusicPlayer.class
    ${JC} ${JCFLAGS} ${SRCDIR}/MusicButton.java -d $(OUTDIR)

${OUTDIR}/RulesDialogManager.class : ${SRCDIR}/RulesDialogManager.java ${OUTDIR}/RulesSudoku.class
	${JC} ${JCFLAGS} ${SRCDIR}/RulesDialogManager.java -d $(OUTDIR)

${OUTDIR}/RulesSudoku.class : ${SRCDIR}/RulesSudoku.java ${OUTDIR}/Title.class
	${JC} ${JCFLAGS} ${SRCDIR}/RulesSudoku.java -d $(OUTDIR)


### REGLES OPTIONNELLES ###

GridMaker : $(OFILES)
	${JVM} ${JVMFLAGS} -cp $(OUTDIR) GridMaker

GridSolver : $(OFILES)
	${JVM} ${JVMFLAGS} -cp $(OUTDIR) GridSolver

doc :
	javadoc -d $(DOCDIR) $(SRC)

clean :
	-rm -rf $(OUTDIR)
	-rm -rf $(DOCDIR)

.PHONY : clean doc