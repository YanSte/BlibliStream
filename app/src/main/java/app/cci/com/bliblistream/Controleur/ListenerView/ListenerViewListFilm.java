package app.cci.com.bliblistream.Controleur.ListenerView;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import app.cci.com.bliblistream.Model.AbstractClass.AbstractButton;
import app.cci.com.bliblistream.Model.AbstractClass.AbstractMyHttpClient;
import app.cci.com.bliblistream.Model.AbstractClass.AbstractTableViewListFilm;
import app.cci.com.bliblistream.Model.Class.CollectionFilm;
import app.cci.com.bliblistream.Model.Class.DownloadImageTask;
import app.cci.com.bliblistream.Model.Class.Film;
import app.cci.com.bliblistream.Model.Class.ImagesCache;
import app.cci.com.bliblistream.Model.Class.MyHttpClientListFilm;
import app.cci.com.bliblistream.Model.Class.User;
import app.cci.com.bliblistream.Model.Service.MyHttpClientConnection;
import app.cci.com.bliblistream.R;
import app.cci.com.bliblistream.Controleur.Control;
import app.cci.com.bliblistream.Outil.ToolKit;

/**
 * Ecouteur de la View Acceuil
 *
 * @author DaRk-_-D0G on 30/09/2014.
 */
public class ListenerViewListFilm {
    private Control control;
    int valeurClic = -2;

    private ListView listView;

    private MyHttpClientListFilm myHttpClientListFilm;

    /**
     * Constructeur
     *
     * @param inControl Control
     */
    public ListenerViewListFilm(Control inControl) {
        ToolKit.log("Class init  --> ListenerViewListFilm");


        this.control = inControl;



        /* creation dun ecouteur de la listView avec les methodes qui peuvent etre sucharger */
        listView = ((ListView) this.control.getActivity().findViewById(R.id.list_film));
        loadFilmListView();

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> arg0, View view,
                                            int position, long id) {
                        // TODO Auto-generated method stub
                       //s Object o = listView.getItemAtPosition(position);
                        control.setFilmChose(position);

                      //  String pen = o.toString();
                        Toast.makeText(control.getActivity().getBaseContext(), "You have chosen the pen: " + position+" " + control.getCollectionFilm().get(position).titre, Toast.LENGTH_LONG).show();


                        control.loadViewAndSetListener(R.layout.view_film);
                    }
                }
        );
    }


    public void loadFilmListView() {

        control.getActivity().runOnUiThread(new Runnable() {
            public void run() {

                AbstractTableViewListFilm abstractTableViewListFilm = new AbstractTableViewListFilm(control,
                        R.layout.view_rowtableview, 5) {

                };




                listView.setAdapter(abstractTableViewListFilm);


            }


            // ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
            // imageView.setImageResource(R.drawable.ic_launcher);
                        /* Animation fonction login bon ou pas */
            //checkUiLoad(validationLogin);

        });
    }
}

