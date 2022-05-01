<template>
  <div>
  <div class="container-fluid">
    <div
      class="mt-4 page-header min-height-300 border-radius-xl"
      :style="{
        backgroundImage:
          'url(' + require('@/assets/img/curved-images/curved14.jpg') + ')',
        backgroundPositionY: '50%',
      }"
    >
      <span class="mask bg-gradient-success opacity-6"></span>
    </div>
    <div class="mx-4 overflow-hidden card card-body blur shadow-blur mt-n6">
      <div class="row gx-4">
        <div class="col-auto">
          <div class="avatar avatar-xl position-relative">
            <img
              src="@/assets/img/noimage.png"
              style="width:98%; height:200px; margin-right:0px"
              alt="profile_image"
              class="shadow-sm w-100 border-radius-lg"
            />
          </div>
        </div>
        <div class="col-auto my-auto">
          <div class="h-100">
            <h5 class="mb-1">{{this.$store.state.markers.user.username}}</h5>
          </div>
        </div>
        <div
          class="mx-auto mt-3 col-lg-4 col-md-6 my-sm-auto ms-sm-auto me-sm-0"
        >
          <div class="nav-wrapper position-relative end-0">
            <ul
              class="p-1 bg-transparent nav nav-pills nav-fill"
              role="tablist"
            >
          
            </ul>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="py-4 container-fluid">
    <div class="mt-3 row">
      <div class="col-12 col-md-6 col-xl-4">
        <div class="card h-100">
        <profile-work-card
          title="Место работы"
          :info="{
            position: this.$store.state.aboutUser.position_selected,
            telefoncomp: this.$store.state.aboutUser.telefoncomp,
            locationcom: this.$store.state.aboutUser.locationcom,
          }"
          :action="{
            route: 'javascript:;',
            tooltip: 'Edit Profile',
          }"
        />
        
          
        </div>
      </div>
      
      <div class="mt-4 col-12 col-md-6 col-xl-4 mt-md-0">
        <profile-info-card
          title="Личная информация"
          :info="{
            fullName: this.$store.state.aboutUser.secName,
            mobile: this.$store.state.aboutUser.telefon,
            email: this.$store.state.aboutUser.email,
            location: this.$store.state.aboutUser.location,
          }"
          :action="{
            route: 'javascript:;',
            tooltip: 'Edit Profile',
          }"
        />
        
      </div>
              
    </div>
    
  </div>
  </div>
</template>

<script>
//import VsudSwitch from "./globalComponent/VsudSwitch.vue";
import ProfileInfoCard from './smallComponents/ProfileInfoCard.vue';
import ProfileWorkCard from './smallComponents/ProfileWorkCard.vue';
//import VsudAvatar from "./globalComponent/VsudAvatar.vue";
import marie from "@/assets/img/marie.jpg";
import ivana from "@/assets/img/ivana-square.jpg";
import peterson from "@/assets/img/team-4.jpg";
import nick from "@/assets/img/team-3.jpg";
import img1 from "@/assets/img/home-decor-1.jpg";
import img2 from "@/assets/img/home-decor-2.jpg";
import img3 from "@/assets/img/home-decor-3.jpg";
import team1 from "@/assets/img/team-1.jpg";
import team2 from "@/assets/img/team-2.jpg";
import team3 from "@/assets/img/team-3.jpg";
import team4 from "@/assets/img/team-4.jpg";
import {
  faFacebook,
  faTwitter,
  faInstagram,
} from "@fortawesome/free-brands-svg-icons";
//import DefaultProjectCard from "./smallComponents/DefaultProjectCard.vue";
//import PlaceHolderCard from "./examples/Cards/PlaceHolderCard.vue";
import setNavPills from "@/assets/js/nav-pills.js";
import setTooltip from "@/assets/js/tooltip.js";

export default {
  name: "ProfileOverview",
  components: {
    
    //VsudSwitch,
    ProfileInfoCard,
    ProfileWorkCard,
    //VsudAvatar,
    //DefaultProjectCard,
    //PlaceHolderCard,
  },
  data() {
    return {
      showMenu: false,
      marie,
      ivana,
      peterson,
      nick,
      img1,
      team1,
      team2,
      team3,
      team4,
      img2,
      img3,
      faFacebook,
      faTwitter,
      faInstagram,
    };
  },

  mounted() {
    this.$store.state.isAbsolute = true;
    setNavPills();
    setTooltip(this.$store.state.bootstrap);
  },
  beforeUnmount() {
    this.$store.state.isAbsolute = false;
  },
};
</script>
