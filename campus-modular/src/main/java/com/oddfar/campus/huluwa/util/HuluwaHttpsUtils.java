package com.oddfar.campus.huluwa.util;

import cn.hutool.json.JSONUtil;
import com.oddfar.campus.huluwa.domain.BaseResult;
import com.oddfar.campus.huluwa.domain.HuluwaResponse;
import com.oddfar.campus.huluwa.entity.RequestLog;
import com.oddfar.campus.huluwa.enums.PlatformEnum;
import com.oddfar.campus.huluwa.repository.HuluwaLogRepository;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HuluwaHttpsUtils {
    private static final Logger log = LoggerFactory.getLogger(HuluwaHttpsUtils.class);
    private static final String REQUEST_METHOD_POST = "POST";
    private static final String DOMAIN = "https://gw.huiqunchina.com";
    public static final String HULUWA_URI_GET_CHANNEL_INFO_ID = "/front-manager/api/get/getChannelInfoId";
    public static final String HULUWA_URI_CUSTOMER_QUERY_TOKEN = "/front-manager/api/customer/queryById/token";
    public static final String HULUWA_URI_CUSTOMER_PROMOTION_CHANNEL_ACTIVIRY = "/front-manager/api/customer/promotion/channelActivity";
    public static final String HULUWA_URI_CUSTOMER_PROMOTION_CHECK_IN_QIANG_GOU = "/front-manager/api/customer/promotion/checkCustomerInQianggou";
    public static final String HULUWA_URI_CUSTOMER_PROMOTION_QUERY_ACTIVIRY_IS_DRAW = "/front-manager/api/customer/promotion/queryActivityIsDraw";
    public static final String HULUWA_URI_CUSTOMER_PROMOTION_APPOINT = "/front-manager/api/customer/promotion/appoint";

    public HuluwaHttpsUtils() {
    }

    public static void main(String[] args) {
        PlatformEnum platformEnum = PlatformEnum.HANG_LV_QIAN_GOU;
        String uri = "/front-manager/api/customer/promotion/checkCustomerInQianggou";
        String content = String.format("{\"activityId\":%d}", 520);
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMTE2Mzc0MTA3IiwiaXNzIjoiZ21hbGwtc3RhcnNreSIsImxvZ0lkIjoibnVsbCIsImV4cCI6MTcxNzIyOTYwOSwiaWF0IjoxNzA5NDUzNjA5fQ.VPG9gaxv-1FEzWswRKuHVbENSNmrItx7oA4KXCSOEU4";
        HuluwaResponse result = sendPost(platformEnum, uri, content, token);
        log.info("{}", result);
    }

    public static <R extends BaseResult> R sendPostResult(PlatformEnum platformEnum, String uri, String content, String token, Class<R> clz) {
        HuluwaResponse response = sendPost(platformEnum, uri, content, token);
        if (response == null) {
            return null;
        } else {
            BaseResult result;
            if (!response.isSuccess()) {
                log.error("[{}]请求信息失败：{}", uri, response);

                try {
                    result = (BaseResult)clz.newInstance();
                    result.setSuccess(false);
                    result.setMessage(response.getMessage());
                    return result;
                } catch (IllegalAccessException | InstantiationException var7) {
                    log.error("处理失败的返回结果出现异常：{}", clz, var7);
                    return null;
                }
            } else {
                result = (BaseResult) JSONUtil.toBean(response.getData(), clz);
                result.setMessage(response.getMessage());
                result.setSuccess(response.isSuccess());
                return result;
            }
        }
    }

    public static <R> R sendPost(PlatformEnum platformEnum, String uri, String content, String token, Class<R> clz) {
        HuluwaResponse response = sendPost(platformEnum, uri, content, token);
        if (response == null) {
            return null;
        } else if (!response.isSuccess()) {
            log.error("[{}]请求信息失败：{}", uri, response);
            return null;
        } else {
            return JSONUtil.toBean(response.getData(), clz);
        }
    }

    public static HuluwaResponse sendPost(PlatformEnum platformEnum, String uri, String content, String token) {
        long start = System.currentTimeMillis();
        String json = null;
        int status = 0;
        String message = null;
        boolean var35 = false;

        HuluwaResponse var25;
        label72: {
            try {
                var35 = true;
                SSLContext sslContext = SSLContext.getInstance("SSL");
                TrustManager[] tm = new TrustManager[]{new MyX509TrustManager()};
                sslContext.init((KeyManager[])null, tm, new SecureRandom());
                SSLSocketFactory ssf = sslContext.getSocketFactory();
                URL url = new URL("https://gw.huiqunchina.com" + uri);
                HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
                conn.setDoOutput(true);
                conn.setDoInput(true);
                conn.setUseCaches(false);
                conn.setRequestMethod("POST");
                conn.setSSLSocketFactory(ssf);
                String ak = platformEnum.getAk();
                String sk = platformEnum.getSk();
                String current = now();
                String sign = encode(ak, sk, "POST", uri, current);
                String digest = hmacsha256(sk, content);
                conn.setRequestProperty("X-Hmac-Date", current);
                conn.setRequestProperty("Datatype", "json");
                conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36 MicroMessenger/7.0.20.1781(0x6700143B) NetType/WIFI MiniProgramEnv/Windows WindowsWechat/WMPF WindowsWechat(0x63090819) XWEB/8531");
                conn.setRequestProperty("X-Hmac-Digest", digest);
                conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                conn.setRequestProperty("X-Hmac-Signature", sign);
                conn.setRequestProperty("X-Hmac-Algorithm", "hmac-sha256");
                conn.setRequestProperty("Channel", "miniapp");
                conn.setRequestProperty("X-Access-Token", token);
                conn.setRequestProperty("X-Hmac-Access-Key", ak);
                conn.setRequestProperty("Accept", "*/*");
                conn.setRequestProperty("Origin", "https://hqmall.huiqunchina.com");
                conn.setRequestProperty("Sec-Fetch-Site", "same-site");
                conn.setRequestProperty("Sec-Fetch-Mode", "cors");
                conn.setRequestProperty("Sec-Fetch-Dest", "empty");
                conn.setRequestProperty("Referer", "https://hqmall.huiqunchina.com/");
                conn.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9");
                conn.setRequestProperty("Connection", "close");
                conn.connect();
                if (null != content) {
                    OutputStream os = conn.getOutputStream();
                    os.write(content.getBytes("utf-8"));
                    os.close();
                }

                int responseCode = conn.getResponseCode();
                InputStream is = null;
                if (responseCode == 200) {
                    is = conn.getInputStream();
                } else {
                    log.error("xxxxxxxxxxxxxx 请求响应异常：" + responseCode);
                    is = conn.getErrorStream();
                }

                InputStreamReader isr = new InputStreamReader(is, "utf-8");
                BufferedReader br = new BufferedReader(isr);
                StringBuffer buffer = new StringBuffer();
                String line = null;

                while((line = br.readLine()) != null) {
                    buffer.append(line);
                }

                json = buffer.toString();
                log.info(json);
                status = 1;
                var25 = (HuluwaResponse)JSONUtil.toBean(json, HuluwaResponse.class);
                var35 = false;
                break label72;
            } catch (Exception var36) {
                message = var36.getMessage();
                log.error("请求出现异常：{}", uri, var36);
                HuluwaLogRepository.cacheActionLog(platformEnum, token, "请求失败：" + var36.getMessage());
                var35 = false;
            } finally {
                if (var35) {
                    long cost = System.currentTimeMillis() - start;
                    RequestLog requestLog = new RequestLog();
                    requestLog.setPlatform(platformEnum);
                    requestLog.setUri(uri);
                    requestLog.setContent(content);
                    requestLog.setToken(token);
                    requestLog.setResponse(json);
                    requestLog.setCost(cost);
                    requestLog.setStatus(Integer.valueOf(status));
                    requestLog.setMessage(message);
                    requestLog.setStamp(new Date());
                    HuluwaLogRepository.cache(requestLog);
                }
            }

            long cost = System.currentTimeMillis() - start;
            RequestLog requestLog = new RequestLog();
            requestLog.setPlatform(platformEnum);
            requestLog.setUri(uri);
            requestLog.setContent(content);
            requestLog.setToken(token);
            requestLog.setResponse(json);
            requestLog.setCost(cost);
            requestLog.setStatus(Integer.valueOf(status));
            requestLog.setMessage(message);
            requestLog.setStamp(new Date());
            HuluwaLogRepository.cache(requestLog);
            return null;
        }

        long cost = System.currentTimeMillis() - start;
        RequestLog requestLog = new RequestLog();
        requestLog.setPlatform(platformEnum);
        requestLog.setUri(uri);
        requestLog.setContent(content);
        requestLog.setToken(token);
        requestLog.setResponse(json);
        requestLog.setCost(cost);
        requestLog.setStatus(Integer.valueOf(status));
        requestLog.setMessage(message);
        requestLog.setStamp(new Date());
        HuluwaLogRepository.cache(requestLog);
        return var25;
    }

    private static String hmacsha256(String sk, String message) {
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(sk.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            byte[] hash = sha256_HMAC.doFinal(message.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (Exception var5) {
            var5.printStackTrace();
            return "";
        }
    }

    private static String encode(String ak, String sk, String method, String uri, String date) {
        String message = String.format("%s\n%s\n\n%s\n%s\n", method, uri, ak, date);
        return hmacsha256(sk, message);
    }

    private static String now() {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.ENGLISH);
        Date date = new Date();
        long ms = date.getTime() - TimeUnit.HOURS.toMillis(8L);
        Date enDate = new Date(ms);
        return sdf.format(enDate);
    }
}
