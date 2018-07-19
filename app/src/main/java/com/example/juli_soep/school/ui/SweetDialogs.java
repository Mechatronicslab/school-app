package com.example.juli_soep.school.ui;

import android.app.Activity;

import com.ontbee.legacyforks.cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by github.com/adip28 on 7/17/2018.
 */
public class SweetDialogs {

    public interface onDialogClosed{
        void onClosed(String string);
    }
    public static void commonWarning(Activity context, String title, String content, boolean close) {
        SweetAlertDialog dialog = new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE);
        dialog.setCancelable(true);
        dialog.setTitleText(title);
        dialog.setContentText(content);
        dialog.setConfirmText("OK");
        dialog.setConfirmClickListener(sweetAlertDialog -> {
            sweetAlertDialog.dismissWithAnimation();
            if(close)
                context.finish();
        });
        dialog.show();
    }
    public static void commonError(Activity context, String content, boolean close) {
        SweetAlertDialog dialog = new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE);
        dialog.setCancelable(false);
        dialog.setTitleText("Gagal memuat permintaan");
        dialog.setContentText(content);
        dialog.setConfirmText("OK");
        dialog.setConfirmClickListener(sweetAlertDialog -> {
            sweetAlertDialog.dismissWithAnimation();
            if(close)
                context.finish();
        });
        dialog.show();
    }

    public static void endpointError(Activity context) {
        SweetAlertDialog dialog = new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE);
        dialog.setCancelable(false);
        dialog.setTitleText("Oops!");
        dialog.setContentText("Koneksi internet Anda sedang tidak stabil atau server mengalami gangguan, silahkan coba beberapa saat lagi");
        dialog.setConfirmText("OK");
        dialog.setConfirmClickListener(sweetAlertDialog -> {
            sweetAlertDialog.dismissWithAnimation();
            context.finish();
        });
        try {
            dialog.show();
        }catch (Exception e){
            e.printStackTrace();

        }
    }
    public static void commonError(Activity context, String title, String content, onDialogClosed listener) {
        SweetAlertDialog dialog = new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE);
        dialog.setCancelable(false);
        dialog.setTitleText(title);
        dialog.setContentText(content);
        dialog.setConfirmText("OK");
        dialog.setConfirmClickListener(sweetAlertDialog -> {
            sweetAlertDialog.dismissWithAnimation();
            listener.onClosed("closed");
        });
        dialog.show();
    }
}
