package Client.support.entities;
import java.util.Calendar;
import java.util.Objects;


public class Card {
    //static data of user
    private Long number;
    
    private String owner;
    private String SecCode;

    private Integer WorkMonth;
    private Integer WorkYear;


    public boolean setNumber (String fname) {
        if (fname.length() >= 17 && fname.length() < 20) {
            try {
                String clear = fname.replaceAll("\\s+","");
                long l = Long.parseLong(clear);
                this.number = l;
                return true;
            } catch (Exception e) {
               return false; 
            }
        }else{
            return false;
        }
    }
    public String getNumber () {return  number.toString();}

    

    public void setOwner (String name) {
       this.owner = name;
    }
    public String getOwner () {return owner;}

    public void setData (String data) {
        String[] separated = data.split("\\/");
        if (separated.length == 2) {
            try {
                WorkMonth = Integer.parseInt(separated[0]);
                WorkYear = Integer.parseInt(separated[1]);
                if (WorkMonth > 12) WorkMonth = 12;
                
            } catch (Exception e) {
                //TODO: handle exception
            }
           

        }
    }
    public String getData () {return WorkMonth+"/"+WorkYear;}
 

    public boolean cardStillWork () {
        int year = Calendar.getInstance().get(Calendar.YEAR);
    
        String str = String.valueOf(year);
        String substring = str.length() > 2 ? str.substring(str.length() - 2) : str;
        year = Integer.parseInt(substring);
        if (year > WorkYear) return false;
        

        int month = Calendar.getInstance().get(Calendar.MONTH);
        if (WorkYear == year && WorkMonth+1 <= month) {
             return false;
        }

        return true;
    } 


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card that = (Card) o;
        return number == that.number 
            && Objects.equals(owner, that.owner) 
            && Objects.equals(SecCode, that.SecCode) 
            && Objects.equals(WorkMonth, that.WorkMonth)
            && Objects.equals(WorkYear,that.WorkYear);

    }


    
    @Override
    public int hashCode() {
        return Objects.hash(number, SecCode, owner, WorkMonth, WorkYear);
    }
}