<template>
  <div class="form-container sign-up-container">
    <form method="POST" action="#" class="form" id="register">
      <img class="sticky" src="@/assets/img/noimage.png" style="width:250px; height:300px; margin-right:0px" alt="Men">
       <div class="row">
         <h3>{{this.$store.state.markers.user.username}}</h3>
       </div>
      <div class="row">
        <div class="col-50" style="padding-left: 30px">
          <h3>Личная информация</h3>
          <label for="fname"><i class="fa fa-user"></i>Фамилия</label>
          <input type="text" name="fname" id="fname" v-model="this.$store.state.aboutUser.firstName"> 

          <label for="name"><i class="fa fa-user"></i>Имя</label>
          <input type="text" id="name" name="name" v-model="this.$store.state.aboutUser.secName">

          <label for="patronymic"><i class="fa fa-user"></i>Отчество</label>
          <input type="text" id="patronymic" name="patronymic" v-model="this.$store.state.aboutUser.thirdName">

          <label for="email"><i class="fa fa-envelope"></i> Email</label>
          <input type="text" id="email" name="email" v-model="this.$store.state.aboutUser.email">
          
          <label for="phone"><i class="fa fa-user"></i>Телефон</label>
          <input type="text" id="phone" name="phone" v-model="this.$store.state.aboutUser.telefon">

          <label for="location"><i class="fa fa-address-card-o"></i> Адрес</label>
          <input type="text" id="location" name="location" v-model="this.$store.state.aboutUser.location">

         
        </div>

        <div class="col-50" style="padding-right: 30px">
          <h3>Место работы</h3>
          <label for="address"><i class="fa fa-user"></i>Адрес места работы</label>
          <input type="text" id="address" name="address" v-model="this.$store.state.aboutUser.locationcom">

          <label for="telkom"><i class="fa fa-user"></i>Телефон компании</label>
          <input type="text" id="telkom" name="telkom" v-model="this.$store.state.aboutUser.telefoncomp">
          
          <label for="position"><i class="fa fa-user"></i>Должность</label>
          <!--<input type="text" id="position" name="position" v-model="position" placeholder="Директор">
-->
          <select name="position" id="position" style="width: 100%; height:50px" v-model="this.$store.state.aboutUser.position_selected">
            <option v-for="option in position" :key="option.text" :value="option.value" >
              {{ option.text }}
            </option>
          </select>

          <div class="row">
            <div class="col-50">
              <h3>Данные расчетов</h3>

              <label for="card_account"><i class="fa fa-user"></i>Карт счет</label>
              <input type="text" id="card_account" name="card_account" v-model="this.$store.state.aboutUser.card" maxlength="20">

              
            </div>
          </div>
        </div>

      </div>

      <input type="button" v-on:click ="send()" value="Нажмите для подтверждения" class="btn">
    </form>
  </div>
</template>


<script>
export default {
  name: 'Settings',
    props: {
        debug: {
            type: Boolean,
            default: false
        }
    },

 data() {
    return {
      valutes: 0,
        firstName: "",
        secName : "",
        thirdName: "",
        email : "", 
        location : "",
        phone: 0,

        locationcom: "",
        telefoncomp: 0,
        position_selected:"",
        position: [
        { text: 'Один', value: 'A' },
        { text: 'Два', value: 'B' },
        { text: 'Три', value: 'C' }
      ],
        telkom: "",
        card: "",

    }
  },

  methods: {
    parseInData (insideData) {
      if (insideData){
        console.log(insideData)
        if (typeof insideData == 'object'){
          if (insideData.username){
            if (insideData.error == 1){        
              if (insideData.wrong == 200) {
                this.$store.state.aboutUser.firstName = insideData.firstName
                this.$store.state.aboutUser.secName = insideData.secName
                this.$store.state.aboutUser.thirdName = this.thirdName
                //this.$store.state.aboutUser.phone = this.phone;
                
              }    
              //TODO: write some more
            }    
          }
        } 
      }
    },


      send : function () {
        console.log (this.string)
          this.$parent.$parent.sendDataToServer('/updateuser/manually',this.string,this.parseInData)
      },
  },
  mounted() {
        
  },
  computed : {
    string  () {
      return {
        username: this.$store.state.markers.user.username,
        password: this.$store.state.markers.user.password,

        firstName: this.$store.state.aboutUser.firstName,
        secName: this.$store.state.aboutUser.secName,
        thirdName: this.$store.state.aboutUser.thirdName,
        email: this.$store.state.aboutUser.email,
        location : this.$store.state.aboutUser.location, 
        phone : this.$store.state.aboutUser.telefon,

        locationcom: this.$store.state.aboutUser.locationcom,
        position: this.$store.state.aboutUser.position,
        telefoncomp: this.$store.state.aboutUser.telefoncomp,
        card: this.$store.state.aboutUser.card,
        position_selected: this.$store.state.aboutUser.position_selected,
      }
    }
  }
}   
</script>








<style scoped>
  
  .container{
    position: -webkit-sticky;
    position: sticky;
    top: 0;
    display: flex;
    flex-wrap: wrap;
  }
  .main {
    overflow: hidden;
    position: fixed;
    top: 0;
    width: 100%;
    background-color: #f1f1f1;
  }

  .main a {
    float: left;
    color: black;
    text-align: left;
    padding: 12px;
    text-decoration: none;
    font-size: 18px;
    line-height: 25px;
    border-radius: 4px;
  }

  .main a.cabinet {
    font-size: 25px;
    font-weight: bold;
  }

  .main a:hover {
    background-color: #ddd;
    color: black;
  }

  .main a.active {
    background-color: #ff416c;
    color: white;
  }

  .main-right {
    float: right;
  }


  img.sticky {
    align: justify;
    padding-top: 60px;
    top: 500px;
    width: 250px;
  }





  * {
    box-sizing: border-box;
  }

  .row {
    display: -ms-flexbox; /* IE10 */
    display: flex;
    -ms-flex-wrap: wrap; /* IE10 */
    flex-wrap: wrap;
    margin: 0 -16px;
  }

  .col-50 {
    -ms-flex: 50%; /* IE10 */
    flex: 50%;
    padding: 0 16px;
  }

  input[type=text] {
    width: 100%;
    margin-bottom: 20px;
    padding: 12px;
    border: 1px solid #ccc;
    border-radius: 3px;
  }

  .position {
    width: 100%;
    margin-bottom: 20px;
    padding: 12px;
    border: 1px solid #ccc;
    border-radius: 3px;
  }

  label {
    margin-bottom: 10px;
    display: block;
  }

  .btn {
    background-color: #e41515;
    color: white;
    padding: 12px;
    margin: 10px 0;
    border: none;
    width: 100%;
    border-radius: 3px;
    cursor: pointer;
    font-size: 17px;
  }

  .btn:hover {
    background-color: #920b0b;
  }


  .user {
    width: 308px; /* Ширина поля с учетом padding */
    height: 30px; /* Высота */
    padding: 0 10px; /* Поля */
    border: none; /* Убираем рамку */
    font-size: 1em; /* Размер текста */
    line-height: 46px; /* Выравниваем по  центру в IE */
  }

</style>
