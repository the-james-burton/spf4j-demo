package performance;

import java.lang.invoke.MethodHandles;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Engine {

  private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  private Producers producers = new Producers();

  private Compute compute = new Compute();

  private Consumers consumers = new Consumers();

  public void runEngine() {
    IntStream
        .generate(() -> producers.produceNumber())
        .limit(10)
        .map(i -> compute.computeOne(i))
        .forEach(i -> consumers.consumeNumber(i));
  }
}
