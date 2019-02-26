# WsManager

A library that simplifies the use of OkHttp Websocket.

For more information, please see:


## How to use

Instantiate a WsManager object:

```
OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                      .pingInterval(15, TimeUnit.SECONDS)
                      .retryOnConnectionFailure(true)
                      .build();
WsManager wsManager = new WsManager.Builder(this)
                .wsUrl("ws://localhost:2333/")
                .needReconnect(true)
                .client(okHttpClient)
                .build();
```

Establish a connection with the server:

```
wsManager.startConnect();
```

Listens for server connection status:

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

Send message to the server:

```
//String msg or ByteString byteString
wsManager.sendMessage();
```

Close the connection to the server:

```
wsManager.stopConnect();
```


