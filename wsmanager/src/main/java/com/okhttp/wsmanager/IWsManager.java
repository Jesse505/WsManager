package com.okhttp.wsmanager;

import okhttp3.WebSocket;
import okio.ByteString;

/**
 * @author Jesse
 */

interface IWsManager {

  WebSocket getWebSocket();

  void startConnect();

  void stopConnect();

  boolean isWsConnected();

  int getCurrentStatus();

  void setCurrentStatus(int currentStatus);

  boolean sendMessage(String msg);

  boolean sendMessage(ByteString byteString);
}
