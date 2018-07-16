package com.alvaroquintana.platzigram.utils;

/**
 * {@link AlertDialogFragment} has 3 buttons:<ul>
 * <li>Positive and negative - in case of Yes/No dialog</li>
 * <li>Neutral - in case ok OK/Cancel dialog</li>
 * </ul>
 * This interface is to handle these 3 clicks.
 */
public interface DialogListener {

    /**
     * Positive button (Yes/Accept) was clicked.
     */
    void onDialogPositiveClick();

    /**
     * Negative button (No/Back) was clicked.
     */
    void onDialogNegativeClick();

    /**
     * Neutral button (OK/Cancel) was clicked.
     */
    void onDialogNeutralClick();


    /**
     * Neutral button (RETRY) was clicked.
     */
    void onDialogRetryClick();

    /**
     * Neutral button (PREFERENCES) was clicked.
     */
    void onDialogPreferencesClick();
}
