import { createStore } from "vuex";
import bootstrap from "bootstrap/dist/js/bootstrap.min.js";
import router from '@/router'


export default createStore({
  


  state: {
    debug_mode: true,
  //переменные для корректного отбражения страницы
    markers: {
      pageStat: "MainPage",
      logged: false,
      user: {
        username: '',
        password: '',
      },
      ftm: null,
      image: undefined,
    },

    menu: {
      image: "",
        name: 'Ой а вы кто?',
        role: 'Я тут посмотреть "кЛиК"',
        button: false,
      items: [
        {
        link: 'MainPage',
          name: 'Главная',
          tooltip: 'Dashboard',
          icon: 'bx-grid-alt',
        },
        {
          link: 'News',
            name: 'Новости',
            tooltip: 'News',
            icon: 'bx-receipt',
        },
          {
          link: 'About',
          name: 'О нас',
          tooltip: 'AboutUs',
          icon: 'bx-group',
        },
      ]
    },

    aboutUser: {
      firstName: "",
      secName: "",
      thirdName: "",
      location: "",
      email: "",
      telefon: 0,

      telefoncomp: 0,
      card: "",
      locationcom: "",
      position_selected: "",
      typeOfacc: 0,
      fullName: '',
      role: "",


      sum_card: 130,
      sum_salary: 130
    },
    
    accontsType: [
      {
        name: "Пользователь",
        addins: [],
      },
    ],





    //dashboard
    hideConfigButton: false,
    isPinned: true,
    showConfig: false,
    isTransparent: "",
    isRTL: false,
    color: "",
    isNavFixed: false,
    isAbsolute: false,
    showNavs: true,
    showSidenav: true,
    showNavbar: true,
    showFooter: true,
    showMain: true,
    navbarFixed:
      "position-sticky blur shadow-blur left-auto top-1 z-index-sticky px-0 mx-4",
    absolute: "position-absolute px-4 mx-0 w-100 z-index-2",
    bootstrap,
  },
  mutations: {
    logout (state) {
      
      state.markers.user.username = '';
      state.markers.user.password = '';
      state.markers.logged = false;
      
      state.aboutUser.role = "";
      state.aboutUser.secName = '';
      state.aboutUser.firstName = '';
      state.aboutUser.thirdName = '';
      state.aboutUser.email = '';
      state.aboutUser.telefon = 0;
      state.aboutUser.location = '';

      state.aboutUser.locationcom = '';
      state.aboutUser.position_selected = '';
      state.aboutUser.telefoncomp = 0;
      state.aboutUser.card = 0;

      
      state.aboutUser.sum_card = 130;
      state.aboutUser.sum_salary = 130;
      
      state.aboutUser.typeOfacc = 0;

      
      router.push('/')
      
    },

    buildMenuPanel (state) {
      let menuItems = state.menu.items

      var user =  {
        link: 'Profile',
        name: 'Личная информация',
        tooltip: 'Profile',
        icon: 'bx-user',
      }
      /*let infocard = {
        link: 'board',
        name: 'Хто я',
        tooltip: 'user',
        icon: 'bx-id-card',
      }*/
      let settings = {
        link: 'Settings',
        name: 'Настройки',
        tooltip: 'Setting',
        icon: 'bx-cog',
      };
      let collected = {
        link: 'Dashboard',
        name: 'Обзор',
        tooltip: 'dashboard',
        icon: 'bx-right-indent',
      };
      let settingsadmin = {
        link: 'SettingsAdmin',
        name: 'Настройка',
        tooltip: 'SettingsAdmin',
        icon: 'bx-coin-stack',
      };
      /*let editprofessions = {
        link: 'ProfessionsEdit',
        name: 'Редактирование',
        tooltip: 'ProfessionsEdit',
        icon: 'bx-coin-stack',
      };
      let editsalary = {
        link: 'SalaryDataEdit',
        name: 'Редактирование',
        tooltip: 'SalaryDataEdit',
        icon: 'bx-coin-stack',
      };*/


      let usrr = menuItems.findIndex(i => i.link === user.link)
      let sett = menuItems.findIndex(i => i.link === settings.link)
      //let inf = menuItems.findIndex(i => i.link === infocard.link)
      let col = menuItems.findIndex(i => i.link === collected.link)
      let setti = menuItems.findIndex(i => i.link === settingsadmin.link)
      //let editprof = menuItems.findIndex(i => i.link === editprofessions.link)
      //let editsal = menuItems.findIndex(i => i.link === editsalary.link)
      
      if (state.markers.logged) {
          if (col == -1) menuItems.splice(1,0,collected)
          //if (inf == -1) menuItems.splice(1,0,infocard)
          if (usrr == -1) menuItems.splice(1,0,user)
          if (sett == -1) menuItems.splice(menuItems.length-1,0,settings)
          if (setti == -1) menuItems.splice(menuItems.length-1,0,settingsadmin)
          //if (editprof == -1) menuItems.splice(menuItems.length-1,0,editprofessions)
          //if (editsal == -1) menuItems.splice(menuItems.length-1,0,editsalary)
        }else {
          col = menuItems.findIndex(i => i.link === collected.link)
          if (col != -1) menuItems.splice(col,1)
          
          usrr = menuItems.findIndex(i => i.link === user.link)
          if (usrr != -1) menuItems.splice(usrr,1)
          
          sett = menuItems.findIndex(i => i.link === settings.link)
          if (sett != -1) menuItems.splice(sett,1)
          
          /*inf = menuItems.findIndex(i => i.link === infocard.link)
          if (inf != -1) menuItems.splice(inf,1)*/

          setti = menuItems.findIndex(i => i.link === settingsadmin.link)
          if (setti != -1) menuItems.splice(setti,1)

          //editprof = menuItems.findIndex(i => i.link === editprofessions.link)
          //if (editprof != -1) menuItems.splice(editprof,1)
          
          //editsal = menuItems.findIndex(i => i.link === editsalary.link)
          //if (editsal != -1) menuItems.splice(editsal,1)
  
        }
      state.menu.items = menuItems;
    },

    saveUser (state, userData,logged = true) {
      state.markers.user.username = userData.username
      state.markers.user.password = userData.password
      state.markers.logged = logged;

      state.aboutUser.firstName = userData.firstname
      state.aboutUser.secName = userData.secondname
      state.aboutUser.typeOfacc = userData.userType | 0

      state.markers.ftm = userData.ftm
    },



    //-----------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------
    toggleConfigurator(state) {
      state.showConfig = !state.showConfig;
    },
    navbarMinimize(state) {
      const sidenav_show = document.querySelector(".g-sidenav-show");
      if (sidenav_show.classList.contains("g-sidenav-hidden")) {
        sidenav_show.classList.remove("g-sidenav-hidden");
        sidenav_show.classList.add("g-sidenav-pinned");
        state.isPinned = true;
      } else {
        sidenav_show.classList.add("g-sidenav-hidden");
        sidenav_show.classList.remove("g-sidenav-pinned");
        state.isPinned = false;
      }
    },
    sidebarType(state, payload) {
      state.isTransparent = payload;
    },
    cardBackground(state, payload) {
      state.color = payload;
    },
    navbarFixed(state) {
      if (state.isNavFixed === false) {
        state.isNavFixed = true;
      } else {
        state.isNavFixed = false;
      }
    },
    toggleEveryDisplay(state) {
      state.showNavbar = !state.showNavbar;
      state.showSidenav = !state.showSidenav;
      state.showFooter = !state.showFooter;
    },
    toggleHideConfig(state) {
      state.hideConfigButton = !state.hideConfigButton;
    },
  },

  actions: {
    SAVE_USER({ commit },userData,logged){
      commit('saveUser',userData,logged)
    },
    toggleSidebarColor({ commit }, payload) {
      commit("sidebarType", payload);
    },
    setCardBackground({ commit }, payload) {
      commit("cardBackground", payload);
    },
  },

  
});
