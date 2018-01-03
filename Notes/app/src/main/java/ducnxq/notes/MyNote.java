package ducnxq.notes;

import java.util.Date;

/**
 * Created by Quy Duc on 1/2/2018.
 */

public class MyNote {
    private String id;
    private String title;
    private String description;
    private Date createdDate;
    public MyNote() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
