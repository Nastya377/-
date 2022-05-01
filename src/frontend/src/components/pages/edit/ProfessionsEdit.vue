<template>
  <div class="form-container sign-up-container">
    <form method="POST" action="#" class="form" id="register">
      
      <div class="row">
        <div class="col-50" style="padding-left: 30px">
          
          <label for="name"><i class="fa fa-user"></i>Название профессии</label>
          <input type="text" name="name" id="name" v-model="name"> 

        <label for="type"><i class="fa fa-user"></i>Тип оплаты труда</label>
          <!--<input type="text" id="position" name="position" v-model="position" placeholder="Директор">
-->
          <select name="type" id="type" style="width: 100%; height:50px" v-model="type_selected">
            <option v-for="option in type" :key="option.text" :value="option.value">
              {{ option.text }}
            </option>
          </select>

          <label for="sum"><i class="fa fa-user"></i>Сумму оплаты</label>
          <input type="text" id="sum" name="sum" v-model="sum">
        </div>

        

      </div>

      <input type="button" v-on:click ="send()" value="Нажмите для подтверждения" class="btn">
    </form>
  </div>
</template>


<script>
export default {
  name: 'ProfessionsEdit',
    props: {
        debug: {
            type: Boolean,
            default: false
        }
    },

 data() {
    return {
      valutes: 0,
        Name: "",
        Sum : "",
        type_selected:"",
        type: [
        { text: 'Один', value: 'A' },
        { text: 'Два', value: 'B' },
        { text: 'Три', value: 'C' }
      ],

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
                this.$store.state.aboutUser.Name = insideData.Name
                this.$store.state.aboutUser.Sum = insideData.Sum
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

        Name: this.Name,
        sum: this.sum,
        type: this.type,
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
