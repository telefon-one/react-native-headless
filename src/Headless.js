import React, {NativeModules} from 'react-native';

export default class Headless {
  constructor() {
    //super();
  }

  startService() {
    console.log(NativeModules);
    console.log(NativeModules.HeadlessModule);
    console.log(NativeModules.HeadlessModule.startService);
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
