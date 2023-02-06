package com.telegram.bot.service;

import okhttp3.*;
import org.springframework.stereotype.Service;

@Service
public class TeleBotChannelService {
    /**
     * @Desc init send http request to telegram api /sendMessage api & send message to channel telegram
     * @param content
     */
    public void sendChannelMessage(String content){
        System.out.println("call send message to channel start");
        // avoid creating several instances, should be singleon
        try {
        OkHttpClient client = new OkHttpClient();

        RequestBody formBodyChannel = new FormBody.Builder()
                .add("chat_id", "@senadev")
                .add("text", content)
                .build();

        Request requestChannel = new Request.Builder()
                .url("https://api.telegram.org/bot5400897033:AAH0C4YgX_r-AKZUIi6vmEPVv-iphKFJSW8/sendMessage")
                .post(formBodyChannel)
                .build();

        Response responseChannel = client.newCall(requestChannel).execute();
        System.out.println(responseChannel.body().string());
        System.out.println("call send message to channel end");
        } catch (Exception exception) {
            exception.getMessage();
        }
    }

    /**
     * @Desc init send http request to telegram api /sendMessage api & send message to group telegram
     * @param content
     */
    public void sendGroupMessage(String content){
        // code to do here
    }
}
