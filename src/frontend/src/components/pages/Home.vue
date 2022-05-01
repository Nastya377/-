<template>
  <div>
      <div >
        <h1>Наши карты</h1>
        <Slider />
      </div>
      <CurrencyValues /> 
  </div>
   
  
</template>

<script>
import CurrencyValues from '../smallComponents/CurrencyValues.vue'
import Slider from '../smallComponents/Slider.vue'

export default {
  name: "Home",
  components: {
    CurrencyValues,
    Slider,
  },
};
</script>