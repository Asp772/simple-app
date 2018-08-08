package com.example.simpleProj.service.impl;

import com.example.simpleProj.exception.MusicSourceAccessException;
import com.example.simpleProj.model.Song;
import com.example.simpleProj.service.MusicService;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Kamarou_S on 01.08.2018.
 */
@Service
public class VKServiceImpl implements MusicService {
    @Override
    public void logon() {

    }

    @Override
    public List<Object> getList() {
        return null;
    }

    @Override
    public List<Object> getQueryResult(String query, int offset) throws MusicSourceAccessException {
        return null;
    }



    /*private final Environment environment;
    private final String cookieNeeded;

    private String getLoginVK() {
        return this.environment.getProperty("vk.login");
    }

    private String getPassVK() {
        return this.environment.getProperty("vk.pass");
    }

    @Autowired
    public VKServiceImpl(Environment environment) {
        this.environment = environment;

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String baseUrl = "https://vk.com/im";
        driver.get(baseUrl);
        driver.findElement(By.id("email")).sendKeys(this.getLoginVK());
        driver.findElement(By.id("pass")).sendKeys(this.getPassVK());

        driver.findElement(By.id("login_button")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("l_aud"))).click();
        Set<Cookie> cookieSet = driver.manage().getCookies();
        driver.close();
        //System.out.println(cookieSet);
        List<String> cookieNames = new ArrayList<>();
        cookieNames.add("remixlang");
        cookieNames.add("remixstid");
        cookieNames.add("remixflash");
        cookieNames.add("remixscreen_depth");
        cookieNames.add("remixdt");
        cookieNames.add("remixsid");
        cookieNames.add("remixgp");
        cookieNames.add("remixseenads");
        StringBuilder stringBuilder = new StringBuilder();
        for (Cookie cookie : cookieSet) {
            if (cookieNames.contains(cookie.getName())) {
                stringBuilder.append(cookie.getName());
                stringBuilder.append("=");
                stringBuilder.append(cookie.getValue());
                stringBuilder.append(";");
            }
        }
        cookieNeeded = stringBuilder.toString();
        //System.out.println(cookieNeeded);
    }

    @Override
    public void logon() {
        *//*System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String baseUrl = "https://vk.com/im";

        driver.get(baseUrl);
        driver.findElement(By.id("email")).sendKeys("375257708161");
        driver.findElement(By.id("pass")).sendKeys("AspireV3");
        driver.findElement(By.id("login_button")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement musicUl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("l_aud")));
        musicUl.click();

        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0,450)", "");
        jsx.executeScript("window.scrollBy(0,450)", "");
        jsx.executeScript("window.scrollBy(0,450)", "");
        jsx.executeScript("window.scrollBy(0,450)", "");
        jsx.executeScript("window.scrollBy(0,450)", "");
        jsx.executeScript("window.scrollBy(0,450)", "");
        List<WebElement> lst = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("audio_row")));


        System.out.println(lst.size());
        System.out.println(lst.get(0).getText());
        System.out.println(lst.get(0).getRect());
        System.out.println(lst.get(0).getAttribute("href"));
        //System.out.println(driver.getPageSource());

        Set<Cookie> cookieSet = driver.manage().getCookies();
        List<String> cookieNames = new ArrayList<>();
        cookieNames.add("remixlang");
        cookieNames.add("remixstid");
        cookieNames.add("remixflash");
        cookieNames.add("remixscreen_depth");
        cookieNames.add("remixdt");
        cookieNames.add("remixsid");
        cookieNames.add("remixgp");
        cookieNames.add("remixseenads");
        StringBuilder stringBuilder = new StringBuilder();
        for (Cookie cookie : cookieSet) {
            if (cookieNames.contains(cookie.getName())) {
                stringBuilder.append(cookie.getName());
                stringBuilder.append("=");
                stringBuilder.append(cookie.getValue());
                stringBuilder.append(";");
            }
        }
        System.out.println(stringBuilder);
        String str = stringBuilder.toString();


        String urlToRead = "https://vk.com/al_audio.php";
        StringBuilder result = new StringBuilder();
        URL url = null;
        HttpURLConnection conn = null;

        BufferedReader rd = null;
        String line;
        try {
            url = new URL(urlToRead);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Cookie", str);
            conn.setRequestProperty("Content-Type",
                    "text/html; charset=utf-8");
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Document doc = Jsoup.parse(result.toString());
        Elements found = doc.getElementsByClass("ai_body");
        if (found.size() > 0) {
            List<Song> songList = new ArrayList<>();
            for (Element el : found) {
                StringBuilder songTitle = new StringBuilder();
                songTitle.append(el.getElementsByClass("ai_artist").get(0).text());
                songTitle.append(el.getElementsByClass("divider").get(0).text());
                songTitle.append(el.getElementsByClass("ai_title").get(0).text());
                songList.add(new Song(songTitle.toString(), el.getElementsByAttributeValue("type", "hidden").get(0).val()));
            }
        }
*//*
    }

    @Override
    public List<Object> getList() {
        String urlToRead = "https://vk.com/al_audio.php";
        StringBuilder result = new StringBuilder();
        URL url = null;
        HttpURLConnection conn = null;
        BufferedReader rd = null;
        String line;
        try {
            url = new URL(urlToRead);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Cookie", cookieNeeded);
            conn.setRequestProperty("Referer", "https://vk.com/audios136082153?q=saturda");

            conn.setRequestProperty("Content-Type", "text/html; charset=utf-8");
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Document doc = Jsoup.parse(result.toString());
        Elements found = doc.getElementsByClass("ai_body");
        if (found.size() > 0) {
            List<Object> songList = new ArrayList<>();
            for (Element el : found) {
                songList.add(
                        new Song(el.getElementsByClass("ai_title").get(0).text(),
                                el.getElementsByClass("ai_artist").get(0).text(),
                                el.getElementsByAttributeValue("type", "hidden").get(0).val()));
            }
            return songList;
        }
        return null;
    }

    @Override
    public List<Object> getQueryResult(String query, int offset) throws MusicSourceAccessException {
        List<NameValuePair> form = new ArrayList<>();
        form.add(new BasicNameValuePair("act", "load_section"));
        form.add(new BasicNameValuePair("search_q", query));
        form.add(new BasicNameValuePair("type", "search"));
        form.add(new BasicNameValuePair("al", "1"));
        form.add(new BasicNameValuePair("offset", String.valueOf(offset)));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(form, Consts.UTF_8);
        HttpPost httpPost = new HttpPost("https://vk.com/al_audio.php");
        httpPost.setEntity(entity);
        httpPost.setHeader("Cookie", cookieNeeded);
        HttpClient httpclient = HttpClientBuilder.create().build();
        List<String> ids = new ArrayList<>();
        try {
            HttpResponse responseBody = httpclient.execute(httpPost);
            String json = EntityUtils.toString(responseBody.getEntity());
            int i = 0;
            while (i != 12) {
                i = json.indexOf("content_id", i);
                i = i + 13;             //13 is 'content_id":"' - length
                int end = json.indexOf("\"", i);
                ids.add(json.substring(i, end));
            }
            if (ids.size() > 0) {
                ids.remove(ids.size() - 1);
                List<Object> songList = new ArrayList<>();
                List<String> tempLst;
                int tens = ids.size() / 5;
                int rest = ids.size() % 5;
                for (i = 0; i < tens; i++) {
                    tempLst = ids.subList(i * 5, i * 5 + 5);
                    StringBuilder stringBuilder = new StringBuilder();
                    for (String str : tempLst) {
                        stringBuilder.append(str);
                        stringBuilder.append(",");
                    }
                    songList.addAll(this.reloadAudio(stringBuilder.toString(), 5));
                }
                for (i = 0; i < rest; i++) {
                    tempLst = ids.subList(5 * tens, tens * 5 + rest);
                    StringBuilder stringBuilder = new StringBuilder();
                    for (String str : tempLst) {
                        stringBuilder.append(str);
                        stringBuilder.append(",");
                    }
                    songList.addAll(this.reloadAudio(stringBuilder.toString(), rest));
                }
                return songList;
            }
        } catch (IOException e) {
            throw new MusicSourceAccessException(e.getMessage());
        }
        return null;
    }

    private List<Song> reloadAudio(String ids, int count) throws MusicSourceAccessException {
        List<Song> songList = new ArrayList<>();
        List<NameValuePair> form = new ArrayList<>();
        form.add(new BasicNameValuePair("act", "reload_audio"));
        form.add(new BasicNameValuePair("ids", ids));
        form.add(new BasicNameValuePair("al", "1"));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(form, Consts.UTF_8);
        HttpPost httpPost = new HttpPost("https://vk.com/al_audio.php");
        httpPost.setEntity(entity);
        httpPost.setHeader("Cookie", cookieNeeded);
        HttpClient httpclient = HttpClientBuilder.create().build();
        try {
            HttpResponse responseBody = httpclient.execute(httpPost);
            String json = EntityUtils.toString(responseBody.getEntity());
            //System.out.println(json);
            int k = 0;
            for (int t = 0; t < count; t++) {
                try {
                    k = json.indexOf("https:\\/\\/vk.com\\/mp3\\/audio_api_unavailable.mp3", k);
                    int endUrlIndex = json.indexOf("\"", k + 1);
                    int startSongNameIndex = json.indexOf("\"", endUrlIndex + 1);
                    int endSongNameIndex = json.indexOf("\"", startSongNameIndex + 1);
                    int startSongArtistIndex = json.indexOf("\"", endSongNameIndex + 1);
                    int endSongArtistIndex = json.indexOf("\"", startSongArtistIndex + 1);
                    songList.add(new Song(json.substring(startSongNameIndex + 1, endSongNameIndex), json.substring(startSongArtistIndex + 1, endSongArtistIndex), this.getRealUrlFromFake(json.substring(k, endUrlIndex))));
                    k = endSongArtistIndex + 1;
                } catch (IndexOutOfBoundsException e) {
                    System.err.println(e.getMessage());
                    continue;
                }
            }
            return songList;
        } catch (IOException e) {
            throw new MusicSourceAccessException(e.getMessage());
        }
    }

    private HttpResponse doPost(Map<String, String> formData, Map<String, String> header, String url) throws IOException {
        List<NameValuePair> form = new ArrayList<>();
        for (Map.Entry<String, String> entry : formData.entrySet()) {
            form.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(form, Consts.UTF_8);
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(entity);
        for (Map.Entry<String, String> entry : header.entrySet()) {
            httpPost.setHeader(entry.getKey(), entry.getValue());
        }
        HttpClient httpclient = HttpClientBuilder.create().build();
        HttpResponse responseBody = null;
        responseBody = httpclient.execute(httpPost);
        return responseBody;
    }

    private String getRealUrlFromFake(String fakeUrl) {
        String jsScript = "var o = \"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMN0PQRSTUVWXYZO123456789+/=\"\n" +
                "    , a = {\n" +
                "    v: function(t) {\n" +
                "        return t.split(\"\").reverse().join(\"\")\n" +
                "    },\n" +
                "    r: function(t, e) {\n" +
                "        t = t.split(\"\");\n" +
                "        for (var i, a = o + o, s = t.length; s--; )\n" +
                "            ~(i = a.indexOf(t[s])) && (t[s] = a.substr(i - e, 1));\n" +
                "        return t.join(\"\")\n" +
                "    },\n" +
                "    s: function(t, e) {\n" +
                "        var i = t.length;\n" +
                "        if (i) {\n" +
                "            var o = function(t, e) {\n" +
                "                var i = t.length\n" +
                "                    , o = [];\n" +
                "                if (i) {\n" +
                "                    var a = i;\n" +
                "                    for (e = Math.abs(e); a--; )\n" +
                "                        e = (i * (a + 1) ^ e + a) % i,\n" +
                "                            o[a] = e\n" +
                "                }\n" +
                "                return o\n" +
                "            }(t, e)\n" +
                "                , a = 0;\n" +
                "            for (t = t.split(\"\"); ++a < i; )\n" +
                "                t[a] = t.splice(o[i - 1 - a], 1, t[a])[0];\n" +
                "            t = t.join(\"\")\n" +
                "        }\n" +
                "        return t\n" +
                "    },\n" +
                "    i: function(t, e) {\n" +
                "        return a.s(t, e ^ vk.id)\n" +
                "    },\n" +
                "    x: function(t, e) {\n" +
                "        var i = [];\n" +
                "        return e = e.charCodeAt(0),\n" +
                "            each(t.split(\"\"), function(t, o) {\n" +
                "                i.push(String.fromCharCode(o.charCodeAt(0) ^ e))\n" +
                "            }),\n" +
                "            i.join(\"\")\n" +
                "    }}\n" +
                "function s(t) {\n" +
                "    if (~t.indexOf(\"audio_api_unavailable\")) {\n" +
                "        var e = t.split(\"?extra=\")[1].split(\"#\")\n" +
                "            , i = \"\" === e[1] ? \"\" : r(e[1]);\n" +
                "        if (e = r(e[0]),\n" +
                "            \"string\" != typeof i || !e)\n" +
                "            return t;\n" +
                "        for (var o, s, l = (i = i ? i.split(String.fromCharCode(9)) : []).length; l--; ) {\n" +
                "            if (o = (s = i[l].split(String.fromCharCode(11))).splice(0, 1, e)[0],\n" +
                "                    !a[o])\n" +
                "                return t;\n" +
                "            e = a[o].apply(null, s)\n" +
                "        }\n" +
                "        if (e && \"http\" === e.substr(0, 4))\n" +
                "            return e\n" +
                "    }\n" +
                "    return t\n" +
                "}\n" +
                "function r(t) {\n" +
                "    if (!t || t.length % 4 == 1)\n" +
                "        return !1;\n" +
                "    for (var e, i, a = 0, s = 0, r = \"\"; i = t.charAt(s++); )\n" +
                "        ~(i = o.indexOf(i)) && (e = a % 4 ? 64 * e + i : i,\n" +
                "        a++ % 4) && (r += String.fromCharCode(255 & e >> (-2 * a & 6)));\n" +
                "    return r\n" +
                "};";


        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(jsScript);
        stringBuilder.append("var vk = {id: 136082153};");
        stringBuilder.append("s('");
        stringBuilder.append(fakeUrl);
        stringBuilder.append("')");
        try {
            ScriptEngineManager factory = new ScriptEngineManager();
            ScriptEngine engine = factory.getEngineByName("JavaScript");
            return engine.eval(stringBuilder.toString()).toString();
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return null;
    }*/
}
