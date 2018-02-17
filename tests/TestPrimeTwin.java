import main.Application;
import org.junit.Before;
import org.junit.Test;
import task.PrimeTwinChains;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CyclicBarrier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestPrimeTwin {

    PrimeTwinChains chain;
    @Before
    public void buildPrimeTwinsChains(){
        int min = 3;
        int max = 30;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4);

        chain = new PrimeTwinChains(cyclicBarrier, min, max);
        Application app = new Application();

    }

    @Test
    public void testIsPrime(){
        assertTrue(chain.isPrime(31));
        assertFalse(chain.isPrime(10));
    }

    @Test
    public void testGetListOfPrimes(){
        ArrayList<Integer> primeList = new ArrayList<>(Arrays.asList(3, 5, 7, 11, 13, 17, 19, 23, 29));

        assertEquals(primeList, chain.getListOfPrimes());
    }

    @Test
    public void testFindChain(){
        ArrayList<Integer> primeList = new ArrayList<>(Arrays.asList(3, 5, 7, 11, 13, 17, 19, 23, 29));
        ArrayList<ArrayList<Integer>> result = chain.getFinalList(chain.iteratePrimeTwins(chain.findPrimeTwins(primeList)) );

        ArrayList<ArrayList<Integer>> expected = new ArrayList<>();
        ArrayList<Integer> chain = new ArrayList<>();
        chain.addAll(Arrays.asList(5, 7, 11, 13));
        expected.add(chain);
        assertEquals(result, expected);
    }
}
