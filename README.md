# PopupWindowDialog
使用PopupWindow完成各种dialog

                pop1.showAtLocation(ll_main, Gravity.BOTTOM, 0, 0);
                pop2.showAtLocation(ll_main, Gravity.CENTER, 0, 0);
                pop3.showAsDropDown(btn_pop3);
  
                控制Gravity可以控制pop的位置  ll_main是本界面的最外层布局

               new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
               new PopupWindow(view, screenWidth * 4 / 5, ViewGroup.LayoutParams.WRAP_CONTENT, true);
               new PopupWindow(popupWindowView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);

               创建pop的时候控制它自己的宽和高
               
  ![](https://github.com/caoweiaaa/PopupWindowDialog/blob/master/pop.gif)
