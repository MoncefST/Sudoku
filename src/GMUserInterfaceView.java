import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;

/**
 * La classe GMUserInterfaceView représente la vue de l'interface utilisateur pour le créateur de grille.
 * Elle crée la barre de menu et initialise les différents composants de l'interface utilisateur.
 * @version 1.0
 * @author Moncef STITI
 * @author Marco ORFAO
 */
public class GMUserInterfaceView  {
  private JMenuBar menuBar = new JMenuBar();
  private Container content;
  private GMGrid grid;

  /**
   * Constructeur de la classe GMUserInterfaceView.
   * Initialise la fenêtre avec le titre approprié, crée la barre de menu et ajoute les composants à la fenêtre.
   * @param window La fenêtre de l'application
   */
  public GMUserInterfaceView(Window window) {
    window.setPageTitle("Créateur de grille");

    content = window.getContentPane();
    BorderLayout gestionnaire = new BorderLayout();
    content.setLayout(gestionnaire);
    grid = new GMGrid();

    // Création des menus
    JMenu menuFichier = createMenu("Fichier");
    JMenu menuGrille = createMenu("Grille");
    JMenu menuAide = createMenu("Aide");

    // Ajout des éléments de menu
    JMenuItem nouveauItem = createMenuItem("Nouveau", new GMResetGrid(grid));
    JMenuItem chargerItem = createMenuItem("Charger", new GMImport(window, grid));
    JMenuItem sauvegarderItem = createMenuItem("Sauvegarder", new GMSaverActionListener(window, grid));
    GMChecker checker = new GMChecker(grid); // Créez une instance de GMChecker
    GMCheckerListener checkerListener = new GMCheckerListener(checker); // Créez une instance de GMCheckerListener en passant GMChecker en argument
    JMenuItem verifierItem = createMenuItem("Vérifier", checkerListener);
    JMenuItem aideGrilleItem = createMenuItem("Comment créer une grille", new GMHowToCreateController());
    JMenuItem reglesSudokuItem = createMenuItem("Règles du Sudoku", new GMRules());


    // Ajout du menu "Jouer"
    JMenu menuJouer = createMenu("Quitter");
    // Création de l'élément de menu "Retour"
    JMenuItem retourMenu = createMenuItem("Quitter",new GMUserInterfaceController(window));
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

  /**
   * Crée un menu avec le titre spécifié.
   * @param title Le titre du menu
   * @return Le menu créé
   */
  private JMenu createMenu(String title) {
    return new JMenu(title);
  }

  /**
   * Crée un élément de menu avec le titre et le listener spécifiés.
   * @param title Le titre de l'élément de menu
   * @param listener Le listener associé à l'élément de menu
   * @return L'élément de menu créé
   */
  private JMenuItem createMenuItem(String title, ActionListener listener) {
    JMenuItem item = new JMenuItem(title);
    item.addActionListener(listener);
    return item;
  }
}
