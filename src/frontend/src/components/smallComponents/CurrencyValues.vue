
<template>

  <div v-if= "loaded">
    
  <div class="card">


      <div class="cours"><h2><b><span>Курсы</span></b></h2></div>

      <table>
          <thead>
          <tr>
            <th>Валюта</th>
            <th class="valu">А-Курс</th>
            <th class="valu">Покупка</th>
            <th class="valu">Продажа</th>
          </tr>
          </thead>
          <tbody>
            <tr v-for="valute in currency" :key= "valute.ID">
              <td class="valu">{{valute.CharCode}}</td>
              <td class="valu"><i class="bx" :class = arrowCalc() style="color: red;" ></i> </td>
              <td class="valu">{{convert(valute.Value,valute.Nominal)}}</td>
              <td class="valu">{{convert(valute.Previous,valute.Nominal)}}</td>
            </tr>   
          </tbody>
      </table>
  </div>
  </div>
</template>







<script>

//Я подключил аксиос для этого в папке src/frontend нужно отработать команду npm install!!!!
import axios from 'axios'
//import Vuetable from 'vuetable-2'
export default {
  components: {
   // Vuetable
  },
  name: 'CurrencyValues',
  props: {
    
  },
 data() {
    return {
      loaded: false,
      currency: {},
      defaultCurrency: {
        nominal: 100
      },
      oldtimestamp: null,
      timestamp: null,

      fetchData() {
        axios.get('https://www.cbr-xml-daily.ru/daily_json.js').then(response => {
          if (response.status == 200) {
            this.loaded = true
            let data = response.data
            this.currency.USD = data.Valute.USD
            this.currency.BYN = data.Valute.BYN
            this.currency.EUR = data.Valute.EUR;
            this.timestamp = data.Timestamp
            this.oldtimestamp = data.PreviousDate
            
          }
        
      })
       
      }
    }
  },
  methods: {
    arrowCalc () {
        
       if (Math.floor(Math.random() * (2 - 1) + 1) == 1) {
        return "bx-caret-up color:green"
       }else{
        return "bx-caret-down color:red"   
       }
    },
    convert (val, val2) {
      if (this.loaded) {
        return val+val2 
      }
      return '00'
    }
  },
  mounted() {
   this.fetchData()
  }
}
</script>





<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
@import url('https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css');
.card {
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.7);
        margin: auto;
        text-align: center;
        font-family: arial;
    }

    .cours{
        color: #bd0909;
        font-size: 150%;
        text-align: center;
        face:Arial;
    }
    .valu{
        margin: 1em;
        padding: 3px;
    }
    th{
        border: 1px solid #800; /* Параметры границы */
        padding: 4px;
    }
</style>
