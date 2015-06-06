package de.pfaffenrodt.swapadaptertest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pfaffenrodt on 02.06.2015.
 */
public class DummyAdapter extends RecyclerView.Adapter<DummyAdapter.ViewHolder>{
    ArrayList<DummyItem> dummyItemArrayList;

    public DummyAdapter(ArrayList<DummyItem> dummyItemArrayList) {
        this.dummyItemArrayList = dummyItemArrayList;
    }

    public ArrayList<DummyItem> getDummyItemArrayList() {
        return dummyItemArrayList;
    }

    public void setDummyItemArrayList(ArrayList<DummyItem> dummyItemArrayList) {
        this.dummyItemArrayList = dummyItemArrayList;
        notifyDataSetChanged();
    }

    /**
     *
     * @param itemArrayList
     * @param id
     * @return index no id match return -1
     */
    private int getIndexById(ArrayList<DummyItem> itemArrayList,long id){
        for(int i=0;i<itemArrayList.size();i++){
            if(itemArrayList.get(i).getId()==id){
                return i;
            }
        }
        return -1;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        if(null != viewHolder.textView){
            DummyItem dummyItem = dummyItemArrayList.get(position);
            viewHolder.textView.setText(dummyItem.getText());
            viewHolder.textView.setBackgroundColor(dummyItem.getColor());
        }
    }

    @Override
    public int getItemCount() {
        if(null != dummyItemArrayList){
            return dummyItemArrayList.size();
        }
        return 0;
    }

    @Override
    public long getItemId(int position) {
        if(null != dummyItemArrayList && position<dummyItemArrayList.size()){
            return dummyItemArrayList.get(position).getId();
        }
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView=(TextView)itemView.findViewById(R.id.item_textView);
        }
    }
}
