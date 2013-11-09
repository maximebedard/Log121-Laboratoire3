package log121.lab3.api;

public interface IStrategie {
	
	public void calculerLeVainqueur(Jeu jeu);
	
	public void calculerScoreTour(Jeu jeu);
	
	public boolean partieTerminee(Jeu jeu);

}
