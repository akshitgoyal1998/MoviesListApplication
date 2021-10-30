package com.phonepe.moviesapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.phonepe.moviesapplication.R;
import com.phonepe.moviesapplication.databinding.LayoutMoviesRowBinding;
import com.phonepe.moviesapplication.model.MovieModel;
import com.phonepe.moviesapplication.utils.Constants;

import java.util.List;

public class MoviesListAdapter extends RecyclerView.Adapter<MoviesListAdapter.MoviesViewHolder> {


    interface onItemClickListener{
        public void onItemClick(MovieModel movieModel);
    }

    private Context context;
    protected LayoutInflater inflater;
    private List<MovieModel> items;

    public MoviesListAdapter(Context context, List<MovieModel> items) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.items = items;
    }


    @NonNull
    @Override
    public MoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutMoviesRowBinding binding = DataBindingUtil.inflate(inflater, R.layout.layout_movies_row, parent, false);
        return new MoviesViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesViewHolder holder, int position) {

        holder.bind(items.get(position));

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class MoviesViewHolder extends RecyclerView.ViewHolder {
        private LayoutMoviesRowBinding binding;

        public MoviesViewHolder(LayoutMoviesRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(MovieModel item) {
            Glide.with(context).load(Constants.IMAGE_BASE_URL + item.getPoster_path()).into(binding.ivPoster);
            binding.tvDescription.setText(item.getOverview());
            binding.tvTitle.setText(item.getTitle());
        }


    }


}
