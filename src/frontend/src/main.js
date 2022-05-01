import { createApp } from 'vue'
import App from './App.vue'

import PageUI from "./page-iu";

import "./assets/css/nucleo-icons.css";
import "./assets/css/nucleo-svg.css";

import router from "./router"
import store from "./store";

const MyApp = createApp(App)
MyApp.use(store);
MyApp.use(router)
MyApp.use(PageUI)
MyApp.mount('#app')
