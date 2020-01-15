/**
 * @format
 */

import {AppRegistry} from 'react-native';
import React from 'react';
import App from './App';
import {name as appName} from './app.json';
//import {Headless} from 'react-native-headless';
import { store } from './src/store';


import { Provider } from 'react-redux';

const RNRedux = () => (
    <Provider store={store}>
      <App />
    </Provider>
  );


AppRegistry.registerHeadlessTask('HeadlessHandler', () => require('./src/event-handler.js').bind(null, store));
AppRegistry.registerComponent(appName, () => RNRedux);
//AppRegistry.registerComponent(appName, () => App);