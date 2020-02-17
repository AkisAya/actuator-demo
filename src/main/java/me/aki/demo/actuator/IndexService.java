package me.aki.demo.actuator;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author akis on 2020/2/14
 */
@Service
public class IndexService {

    @Autowired
    private MeterRegistry registry;

    public String recommend() throws InterruptedException {
        Timer.Sample sample;

        sample = Timer.start(registry);
        recall();
        sample.stop(registry.timer("recommend.timer.recall"));

        sample = Timer.start(registry);
        profile();
        sample.stop(registry.timer("recommend.timer.profile"));

        sample = Timer.start(registry);
        predict();
        sample.stop(registry.timer("recommend.timer.predict"));

        return "OK";
    }

    public void recall() throws InterruptedException {
        Thread.sleep(20 + new Random().nextInt(10));
    }

    private void profile() throws InterruptedException {
        Thread.sleep(10 + new Random().nextInt(10));
    }

    public void predict() throws InterruptedException {
        Thread.sleep(30 + new Random().nextInt(5));
    }
}
