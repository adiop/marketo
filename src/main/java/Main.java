import java.util.Collections;
import java.util.List;

/**
 * Created by u2346 on 11/18/15.
 */
public class Main {

    public static void main(String[] args) {
        if (args[0] == null) {
            System.out.println("You must pass the path to file as an argument.");
            System.exit(0);
        }

        List<Lead>listWithPossibleDup = LeadObjectUtilities.getListOfLeadsFromFile(args[0]);

        Collections.sort(listWithPossibleDup,new LeadsComparator() );

        System.out.println("sorted Leads List with possible duplicate");
        for (Lead tmp : listWithPossibleDup ) {
            System.out.println(tmp.getId() + " : " + tmp.toString());
        }

        System.out.println("_____________________________________________________________________________________________");

        List <Lead> listWithNoDup = LeadObjectUtilities.removeDuplicates(listWithPossibleDup);

        if (listWithNoDup != null) {
            System.out.println("sorted Leads List with no duplicate");
            for (Lead tmp : listWithNoDup ) {
                System.out.println(tmp.toString());
            }

        }

        System.out.println("_____________________________________________________________________________________________");

        // Logging the changes
        System.out.println(LeadObjectUtilities.loggingChanges(listWithPossibleDup, listWithNoDup));

        System.out.println("_____________________________________________________________________________________________");

        System.out.println(LeadObjectUtilities.writeListToJson(listWithNoDup));

    }
}
