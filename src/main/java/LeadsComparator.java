import java.util.Comparator;

/**
 * Created by u2346 on 11/17/15.
 */
public class LeadsComparator implements Comparator<Lead> {
    public int compare (Lead l1, Lead l2) {

        return l2.getEntryDate().compareTo(l1.getEntryDate());

    }


}
