package com.moringaschool.covidinformer.Adapter;

import static com.moringaschool.covidinformer.Constant.COUNTRY_ACTIVE;
import static com.moringaschool.covidinformer.Constant.COUNTRY_CONFIRMED;
import static com.moringaschool.covidinformer.Constant.COUNTRY_DECEASED;
import static com.moringaschool.covidinformer.Constant.COUNTRY_FLAGURL;
import static com.moringaschool.covidinformer.Constant.COUNTRY_NAME;
import static com.moringaschool.covidinformer.Constant.COUNTRY_NEW_CONFIRMED;
import static com.moringaschool.covidinformer.Constant.COUNTRY_NEW_DECEASED;
import static com.moringaschool.covidinformer.Constant.COUNTRY_RECOVERED;
import static com.moringaschool.covidinformer.Constant.COUNTRY_TESTS;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.moringaschool.covidinformer.R;
import com.moringaschool.covidinformer.UI.StatsData;
import com.moringaschool.covidinformer.model.Stats;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StatsAdapter extends RecyclerView.Adapter<StatsAdapter.MyViewHolder> {
    private Context mContext;
    private ArrayList<Stats> StatsArrayList;
    private String searchText="";
    private SpannableStringBuilder sb;

    public StatsAdapter(Context mContext, ArrayList<Stats> countryWiseModelArrayList) {
        this.mContext = mContext;
        this.StatsArrayList = countryWiseModelArrayList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_stats, parent, false);
        return new MyViewHolder(view);
    }

    public void filterList(ArrayList<Stats> filteredList, String text) {
        StatsArrayList = filteredList;
        this.searchText = text;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Stats currentItem = StatsArrayList.get(position);
        String countryName = currentItem.getCountry();
        String countryTotal = currentItem.getConfirmed();
        String countryFlag = currentItem.getFlag();
        String countryRank = String.valueOf(position+1);
        int countryTotalInt = Integer.parseInt(countryTotal);
        Log.d("country rank", countryRank);
        holder.tv_rankTextView.setText(countryRank+".");
        Log.d("country total cases int", String.valueOf(countryTotalInt));
        holder.tv_countryTotalCases.setText(NumberFormat.getInstance().format(countryTotalInt));
        holder.tv_countryName.setText(countryName);

        if(searchText.length()>0){
            //color your text here
            int index = countryName.indexOf(searchText);
            sb = new SpannableStringBuilder(countryName);
            Pattern word = Pattern.compile(searchText.toLowerCase());
            Matcher match = word.matcher(countryName.toLowerCase());
            while(match.find()){
                ForegroundColorSpan fcs = new ForegroundColorSpan(Color.rgb(52, 195, 235)); //specify color here
                sb.setSpan(fcs, match.start(), match.end(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                //index = stateName.indexOf(searchText,index+1);

            }
            holder.tv_countryName.setText(sb);

        }else{
            holder.tv_countryName.setText(countryName);
        }


        Glide.with(mContext).load(countryFlag).diskCacheStrategy(DiskCacheStrategy.DATA).into(holder.iv_flagImage);
        holder.lin_country.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Stats clickedItem = StatsArrayList.get(position);
                Intent perCountryIntent = new Intent(mContext, StatsData.class);

                perCountryIntent.putExtra(COUNTRY_NAME, clickedItem.getCountry());
                perCountryIntent.putExtra(COUNTRY_CONFIRMED, clickedItem.getConfirmed());
                perCountryIntent.putExtra(COUNTRY_ACTIVE, clickedItem.getActive());
                perCountryIntent.putExtra(COUNTRY_RECOVERED, clickedItem.getRecovered());
                perCountryIntent.putExtra(COUNTRY_DECEASED, clickedItem.getDeceased());
                perCountryIntent.putExtra(COUNTRY_NEW_CONFIRMED, clickedItem.getNewConfirmed());
                perCountryIntent.putExtra(COUNTRY_NEW_DECEASED, clickedItem.getNewDeceased());
                perCountryIntent.putExtra(COUNTRY_TESTS, clickedItem.getTests());
                perCountryIntent.putExtra(COUNTRY_FLAGURL, clickedItem.getFlag());

                mContext.startActivity(perCountryIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return StatsArrayList==null || StatsArrayList.isEmpty() ? 0 : StatsArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_countryName, tv_countryTotalCases, tv_rankTextView;
        ImageView iv_flagImage;
        LinearLayout lin_country;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_countryName = itemView.findViewById(R.id.layout_country_wise_country_name_textview);
            tv_countryTotalCases = itemView.findViewById(R.id.layout_country_wise_confirmed_textview);
            iv_flagImage = itemView.findViewById(R.id.layout_country_wise_flag_imageview);
            tv_rankTextView = itemView.findViewById(R.id.layout_country_wise_country_rank);
            lin_country = itemView.findViewById(R.id.layout_country_wise_lin);
        }
    }
}
