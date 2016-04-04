package net.infobosccoma.gravacioaudio;

import android.content.Context;
import android.view.View;
import android.widget.Button;

/**
 * Classe que estén la classe Button per implementar un bot� de gravaci�
 *
 * @author Marc Nicolau
 *
 */
class RecordButton extends Button {
    private boolean mRecording = true;
    private OnClickListener clicker = new OnClickListener() {
        public void onClick(View v) {
            myClick();
        }
    };


    public RecordButton(Context ctx) {
        super(ctx);
        setText(R.string.start_recording);
        setOnClickListener(clicker);
    }

    public boolean isRecording() {
        return mRecording;
    }

    public void setRecording(boolean mStartRecording) {
        this.mRecording = mStartRecording;
    }

    private void myClick() {
        if (mRecording) {
            setText("Stop recording");
        } else {
            setText("Start recording");
        }
        mRecording = !mRecording;
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