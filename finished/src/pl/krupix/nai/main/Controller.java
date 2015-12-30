package pl.krupix.nai.main;


import org.apache.log4j.Logger;
import pl.krupix.nai.neuralnetwork.NeuralNetwork;
import pl.krupix.nai.tester.Tester;

import java.util.ArrayList;

/**
 * Created by krupix on 28.12.2015.
 */
public class Controller {

    static Logger log = Logger.getLogger(Controller.class);


    private NeuralNetwork neuralNetwork;

    public Controller() {
        neuralNetwork = new NeuralNetwork();
    }


    public void control() {
        try {
            Tester tester = new Tester(neuralNetwork);

            while (tester.hasMoreTrainingSamples()) {
                tester.testNetwork(); // print % of correct samples
                tester.trainWithSingleSample();
            }
            log.info("Testing network finished. Wrong Data Result: \n" + tester.getResultCollectorForIncorrectData());
            log.info("Testing network finished. Results: \n" + tester.getResultCollector());
        } catch (Exception e) {
            log.error(e);
        }


    }

}
