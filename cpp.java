package com.example.demo.control;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cpp")
public class cpp {
  @RequestMapping("/issues")
  public String issues() throws IOException {
    String url1 = "https://api.github.com/repos/msgpack/msgpack-c/issues?state=all&per_page=100";

    HttpURLConnection connection = null;
    InputStream is = null;
    BufferedReader br = null;
    StringBuffer result = new StringBuffer();
    try {
      //创建连接
      URL url = new URL(url1);
      connection = (HttpURLConnection) url.openConnection();
      //设置请求方式
      connection.setRequestMethod("GET");
      //设置连接超时时间
      connection.setReadTimeout(15000);
      //开始连接
      connection.connect();
      //获取响应数据
      if (connection.getResponseCode() == 200) {
        //获取返回的数据
        is = connection.getInputStream();
        if (null != is) {
          br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
          String temp = null;
          while (null != (temp = br.readLine())) {
            result.append(temp);
          }
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (null != br) {
        try {
          br.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if (null != is) {
        try {
          is.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      //关闭远程连接
      connection.disconnect();
    }
    JSONArray objects = JSONArray.parseArray(result.toString());
    double cnt = 0;

    for (int i = 0; i < objects.size(); i++) {
      JSONObject object = (JSONObject) objects.get(i);
      if (object.get("state").equals("closed")) cnt++;
    }
    double bili = cnt / (100 - cnt);
    return String.format("%s%.2f", "The ratio between number of closed issues and open issues is ", bili);
  }

  @RequestMapping("/commits")
  public String commits() throws IOException {
    String url1 = "https://api.github.com/repos/msgpack/msgpack-c/commits?per_page=100";

    HttpURLConnection connection = null;
    InputStream is = null;
    BufferedReader br = null;
    StringBuffer result = new StringBuffer();
    try {
      //创建连接
      URL url = new URL(url1);
      connection = (HttpURLConnection) url.openConnection();
      //设置请求方式
      connection.setRequestMethod("GET");
      //设置连接超时时间
      connection.setReadTimeout(15000);
      //开始连接
      connection.connect();
      //获取响应数据
      if (connection.getResponseCode() == 200) {
        //获取返回的数据
        is = connection.getInputStream();
        if (null != is) {
          br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
          String temp = null;
          while (null != (temp = br.readLine())) {
            result.append(temp);
          }
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (null != br) {
        try {
          br.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if (null != is) {
        try {
          is.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      //关闭远程连接
      connection.disconnect();
    }
    JSONArray array = JSONArray.parseArray(result.toString());
    int[] times = new int[4];
    int max = 0;
    for (int i = 0; i < array.size(); i++) {
      JSONObject object = (JSONObject) array.get(i);
      switch (Integer.parseInt(((JSONObject) ((JSONObject) object.get("commit")).get("committer")).get("date").toString().substring(11, 13)) / 6) {
        case 0:
          times[0]++;
          if (times[0] > times[max]) max = 0;
          break;
        case 1:
          times[1]++;
          if (times[1] > times[max]) max = 1;
          break;
        case 2:
          times[2]++;
          if (times[2] > times[max]) max = 2;
          break;
        case 3:
          times[3]++;
          if (times[3] > times[max]) max = 3;
          break;
      }
    }
    switch (max) {
      case 0:
        return "Committer prefer to commit in morning";
      case 1:
        return "Committer prefer to commit in forenoon";
      case 2:
        return "Committer prefer to commit in afternoon";
      default:
        return "Committer prefer to commit in evening";
    }
  }

  @RequestMapping("/contributors")
  public String contributors() throws IOException {
    String url1 = "https://api.github.com/repos/msgpack/msgpack-c/contributors";

    HttpURLConnection connection = null;
    InputStream is = null;
    BufferedReader br = null;
    StringBuffer result = new StringBuffer();
    try {
      //创建连接
      URL url = new URL(url1);
      connection = (HttpURLConnection) url.openConnection();
      //设置请求方式
      connection.setRequestMethod("GET");
      //设置连接超时时间
      connection.setReadTimeout(15000);
      //开始连接
      connection.connect();
      //获取响应数据
      if (connection.getResponseCode() == 200) {
        //获取返回的数据
        is = connection.getInputStream();
        if (null != is) {
          br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
          String temp = null;
          while (null != (temp = br.readLine())) {
            result.append(temp);
          }
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (null != br) {
        try {
          br.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if (null != is) {
        try {
          is.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      //关闭远程连接
      connection.disconnect();
    }
    JSONArray array = JSONArray.parseArray(result.toString());
    return "The most active developer's contributions is " + ((JSONObject) array.get(0)).get("contributions");
  }

}
