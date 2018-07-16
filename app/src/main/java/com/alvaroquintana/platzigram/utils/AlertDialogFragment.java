package com.alvaroquintana.platzigram.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.alvaroquintana.platzigram.R;

public class AlertDialogFragment extends DialogFragment {

    public static final String EXTRA_TITLE = "title";
    public static final String EXTRA_MESSAGE = "message";
    public static final String EXTRA_TYPE = "type";

    public static AlertDialogFragment newYesNoInstance(String title, String message) {
        return newInstance(title, message, DialogType.YES_NO_DIALOG);
    }

    public static AlertDialogFragment newOkInstance(String title, String message) {
        return newInstance(title, message, DialogType.OK_DIALOG);
    }
    public static AlertDialogFragment newRetryInstance(String title, String message) {
        return newInstance(title, message, DialogType.RETRY);
    }
    public static AlertDialogFragment newNotificationInstance(String title, String message) {
        return newInstance(title, message, DialogType.NOTIFICATION);
    }

    static AlertDialogFragment newInstance(String title, String message, DialogType type) {
        AlertDialogFragment frag = new AlertDialogFragment();
        Bundle args = new Bundle();
        args.putString(EXTRA_TITLE, title);
        args.putString(EXTRA_MESSAGE, message);
        args.putInt(EXTRA_TYPE, type.ordinal());
        frag.setCancelable(false);
        frag.setArguments(args);
        return frag;
    }

    @Override
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String title = getArguments().getString(EXTRA_TITLE);
        String message = getArguments().getString(EXTRA_MESSAGE);
        int type = getArguments().getInt(EXTRA_TYPE);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(),
                android.R.style.Theme_Material_Light_Dialog)
                .setTitle(title)
                .setMessage(message);
        switch (DialogType.values()[type]) {
            case YES_NO_DIALOG:
                builder.setPositiveButton(R.string.dialog_accept,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                ((DialogListener) getActivity()).onDialogPositiveClick();
                            }
                        }
                )
                        .setNegativeButton(R.string.dialog_back,
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton) {
                                        ((DialogListener) getActivity()).onDialogNegativeClick();
                                    }
                                }
                        );
                break;
            case OK_DIALOG:
                builder.setNeutralButton(R.string.dialog_ok,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                ((DialogListener) getActivity()).onDialogNeutralClick();
                            }
                        }
                );
                break;
            case RETRY:
                builder.setNeutralButton(R.string.dialog_ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ((DialogListener) getActivity()).onDialogRetryClick();
                    }
                });
                break;
            case NOTIFICATION:
                builder.setNeutralButton(R.string.go_settings, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ((DialogListener) getActivity()).onDialogPreferencesClick();
                    }
                });
                break;
        }

        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(
                    getResources().getDrawable(R.drawable.bg_solid_white, null));
        }
        //dialog.getWindow().getDecorView().setBackgroundResource(android.R.color.transparent);
        return dialog;
    }

    enum DialogType {
        YES_NO_DIALOG,
        OK_DIALOG,
        RETRY,
        NOTIFICATION
        }
}
