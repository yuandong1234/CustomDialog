package yuandong.customdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import yuandong.customdialog.widget.BottomDialog;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    private BottomDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.sexSelect).setOnClickListener(this);
        initDialog();
    }

    private void initDialog(){
        View contentView=View.inflate(MainActivity.this,R.layout.layout_dialog_bootom_menu,null);
        BottomDialog.Builder builder=new BottomDialog.Builder(this);
        builder.setContentView(contentView);
        builder.setListener(this);
        dialog= builder.create();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sexSelect:
                if(!dialog.isShowing()){
                    dialog.show();
                }
                break;
            case R.id.ll_sex_man:
                dialog.dismiss();
                Toast.makeText(this,"你的性别是“ 男 ”",Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_sex_woman:
                dialog.dismiss();
                Toast.makeText(this,"你的性别是“ 女 ”",Toast.LENGTH_SHORT).show();
                break;
            case R.id.cancel:
                dialog.dismiss();
                break;
        }

    }
}
