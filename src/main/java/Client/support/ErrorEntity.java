package Client.support;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
//import java.sql.Date;
import java.util.Objects;
import java.util.Date;

@Entity
@Table(name = "errorCollector", schema = "salary")
public class ErrorEntity {
    

    //static data of user
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long errorId;
    private String name;
    private String code;
    private String info;
    private Date timestamp;

    @Column(name = "errorId")
    public Long getId () {
        return errorId;
    }
    public void setuserId(Long errorId) {
        this.errorId = errorId;
    }
    
    
    @Basic
    @Column(name = "code")
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }


    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "info")
    public String getInfo() {
        return info;
    }
    
    public void setInfo(String info) {
        this.info = info;
    }

    @CreationTimestamp
    @Column(name = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getTimestamp() {
        return timestamp;
    }

    @PrePersist
    public void setTimestamp() {
        timestamp = new Date();
    }

    public ErrorEntity () {}
    public ErrorEntity (String name, String code, String info) {
        this.name = name;
        this.code = code;
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErrorEntity that = (ErrorEntity) o;
        return errorId == that.errorId && Objects.equals(code, that.code) && Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errorId, name, code, info, timestamp);
    }
}
