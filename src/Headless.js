import React, {NativeModules} from 'react-native';

export default class Headless {
  constructor() {
    //super();
  }

  toForeground() {
    return NativeModules.Headless.toForeground();
  }

  toBackground() {
    return NativeModules.Headless.toBackground();
  }
}
