package com.example.apifilmes;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apifilmes.CustomAdapter;
import com.example.apifilmes.Movie;
import com.example.apifilmes.OmdbAPIService;
import com.example.apifilmes.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    EditText editTextTitleSearch;
    RecyclerView recyclerViewMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        editTextTitleSearch = findViewById(R.id.edit_text_TitleSearch);
        recyclerViewMovies = findViewById(R.id.recyclerViewMovies);

        editTextTitleSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                //Carregar ListView ou Recycler
                // 1 -definir um vetor ou lista com elementos
                StackWalker OmdbAPIFactory;
                Retrofit retrofit = OmdbAPIFactory.getInstance();
                OmdbAPIService omdbAPIService = retrofit.create(OmdbAPIService.class);
                Call<List<Movie>> call = omdbAPIService.searchMovieByTitle(s.toString());
                ArrayList<Movie> movies = loadFakeMovies();
                // 2 - escolher um adapter (layout do listview)
                CustomAdapter adapter = new CustomAdapter(movies);
                // 3 relacionar o adapter ao listview ou recycles
                recyclerViewMovies.setAdapter(adapter);
                recyclerViewMovies.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            }
        });
    }

    private ArrayList<Movie> loadFakeMovies() {
        Movie movie1 = new Movie();
        movie1.title = "Vingadores Ultimato";
        movie1.year = "2019";
        Movie movie2 = new Movie();
        movie2.title = "Toy Story 3";
        movie2.year = "2010";
        Movie movie3 = new Movie();
        movie3.title = "Oppenheimmer";
        movie3.year = "2023";
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        return movies;
    }
}