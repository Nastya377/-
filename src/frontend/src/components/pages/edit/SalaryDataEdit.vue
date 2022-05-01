<template>
  <div class="form-container sign-up-container">
    <form method="POST" action="#" class="form" id="register">
      
      <div class="row">
        <div class="col-50" style="padding-left: 30px">
          
          <label for="rate"><i class="fa fa-user"></i>Расценка за единицу продукции</label>
          <input type="text" name="rate" v-bind:id="rate" v-model="this.rate"> 

          <label for="premium"><i class="fa fa-user"></i>Процент премий</label>
          <input type="text" v-bind:id="premium" name="premium" v-model="this.premium">
        </div>
      <div>
          {{this.rate}}
      </div>
        

      </div>

      <input type="button" v-on:click ="send()" value="Нажмите для подтверждения" class="btn">
    </form>
  </div>
</template>


<script>
export default {
  name: 'SalaryDataEdit',
    props: {
        debug: {
            type: Boolean,
            default: false
        }
    },

 data() {
    return {
      valutes: 0,
        Rate: 0,
        Premium : 0,

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
                this.$store.state.aboutUser.Rate = insideData.Rate
                this.$store.state.aboutUser.Premium = insideData.Premium
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

        rate: this.rate,
        premium: this.premium,
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
    background-color: #da0909;
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
