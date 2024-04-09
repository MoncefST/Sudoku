public class Grille {
    private int[] grille = null;

    public Grille(){
        this.grille = new int[81];
        int x;

        for (x=0 ; x < 81 ; x++) {
            this.grille[x]=0;                        //remplie la grille de "0" -> "0" est un marqueur signifiant que la case est vide
        }
    }

    public boolean case_vide(int position){
        if (this.grille[position] == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean est_valide(int position, int nbr){
        
        /* check si le numéro se répète sur la colonne */

        int colonne = position%9;
        int id_test = colonne;
        while (id_test != (72+colonne)) {
            if ((this.grille[id_test]==nbr) && (id_test != position)) {
                return false;
            }
            id_test += 9;
        }
        
        /* check si le numéro se répète sur la ligne */

        int ligne = position/9;
        id_test = ligne * 9;
        
        while (id_test != ((ligne +1)*9)) {
            if ((this.grille[id_test]==nbr) && (id_test != position)) {
                return false;
            }
            id_test += 1;
        }

        /* check si le numéro se répète dans le carré auquel il appartient */

        int Vcase = ligne/3;                                                    // permet de connaître la position du carré sur un axe vertical 
        int Hcase = colonne/3;                                                  // permet de connaître la position du carré sur un axe horizontal
        int x,y;
        
        for (x=0; x<3 ;x++) {
            for (y=0; y<3 ;y++) {
                id_test = Vcase*27+(y+Hcase*3)+(x*9);
                if ((this.grille[id_test]==nbr) && (id_test != position)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void remplir_case(int position,int nbr){
        if ((nbr > 0) && (nbr < 10)){
            this.grille[position] = nbr;
        } else {
            System.out.println("veuillez choisir un nombre entre 1 et 9");
        }
    }

    /*public static void main(String[] args){
        Grille grille = new Grille();
        grille.remplir_case(3,59);
        System.out.println(grille.case_vide(3));
    }*/
}
