package Client.support.entities;

import javax.persistence.*;
import java.util.Objects;
import org.hibernate.annotations.CreationTimestamp;
import java.util.Calendar;
import java.util.Date;


import Client.UserEntity;

@Entity
@Table(name = "salarys", schema = "salary")
public class SalarysEntity {
    @Column(name = "record_id")
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    private Long rowId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user_salary;

    @Column(name = "income", columnDefinition="Decimal(50,2)  default '0.00'")
    private double income;
    
    @Column(name = "collected", columnDefinition="Decimal(65,2)  default '0.00'")
    private double collected;

    @Column(name = "outcome", columnDefinition="Decimal(50,2) default '0.00'")
    private double outcome;

    @Column(name = "type_act", columnDefinition="TINYINT default '0'")
    private int type_act;
    
    @CreationTimestamp
    @Column(name = "date_salary")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSalary;

    @CreationTimestamp
    @Column(name = "date_str")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateString;


    public Date getDateSalary() {
        return dateSalary;
    }

    public void setDateSalary(Date date) {
        dateSalary = date;
    }

    public void setDateSalary(int mm, int yy) {
        if (mm < 12 && mm >= 0) {
            dateSalary = new Date();
           Calendar cal = Calendar.getInstance();
           cal.set(Calendar.MONTH,mm);
           cal.set(Calendar.YEAR, yy);
            dateSalary.setTime(cal.getTimeInMillis());
        }
    }


    public Date getDateString() {
        return dateSalary;
    }

    @PrePersist
    public void setDateString() {
        dateString = new Date();
    }

    public void setDateString(int mm, int yy) {
        if (mm < 12 && mm >= 0) {
            dateString = new Date();
           Calendar cal = Calendar.getInstance();
           cal.set(Calendar.MONTH,mm);
           cal.set(Calendar.YEAR, yy);
            dateSalary.setTime(cal.getTimeInMillis());
        }
    }
    
    public Long getrawID () {return rowId;}   
    public void setuserId(Long id) {
        this.rowId = id;
    }


    public int getTypeAct () {return type_act;}   
    public void setTypeAct(int i) {
        this.type_act = i;
    }

    public double getincome () {return income;}   
    public void setincome(double in) {
        this.income = in;
    }

    public double getcollected () {return collected;}   
    public void setcollected(double in) {
        this.collected = in;
    }

    public double getoutcome () {return outcome;}   
    public void setoutcome(double in) {
        this.outcome = in;
    }


    public UserEntity getSalaryRow () {return user_salary;}   
    public void setSalaryRow(UserEntity userSalary) {
        this.user_salary = userSalary;
    }

    

    
    
   
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalarysEntity that = (SalarysEntity) o;
        return rowId == that.rowId 
            && Objects.equals(dateString, that.dateString) 
            && Objects.equals(collected, that.collected);
    }
    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------

   
}
