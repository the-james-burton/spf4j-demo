package performance;

import java.lang.invoke.MethodHandles;
import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spf4j.annotations.PerformanceMonitor;
import org.spf4j.annotations.RecorderSourceInstance;

public class Compute {

  private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  @PerformanceMonitor(warnThresholdMillis = 50, errorThresholdMillis = 500, recorderSource = RecorderSourceInstance.Rs5m.class)
  public Integer computeOne(final Integer i) {
    simulateCalculation(1);
    return i + 1;
  }

  @PerformanceMonitor(warnThresholdMillis = 50, errorThresholdMillis = 500, recorderSource = RecorderSourceInstance.Rs5m.class)
  public Integer computeTwo(Integer i) {
    simulateCalculation(2);
    return i * 2;
  }

  @PerformanceMonitor(warnThresholdMillis = 50, errorThresholdMillis = 500, recorderSource = RecorderSourceInstance.Rs5m.class)
  public Integer computeThree(Integer i) {
    simulateCalculation(3);
    return i / 2;
  }

  @PerformanceMonitor(warnThresholdMillis = 50, errorThresholdMillis = 500, recorderSource = RecorderSourceInstance.Rs5m.class)
  public Integer computeFour(Integer i) {
    simulateCalculation(4);
    return i - 1;
  }

  private void simulateCalculation(int x) {
    try {
      Thread.sleep(ThreadLocalRandom.current().nextInt(0, 20 * x));
    } catch (InterruptedException e) {
      logger.warn("interrupted:{}", e.getMessage());
    }
  }

}
