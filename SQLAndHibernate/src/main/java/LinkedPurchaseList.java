import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class LinkedPurchaseList {
    @EmbeddedId
    private KeyLPL keyLPL;

    public KeyLPL getKeyLPL() {
        return keyLPL;
    }

    public void setKeyLPL(int student_id, int course_id) {
        keyLPL = new KeyLPL(student_id, course_id);
    }
}
