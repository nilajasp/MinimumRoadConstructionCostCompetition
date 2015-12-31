import org.junit.Assert;
import org.junit.Test;

/**
 * Created by nilajapatankar on 12/7/14.
 */
public class RoadConstructionTest {
    @Test
    public void TestCase1()
    {
        CandidateCode roadConstruction = new CandidateCode();
        Assert.assertEquals(6, roadConstruction.minimumCost(new String[]{"A","B","C","D"}, new int[]{2,3,1,5,4,3}));
    }

    @Test
    public void TestCase2()
    {
        CandidateCode roadConstruction = new CandidateCode();
        Assert.assertEquals(6, roadConstruction.minimumCost(new String[]{"A","B","C","D"}, new int[]{2,1,3,2,4,3}));
    }

    @Test
    public void TestCase3()
    {
        CandidateCode roadConstruction = new CandidateCode();
        Assert.assertEquals(8, roadConstruction.minimumCost(new String[]{"A","B","C","D","E","F"}, new int[]{2,1,3,2,4,3,4,5,6,4,3,2,1,3,4}));
    }

    @Test
    public void TestCase4()
    {
        CandidateCode roadConstruction = new CandidateCode();
        Assert.assertEquals(30, roadConstruction.minimumCost(new String[]{"A","B","C","D","E","F"}, new int[]{6,6,6,6,6,6,6,6,6,6,6,6,6,6,6}));
    }

    @Test
    public void TestCase5()
    {
        CandidateCode roadConstruction = new CandidateCode();
        Assert.assertEquals(8, roadConstruction.minimumCost(new String[]{"A","B","C","D","E","F"}, new int[]{1,2,2,6,4,3,4,5,6,1,3,6,4,3,1}));
    }

    @Test
    public void TestCase6()
    {
        CandidateCode roadConstruction = new CandidateCode();
        Assert.assertEquals(5, roadConstruction.minimumCost(new String[]{"A","B","C","D","E","F"}, new int[]{1,1,1,6,4,3,4,5,6,4,3,6,1,3,1}));
    }
}
