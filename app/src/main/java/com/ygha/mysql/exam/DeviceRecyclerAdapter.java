package com.ygha.mysql.exam;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DeviceRecyclerAdapter extends RecyclerView.Adapter<DeviceRecyclerAdapter.itemViewHolder> {

    private List mItemList;

    public DeviceRecyclerAdapter(List mItemList) {
        this.mItemList = mItemList;
    }

    public interface OnItemClickListener {
        void onItemClick(View v, int position) ;
    }

    private OnItemClickListener mListener;

    @Override
    public itemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        return new itemViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(itemViewHolder a_holder, int a_position) {
        SpaceEntity studentEntity = (SpaceEntity) mItemList.get(a_position);

        a_holder.tvSpace.setText(studentEntity.getSpace());
        a_holder.tvNickname.setText(studentEntity.getNickname());
        a_holder.tvUuid.setText(studentEntity.getUuid());
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    public class itemViewHolder extends RecyclerView.ViewHolder {
        private TextView tvSpace;
        private TextView tvNickname;
        private TextView tvUuid;

        public itemViewHolder(View a_view) {
            super(a_view);
            tvSpace = a_view.findViewById(R.id.tv_item_grade);
            tvNickname = a_view.findViewById(R.id.tv_item_number);
            tvUuid = a_view.findViewById(R.id.tv_item_name);

            // 아이템 클릭 이벤트 처리.
            a_view.setOnClickListener(a_view1 -> {
                final int pos = getAdapterPosition() ;
                if (pos != RecyclerView.NO_POSITION) {
                    // 리스너 객체의 메서드 호출.
                    if (mListener != null) {
                        mListener.onItemClick(a_view1, pos) ;
                    }
                }
            });
        }
    }

    public void setOnItemClickListener(OnItemClickListener a_listener) {
        mListener = a_listener ;
    }
}
