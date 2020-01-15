/**
 * @format
 */

import {AppRegistry} from 'react-native';
//import App from './App';
import {name as appName} from './app.json';

const store=null;

AppRegistry.registerHeadlessTask('HeadlessHandler', () => require('./src/event-handler.js').bind(null, store));

//AppRegistry.registerComponent(appName, () => App);
