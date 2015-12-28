package pl.krupix.neutralnetwork;

import org.apache.log4j.Logger;
import org.apache.log4j.helpers.UtilLoggingLevel;
import pl.krupix.utils.Utils;

import java.util.Random;

/**
 * Created by krupix on 28.12.2015.
 */
public class Percepton {

    static Logger log = Logger.getLogger(Percepton.class);


    private float[] weights;


    public Percepton(int inputsNumber) {

        weights = new float[inputsNumber];

        for (int i = 0; i < weights.length; i++) {
            weights[i] = new Random().nextFloat();
        }

        log.debug("weights created: " + Utils.tabToString(weights));
    }


    public int use(float[] inputs) {

        float sum = 0;

        for (int i = 0; i < weights.length; i++) {
            sum += inputs[i] * weights[i];
        }

        return activate(sum);
    }


    public int activate(float sum) {
        if (sum > 0) return 1;
        else return -1;
    }


    public void train(float[] inputs, int desired) {

        int guess = this.use(inputs);

        float error = desired - guess;

        for (int i = 0; i < weights.length; i++) {
            weights[i] += NeutralNetwork.LEARNING_CONSTANT * error * inputs[i];
        }


        log.debug("weights after train: " + Utils.tabToString(weights));

    }


}
