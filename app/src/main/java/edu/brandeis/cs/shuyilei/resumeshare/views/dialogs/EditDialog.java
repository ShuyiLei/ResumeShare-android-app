package edu.brandeis.cs.shuyilei.resumeshare.views.dialogs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.EditText;
import android.widget.ImageView;

import edu.brandeis.cs.shuyilei.resumeshare.R;

/**
 * Created by shuyilei on 11/17/16.
 */

public class EditDialog extends BaseDialog {
    private ImageView mImageView;
    private EditText mEditText;

    public EditDialog(Context context) {
        super(context);
        setDialogContentView(R.layout.include_dialog_edittext);
        mEditText = (EditText) findViewById(R.id.dialog_edittext);
        mImageView=(ImageView)findViewById(R.id.iv_icon);
    }

    public void setIcon(Drawable drawable){
        mImageView.setBackground(drawable);
    }

    @Override
    public void setTitle(CharSequence text) {
        super.setTitle(text);
    }

    public void setButton(CharSequence text,
                          OnClickListener listener) {
        super.setButton1(text, listener);
    }

    public void setButton(CharSequence text1,
                          OnClickListener listener1, CharSequence text2,
                          OnClickListener listener2) {
        super.setButton1(text1, listener1);
        super.setButton2(text2, listener2);
    }

    public String getEditText() {
        if (isNull(mEditText)) {
            return null;
        }
        return mEditText.getText().toString().trim().replace(" ","%20");
    }

    public void setTextNull() {
        mEditText.setText("");
    }

    public void setEditTextHint(CharSequence text) {
        mEditText.setHint(text);
    }

    private boolean isNull(EditText editText) {
        String text = editText.getText().toString().trim();
        if (text != null && text.length() > 0) {
            return false;
        }
        return true;
    }
    public void requestEditTextFocus() {
        mEditText.requestFocus();
    }
}
