package samples.tech.com.recylerviewanimation;

import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by android on 22/5/18.
 */

public class MyRecAdapter extends RecyclerView.Adapter<MyRecAdapter.MyViewHolder> {

    private List<String> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            year = (TextView) view.findViewById(R.id.year);
        }
    }

    public MyRecAdapter(List<String> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText("working");
        holder.year.setText("1994");
    }

    @Override
    public int getItemCount() {
        return 20;
    }
}