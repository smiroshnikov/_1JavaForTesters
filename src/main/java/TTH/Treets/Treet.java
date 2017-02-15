package TTH.Treets;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by miross1 on 2/15/2017.
 * Repeating TTH tutorial that was bad , so lets type and understand this completely
 * Treet is a tweet-like thing with author , date  and description fields
 */

public class Treet implements Comparable, Serializable {
    private static final long serialVersionUID = 1884658576115477459L;
    //private boolean brokenFlag = true;
    private String author;
    private String description;
    private Date creationDate;

    public Treet(String author, String description, Date creationDate) {
        this.author = author;
        this.description = description;
        this.creationDate = creationDate;

    }

    @Override
    public String toString() {
        return String.format("Treet:   by \"%s \" --> %s%n @ %s%n ", author, description, creationDate);
    }

    @Override
    public int compareTo(Object o) {
        Treet otherTreet = (Treet) o;
        if (equals(otherTreet)) {
            return 0;
        }
        int dateCmp = creationDate.compareTo(otherTreet.creationDate);
        if (dateCmp == 0) {
            return description.compareTo(otherTreet.description);
        }
        return dateCmp;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String[] getwords() {
        return description.toLowerCase().split("[^\\w#@']+");
    }
}
