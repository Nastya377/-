<template>
  <div class="slide-class">
    <transition-group name='fade' tag='div'>
      <div v-for="i in [currentIndex]" :key='i'>
        <img :src="currentImg" style="width:auto; height:250px; margin-right:0px"/>
      </div>
    </transition-group>
    <a class="prev" @click="prev" href='#'>&#10094;</a>
    <a class="next" @click="next" href='#'>&#10095;</a>
  </div>
</template>

<script>
export default {
  name: 'Slider',
  props: {
    debug: {
      type: Boolean,
      default: false
    },
    slideShow: {
      type: Boolean,
      default:true,
    },
    slideTime : {
      type: Number,
      default: 15000
    }
  },
  data() {
    return {
      images: [
        require('../../assets/cards/credit-card-1.jpg'),
        require('../../assets/cards/credit-card-2.jpg'),
        require('../../assets/cards/credit-card-3.jpg'),
        require('../../assets/cards/credit-card-4.jpg'),
        require('../../assets/cards/credit-card-5.jpg'),
        ],
      slideTimer: this.slideTime,
      lastimage: 0,
      nowImage: () => new Date().getTime(),
      timer: null,
      currentIndex: 0,
    }
  },

  
    mounted: function() {
      if (this.slideShow) this.startSlide();
    },
  
    methods: {
      startSlide: function() {
        this.timer = setInterval(this.next, this.slideTime);
      },

      newSlide () {
        this.infoAbout()
        if (this.nowImage() > this.lastimage+1000){
          this.lastimage = this.nowImage();
          return true
        }
        return false
      },
  
      next: function() {
        if (this.newSlide()) this.currentIndex += 1
      },
      prev: function() {
        if (this.newSlide()) this.currentIndex -= 1
      },

      infoAbout () {
        if (!this.debug) return;
        console.group("slider")
          console.log(`auto`+ this.slideShow)
          console.log(this.timer)
          console.log(this.slideTime)

          console.group("time")
          console.log(`older time: ${this.lastimage}`)
          console.log(`new time: ${this.nowImage()}`)
          console.groupEnd()
        console.groupEnd()
      }

    },
  
    computed: {
      currentImg: function() {
        return this.images[Math.abs(this.currentIndex) % this.images.length];
      }
    }
  
}
</script>

<style>
.slide-class{
  height:250px;
  max-width:400px;
  display: flex;
  margin-left: auto;
  margin-right: auto;
  margin-top: 2rem;
  margin-bottom: 2rem;
}


.fade-enter-active,
.fade-leave-active {
  transition: all .9s ease;
  
  overflow: hidden;
  visibility:hidden;
  position: relative;
  width:100%;
  opacity: 1;
}

.fade-enter,
.fade-leave-to {
  visibility: hidden;
  width:100%;
  transform: translateY(30px);
  opacity: 0;
}

img {
    height:100px;
    width: 100px;
    margin-right: 20px;
  }

.prev, .next {
  cursor: pointer;
  top: 10ex;
  height: 6ex;
  position: absolute;
  width: auto;
  padding: 16px;
  font-weight: bold;
  font-size: 18px;
  transition: .7s ease;
  border-radius: 5px 5px 5px 5px;
  text-decoration: none;
  user-select: none;
}

/* Position the "next button" to the right */
.next {
  position:relative;
  color: #d10505;
  padding: auto;
  right: 4ex;
}

.prev {
  position:relative;
  color: #d10505;
  padding: auto;
  left: -43ex;
}

/* On hover, add a black background color with a little bit see-through */
.prev:hover, .next:hover {
  background-color: rgba(255, 37, 0,0.9);
}
</style>
