package test.openerp.utils;

import android.support.design.widget.Snackbar;
import android.view.View;



public class Toaster {


    public static void displaySnackbar(View view, int message){

        Snackbar snackbar = Snackbar.make(view,message, Snackbar.LENGTH_SHORT);
        snackbar.show();
    }

    public static void displaySnackbarString(View view, String message){

        Snackbar snackbar = Snackbar.make(view,message, Snackbar.LENGTH_SHORT);
        snackbar.show();
    }
}