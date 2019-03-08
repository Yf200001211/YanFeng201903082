package bwie.com.yanfeng20190308.adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import bwie.com.yanfeng20190308.R;
import bwie.com.yanfeng20190308.ShowActivity;
import bwie.com.yanfeng20190308.bean.GetBean;
import bwie.com.yanfeng20190308.bean.ShopBean;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ViewHolder> {
    Context context;
    List<ShopBean.DataBean>list;
    private Handler handler;
    private GetBean.DataBean dataBean;
    private List<ShopBean.DataBean.ListBean> list1;

    public ShopAdapter(Context context, List<ShopBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(viewGroup.getContext(), R.layout.shop_item1, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        viewHolder.name.setText(list.get(i).getSellerName());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        viewHolder.recycl_shop.setLayoutManager(linearLayoutManager);
        for (int j = 0;j<list.size();j++){
            list1 = list.get(i).getList();

        }
        ProductAdapter productAdapter =new ProductAdapter(context,list1);
        viewHolder.recycl_shop.setAdapter(productAdapter);
//
//        handler = new Handler(new Handler.Callback() {
//            @Override
//            public boolean handleMessage(Message msg) {
//                List<GetBean.DataBean> dataBeans = new ArrayList<>();
//                dataBean = dataBeans.get(i);
//                ProductAdapter productAdapter = new ProductAdapter(context, dataBean);
//                viewHolder.recycl_shop.setAdapter(productAdapter);
//                return true;
//            }
//        });
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CheckBox checkbox_shop;
        private RecyclerView recycl_shop;
        private TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            checkbox_shop = itemView.findViewById(R.id.checkbox_shop);
            recycl_shop = itemView.findViewById(R.id.recycl_shop);
            name = itemView.findViewById(R.id.name);
        }
    }
}
