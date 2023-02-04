package platform.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

@Entity
@JsonSerialize
@Table(name = "Code")
public class Code {
    @JsonIgnore
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "code")
    private String code;
    @Column(name="date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @JsonIgnore
    private LocalDateTime dateForDiff;

    @Column(name = "time")
    private Long time;

    @JsonIgnore
    @Column(name = "timeInit")
    private Long timeInit;


    @Column(name = "views")
    private Long views;
    @JsonIgnore
    @Column(name = "secrettime")
    private Integer secretTime;

    @JsonIgnore
    @Column(name = "secretviews")
    private Integer secretViews;

    public LocalDateTime getDateForDiff() {
        return dateForDiff;
    }



    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }



    public Code(String code, Long time, Long views) {
        this.code = code;
        this.date = new Date();
        this.id = UUID.randomUUID().toString();
        this.dateForDiff = LocalDateTime.now();
        this.timeInit = 0L;
        this.time = 0L;
        this.views = 0L;
        this.secretTime = 0;
        this.secretViews = 0;
        if (time > 0){
            this.secretTime = 1;
            this.timeInit = time;
        }
        if (views > 0){
            this.secretViews = 1;
            this.views = views;
        }
    }

    public Code() {

    }

    public Integer getSecretTime() {
        return secretTime;
    }
    public Integer getSecretViews() {
        return secretViews;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getTimeInit() {
        return timeInit;
    }

    public void setTimeInit(Long time) {
        this.timeInit = timeInit;
    }

    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        this.views = views;
    }

    public void setSecretTime(Integer secretTime) {
        this.secretTime = secretTime;
    }

    public void setSecretViews(Integer secretViews) {
        this.secretViews = secretViews;
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getDate() {
        return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(date);
    }
    public Date DateDate() {
        return date;
    }
    @Override
    public String toString(){
        return "code: " + this.code +"\n" +
                "id: " + this.id +"\n" +
                "date: " + this.date +"\n" +
                "time: " + this.time +"\n" +
                "views: " + this.views +"\n";
    }
}