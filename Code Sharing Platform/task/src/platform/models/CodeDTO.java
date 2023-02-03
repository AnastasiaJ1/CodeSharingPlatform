package platform.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CodeDTO {
    @Id
    @JsonProperty("code")
    String code;
    @JsonProperty("time")
    Long time;
    @JsonProperty("views")
    Long views;

    public void setCode(String code) {
        this.code = code;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        this.views = views;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code, Long time, Long views) {
        this.code = code;
        this.time = time;
        this.views = views;
    }
}
