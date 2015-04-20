package app.cci.com.bliblistream.View.TableView;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import app.cci.com.bliblistream.Controler.Control;
import app.cci.com.bliblistream.Model.DownloadData.DownloadImageTask;
import app.cci.com.bliblistream.Model.DownloadData.ImagesCache;
import app.cci.com.bliblistream.Outil.ToolKit;
import app.cci.com.bliblistream.R;


/**
 *
 * Listener Abstrait de la TableView
 * @author DaRk-_-D0G on 06/10/2014.
 */
public class AbstractTableViewListFilmNouveaute extends BaseAdapter {
    private Control control;

    /* ce tableau trace le clic */
   // private HashMap<Integer, Integer> mIdMap = new HashMap<Integer, Integer>();
    ImagesCache cache;
    private LayoutInflater mLayoutInflater = null;
    public int filtreCat;
    Integer mLastPosition;
    Integer limit;
    Context mContext;
    int inTextViewResourceId;
    /**
     * Constructeur du Listener des lignes de la TableView
     * @param inContext Context
     * @param inTextViewResourceId int
     * @param inObjects String[]
     */
    public AbstractTableViewListFilmNouveaute(Control control, int inTextViewResourceId, Integer limit) {
        this.mContext = control.getActivity().getApplicationContext();
        mLayoutInflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        mLastPosition = 0;
        this.limit = limit;
        this.control = control;
        cache = ImagesCache.getInstance();
        cache.initializeCache();

        this.inTextViewResourceId = inTextViewResourceId;

        //Since you are using it from `Adapter` call first Constructor.

        /* Pour chaque ligne on ajoute un tableau de pointeur */
       /* for (int i = 0; i < inObjects.size() -1; ++i) {
            mIdMap.put(i, i);
        }*/
    }



    /**
     * Methode qui serre a charger chaque ligne d'une viewRow et la personnaliser
     * @param position int
     * @param convertView View
     * @param parent ViewGroup
     * @return View
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(position == 1) {
            //ToolKit.log("--POSE-->"+position);
            this.mLastPosition += 1;
        }
        View v = convertView;
        CompleteListViewHolder viewHolder;
     //   if (convertView == null) {


            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.view_rowtableview, null);
            viewHolder = new CompleteListViewHolder(v,this);
            v.setTag(viewHolder);

        ToolKit.log("--->"+control.getCollectionFilm().get(position).categorie.id);
        ToolKit.log("--->"+filtreCat);
        if(control.getCollectionFilm().get(position).nouveaute == true) { //arrayitems is the underlying array
            v.setVisibility(View.VISIBLE);
          //  v.lLayout.setVisibility(View.VISIBLE);
        }
        else {
            return inflater.inflate(R.layout.blank_layout, parent,
                    false);
          //  v.setVisibility(View.GONE);
           // holder.lLayout.setVisibility(View.GONE);
        }


            String img = control.getCollectionFilm().get(position).lienImage;

            Bitmap bm = cache.getImageFromWarehouse(img);

            if (bm != null) {



               // if(this.mLastPosition >= 5) {
                    //ToolKit.log("--POSE-->"+position);
                    //  ToolKit.animationThis(R.anim.animation_translateenentredroit, progressBar, activity.getBaseContext());
                  //  ToolKit.animationThis(R.anim.animation_translateenentredroit, viewHolder.imageView, control.getActivity().getBaseContext());
                    viewHolder.imageView.setImageBitmap(bm);
                //}





            } else {

                viewHolder.imageView.setImageBitmap(null);
                viewHolder.imgTask.execute(img);
                viewHolder.imageView.setImageBitmap(null);


            }




            String nom = this.control.getCollectionFilm().get(position).titre;
            String description = this.control.getCollectionFilm().get(position).description;

            viewHolder.titreFilmView.setText(nom);
            viewHolder.descriptionView.setText(description);
       // } else {
         //   viewHolder = (CompleteListViewHolder) v.getTag();
        //}






        return v;
    }

    /**
     * Obtenir un Item
     * @param position int
     * @return long
     */
    @Override
    public Object getItem(int position) {
       // ToolKit.log("--->position--->"+position);
        return control.getCollectionFilm().get(position);
    }
    @Override
    public int getCount() {

        return control.getCollectionFilm().size();
    }
    @Override
    public void notifyDataSetChanged() {




            //ivImageView.setImageBitmap(bitmap);

        super.notifyDataSetChanged();
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    /**
     * ?
     * @return boolean
     */
    @Override
    public boolean hasStableIds() {
        return true;
    }

    class CompleteListViewHolder {
        public TextView titreFilmView;
        public TextView descriptionView;
        public ImageView imageView;
        public DownloadImageTask imgTask;
        //imageView.setScaleType(imageView.ScaleType.CENTER_INSIDE);
        public ProgressBar progressBar;
        public CompleteListViewHolder(View base, BaseAdapter baseAdapter) {
            imgTask = new DownloadImageTask(baseAdapter, 500, 200);
            imageView = (ImageView) base.findViewById(R.id.icon);
            progressBar = (ProgressBar) base.findViewById(R.id.progressBar);
             titreFilmView = (TextView) base.findViewById(R.id.titreFilm);
             descriptionView = (TextView) base.findViewById(R.id.descriptionFilm);
        }
    }
}