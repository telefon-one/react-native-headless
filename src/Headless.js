import React, {NativeModules} from 'react-native';

export default class Headless {
  constructor() {
    //super();
  }

  startService() {
    return NativeModules.Headless.startService();
  }

  stopService() {
    return NativeModules.Headless.stopService();
  }

  toForeground() {
    return NativeModules.Headless.toForeground();
  }

  toBackground() {
    return NativeModules.Headless.toBackground();
  }
}
