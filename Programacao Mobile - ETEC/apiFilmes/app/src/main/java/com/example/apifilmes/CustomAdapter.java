package com.example.apifilmes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.apifilmes.Movie;
import com.example.apifilmes.R;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private ArrayList<Movie> localDataSet;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewTitle, textViewYear;
        private final ImageView imageViewPoster;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            textViewYear = view.findViewById(R.id.textViewYear);
            textViewTitle = view.findViewById(R.id.textViewTitle);
            imageViewPoster = view.findViewById(R.id.imageViewPoster);
        }

        public TextView getTextViewTitle() {
            return textViewTitle;
        }
        public TextView getTextViewYear() {
            return textViewYear;
        }
        public ImageView getImageViewPoster() {
            return imageViewPoster;
        }
    }

    /**
     * Initialize the dataset of the Adapter
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView
     */
    public CustomAdapter(ArrayList<Movie> dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Precisa alterar R.layout.nome_do_xml_do_listView
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_movie_list, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getTextViewTitle().setText(localDataSet.get(position).title);
        viewHolder.getTextViewYear().setText(localDataSet.get(position).year);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}
