package com.example.exercise03;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private ImageView _imageViewForDrawing;
    private TextView _xPosTextView;
    private TextView _yPosTextView;

    private Canvas _canvas;
    private Paint _paint;
    private Bitmap _bitmap;

    // position of last drawn item
    private int _curXPos;
    private int _curYPos;
    private int _xIncrement;
    private int _yIncrement;
    private int _noIncrement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this._imageViewForDrawing = findViewById(R.id.imageViewForDrawing);

        // configs display env
        this._init();
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_DOWN:
                this._drawLineDown();
                return true;

            case KeyEvent.KEYCODE_DPAD_LEFT:
                this._drawLineLeft();
                return true;

            case KeyEvent.KEYCODE_DPAD_UP:
                this._drawLineUp();
                return true;

            case KeyEvent.KEYCODE_DPAD_RIGHT:
                this._drawLineRight();
                return true;
        }
        return false;
    }

    // helper methods
    private void _drawLineLeft() {
        if (this._curXPos - this._xIncrement < 0) {
            Toast.makeText(this, getResources().getString(R.string.ex1_draw_left_msg), Toast.LENGTH_SHORT).show();
        } else {
            this._drawLine(this._canvas, -this._xIncrement, this._noIncrement);
            this._imageViewForDrawing.invalidate();
        }
    }

    private void _drawLineUp() {
        if (this._curYPos - this._yIncrement < 0) {
            Toast.makeText(this, getResources().getString(R.string.ex1_draw_up_msg), Toast.LENGTH_SHORT).show();
        } else {
            this._drawLine(this._canvas, this._noIncrement, -this._yIncrement);
            this._imageViewForDrawing.invalidate();
        }
    }

    private void _drawLineRight() {
        if (this._curXPos + this._xIncrement > this._bitmap.getWidth()) {
            Toast.makeText(this, getResources().getString(R.string.ex1_draw_right_msg), Toast.LENGTH_SHORT).show();
        } else {
            this._drawLine(this._canvas, this._xIncrement, this._noIncrement);
            // force redraw/update canvas
            this._imageViewForDrawing.invalidate();
        }
    }

    private void _drawLineDown() {
        if (this._curYPos + this._yIncrement > this._bitmap.getHeight()) {
            Toast.makeText(this, getResources().getString(R.string.ex1_draw_down_msg), Toast.LENGTH_SHORT).show();
        } else {
            this._drawLine(this._canvas, this._noIncrement, this._yIncrement);
            this._imageViewForDrawing.invalidate();
        }
    }

    private void _init() {
        // set up Paint config
        this._paint = new Paint();
        this._paint.setColor(Color.RED);
        this._paint.setStrokeWidth(10);

        // creating a bitmap as content view for the image
        this._bitmap = Bitmap.createBitmap(getWindowManager()
                .getDefaultDisplay().getWidth(), getWindowManager()
                .getDefaultDisplay().getHeight(), Bitmap.Config.ARGB_8888);

        this._canvas = new Canvas(this._bitmap);

        this._imageViewForDrawing = findViewById(R.id.imageViewForDrawing);
        this._imageViewForDrawing.setImageBitmap(this._bitmap);
        this._imageViewForDrawing.setVisibility(View.VISIBLE);

        this._xPosTextView = findViewById(R.id.xPosTextView);
        this._yPosTextView = findViewById(R.id.yPosTextView);

        this._xIncrement = getResources().getInteger(R.integer.ex1_x_pos_increment);
        this._yIncrement = getResources().getInteger(R.integer.ex1_y_pos_increment);
        this._noIncrement = getResources().getInteger(R.integer.ex1_no_pos_increment);

        this._clearCanvas();

        // default configs selected
        final RadioButton redLineColorRadioBtn = findViewById(R.id.redLineColorRadioBtn);
        redLineColorRadioBtn.setChecked(true);

        // attach event handlers
        findViewById(R.id.rightArrowKeyBtn).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                MainActivity.this._drawLineRight();
                return true;
            }
        });
        findViewById(R.id.upArrowKeyBtn).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                MainActivity.this._drawLineUp();
                return true;
            }
        });
        findViewById(R.id.leftArrowKeyBtn).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                MainActivity.this._drawLineLeft();
                return true;
            }
        });
        findViewById(R.id.downArrowKeyBtn).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                MainActivity.this._drawLineDown();
                return true;
            }
        });

        findViewById(R.id.clearCanvasBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this._clearCanvas();
            }
        });

        final RadioGroup lineColorRadioGroup = findViewById(R.id.lineColorRadioGroup);
        lineColorRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int idChecked) {
                switch (idChecked) {
                    case R.id.redLineColorRadioBtn:
                        MainActivity.this._paint.setColor(Color.RED);
                        break;
                    case R.id.cyanLineColorRadioBtn:
                        MainActivity.this._paint.setColor(Color.YELLOW);
                        break;
                    case R.id.yellowLineColorRadioBtn:
                        MainActivity.this._paint.setColor(Color.CYAN);
                        break;
                }
            }
        });

        final Spinner lineThicknessSpinner = findViewById(R.id.lineThicknessSpinner);
        lineThicknessSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                MainActivity.this._paint.setStrokeWidth(Integer.parseInt(getResources().getStringArray(R.array.ex1_line_thickness_array)[position]));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    private void _startDrawing() {
        this._canvas.drawPoint(0, 0, this._paint);
    }

    private void _clearCanvas() {
        this._canvas.drawColor(Color.WHITE);
        this._curXPos = this._curYPos = 0;
        this._startDrawing();
        this._xPosTextView.setText("X: " + this._curXPos);
        this._yPosTextView.setText("Y: " + this._curYPos);
    }

    private void _drawLine(Canvas canvas, int xIncrement, int yIncrement) {
        this._xPosTextView.setText("X: " + this._curXPos);
        this._yPosTextView.setText("Y: " + this._curYPos);
        this._canvas.drawLine(_curXPos, _curYPos, _curXPos += xIncrement, _curYPos += yIncrement, this._paint);
    }

}
