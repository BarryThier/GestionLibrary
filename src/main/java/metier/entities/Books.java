package metier.entities;

import java.io.Serializable;
import java.sql.Date;

public class Books implements Serializable{
	private int codeCatalogue;
	private String titre;
	private String auteur;
	private String editeur;
	private String theme;
	private String dateAcq;
	private String codeUsure;
	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Books( String titre, String auteur, String editeur, String theme, String dateAcq,
			String codeUsure) {
		super();
		this.titre = titre;
		this.auteur = auteur;
		this.editeur = editeur;
		this.theme = theme;
		this.dateAcq = dateAcq;
		this.codeUsure = codeUsure;
	}
	public int getCodeCatalogue() {
		return codeCatalogue;
	}
	public void setCodeCatalogue(int codeCatalogue) {
		this.codeCatalogue = codeCatalogue;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public String getEditeur() {
		return editeur;
	}
	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getDateAcq() {
		return dateAcq;
	}
	public void setDateAcq(String dateAcq) {
		this.dateAcq = dateAcq;
	}
	
	public String getCodeUsure() {
		return codeUsure;
	}
	public void setCodeUsure(String codeUsure) {
		this.codeUsure = codeUsure;
	}
	@Override
	public String toString() {
		return "Books [codeCatalogue=" + codeCatalogue + ", titre=" + titre + ", auteur=" + auteur + ", editeur="
				+ editeur + ", theme=" + theme + ", dateAcq=" + dateAcq + ", codeUsure=" + codeUsure + "]";
	}
}
