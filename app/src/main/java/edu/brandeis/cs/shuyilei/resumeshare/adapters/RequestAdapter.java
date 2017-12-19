package edu.brandeis.cs.shuyilei.resumeshare.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import edu.brandeis.cs.shuyilei.resumeshare.R;
import edu.brandeis.cs.shuyiei.resumeshare.beans.Request;
import edu.brandeis.cs.shuyilei.resumeshare.beans.User;
import edu.brandeis.cs.shuyilei.resumeshare.controllers.ContactController;
import edu.brandeis.cs.shuyilei.resumeshare.controllers.UserController;
import edu.brandeis.cs.shuyilei.resumeshare.views.activities.HomeActivity;

/**
 * Created by shuyilei on 11/18/16.
 */

public class RequestAdapter extends BaseAdapter {
    private List<Request> mList;
    private LayoutInflater mInflater;
    private int position;
    private Context context;
    public RequestAdapter(Context context){
        this.mList=new ArrayList<Request>();
        this.context=context;
        this.mInflater=LayoutInflater.from(context);
    }
    public void putData(Request requset){
        this.mList.add(requset);
       notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        final int id=position;
        final RequestAdapter.ViewHolder viewHolder;
        if(convertView==null){
            viewHolder=new RequestAdapter.ViewHolder();
            convertView=mInflater.inflate(R.layout.list_item_request,null);
            viewHolder.imageView=(ImageView) convertView.findViewById(R.id.iv_request_image);
            viewHolder.name=(TextView)convertView.findViewById(R.id.tv_request_name);
            viewHolder.account=(TextView)convertView.findViewById(R.id.tv_request_account);
            viewHolder.message=(TextView)convertView.findViewById(R.id.tv_request_message);
            viewHolder.accept=(Button)convertView.findViewById(R.id.btn_request_accept);
            viewHolder.refuse=(Button)convertView.findViewById(R.id.btn_request_refuse);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (RequestAdapter.ViewHolder) convertView.getTag();

        }
        Request request=mList.get(id);
        viewHolder.imageView.setImageResource(R.drawable.kellyisgenius);
        viewHolder.name.setText(request.getHostName());
        viewHolder.account.setText(request.getHostAccount());
        viewHolder.message.setText(request.getMessage());
        viewHolder.name.setText(request.getHostName());

        final boolean visiable=false;

        viewHolder.accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserController userController=new UserController(context);
                userController.addContact(((HomeActivity)context).getCurrentUser(),mList.get(id).getHostAccount());
                userController.refuseRequest(mList.get(id).getId());
                mList.remove(id);
                notifyDataSetChanged();
            }
        });
        viewHolder.refuse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserController userController=new UserController(context);
                userController.refuseRequest(mList.get(id).getId());
                mList.remove(id);
                notifyDataSetChanged();
            }
        });
        return convertView;
    }

    class ViewHolder{
        public ImageView imageView;
        public TextView name;
        public TextView account;
        public TextView message;
        public Button accept;
        public Button refuse;
    }
}
