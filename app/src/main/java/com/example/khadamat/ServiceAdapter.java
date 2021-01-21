package com.example.khadamat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/*RecyclerView.adapter
RecyclerView ViewHolder
 */
public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ServiceHolder>{

    private Context mCtx;
    private List<Service> serviceList;

    public ServiceAdapter(Context mCtx, List<Service> serviceList) {
        this.mCtx = mCtx;
        this.serviceList = serviceList;
    }

    @NonNull
    @Override
    public ServiceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.card_layout,null);
        return new ServiceHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ServiceHolder holder, int position) {
        Service service = serviceList.get(position);
        holder.serviceName.setText(service.getType_service());
        holder.serviceCity.setText(service.getVille());
        holder.serviceRating.setText(service.getRating());
        holder.servicePrice.setText(String.valueOf(service.getPrice()));

    }

    @Override
    public int getItemCount() {
        return serviceList.size();
    }

    class ServiceHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView serviceName,serviceCity,serviceRating,servicePrice;
        public ServiceHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.Image);
            serviceName = itemView.findViewById(R.id.Service);
            serviceCity = itemView.findViewById(R.id.City);
            serviceRating=itemView.findViewById(R.id.Rating);
            servicePrice=itemView.findViewById(R.id.Price);
        }
    }
}
