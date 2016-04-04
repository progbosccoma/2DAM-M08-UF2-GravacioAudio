package net.infobosccoma.gravacioaudio;

import android.content.Context;
import android.view.View;
import android.widget.Button;

/**
 * Classe que estén la classe Button per implementar un botó de reproducció
 *
 * @author Marc Nicolau
 *
 */
class PlayButton extends Button {
    private boolean mPlaying = true;
    private OnClickListener clicker = new OnClickListener() {
        public void onClick(View v) {
            myClick();
        }
    };


    public PlayButton(Context ctx) {
        super(ctx);
        setText(R.string.start_recording);
        setOnClickListener(clicker);
    }

    public boolean isPlaying() {
        return mPlaying;
    }

    public void setmPlaying(boolean mStartPlaying) {
        this.mPlaying = mStartPlaying;
    }

    private void myClick() {
        if (mPlaying) {
            setText("Stop playing");
        } else {
            setText("Start playing");
        }
        mPlaying = !mPlaying;
    }

    public void addOnClickListener(final OnClickListener otherListener) {
        clicker = new OnClickListener() {
            @Override
            public void onClick(View v) {
                myClick();
                otherListener.onClick(v);
            }
        };
        setOnClickListener(clicker);
    }


}