package performance;

import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.io.Files;

public class Main implements Runnable {

  private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  private Engine engine = new Engine();

  public static void main(String[] args) {
    Main me = new Main();
    me.run();
    logger.info("done");
    System.exit(0);
  }

  @Override
  public void run() {
    // the required system property seems to be different than in the docs...
    logger.info("spf4j.perf.ms.config:{}", System.getProperty("spf4j.perf.ms.config"));
    logger.info("java.io.tmpdir:{}", System.getProperty("java.io.tmpdir"));
    // for some reason, spf4j will not create a txt database file itself...
    try {
      Files.touch(new File("/tmp/spf4j.metrics.tsdb.txt"));
    } catch (IOException e) {
      logger.error("unable to touch txt file:{}", e.getMessage());
    }
    engine.runEngine();
  }

}
