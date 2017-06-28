package performance;

import java.lang.invoke.MethodHandles;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spf4j.annotations.PerformanceMonitor;
import org.spf4j.annotations.RecorderSourceInstance;

public class Engine {

  private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  private Producers producers = new Producers();

  private Compute compute = new Compute();

  private Consumers consumers = new Consumers();

  @PerformanceMonitor(warnThresholdMillis = 10, errorThresholdMillis = 100, recorderSource = RecorderSourceInstance.Rs5m.class)
  public void runEngine() {
    IntStream
        .generate(() -> producers.produceNumber())
        .limit(100)
        .map(i -> compute.computeOne(i))
        .map(i -> compute.computeTwo(i))
        .map(i -> compute.computeThree(i))
        .map(i -> compute.computeFour(i))
        .forEach(i -> consumers.consumeNumber(i));
  }
}
