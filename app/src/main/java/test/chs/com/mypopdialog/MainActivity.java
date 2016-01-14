package test.chs.com.mypopdialog;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_pop1,btn_pop2,btn_pop3;
    private PopupWindow pop1;
    private PopupWindow pop2;
    private PopupWindow pop3;
    private LinearLayout ll_main;
    private int screenWidth;
    private List<String> mItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        screenWidth = metrics.widthPixels;
        initView();
        initEvent();
        initPop1();
        initPop2();
        initPop3();
    }

    private void initEvent() {
        btn_pop1.setOnClickListener(this);
        btn_pop2.setOnClickListener(this);
        btn_pop3.setOnClickListener(this);
    }

    private void initView() {
        btn_pop1 = (Button) findViewById(R.id.btn_pop1);
        btn_pop2 = (Button) findViewById(R.id.btn_pop2);
        btn_pop3 = (Button) findViewById(R.id.btn_pop3);
        ll_main = (LinearLayout) findViewById(R.id.ll_main);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_pop1:
                pop1.showAtLocation(ll_main, Gravity.BOTTOM, 0, 0);
                makeWindowDark();
                break;
            case R.id.btn_pop2:
                pop2.showAtLocation(ll_main, Gravity.CENTER, 0, 0);
                makeWindowDark();
                break;
            case R.id.btn_pop3:
                pop3.showAsDropDown(btn_pop3);
                break;
        }
    }

    private void initPop1() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.pop_1, null);
        pop1 = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        pop1.setFocusable(true);
        pop1.setOutsideTouchable(true);
        pop1.setBackgroundDrawable(new ColorDrawable());
        Button btn_ok = (Button) view.findViewById(R.id.btn_ok);
        Button btn_cancel = (Button) view.findViewById(R.id.btn_cancel);
        pop1.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                makeWindowLight();
            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop1.dismiss();
            }
        });
    }
    private void initPop2() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.pop_2, null);
        pop2 = new PopupWindow(view, screenWidth * 4 / 5, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        pop2.setFocusable(true);
        pop2.setOutsideTouchable(true);
        pop2.setBackgroundDrawable(new ColorDrawable());
        Button btn_ok = (Button) view.findViewById(R.id.btn_ok);
        Button btn_cancel = (Button) view.findViewById(R.id.btn_cancel);
        pop2.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                makeWindowLight();
            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop1.dismiss();
            }
        });
    }

    private void initPop3() {
        mItems = new ArrayList<>();
        mItems.add("条目1");
        mItems.add("条目2");
        mItems.add("条目3");
        mItems.add("条目4");
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View popupWindowView = inflater.inflate(R.layout.pop_3, null);
        pop3 = new PopupWindow(popupWindowView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
        pop3.setBackgroundDrawable(new ColorDrawable());
        pop3.setOutsideTouchable(true);
        pop3.setAnimationStyle(R.style.PopupWindowAnimation);
        pop3.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
//                iv_arrows.setBackgroundResource(R.mipmap.arrow_down);
            }
        });
        ListView lv_selector = (ListView) popupWindowView.findViewById(R.id.lv_selector);
        LinearLayout ll_main = (LinearLayout) popupWindowView.findViewById(R.id.ll_main);
        ItemSelectorAdapter adapter = new ItemSelectorAdapter(this, mItems);
        lv_selector.setAdapter(adapter);
        lv_selector.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }
        });
        ll_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop3.dismiss();
            }
        });
    }
    /**
     * 让屏幕变暗
     */
    public void makeWindowDark() {
        Window window = getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.alpha = 0.5f;
        window.setAttributes(lp);
    }

    /**
     * 让屏幕变亮
     */
    public void makeWindowLight() {
        Window window = getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.alpha = 1f;
        window.setAttributes(lp);
    }
}
