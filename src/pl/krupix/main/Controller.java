package pl.krupix.main;


import org.apache.log4j.Logger;
import pl.krupix.neuralnetwork.NeuralNetwork;
import pl.krupix.perceptons.Percepton;

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

        ArrayList<float[]> inputs = new ArrayList<float[]>();
        inputs.add(new float[]{0, 0, 0, 0, 0, 0, 1, 0, 0});
        inputs.add(new float[]{0, 1, 0, 0, 0, 0, 1, 0, 0});

        neuralNetwork.use(inputs);

        inputs = new ArrayList<float[]>();
        inputs.add(new float[]{0, 0, 0, 0, 0, 0, 1, 0, 0});
        inputs.add(new float[]{0, 1, 0, 0, 0, 0, 1, 0, 0});

        neuralNetwork.train(inputs, 1);

        inputs = new ArrayList<float[]>();
        inputs.add(new float[]{1, 1, 1, 1, 1, 0, 1, 0, 0});
        inputs.add(new float[]{0, 1, 1, 0, 0, 0, 0, 0, 0});


        neuralNetwork.train(inputs, -1);

//
//
        inputs = new ArrayList<float[]>();
        inputs.add(new float[]{0, 0, 0, 0, 0, 0, 1, 0, 0});
        inputs.add(new float[]{0, 1, 0, 0, 0, 0, 1, 0, 0});

        neuralNetwork.use(inputs);

        inputs = new ArrayList<float[]>();
        inputs.add(new float[]{1, 1, 1, 1, 1, 0, 1, 0, 0});
        inputs.add(new float[]{0, 1, 1, 0, 0, 0, 0, 0, 0});


        neuralNetwork.use(inputs);


    }

}
