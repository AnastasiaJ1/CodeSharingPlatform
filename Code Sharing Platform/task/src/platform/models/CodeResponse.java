package platform.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
public class CodeResponse {
    @Id
    @JsonIgnore
    private String  id;
    private String code;

    public CodeResponse(String id, String code, String date, Long time, Long views) {
        this.id = id;
        this.code = code;
        this.date = date;
        this.time = time;
        this.views = views;
    }

    String date;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Long time;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Long views;

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getDate() {
        return date;
    }

    public Long getTime() {
        return time;
    }

    public Long getViews() {
        return views;
    }
}
