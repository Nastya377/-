<template>
  <div class="py-4 container-fluid">
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
  
    <div class="card-body p-3">
    <div class="row">
      <div class="col-xl-3 col-sm-6 mb-xl-0 mb-4">
        <mini-statistics-card
          title="Сумма на карте"
          value="$53,000"
          :percentage="{
            value: '+505%',
            color: 'text-success',
          }"
          :icon="{
            component: 'ni ni-money-coins',
            background: iconBackground,
          }"
          direction-reverse
        />
      </div>
      <div class="col-xl-3 col-sm-6 mb-xl-0 mb-4">
        <mini-statistics-card
          title="Общее списание"
          value="2,300"
          :percentage="{
            value: '+3%',
            color: 'text-success',
          }"
          :icon="{
            component: ' ni ni-world',
            background: iconBackground,
          }"
          direction-reverse
        />
      </div>
      <!--<div class="col-xl-3 col-sm-6 mb-xl-0 mb-4">
        <mini-statistics-card
          title="New Clients"
          value="+3,462"
          :percentage="{
            value: '-2%',
            color: 'text-danger',
          }"
          :icon="{
            component: 'ni ni-paper-diploma',
            background: iconBackground,
          }"
          direction-reverse
        />
      </div>-->
      <div class="col-xl-3 col-sm-6 mb-xl-0">
        <mini-statistics-card
          title="Зарплата"
          value="$103,430"
          :percentage="{
            value: '+5%',
            color: 'text-success',
          }"
          :icon="{
            component: 'ni ni-cart',
            background: iconBackground,
          }"
          direction-reverse
        />
      </div>
    </div>
    </div>

    <div class="row">
      <div class="col-lg-7 mb-lg-0 mb-4">
        <div class="card">
          <span class="mask bg-gradient-dark"></span>
          <div class="card-body p-3">
            <div class="row">
              <div class="col-lg-6">
                <div class="d-flex flex-column h-100">
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
              <div class="col-lg-5 ms-auto text-center mt-5 mt-lg-0">
                <div class="bg-gradient-success border-radius-lg h-100">
                  <img
                    src="../../assets/img/shapes/waves-white.svg"
                    style="width:98%; height:250px; margin-right:0px"
                    class="position-absolute h-100 w-50 top-0 d-lg-block d-none"
                    alt="waves"
                  />
                  <div
                    class="position-relative d-flex align-items-center justify-content-center h-100"
                  >
                    <img
                      class="w-100 position-relative z-index-2 pt-4"
                      style="width:100%; height:250px; margin-right:0px"
                      src="../../assets/bank.png"
                      alt="rocket"
                    />
                  </div>
                </div>
              </div>

            </div>
          </div>
        </div>
      </div>
      <div class="col-lg-5">
        <div class="card h-100 p-3">
          <div>
            <span class="mask bg-gradient-dark"></span>
            <div class="card-body position-relative z-index-1 p-3 h-100">
              <div class="d-flex flex-column h-100">
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
          </div>
        </div>
      </div>
    </div>
    <div class="mt-4 row">
      <!--<div class="mb-4 col-lg-5 mb-lg-0">
        <div class="card z-index-2">
          <div class="p-3 card-body">
            <reports-bar-chart
              id="chart-bar"
              title="active Users"
              description="(<strong>+23%</strong>) than last week"
              :chart="{
                labels: [
                  'Apr',
                  'May',
                  'Jun',
                  'Jul',
                  'Aug',
                  'Sep',
                  'Oct',
                  'Nov',
                  'Dec',
                ],
                datasets: {
                  label: 'Sales',
                  data: [450, 200, 100, 220, 500, 100, 400, 230, 500],
                },
              }"
              :items="[
                {
                  icon: {
                    color: 'primary',
                    component: faUsers,
                  },
                  label: 'users',
                  progress: { content: '37K', percentage: 60 },
                },
                {
                  icon: { color: 'info', component: faHandPointer },
                  label: 'clicks',
                  progress: { content: '2m', percentage: 90 },
                },
                {
                  icon: { color: 'warning', component: faCreditCard },
                  label: 'Sales',
                  progress: { content: '435$', percentage: 30 },
                },
                {
                  icon: { color: 'danger', component: faScrewdriverWrench },
                  label: 'Items',
                  progress: { content: '43', percentage: 50 },
                },
              ]"
            />
          </div>
        </div>
      </div>-->
      <div class="mb-4 col-lg-5 mb-lg-0">
        <div class="card z-index-2">
          <p>Ваша карта</p>
          <div class="p-3 card-body">
            <master-card />
            </div>
        </div>
      </div>
      <div class="col-lg-7">
        <!-- line chart -->
        <div class="card z-index-2">
          <gradient-line-chart
            id="chart-line"
            title="Затраты с карты"
            description=""
            :chart="{
              labels: [
                'Apr',
                'May',
                'Jun',
                'Jul',
                'Aug',
                'Sep',
                'Oct',
                'Nov',
                'Dec',
              ],
              datasets: [
                {
                  label: 'Списание с карты на 2021',
                  data: [70, 35, 230, 380, 375, 250, 400, 230, 500],
                },
                {
                  label: 'Списание с карты на 2022',
                  data: [30, 90, 40, 30, 290, 200, 340, 230, 400],
                },
              ],
            }"
          />
        </div>
      </div>
    </div>

    
    <!--<div class="col-lg-8">
         <div class="col-md-12 mb-4">
            <payment-methods-card />
          </div>
        </div>-->
    <div class="row my-4">
      <div class="col-md-5 mt-4">
        <ranking-list-card
          :horizontal-break="false"
          :card="{
            title: 'Переводы',
            date: '2022',
            subtitle: '',
          }"
          :item="[
            {
              title: 'Алми',
              date: '03 May 2022, at 11:30 PM',
              amount: '- $ 1,300',
              icon: 'fa-arrow-down',
              color: 'danger',
            },
            {
              title: '5 элемент',
              date: '02 May 2022, at 15:18 AM',
              amount: '- $ 2,700',
              icon: 'fa-arrow-up',
              color: 'danger',
            },
          ]"
        >
          <ranking-list
            title="Прошлая неделя"
            :item="[
              {
                title: 'Альфа-банк',
                date: '29 May 2022, at 13:45 PM',
                amount: '+ $ 750',
                icon: 'fa-arrow-up',
                color: 'success',
              },
              {
                title: 'Zephyrmobile',
                date: '28 May 2022, at 12:30 PM',
                amount: '+ $ 1,000',
                icon: 'fa-arrow-up',
                color: 'success',
              },
              {
                title: 'Кафе Диалог',
                date: '28 May 2022, at 08:30 AM',
                amount: '- $ 2,500',
                icon: 'fa-arrow-up',
                color: 'danger',
              },
              
            ]"
            :horizontal-break="false"
          />
        </ranking-list-card>
      </div>
      <!--<div class="col-lg-8 col-md-6 mb-md-0 mb-4">
       <projects-card />
      </div>
      <div class="col-lg-4 col-md-6">
        <timeline-list
          class="h-100"
          title="Orders overview"
          description="<i class='fa fa-arrow-up text-success' aria-hidden='true'></i>
        <span class='font-weight-bold'>24%</span> this month"
        >
          <timeline-item
            color="success"
            icon="bell-55"
            title="$2400 Design changes"
            date-time="22 DEC 7:20 PM"
          />
          <TimelineItem
            color="danger"
            icon="html5"
            title="New order #1832412"
            date-time="21 DEC 11 PM"
          />
          <TimelineItem
            color="info"
            icon="cart"
            title="Server payments for April"
            date-time="21 DEC 9:34 PM"
          />
          <TimelineItem
            color="warning"
            icon="credit-card"
            title="New card added for order #4395133"
            date-time="20 DEC 2:20 AM"
          />
          <TimelineItem
            color="primary"
            icon="key-25"
            title="Unlock packages for development"
            date-time="18 DEC 4:54 AM"
          />
          <TimelineItem
            color="info"
            icon="check-bold"
            title="Notifications unread"
            date-time="15 DEC"
          />
        </timeline-list>
      </div>-->
      
    </div>
  </div>
