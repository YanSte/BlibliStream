package app.cci.com.bliblistream.Activity;

import android.app.Activity;
import android.os.Bundle;


import app.cci.com.bliblistream.Controler.Control;
import app.cci.com.bliblistream.R;


/**
 * Class de l\u0027activite principale de l\u0027application, Herite de Activity
 */
public class MainActivity extends Activity {

    //Le controleur de l application
    private Control control;


    /**
     * Lancement de l'application
     *
     * @param savedInstanceState Bundle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //initialisation de lattribut controleur
        this.control = new Control(this);


    }

    /**
     * Restauration de l'application
     */
    @Override
    protected void onResume() {
        super.onResume();

        if(this.control.getListener() == null) {
            this.control.loadViewAndSetListener(R.layout.view_login);
        }
        /* TODO TEMP */



        //TODO Ici faire un check up avec le control pour savoir on ce situe l application
       /* this.animFadein = AnimationUtils.loadAnimation(getApplicationContext(),
                );

        // set animation listener
        View btn = (View) findViewById(R.id.layout_login);
        btn.startAnimation(animFadein);*/

    }

    /**
     * Mise en pause de l'application
     */
    @Override
    protected void onPause() {
        super.onPause();
    }

    /**
     * Fermeture l'application
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
    //    ToolKit.log("OK");

        this.control.LoadLastViewAndSetListener();


    }
    /**
     * getSize and
     */
    /******/

}

