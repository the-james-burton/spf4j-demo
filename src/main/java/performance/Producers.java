package performance;

import java.util.concurrent.ThreadLocalRandom;

import org.spf4j.annotations.PerformanceMonitor;
import org.spf4j.annotations.RecorderSourceInstance;

public class Producers {

  @PerformanceMonitor(warnThresholdMillis = 1, errorThresholdMillis = 100, recorderSource = RecorderSourceInstance.Rs5m.class)
  public Integer produceNumber() {
    return ThreadLocalRandom.current().nextInt(1, 10);
  }

}
