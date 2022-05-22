package entity;

public class Candidate {

    private int id;
    private String president;
    private String formula;
    private String presidentImage;
    private String formulaImage;
    private String groupImage;
    private int votes;

    public Candidate(int id, String president, String formula, String presidentImage, String formulaImage, String groupImage, int votes) {
        this.id = id;
        this.president = president;
        this.formula = formula;
        this.presidentImage = presidentImage;
        this.formulaImage = formulaImage;
        this.groupImage = groupImage;
        this.votes=votes;
    }
    public Candidate() { }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPresident() {
        return president;
    }
    public void setPresident(String president) {
        this.president = president;
    }
    public String getFormula() {
        return formula;
    }
    public void setFormula(String formula) {
        this.formula = formula;
    }
    public String getPresidentImage() {
        return presidentImage;
    }
    public void setPresidentImage(String presidentImage) {
        this.presidentImage = presidentImage;
    }
    public String getFormulaImage() {
        return formulaImage;
    }
    public void setFormulaImage(String formulaImage) {
        this.formulaImage = formulaImage;
    }
    public String getGroupImage() {
        return groupImage;
    }
    public void setGroupImage(String groupImage) {
        this.groupImage = groupImage;
    }
    public int getVotes() {
        return votes;
    }
    public void setVotes(int votes) {this.votes = votes;}
}
