# WsManager

基于okhttp封装的websocket操作库


## How to use

Maven:

```xml
<dependency>
  <groupId>com.okhttp.wsmanager</groupId>
  <artifactId>wsmanager</artifactId>
  <version>1.0.0</version>
  <type>pom</type>
</dependency>
```

or Gradle:

```groovy
compile 'com.okhttp.wsmanager:wsmanager:1.0.0'
```


创建一个WsManager实例:

```
OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                      .pingInterval(15, TimeUnit.SECONDS)
                      .retryOnConnectionFailure(true)
                      .build();
WsManager wsManager = new WsManager.Builder(this)
                .wsUrl("ws://localhost:2333/")
                .needReconnect(true)  //是否需要重连
                .client(okHttpClient)
                .setHeaders(null)    //设置请求头
                .setReconnnectInterval(10*1000)  //设置重连步长(ms)
                .setReconnnectIMaxTime(120*1000) //设置重连最大时长
                .build();
```

建立连接:

```
wsManager.startConnect();
```

监听服务端的连接状态以及消息的回调:

```
wsManager.setWsStatusListener(new WsStatusListener() {
            @Override
            public void onOpen(Response response) {
                super.onOpen(response);
            }

            @Override
            public void onMessage(String text) {
                super.onMessage(text);
            }

            @Override
            public void onMessage(ByteString bytes) {
                super.onMessage(bytes);
            }

            @Override
            public void onReconnect() {
                super.onReconnect();
            }

            @Override
            public void onClosing(int code, String reason) {
                super.onClosing(code, reason);
            }

            @Override
            public void onClosed(int code, String reason) {
                super.onClosed(code, reason);
            }

            @Override
            public void onFailure(Throwable t, Response response) {
                super.onFailure(t, response);
            }
        });
```

发送消息给服务端:

```
//String msg or ByteString byteString
wsManager.sendMessage();
```

关闭服务端的连接:

```
wsManager.stopConnect();
```