</template>
<script>
import MiniStatisticsCard from "./examples/Cards/MiniStatisticsCard.vue";
import MasterCard from "./examples/Cards/MasterCard.vue";
import ProfileInfoCard from './smallComponents/ProfileInfoCard.vue';
import ProfileWorkCard from './smallComponents/ProfileWorkCard.vue';
import RankingList from "./examples/Cards/RankingList.vue";
import RankingListCard from "./examples/Cards/RankingListCard.vue";
//import PaymentMethodsCard from "./smallComponents/PaymentMethodsCard.vue";
//import ReportsBarChart from "./examples/Charts/ReportsBarChart.vue";
import GradientLineChart from "./examples/Charts/GradientLineChart.vue";
//import TimelineList from "./smallComponents/TimelineList.vue";
//import TimelineItem from "./smallComponents/TimelineItem.vue";
//import ProjectsCard from "./smallComponents/ProjectsCard.vue";
/*import US from "@/assets/img/icons/flags/US.png";
import DE from "@/assets/img/icons/flags/DE.png";
import GB from "@/assets/img/icons/flags/GB.png";
import BR from "@/assets/img/icons/flags/BR.png";
/**
import {
  faHandPointer,
  faUsers,
  faCreditCard,
  faScrewdriverWrench,
} from "@fortawesome/free-solid-svg-icons";*/
export default {
  name: "dashboard-default",
  /*data() {
    return {
      iconBackground: "bg-gradient-success",
   //   faCreditCard,
   //   faScrewdriverWrench,
   //   faUsers,
   //   faHandPointer,
      sales: {
        us: {
          country: "United States",
          sales: 2500,
          value: "$230,900",
          bounce: "29.9%",
          flag: US,
        },
        germany: {
          country: "Germany",
          sales: "3.900",
          value: "$440,000",
          bounce: "40.22%",
          flag: DE,
        },
        britain: {
          country: "Great Britain",
          sales: "1.400",
          value: "$190,700",
          bounce: "23.44%",
          flag: GB,
        },
        brasil: {
          country: "Brasil",
          sales: "562",
          value: "$143,960",
          bounce: "32.14%",
          flag: BR,
        },
      },
    };
  },*/
  components: {
    MiniStatisticsCard,
    ProfileInfoCard,
    ProfileWorkCard,
    MasterCard,
    RankingList,
    RankingListCard,
    //PaymentMethodsCard,
    //ReportsBarChart,
    GradientLineChart,
    //ProjectsCard,
    //TimelineList,
    //TimelineItem,
  },
};
</script>
