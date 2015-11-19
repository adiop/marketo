import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by u2346 on 11/18/15.
 */
@Test
public class TestLeadObjectUtilities {
    List<Lead> testLit = null;

    @BeforeTest
    public void createDataForTest () {
        testLit = new ArrayList<Lead>() {{
            long now = System.currentTimeMillis();
            add(new Lead("jkj238238jdsnfsj23","Assane","Diop","adgo@test.com","333 Autum St",new Date(now)));
            add(new Lead("belr28238jdsnfsj23","Fred","Smith","diop@test.com","1234 Fall St",new Date(now - 35678)));
            add(new Lead("belr28238jdsnfsj23","John","Doe","doej@test.com","13 Winter St",new Date(now )));
            add(new Lead("belr28238jdsnfsj23","ed","pike","pike@test.com","1 Fire St",new Date(now + 4555)));
            add(new Lead("jkj238238jdsnfsj23","Larry","King","diop@test.com","123 Water St",new Date(now - 1000)));
            add(new Lead("sel045238jdsnfsj23","Barack","Obama","bamaprez@test.com","123 Water St",new Date(now + 1000)));


        }};
    }

    @Test
    public void sortListTest () {
        String [] correctSorting = {"pike","Obama","Diop","Doe","King","Smith"};
        int count = 0;
        Collections.sort(testLit, new LeadsComparator());
        System.out.println("sorted Leads List with possible duplicate");
        for (Lead tmp : testLit ) {
            Assert.assertEquals(correctSorting[count++], tmp.getLastName());
        }

    }

    @Test
    public void removeDupTest () {
        String [] correctWithNoDup = {"Diop","Smith","Obama"};
        int count = 0;
        List <Lead> listWithNoDup = LeadObjectUtilities.removeDuplicates(testLit);
        for (Lead tmp : listWithNoDup ) {
            Assert.assertEquals(correctWithNoDup[count++], tmp.getLastName());
        }

    }

    @Test
    public void writeListToJsonNegativeTest () {
        List <Lead> nulList = null;
        Assert.assertNull(LeadObjectUtilities.writeListToJson(nulList));

    }

    @Test
    public void removeDupNegativeTest () {
        List <Lead> nulList = null;
        Assert.assertNull(LeadObjectUtilities.removeDuplicates(nulList));

    }
}
