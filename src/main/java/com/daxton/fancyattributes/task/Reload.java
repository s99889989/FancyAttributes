package com.daxton.fancyattributes.task;


import com.daxton.fancyattributes.config.FileConfig;

public class Reload {
    //重新讀取的一些任務
    public static void execute(){
        //設定檔
        FileConfig.reload();

    }

}
