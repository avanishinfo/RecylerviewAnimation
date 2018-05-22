package samples.tech.com.recylerviewanimation;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;


import java.util.ArrayList;
import java.util.List;

import samples.tech.com.recylerviewanimation.utilities.GridRecyclerView;


public class MainActivity extends AppCompatActivity {

    GridRecyclerView recyclerView;
    List<String> movieList;
    MyRecAdapter mAdapter;
    Button btnTranslate;
    String text;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecView();
        movieList = new ArrayList<>();
        movieList.add("abc");
        movieList.add("sghahdf");
        movieList.add("abc");
        movieList.add("abc");
        movieList.add("abc");
        movieList.add("abc");
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            mAdapter = new MyRecAdapter(movieList);
            recyclerView.setAdapter(mAdapter);

        }
        text = "Stay connected at a glance\n" +
                "Stay in the moment with smart ways to text, email and see who’s calling, without pulling out your phone.Meet your health and fitness partner\n" +
                "Workout without your phone. Google Fit and other health apps make it easy to get motivated, stay balanced and track your health right from your wrist.";
        btnTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             /*   try {
                    Translate.translate(text,("en"),("hi"));
                } catch (Exception e) {
                    e.printStackTrace();
                }*/


            }
        });
    }


    @Override
    public void onEnterAnimationComplete() {
        super.onEnterAnimationComplete();
        mAdapter = new MyRecAdapter(movieList);
        recyclerView.setAdapter(mAdapter);
        recyclerView.scheduleLayoutAnimation();
    }

    public void initRecView() {
        recyclerView = findViewById(R.id.gridRecylerView);
        GridLayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        btnTranslate = (Button) findViewById(R.id.btnTranslate);

    }

    private void runLayoutAnimation(final RecyclerView recyclerView) {
        final Context context = recyclerView.getContext();
        final LayoutAnimationController controller =
                AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_fall_down);
        recyclerView.setLayoutAnimation(controller);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }
}

