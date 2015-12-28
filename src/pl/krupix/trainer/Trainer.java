package pl.krupix.trainer;

/**
 * Created by krupix on 28.12.2015.
 */
public class Trainer {

    public float[] inputs;
    public int answer;

    public Trainer(float x, float y, int a) {
        inputs = new float[3];
        inputs[0] = x;
        inputs[1] = y;

        inputs[2] = 1;
        answer = a;
    }
}
