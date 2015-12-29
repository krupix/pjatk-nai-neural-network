package pl.krupix.perceptons;

/**
 * Created by krupix on 29.12.2015.
 */
public class FinalPercepton extends Percepton {



    public FinalPercepton(int inputsNumber) {
        super(inputsNumber);
    }


    public float activate(float sum) {
        if (sum > 0) return 1;
        else return -1;
    }


}
