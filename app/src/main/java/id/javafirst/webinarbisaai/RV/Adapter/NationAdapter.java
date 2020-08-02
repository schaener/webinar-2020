package id.javafirst.webinarbisaai.RV.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.javafirst.webinarbisaai.RV.Model.NationModel;
import id.javafirst.webinarbisaai.R;

public class NationAdapter extends RecyclerView.Adapter<NationAdapter.ViewHolder> {
    List<NationModel> listNationModel;
    Context context;

    public NationAdapter(List<NationModel> listNationModel, Context context) {
        this.listNationModel = listNationModel;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nation_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final NationModel model = listNationModel.get(position);
        holder.nationName.setText(model.getNationName());
        holder.nationImage.setImageResource(model.getNationImage());
    }

    @Override
    public int getItemCount() {
       return listNationModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nationName;
        ImageView nationImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nationName = itemView.findViewById(R.id.txtNation);
            nationImage = itemView.findViewById(R.id.imgNation);
        }
    }
}
