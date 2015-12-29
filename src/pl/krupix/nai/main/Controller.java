package pl.krupix.nai.main;


import org.apache.log4j.Logger;
import pl.krupix.nai.neuralnetwork.NeuralNetwork;

import java.util.ArrayList;

/**
 * Created by krupix on 28.12.2015.
 */
public class Controller {

    static Logger log = Logger.getLogger(Controller.class);


    private NeuralNetwork neuralNetwork;

    public Controller() {

        neuralNetwork = new NeuralNetwork();
        init();
    }


    private void init() {

    }


    public void control() {




    }

}
