package pl.krupix.nai.tester;

import org.apache.log4j.Logger;
import pl.krupix.nai.neuralnetwork.NeuralNetwork;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by krupix on 29.12.2015.
 */
public class Tester {

    static Logger log = Logger.getLogger(Tester.class);


    private String testFilePath = "/Users/krupix/KruPiX/dev/git/pjatk-nai-neuralnetwork/test/test_data.txt";
    private String trainFilePath = "/Users/krupix/KruPiX/dev/git/pjatk-nai-neuralnetwork/test/train_data.txt";
    private String wrongTestFilePath = "/Users/krupix/KruPiX/dev/git/pjatk-nai-neuralnetwork/test/wrong_data.txt";

    private Scanner samplesReader;
    private NeuralNetwork neuralNetwork;
    private ArrayList<Integer> resultCollector, resultCollectorForIncorrectData;

    public Tester(NeuralNetwork neuralNetwork) throws FileNotFoundException {
        this.neuralNetwork = neuralNetwork;
        resultCollector = new ArrayList<Integer>();
        resultCollectorForIncorrectData = new ArrayList<Integer>();
        initSamples();
    }

    public void initSamples() {
        File file = new File(trainFilePath);
        try {
            samplesReader = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void trainWithSingleSample() {
        String line = samplesReader.nextLine();
        int desiredOutput = 1;
        neuralNetwork.train(generateInputsListFromLine(line), desiredOutput);
    }

    public void testNetwork() throws IOException {
        testNetworkFor(testFilePath, resultCollector);
        testNetworkFor(wrongTestFilePath, resultCollectorForIncorrectData);
    }

    private void testNetworkFor(String filePath, ArrayList<Integer> resultCollector) {

        try {

            File file = new File(filePath);
            Scanner input = new Scanner(file);

            int result = 0;

            while (input.hasNextLine()) {
                String line = input.nextLine();
                generateInputsListFromLine(line);
                neuralNetwork.use(generateInputsListFromLine(line));

                if (neuralNetwork.getOutput() == 1) {
                    result++;
                }
            }

            log.info("Test results: " + result + "%");
            resultCollector.add(result);
            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }



    public boolean hasMoreTrainingSamples() {
        return samplesReader.hasNextLine();
    }

    private ArrayList<float[]> generateInputsListFromLine(String line) {

        ArrayList<float[]> inputsList = new ArrayList<float[]>();
        Scanner in = new Scanner(line);

        for (int i = 0; i < NeuralNetwork.SECOND_LAYER_PERCEPTON_INPUTS_NUMBER; i++) {

            float[] tmp = new float[NeuralNetwork.INPUTS_NUMBER];

            for (int j = 0; j < NeuralNetwork.INPUTS_NUMBER; j++) {
                tmp[j] = (float) in.nextInt();
            }

//            log.debug("Got: " + Utils.tabToString(tmp));
            inputsList.add(tmp);
        }

        return inputsList;
    }

    public ArrayList<Integer> getResultCollector() {
        return resultCollector;
    }

    public ArrayList<Integer> getResultCollectorForIncorrectData() {
        return resultCollectorForIncorrectData;
    }
}
