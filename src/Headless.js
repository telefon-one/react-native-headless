import React, {NativeModules} from 'react-native';

const { Headless } = NativeModules;

export default Headless;

/*
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
*/