package Client.support.answers;

public class Answer {
    
    private String wrong;
    private String gf;

    public String getWrong() {
        return wrong;
    }
    public void setWrong(String str) {
        this.wrong = str;
    }
    
    public String getGF() {
        return gf;
    }
    public void setGF(String f) {
        this.gf = f;
    }
   public Answer (String f) {
        this.wrong = f;
        this.gf = "ghgh";
    } 
}