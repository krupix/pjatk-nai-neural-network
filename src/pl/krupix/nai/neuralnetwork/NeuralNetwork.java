package pl.krupix.nai.neuralnetwork;

import org.apache.log4j.Logger;
import pl.krupix.nai.perceptons.FinalPercepton;
import pl.krupix.nai.perceptons.Percepton;

import java.util.ArrayList;

/**
 * Created by krupix on 28.12.2015.
 */
public class NeuralNetwork {

    static Logger log = Logger.getLogger(NeuralNetwork.class);

    public static float LEARNING_CONSTANT = 0.01f;
    public static int INPUTS_NUMBER = 9;
    public static int SECOND_LAYER_PERCEPTON_INPUTS_NUMBER = 5;

    private ArrayList<Percepton> perceptonsList;
    private FinalPercepton lastPercepton;

    private float output;


    public NeuralNetwork() {
        perceptonsList = new ArrayList<Percepton>();
        init();
    }

    public void init() {
        perceptonsList.add(new Percepton(INPUTS_NUMBER));
        perceptonsList.add(new Percepton(INPUTS_NUMBER));
        perceptonsList.add(new Percepton(INPUTS_NUMBER));
        perceptonsList.add(new Percepton(INPUTS_NUMBER));
        perceptonsList.add(new Percepton(INPUTS_NUMBER));
        lastPercepton = new FinalPercepton(SECOND_LAYER_PERCEPTON_INPUTS_NUMBER);
    }

    public void use(ArrayList<float[]> inputsList) {

        for (int i = 0; i < SECOND_LAYER_PERCEPTON_INPUTS_NUMBER; i++) {
            perceptonsList.get(i).use(inputsList.get(i));
        }

        output = lastPercepton.use(getPerceptonsOutputs());

        log.info("OUT => " + output);
    }

    public void train(ArrayList<float[]> inputsList, int desiredOutput) {

        log.debug(" *** TRAIN STARTED ***");
        use(inputsList);
        log.info("neuralNetork before train OUT => " + output + ", wants " + desiredOutput);
        lastPercepton.train(desiredOutput);

        for (int i = 0; i < perceptonsList.size(); i++) {
            perceptonsList.get(i).train(lastPercepton.getWeight(i));
        }

        use(inputsList);
        log.info("neuralNetork after train OUT => " + output);
        log.debug(" *** TRAIN FINISHED ***");

    }

    private float[] getPerceptonsOutputs() {

        float[] tmpOutputTab = new float[SECOND_LAYER_PERCEPTON_INPUTS_NUMBER];

        for (int i = 0; i < perceptonsList.size(); i++) {
            tmpOutputTab[i] = perceptonsList.get(i).getOutput();
        }

        return tmpOutputTab;
    }

    public float getOutput() {
        return output;
    }
}
