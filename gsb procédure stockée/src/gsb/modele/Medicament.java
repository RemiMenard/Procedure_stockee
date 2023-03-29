package gsb.modele;

public class Medicament {
	public String MED_DEPOTLEGAL; 
	public String MED_NOMCOMMERCIAL;
	public String MED_COMPOSITION;
	public String MED_EFFETS;
	public String MED_CONTREINDIC;
	public double MED_PRIXECHANTILLON;
	public String FAM_CODE;
	public String FAM_LIBELLE;
	
	public Medicament (String MED_DEPOTLEGAL, String MED_NOMCOMMERCIAL,String MED_COMPOSITION,String MED_EFFETS,
	 String MED_CONTREINDIC,double MED_PRIXECHANTILLON,String FAM_CODE,String FAM_LIBELLE) {
		this.MED_DEPOTLEGAL=MED_DEPOTLEGAL;
		this.MED_NOMCOMMERCIAL=MED_NOMCOMMERCIAL;
		this.MED_COMPOSITION=MED_COMPOSITION;
		this.MED_EFFETS=MED_EFFETS;
		this.MED_CONTREINDIC=MED_CONTREINDIC;
		this.MED_PRIXECHANTILLON=MED_PRIXECHANTILLON;
		this.FAM_CODE=FAM_CODE;
		this.FAM_LIBELLE=FAM_LIBELLE;
	}

	public String getMED_DEPOTLEGAL() {
		return MED_DEPOTLEGAL;
	}

	public void setMED_DEPOTLEGAL(String MED_DEPOTLEGAL) {
		this.MED_DEPOTLEGAL = MED_DEPOTLEGAL;
	}

	public String getMED_NOMCOMMERCIAL() {
		return MED_NOMCOMMERCIAL;
	}

	public void setMED_NOMCOMMERCIAL(String MED_NOMCOMMERCIAL) {
		this.MED_NOMCOMMERCIAL = MED_NOMCOMMERCIAL;
	}

	public String getMED_COMPOSITION() {
		return MED_COMPOSITION;
	}

	public void setMED_COMPOSITION(String MED_COMPOSITION) {
		this.MED_COMPOSITION = MED_COMPOSITION;
	}

	public String getMED_EFFETS() {
		return MED_EFFETS;
	}

	public void setMED_EFFETS(String MED_EFFETS) {
		this.MED_EFFETS = MED_EFFETS;
	}

	public String getMED_CONTREINDIC() {
		return MED_CONTREINDIC;
	}

	public void setMED_CONTREINDIC(String MED_CONTREINDIC) {
		this.MED_CONTREINDIC = MED_CONTREINDIC;
	}

	public double getMED_PRIXECHANTILLON() {
		return MED_PRIXECHANTILLON;
	}

	public void setMED_PRIXECHANTILLON(double MED_PRIXECHANTILLON) {
		this.MED_PRIXECHANTILLON = MED_PRIXECHANTILLON;
	}

	public String getFAM_CODE() {
		return FAM_CODE;
	}

	public void setFAM_CODE(String fAM_CODE) {
		FAM_CODE = fAM_CODE;
	}

	public String getFAM_LIBELLE() {
		return FAM_LIBELLE;
	}

	public void setFAM_LIBELLE(String fAM_LIBELLE) {
		FAM_LIBELLE = fAM_LIBELLE;
	}
	
}
