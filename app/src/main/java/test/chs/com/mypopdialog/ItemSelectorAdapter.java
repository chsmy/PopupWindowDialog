package test.chs.com.mypopdialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;


import java.util.List;

/**
 * 作者：chs on 2015/11/24 17:32
 * 邮箱：657083984@qq.com
 */
public class ItemSelectorAdapter extends MyBaseAdapter<String,ListView> {
    private LayoutInflater mInflater;
    private List<String> mData;
    public ItemSelectorAdapter(Context ct, List<String> list) {
        super(ct, list);
        mInflater = LayoutInflater.from(ct);
        mData = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView==null){
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_selector,null);
            holder.tv_item = (TextView) convertView.findViewById(R.id.tv_item);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv_item.setText(mData.get(position));
        return convertView;
    }
    private class ViewHolder{
        private TextView tv_item;
    }
}
