package iut;


/**
 * Représente un nombre rationnel (quotient de deux entiers)
 * @author aguidet
 * @version 2017
 */
public class Rationnel {
	private int numérateur;
	private int dénominateur;

	/**
	 * Construit un rationnel valant 0
	 */
	public Rationnel() {
		numérateur = 0;
                dénominateur = 1;
	}

	/**
	 * Construit un rationnel valant l'entier passé en paramètre
	 * @param num la valeur à affecter au rationnel (num/1)         
	 */
	public Rationnel(int num) {
		numérateur = num;
                dénominateur = 1;
	}

	/**
	 * Construit un rationnel
	 * @param num le numérateur
	 * @param den le dénominateur (doît être non nul)
         * @throws ArithmeticException si le dénominateur est nul
	 */
	public Rationnel(int num, int den) throws ArithmeticException {
		if(den==0) throw new ArithmeticException();
                numérateur = num;
                dénominateur = den;
                normalise();
	}

	/**
	 * Construit un rationnel à partir d'une représentation châine
	 * @param s une chaîne représentant le rationnel sous la forme n/d
         * @throws Exception si la chaîne est mal formée
	 */
	public Rationnel(String s) throws Exception {
		String[] parties = s.split("/");
                if(parties.length<1) throw new Exception("Il manque le numérateur");
                numérateur = Integer.parseInt(parties[0]);
                if(parties.length==2)
                {
                    dénominateur = Integer.parseInt(parties[1]);
                }
                normalise();
	}

	/**
	 * Exprime le rationnel sous la forme d'une chaîne de caractères
	 * @return le rationnel sous la forme n/d
	 */
        @Override
	public String toString() {
		return String.valueOf(numérateur)+"/"+String.valueOf(dénominateur);
	}

	/**
	 * Ajoute un rationnel
	 * @param r le rationnel à ajouter
	 */
	public void ajouter(Rationnel r) {
               this.numérateur = (this.numérateur * r.dénominateur) + (this.dénominateur * r.numérateur);
               this.dénominateur = this.dénominateur * r.dénominateur;
               this.normalise();
	}

	/**
	 * multiplie par un rationnel
	 * @param r le rationnel à multiplier
	 */
	public void multiplier(Rationnel r) {
		numérateur *= r.numérateur;
                dénominateur *= r.dénominateur;
                normalise();
	}

	/**
	 * indique si les deux rationnels sont égaux en valeur (10/20 = 1/2)
	 * @param r le rationnel à comparer
         * @return vrai si les deux sont égaux
	 */
	public boolean estEgal(Rationnel r) {
            return numérateur*r.dénominateur == dénominateur*r.numérateur;
	}

	/**
	 * indique si le rationnel est inférieur au paramètre
	 * @param r le rationnel à comparer
	 * @return vrai si le rationnel est plus petit en valeur
	 */
	public boolean estInférieur(Rationnel r) {
		//return this.toDouble() < r.toDouble();
                return (this.numérateur * r.dénominateur) < (this.dénominateur * r.numérateur);
	}

	/**
	 * calcule une valeur approchée du rationnel
	 * @return la valeur approchée, sous forme double, du rationnel
	 */
	public double toDouble() {
		return (double)numérateur/(double)dénominateur;
	}



        @Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		} else if (object instanceof Rationnel) {
			return estEgal((Rationnel)object);
		}
		return false;
	}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.numérateur;
        hash = 37 * hash + this.dénominateur;
        return hash;
    }
        
        private void normalise()
        {
            int p = Utils.pgcd(Math.abs(numérateur), Math.abs(dénominateur));
            numérateur /= p;
            dénominateur /= p;
        }
        
    
}