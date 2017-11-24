package com.example.virtualapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.lody.virtual.client.core.VirtualCore;
import com.lody.virtual.client.ipc.VActivityManager;
import com.lody.virtual.remote.InstallResult;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button)findViewById(R.id.install);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InstallResult ir = VirtualCore.get().installPackage("/data/local/tmp/wechat.apk", 0);
                if(ir.isSuccess) {
                    Toast.makeText(MainActivity.this, "安装成功", Toast.LENGTH_LONG).show();
                }
            }
        });

        Button btn_start = (Button)findViewById(R.id.start);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = VirtualCore.get().getLaunchIntent("com.tencent.mm",0);
                VActivityManager.get().startActivity(intent, 0);
            }
        });

        Button btn_uninstall = (Button)findViewById(R.id.uninstall);
        btn_uninstall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VirtualCore.get().uninstallPackage("com.tencent.mm");
            }
        });
    }
}
