package com.example.demo.control;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
@RequestMapping("/cpp")
public class cpp {
  @RequestMapping("/issues")
  public JSONArray issues() throws IOException {
    String url1 = "https://api.github.com/repos/msgpack/msgpack-c/issues";

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
    return JSONArray.parseArray(result.toString());

//    String pretty = JSON.toJSONString(result.toString(), SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
//        SerializerFeature.WriteDateUseDateFormat);
//    return pretty;
//        int i = 1;
//        while (i==0){
//
//        }
//        for (int i = 0; i < 9; i ++) {
//            String command = "gh api repos/kubernetes-client/javascript/commits?state=all\"&\"page="+i+"\"&\"per_page=100 | Out-File -Append C:\\\\Users\\\\26227\\\\Desktop\\\\commitsjs11.json";
//            PowerShell.executeSingleCommand(command);
//        }
//        Execute a command in PowerShell session

    //Print results

  }

  @RequestMapping("/commits")
  public JSONArray commits() throws IOException {
    String url1 = "https://api.github.com/repos/msgpack/msgpack-c/commits";

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
    return JSON.parseArray(result.toString());

  }

  @RequestMapping("/contributors")
  public JSONArray contributors() throws IOException {
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
    return JSONArray.parseArray(result.toString());


  }

  @RequestMapping("/releases")
  public JSONArray releases() throws IOException {
    String url1 = "https://api.github.com/repos/msgpack/msgpack-c/releases";

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
    return JSONArray.parseArray(result.toString());
  }
}