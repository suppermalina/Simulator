package ExecutionalInstances;

import java.util.ArrayList;
import java.util.List;

import org.rosuda.JRI.Rengine;

public final class RandomNumberGenerator {
	private final static Rengine ENGINE = new Rengine(new String[] {"--vanilla"}, false, null);
    
    public static void setSeed(long seed) {
    	ENGINE.eval("set.seed(" + seed + ")");
    }
    
    public synchronized static double getInstance(double avgRate) {
    	double seed = Math.random();
		ENGINE.eval("set.seed(" + seed + ")");
		double base = ENGINE.eval("runif(1)").asDouble();
		double result = -avgRate * Math.exp(base);
	    return result;
    }
}