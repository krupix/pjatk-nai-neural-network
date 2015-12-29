package pl.krupix.perceptons;

import org.apache.log4j.Logger;
import org.apache.log4j.helpers.UtilLoggingLevel;
import pl.krupix.neuralnetwork.NeuralNetwork;
import pl.krupix.utils.Utils;

import java.util.Random;

/**
 * Created by krupix on 28.12.2015.
 */
public class Percepton {

    private static Logger log = Logger.getLogger(Percepton.class);

    public static int PERCEPTONS_COUNT;
    private int PERCEPTON_NUMER;
    private float MIN_WEIGHT = -1,
                  MAX_WEIGHT = 1;

    private String DEBUG_STRING = "Percepton[" + PERCEPTON_NUMER + "] ";

    private float[] weights;
    private float[] inputs;

    private float output;


    public Percepton(int inputsNumber) {

        this.PERCEPTON_NUMER = ++PERCEPTONS_COUNT;

        weights = new float[inputsNumber];

        for (int i = 0; i < weights.length; i++) {
            weights[i] = new Random().nextFloat() * (MAX_WEIGHT - MIN_WEIGHT) + MIN_WEIGHT;
        }

        log.debug(DEBUG_STRING + "generated wages " + Utils.tabToString(weights));

    }

    public float use(float[] inputs) {

        this.inputs = inputs;

        float sum = 0;

        for (int i = 0; i < weights.length; i++) {
            sum += inputs[i] * weights[i];
        }

        output = activate(sum);
        log.info(DEBUG_STRING + "used with inputs: " + Utils.tabToString(inputs) + " OUT => " + output);
        log.info(DEBUG_STRING + "wages " + Utils.tabToString(weights));
        return output;
    }


    public float activate(float sum) {
//        if (sum > 0) return 1;
//        else return -1;
        return sum;
    }


    public void train(int desiredOutput) {

        float error = desiredOutput - output;

        for (int i = 0; i < weights.length; i++) {
            weights[i] += NeuralNetwork.LEARNING_CONSTANT * error * this.inputs[i];
        }

    }

    public void train(float previousWeight) {

        float error = (float) output - previousWeight;

        for (int i = 0; i < weights.length; i++) {
            weights[i] += NeuralNetwork.LEARNING_CONSTANT * error * this.inputs[i];
        }

    }

    public float getOutput() {
        return output;
    }

    public float getWeight(int index) {
        return weights[index];
    }
}
