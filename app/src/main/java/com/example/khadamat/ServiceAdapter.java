package com.example.khadamat;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.khadamat.service.ServiceActivity;

import java.util.List;

/*RecyclerView.adapter
RecyclerView ViewHolder
 */
public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ServiceHolder> {

    private Context mCtx;
    private List<Service> serviceList;

    private RecyclerView.RecyclerListener listener;


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
        final Service service = serviceList.get(position);
        holder.serviceName.setText(service.getServicename());
        holder.serviceCity.setText(service.getVille());
        holder.serviceRating.setText(service.getRating());
        holder.servicePrice.setText(service.getPrice());
        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(service.getImageId(),null));
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mCtx,ServiceActivity.class);
                intent.putExtra("serviceImg",service.getImageId());
                intent.putExtra("fullname",service.getFull_name());
                intent.putExtra("servicename",service.getServicename());
                intent.putExtra("servicetype",service.getType_service());
                intent.putExtra("serviceprice",service.getPrice());
                intent.putExtra("telephone",service.getTelephone());
                intent.putExtra("servicedescription",service.getDescription());
                intent.putExtra("localisation",service.getLocalisation());
                intent.putExtra("city",service.getVille());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mCtx.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return serviceList.size();
    }


    class ServiceHolder extends RecyclerView.ViewHolder {
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


}}
