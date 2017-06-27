package performance;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main implements Runnable {

  private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  private Engine engine = new Engine();

  public static void main(String[] args) {
    Main me = new Main();
    me.run();
  }

  @Override
  public void run() {
    logger.info("perf.ms.config:{}", System.getProperty("perf.ms.config"));
    engine.runEngine();
  }

}
