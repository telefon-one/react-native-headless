import React, {NativeModules} from 'react-native';

export default class Headless {
  constructor() {
    //super();
  }

  startService() {
    return NativeModules.HeadlessModule.startService();
  }

  stopService() {
    return NativeModules.HeadlessModule.stopService();
  }

  toForeground() {
    return NativeModules.HeadlessModule.toForeground();
  }

  toBackground() {
    return NativeModules.HeadlessModule.toBackground();
  }
}
