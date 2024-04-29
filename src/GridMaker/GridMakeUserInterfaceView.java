import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;


public class GridMakeUserInterfaceView  {
  private JMenuBar menuBar = new JMenuBar();
  private Container content;
  private GridMakerGrid grid;

  public GridMakeUserInterfaceView(Window window) {
    window.setPageTitle("Créateur de grille");

    content = window.getContentPane();
    BorderLayout gestionnaire = new BorderLayout();
    content.setLayout(gestionnaire);
    grid = new GridMakerGrid();

    // Création des menus
    JMenu menuFichier = createMenu("Fichier");
    JMenu menuGrille = createMenu("Grille");
    JMenu menuAide = createMenu("Aide");

    // Ajout des éléments de menu
    JMenuItem nouveauItem = createMenuItem("Nouveau", new GridMakerResetGrid(grid));
    JMenuItem chargerItem = createMenuItem("Charger", new GridMakerImport(window, grid));
    JMenuItem sauvegarderItem = createMenuItem("Sauvegarder", new GridMakerSaver(window, grid));
    GridMakerChecker checker = new GridMakerChecker(grid); // Créez une instance de GridMakerChecker
    GridMakerCheckerListener checkerListener = new GridMakerCheckerListener(checker); // Créez une instance de GridMakerCheckerListener en passant GridMakerChecker en argument
    JMenuItem verifierItem = createMenuItem("Vérifier", checkerListener);
    JMenuItem aideGrilleItem = createMenuItem("Comment créer une grille", new GridMakerHowToCreateController());
    JMenuItem reglesSudokuItem = createMenuItem("Règles du Sudoku", new GridMakerRules());


    // Ajout du menu "Jouer"
    JMenu menuJouer = createMenu("Quitter");
    // Création de l'élément de menu "Retour"
    JMenuItem retourMenu = createMenuItem("Quitter",new GridMakeUserInterfaceController(window));
    // Ajout de l'élément "Retour" au menu "Jouer"
    menuJouer.add(retourMenu);
    // Ajout du menu "Jouer" à la barre de menu
    menuBar.add(menuJouer);


    // Ajout des menus à la barre de menu
    menuFichier.add(nouveauItem);
    menuFichier.add(chargerItem);
    menuFichier.add(sauvegarderItem);
    menuGrille.add(verifierItem);
    menuAide.add(aideGrilleItem);
    menuAide.add(reglesSudokuItem);

    menuBar.add(menuFichier);
    menuBar.add(menuGrille);
    menuBar.add(menuAide);

    window.add(menuBar, BorderLayout.NORTH);
    content.add(grid, BorderLayout.CENTER);

    window.setDefaultCloseOperation(Window.EXIT_ON_CLOSE);
    window.setVisible(true);
  }

  private JMenu createMenu(String title) {
    return new JMenu(title);
  }

  private JMenuItem createMenuItem(String title, ActionListener listener) {
    JMenuItem item = new JMenuItem(title);
    item.addActionListener(listener);
    return item;
  }
}
