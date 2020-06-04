package com.example.deliveryapplication.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.deliveryapplication.R;
import com.example.deliveryapplication.listener.OnNavigateToMapListener;
import com.example.deliveryapplication.model.Delivery;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StopAdapter extends RecyclerView.Adapter<StopAdapter.SortHolder> {

    private Context context;
    private List<Delivery> deliveries;
    private OnNavigateToMapListener listener;

    public StopAdapter(Context context, List<Delivery> deliveries, OnNavigateToMapListener listener) {
        this.context = context;
        this.deliveries = deliveries;
        this.listener = listener;
    }

    @NonNull
    @Override
    public SortHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new SortHolder(LayoutInflater.from(context).inflate(R.layout.base_layout, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SortHolder holder, int position) {
        Delivery delivery = deliveries.get(position);
        holder.initData(delivery, position + 1, context);

        holder.layFinish.setOnClickListener(v -> {
            delivery.setFinished(true);
            notifyItemChanged(position);
        });

        holder.layNavigate.setOnClickListener(v -> listener.setOnNavigateToMap(delivery));
    }

    @Override
    public int getItemCount() {
        return deliveries == null ? 0 : deliveries.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    static class SortHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.view_finish)
        LinearLayout viewFinish;
        @BindView(R.id.view_close)
        CardView viewClose;
        @BindView(R.id.view_open)
        LinearLayout viewOpen;

        @BindView(R.id.header_container)
        LinearLayout headerContainer;

        @BindView(R.id.tv_finish_order_number)
        TextView tvFinishOrderNumber;
        @BindView(R.id.tv_finis_address)
        TextView tvFinisAddress;

        @BindView(R.id.tv_close_item_number)
        TextView tvCloseItemNumber;
        @BindView(R.id.tv_close_order_number)
        TextView tvCloseOrderNumber;

        @BindView(R.id.tv_close_address)
        TextView tvCloseOrderAddress;
        @BindView(R.id.tv_close_estimate_time)
        TextView tvCloseEstimateTime;
        @BindView(R.id.tv_close_delivery_times)
        TextView tvCloserDeliveryTimes;

        @BindView(R.id.ic_close_issue)
        ImageView icCloseIssue;

        @BindView(R.id.tv_child_item_number)
        TextView tvOpenItemNumber;
        @BindView(R.id.tv_child_order_number)
        TextView tvOpenOrderNumber;
        @BindView(R.id.tv_child_address)
        TextView tvOpenOrderAddress;
        @BindView(R.id.tv_child_estimate_time)
        TextView tvOpenEstimateTime;
        @BindView(R.id.tv_child_delivery_times)
        TextView tvOpenDeliveryTimes;


        @BindView(R.id.ic_child_issue)
        ImageView icOpenIssue;
        @BindView(R.id.lay_navigate)
        LinearLayout layNavigate;
        @BindView(R.id.lay_finish)
        LinearLayout layFinish;

        @SuppressLint("SimpleDateFormat")
        private SimpleDateFormat SDF = new SimpleDateFormat("MM:hh");

        public SortHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void initData(Delivery delivery, int itemNumber, Context context) {
            if (delivery.isFinished()) {
                viewFinish.setVisibility(View.VISIBLE);
                tvFinishOrderNumber.setText(String.valueOf(delivery.getOrderNumber()));
                tvFinisAddress.setText(delivery.getAddress().getAddress());
            } else {
                if (viewOpen.getVisibility() != View.VISIBLE) {
                    viewClose.setVisibility(View.VISIBLE);
                }
                tvCloseItemNumber.setText(String.valueOf(itemNumber));
                tvCloseOrderNumber.setText(String.valueOf(delivery.getOrderNumber()));
                tvCloseOrderAddress.setText(delivery.getAddress().getAddress());
                tvCloseEstimateTime.setText(delivery.getEstimateTime());
                tvCloserDeliveryTimes.setText(delivery.getDeliveryTimes());
            }

            if (checkDeliveryTime(delivery.getDeliveryTimes(), delivery.getEstimateTime())) {
                icCloseIssue.setVisibility(View.INVISIBLE);
                icOpenIssue.setVisibility(View.INVISIBLE);
                tvCloseEstimateTime.setTextColor(context.getColor(R.color.color_green));
                tvOpenEstimateTime.setTextColor(context.getColor(R.color.color_green));
            } else {
                icCloseIssue.setVisibility(View.VISIBLE);
                icOpenIssue.setVisibility(View.VISIBLE);
                tvCloseEstimateTime.setTextColor(context.getColor(R.color.color_red));
                tvOpenEstimateTime.setTextColor(context.getColor(R.color.color_red));
            }
            tvOpenItemNumber.setText(String.valueOf(itemNumber));
            tvOpenOrderNumber.setText(String.valueOf(delivery.getOrderNumber()));
            tvOpenOrderAddress.setText(delivery.getAddress().getAddress());
            tvOpenEstimateTime.setText(delivery.getEstimateTime());
            tvOpenDeliveryTimes.setText(delivery.getDeliveryTimes());

            viewClose.setOnClickListener(v -> {
                viewClose.setVisibility(View.GONE);
                viewOpen.setVisibility(View.VISIBLE);
            });

            viewOpen.setOnClickListener(v -> {
                if (delivery.isFinished()) {
                    viewOpen.setVisibility(View.GONE);
                    viewFinish.setVisibility(View.VISIBLE);
                } else {
                    viewOpen.setVisibility(View.GONE);
                    viewClose.setVisibility(View.VISIBLE);
                }
            });
        }

        private boolean checkDeliveryTime(String deliveryTimes, String estimateTime) {
            try {
                String[] times = deliveryTimes.split("-");
                Date firstDeliveryTime = SDF.parse(times[0]);
                Date secondDeliveryTime = SDF.parse(times[1]);
                Date time = SDF.parse(estimateTime);
                return time != null && time.after(firstDeliveryTime) && time.before(secondDeliveryTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return false;
        }
    }
}