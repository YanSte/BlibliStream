package app.cci.com.bliblistream.Controleur.ListenerView;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import app.cci.com.bliblistream.Controleur.Control;
import app.cci.com.bliblistream.Model.AbstractClass.AbstractTableViewListCategorie;
import app.cci.com.bliblistream.Model.AbstractClass.AbstractTableViewListFilm;
import app.cci.com.bliblistream.Model.Class.MyHttpClientListFilm;
import app.cci.com.bliblistream.Outil.ToolKit;
import app.cci.com.bliblistream.R;

/**
 * Ecouteur de la View Acceuil
 *
 * @author DaRk-_-D0G on 30/09/2014.
 */
public class ListenerViewListCategorie {
    private Control control;
    int valeurClic = -2;

    private ListView listView;

    private MyHttpClientListFilm myHttpClientListFilm;

    /**
     * Constructeur
     *
     * @param inControl Control
     */
    public ListenerViewListCategorie(Control inControl) {
        ToolKit.log("Class init  --> ListenerViewListFilm");




        this.control = inControl;
        ToolKit.log("Class init  --> BACkkkkkkk-------------------------------------------");




        /* creation dun ecouteur de la listView avec les methodes qui peuvent etre sucharger */
        listView = ((ListView) this.control.getActivity().findViewById(R.id.list_film));
        loadFilmListView();


    }


    public void loadFilmListView() {

        control.getActivity().runOnUiThread(new Runnable() {
            public void run() {

                AbstractTableViewListCategorie abstractTableViewListCategorie = new AbstractTableViewListCategorie(control,
                        R.layout.view_rowtableview, 5) {

                };

                listView.setAdapter(abstractTableViewListCategorie);
                listView.setOnItemClickListener(abstractTableViewListCategorie);
            }


            // ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
            // imageView.setImageResource(R.drawable.ic_launcher);
                        /* Animation fonction login bon ou pas */
            //checkUiLoad(validationLogin);

        });
    }
}

