package cn.sharehe.weixin.vxinterface;

import cn.sharehe.weixin.constant.VxConfigEnum;
import cn.sharehe.weixin.utils.HttpInterface;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @Author: wugui
 * @Date 2018-7-17 11:15
 */
public class GetToken {
    private static String Token = "11_Rwf_vNCLoGB2NyalxsEyyMLs67MKWRrTAVob8S8TMFb1leloqt1MLWZwCGkJ1F_3NfGRlyzA5QgSabfbF4Y__vK8SytTeE_WVwUZgFF8Sen41EGo0TJi14iKIVuqFWYutgNUxEsrmZbY3EwuORSaAJAADE";
    public static String getToken(){
        if (Token != null)
            return Token;
        synchronized (GetToken.class){
            if (Token == null){
                String url = VxConfigEnum.ROOTURLS.val + "cgi-bin/token?grant_type=client_credential&appid="+ VxConfigEnum.APPID.val+"&secret="+ VxConfigEnum.APPSECRET.val;
                JSONObject json = JSON.parseObject(HttpInterface.doGet(url));
                Token = json.getString("access_token");
                System.out.println(Token);
            }
        }
        return Token;
    }
    public static void setTokenNull(){
        Token = null;
    }

    public static void main(String[] args) {
        System.out.println(GetToken.getToken());
    }
}
