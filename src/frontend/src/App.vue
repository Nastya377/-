<template>
  <div>
    <!------------------------------------------------------------------------------- -->
    <!------------------------------------------------------------------------------- -->  
    <!--side bar -->
    <div>
      <SidebarMenuAkahon 
        :profileImg="$store.state.menu.image" 
        :profileName="$store.state.menu.name" 
        :profileRole="$store.state.menu.role"
        :isExitButton="$store.state.menu.button" 
        :menuItems="$store.state.menu.items " />
    </div>  
    <!------------------------------------------------------------------------------- -->
    <!------------------------------------------------------------------------------- -->  
    <router-view />
  

  <app-footer v-show="this.$store.state.showFooter" />
  
  <HelloWorld v-if="false"/>  
  </div>
</template>

<script>


import SidebarMenuAkahon from "./components/Sidebar-menu-akahon.vue"
import HelloWorld from './components/HelloWorld.vue'

import AppFooter from './components/smallComponents/Footer.vue'

export default {  
  name: 'App',
  
  components: {
    HelloWorld,
    SidebarMenuAkahon,
    AppFooter
  },
  /////------------------------------------------------------------------------------------------------------------------------------------
  /////------------------------------------------------------------------------------------------------------------------------------------
  //data
  data() {
    return {
      debug_mode: true,
      //переменные для корректного отбражения страницы
      markers: {
        allowSw: [
        ],
        allowPages: [
          'Login',
          "About",
          "News",
          "Home",
          "Profile",
          //"board",
          "Dashboard",
          "Settings",
          "SettingsAdmin"
          //"ProfessionsEdit",
          //"SalaryDataEdit"
        ],
      },

      jsonData: "",

     }

  },

  /////------------------------------------------------------------------------------------------------------------------------------------
  /////------------------------------------------------------------------------------------------------------------------------------------
  //methods
  methods: {
    updatePage () {
      this.menuUser()
      this.$store.commit("buildMenuPanel")
    },
    
    menuUser () {
      console.log(this.loged); 
      let STR = this.$store.state
      if (this.$store.state.markers.logged) {
        if (!STR.markers.image) {
            STR.menu.image = require('./assets/noimage.png');
          }else{
            STR.menu.image = STR.markers.image
          }
        if (STR.aboutUser.firstName || STR.aboutUser.secName){
          STR.menu.name = STR.markers.aboutUser.firstName + '  ' + STR.markers.aboutUser.secName
        }else{
          STR.menu.name = STR.markers.user.username;
        }
        if (STR.aboutUser.typeOfacc < STR.accontsType.length){ 
          STR.menu.role = STR.accontsType[STR.aboutUser.typeOfacc].name
        }else{
          STR.menu.role = STR.accontsType[0].name
        }

         STR.menu.button = true;
      }else{
        STR.menu.image = '';
        STR.menu.name = 'Ой а вы кто?';
        STR.menu.role = 'Вход/Регистрация';
        STR.menu.button = false;
      }
    },
  
  
    //------------------------------------------------------------------------
    sendDataToServer (url = '', data = null,func, method = "POST") {
      var xhr = new XMLHttpRequest();
      xhr.onreadystatechange =  () => {
        if (xhr.status == 200 && xhr.readyState === 4) {
          if (func) {
            func(JSON.parse(xhr.responseText))
          }
          this.jsonData = xhr.responseText
        }else {
          if (![200,0].includes(xhr.status)){
            console.log("assec to server:"+  xhr.status)
          } 
        }  
      }
      xhr.open(method,"/api"+url, true);
      xhr.send(JSON.stringify(data));
    },
    //------------------------------------------------------------------------ 
  

  switchPage () {
    console.group("user")
    console.log(this.loged)
    console.log(this.$store.state.markers.user.username)
    console.log(this.$store.state.markers.user.password)
    console.groupEnd()
    this.updatePage()
    if (this.$store.state.markers.logged) {
      if (this.$store.state.markers.ftm){
        this.loginButton("User");
      }else{
        this.loginButton("MainPage")
      }
   }else{
     this.$store.state.markers.pageStat = this.markers.allowSw[0]
   }
  },

  loginButton(data) {
    if (this.markers.allowPages.includes(data)){
      this.markers.pageStat = data;
      return this.$router.push(`/${data}`) 
    }else if (data == "MainPage") {
       this.markers.pageStat = data;
      return this.$router.push('/')//location.href= `/`
    } 
    //this.sendDataToServer("/examples/echo",{wrong:"dfg",gf:"456"})
  },

  },
  /////------------------------------------------------------------------------------------------------------------------------------------
  /////------------------------------------------------------------------------------------------------------------------------------------
  ///computed
  computed: {
    loged () {
      return this.$store.state.markers.logged
    }
  },
  mounted () {
    this.updatePage ()
  }

}


</script>

<style>
.login-page-cenry {
  display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    font-family: 'Montserrat', sans-serif;
    height: 100vh;
    margin: -20px 0 50px;
}


#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

.slider-class-kebab {
  width: 75px;
  
}


</style>
