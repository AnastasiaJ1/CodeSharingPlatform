package platform.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class IdResponse {
    @Id
    String id;
    public IdResponse(String id) {
        this.id = id;
    }

    public IdResponse() {

    }

    public String getId() {
        return id;
    }


}
