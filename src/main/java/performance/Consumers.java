package performance;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Consumers {

  private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  public void consumeNumber(Integer i) {
    logger.info("consumeNumber:{}", i);
  }

}
