package kumo.myapplication;

import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class TecladoFragment extends Fragment {

    private RecyclerView recView;

    private ArrayList<xElementoList> datos;

    public TecladoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View _view =  inflater.inflate(R.layout.fragment_teclado, container, false);

        Keyboard mKeyboard= new Keyboard(this.getContext(),R.layout.num_keyboard);

        // Lookup the KeyboardView
        KeyboardView mKeyboardView= (KeyboardView)_view.findViewById(R.id.keyboardview);
        // Attach the keyboard to the view
        mKeyboardView.setKeyboard(mKeyboard);
        // Do not show the preview balloons
        mKeyboardView.setPreviewEnabled(false);

        mKeyboardView.setOnKeyboardActionListener(mOnKeyboardActionListener);


        return _view;
    }

    private KeyboardView.OnKeyboardActionListener mOnKeyboardActionListener = new KeyboardView.OnKeyboardActionListener() {
        @Override public void onKey(int primaryCode, int[] keyCodes) {
            Log.d("Key:", Integer.toString(primaryCode));
        }

        @Override public void onPress(int arg0) {

        }

        @Override public void onRelease(int primaryCode) {
        }

        @Override public void onText(CharSequence text) {
        }

        @Override public void swipeDown() {
        }

        @Override public void swipeLeft() {
        }

        @Override public void swipeRight() {
        }

        @Override public void swipeUp() {
        }
    };
}