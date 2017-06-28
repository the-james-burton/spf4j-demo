package performance;

import java.lang.invoke.MethodHandles;
import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spf4j.annotations.PerformanceMonitor;
import org.spf4j.annotations.RecorderSourceInstance;

public class Consumers {

  private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  @PerformanceMonitor(warnThresholdMillis = 50, errorThresholdMillis = 500, recorderSource = RecorderSourceInstance.Rs5m.class)
  public void consumeNumber(Integer i) {
    try {
      Thread.sleep(ThreadLocalRandom.current().nextInt(0, 10));
    } catch (InterruptedException e) {
      logger.warn("interrupted:{}", e.getMessage());
    }
    logger.info("consumeNumber:{}", i);
  }

}
