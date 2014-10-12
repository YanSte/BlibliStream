package app.cci.com.bliblistream.Outil;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.media.Image;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import app.cci.com.bliblistream.R;

/**
 *
 * Class des tools
 * @author DaRk-_-D0G on 06/10/2014.
 */
public class ToolKit {

    public static void log(String inParam) {
        Log.i("test1", "##################################");
        Log.i("test1", inParam);
        Log.i("test1", "##################################");
    }
    public static void logWTF(String inParam) {
        Log.wtf("test1", "##################################");
        Log.wtf("test1", inParam);
        Log.wtf("test1", "##################################");
    }
    public static void showMessage(int inImage, String inMessage, final Activity inActivity, int x, int y) {

        LayoutInflater inflater = inActivity.getLayoutInflater();
        View layout = inflater.inflate(R.layout.view_toast, (ViewGroup) inActivity.findViewById(R.id.custom_toast_layout_id));

        try {
            ImageView image = (ImageView) layout.findViewById(R.id.toast_image);
            if(inImage != -1) {

                image.setImageResource(inImage);
            }
            // set a message
            TextView text = (TextView) layout.findViewById(R.id.toast_text);
            text.setText(inMessage);
        } catch (NullPointerException e) {
            logWTF("<!> TOAST erreur image ou Text vide");
        }



        // Toast...
        Toast toast = new Toast(inActivity.getBaseContext());
        if(x == -1 || y == -1){
            x=0;
            y=0;
        }

        toast.setGravity(Gravity.TOP, x, y);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }

    /**
     * Obtenir la taille de lecran
     * @param inActivity Activity
     * @return Point
     */
    public static Point getSize(Activity inActivity) {
        Display display = inActivity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size;
    }

    /**
     * Tableau de la taille ecran
     * @return Interger[]
     */
    public static int[][] sizeScreen(Activity inActivity) {
        Point point = ToolKit.getSize(inActivity);

        int[][] relations= new int[5][2];

        relations[0][0] = point.x;
        relations[0][1] = point.y;


        relations[1][0] = point.x/8;
        relations[1][1] = point.y/8;

        relations[2][0] = point.x/4;
        relations[2][1] = point.y/4;

        relations[3][0] = (point.x)*3/8;
        relations[3][1] = (point.y)*3/8;

        relations[4][0] = point.x/2;
        relations[4][1] = point.y/2;



        return relations;
    }

}