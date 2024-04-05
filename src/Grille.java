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

    public void remplir_case(int position,int nbr){
        if ((nbr > 0) && (nbr < 10)){
            this.grille[position] = nbr;
        } else {
            System.out.println("veuillez choisir un nombre entre 1 et 9");
        }
    }

    public static void main(String[] args){
        Grille grille = new Grille();
        grille.remplir_case(3,59);
        System.out.println(grille.case_vide(3));

    }
}
