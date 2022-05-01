
import { createRouter, createWebHistory } from "vue-router";
//import store from "../store";

import Login from "../components/pages/LoginPage.vue"
import About from '../components/pages/About.vue'
import News from '../components/pages/News.vue'
import Home from '../components/pages/Home.vue'
import Profile from '../components/pages/Profile.vue'
//import Billing from "../components/pages/Billing.vue"
import Dashboard from "../components/pages/Dashboard.vue"
import Settings from "../components/pages/Settings.vue"
import SettingsAdmin from "../components/pages/SettingsAdmin.vue"
import ProfessionsEdit from "../components/pages/edit/ProfessionsEdit.vue"
import SalaryDataEdit from "../components/pages/edit/SalaryDataEdit.vue"
import store from "../store";

const routes = [
    {
      path: "/Home",
      name: "/",
      redirect: "/",
    },

    {
      path: "/",
      name: "/",
      component: Home,
    },
    {
      path: "/About",
      name: "About",
      component: About,
    },

    {
      path: "/News",
      name: "News",
      component: News,
    },
    {
      path: "/Login",
      name: "login",
      component: Login,
    },
    
    {
      path: "/profile",
      name: "Profile",
      component: Profile,
      meta: {logged:true}
    },
    /*{
      path: "/board",
      name: "billing",
      component: Billing,
      meta: {logged:true}
    },*/
    {
      path: "/dashboard",
      name: "dashboard",
      component: Dashboard,
      meta: {logged:true , blocked: true}
    },
    {
      path: "/settings",
      name: "settings",
      component: Settings,
      meta: {logged:true}
    },
    {
      path: "/SettingsAdmin",
      name: "setting",
      component: SettingsAdmin,
      meta: {logged:true , blocked: true}
    },
    {
      path: "/ProfessionsEdit",
      name: "editp",
      component: ProfessionsEdit,
      meta: {logged:true , blocked: true}
    },
    {
      path: "/SalaryDataEdit",
      name: "edits",
      component: SalaryDataEdit,
      meta: {logged:true , blocked: true}
    },
  ];
  
  const router = createRouter({
    mode: "history",
    history: createWebHistory(process.env.BASE_URL),
    routes,
    linkActiveClass: "active",
  });

  router.beforeEach((to, from, next) => {
    if (to.matched.some(record => record.meta.blocked)){
      return next("/");
    }
    if (to.matched.some(record => record.meta.logged)) {
      if (store.state.markers.logged) {
          if (to.matched.some(record => record.meta.lvl <= store.state.aboutUser.typeOfacc)){
            return next("/");
          }
          next();
        } else{
          next("/Login")
        }  
    } else {
        next();
    }
  })
  export default router;