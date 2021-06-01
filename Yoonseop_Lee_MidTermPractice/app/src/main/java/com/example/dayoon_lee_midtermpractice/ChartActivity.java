package com.example.dayoon_lee_midtermpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.PathShape;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;


public class ChartActivity extends AppCompatActivity {

    private ImageView imageView;
    private Paint paint;
    private Bitmap bitmap;
    private Canvas canvas;
    //
    int barStartY = 0;
    int barY = 0;
    int barHeight = 100;
    //
    int[] checkedStates = new int[4];
    //
    RadioButton Lose;
    RadioButton Remember;
    RadioButton LearnThings;
    RadioButton KeepTrack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        //
        this.getSupportActionBar().setTitle("Brain Challenge");

        checkedStates=getIntent().getExtras().getIntArray("checkedStates");

        Lose = (RadioButton)findViewById(R.id.Lose);
        Remember = (RadioButton)findViewById(R.id.Remember);
        LearnThings = (RadioButton)findViewById(R.id.LearnThings);
        KeepTrack = (RadioButton)findViewById(R.id.KeepTrack);


        // set up the paint
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(20);
        //create the big image view to show memory map
        imageView = (ImageView)findViewById(R.id.imageView);
        int width = (int) getResources().getDimension(R.dimen.img_width);
        int height = (int) getResources().getDimension(R.dimen.img_height);
        //
        //prepare drawing environment
        //create a bitmap as content view for the canvas
        bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        //set canvas background
        canvas.drawColor(Color.BLACK);
        //set a bitmap as content view for the image
        imageView.setImageBitmap(bitmap);
        //render the view to the canvas
        imageView.draw(canvas);
        //

        String X[] = getResources().getStringArray(R.array.XCordinates);
        String Y[] = getResources().getStringArray(R.array.YCordinates);


        //compute the width of vitamin A consumption and draw with blue
        double barWidthOfVitaminA = checkedStates[0] * width;
        canvas.drawRect(0, barY, (int) barWidthOfVitaminA, barY + barHeight, paint);
        paint.setTextSize(100);
        paint.setColor(Color.CYAN);
        canvas.drawLine(Float.parseFloat(X[0]), Float.parseFloat(Y[3]),Float.parseFloat(X[1]),Float.parseFloat(Y[0]),paint);
        canvas.drawLine(Float.parseFloat(X[1]), Float.parseFloat(Y[0]),Float.parseFloat(X[2]),Float.parseFloat(Y[3]),paint);
        canvas.drawLine(Float.parseFloat(X[2]), Float.parseFloat(Y[3]),Float.parseFloat(X[3]),Float.parseFloat(Y[0]),paint);
        canvas.drawLine(Float.parseFloat(X[3]), Float.parseFloat(Y[0]),Float.parseFloat(X[4]),Float.parseFloat(Y[3]),paint);
        canvas.drawLine(Float.parseFloat(X[4]), Float.parseFloat(Y[3]),Float.parseFloat(X[5]),Float.parseFloat(Y[0]),paint);
        canvas.drawLine(Float.parseFloat(X[5]), Float.parseFloat(Y[0]),Float.parseFloat(X[6]),Float.parseFloat(Y[3]),paint);
        canvas.drawLine(Float.parseFloat(X[6]), Float.parseFloat(Y[3]),Float.parseFloat(X[7]),Float.parseFloat(Y[0]),paint);

        try {


        }
        catch(Exception e)
        {
            Log.d("exception",e.getMessage());
        }
        imageView.invalidate(); //refreshes the painting

    }
    private void setShapeByDrawable(Drawable drawable) {
        // We will animate the imageview
        ImageView reusableImageView = (ImageView) findViewById(R.id.imageView);
        reusableImageView.setImageDrawable(drawable);
    }
    public void nextClicked(View view) {
        String res = "";
        if (Lose.isChecked())
        {
            res += "Lose things\n";
        }
        if (Remember.isChecked())
        {
            res += "Remember names\n";
        }
        if (LearnThings.isChecked())
        {
            res += "Learn things quickly\n";
        }
        if (KeepTrack.isChecked())
        {
            res += "Keep track of multiple things";
        }
        Toast.makeText(ChartActivity.this, res, Toast.LENGTH_SHORT).show();

    }
}
