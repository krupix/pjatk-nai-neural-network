package pl.krupix.main;


import org.apache.log4j.Logger;
import org.apache.log4j.lf5.viewer.TrackingAdjustmentListener;
import pl.krupix.neutralnetwork.Percepton;
import pl.krupix.trainer.Trainer;

/**
 * Created by krupix on 28.12.2015.
 */
public class Controller {

    static Logger log = Logger.getLogger(Controller.class);


    public Controller() {
        init();
    }


    private void init() {
    }


    public void control() {

        Trainer trainer = new Trainer(2.0f, 1.0f, 3);

        Percepton percepton = new Percepton(2);
        percepton.train(trainer.inputs, trainer.answer);

    }

}
