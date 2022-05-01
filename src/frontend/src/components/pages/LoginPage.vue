<template>
  <div class="container " v-bind:class="{'right-panel-active': isSwiched}" id="container">
        <!-- sign in page -->
        <div class="form-container sign-in-container">
        <form class="form" id="login" >
            <h1 class="form__title">Вход</h1>
            <div class="form__input-group">
            <label for="username">Имя Пользователя: </label>
            <input type="text" class="form__input" name="username" v-model="user.username" id="usernameLog" maxlength="20" required> 
            </div>
            <div class="form__input-group">
            <label for="pass">Пароль: </label>
            <input type="password" class="form__input" name="passwordL" v-model="user.password" id="passwordLog" maxlength="20" required> 
            </div>
            <div class="form__input-group">
            <button type="button" v-on:click ="login()" class="form__button">Поехали</button>
            <div class ="wrong" v-if="message === '1010'">
                Данные не верны :( 
            </div>
            </div>
        </form>
        </div>

        <!--  create account page -->
        <div class="form-container sign-up-container">
        <form class="form" id="register" >
            <h1 class="form__title">Регистрация</h1>
            <div class="form__input-group">
            <label for="username"> Имя Пользователя: </label>
            <input  type="text" class="form__input" name="username" id="usernameReg" v-model="user.username" maxlength="20" required>
            </div>
            <div class="form__input-group">
            <label for="pass">Пароль: </label>
            <input  type="password" class="form__input" name="passwordR" v-model="user.password" id="passwordREg" maxlength="20" required> 
            </div>
            <button class="form__button" type="button" v-on:click ="register()">Начинаем!</button>
            <div class ="wrong"  v-if="message === '1000'"> 
                Такой аккаунт уже существует :( 
            </div>
            <div class ="wrong"  v-if="message === '1500'"> 
                Пароль слишком короткий 
            </div>
            
        </form>
        </div> 
        
        <div class="overlay-container">
            <div class="overlay">
                <div class="overlay-panel overlay-left">
                    <h1>С возвращением!</h1>
                    <p>Пожалуйста войдите используя персональные данные</p>
                    <button class="ghost" v-on:click="leftBttn()" id="signIn">Вход</button>
                </div>
                <div class="overlay-panel overlay-right">
                    <h1>Привет!</h1>
                    <p>Введите свои личные данные и начните путешествие с нами</p>
                    <button v-on:click="rightBttn()" class="ghost" id="signUp">Регистрация</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
  name: 'LoginPage',
    props: {
        debug: {
            type: Boolean,
            default: false
        }
    },

 data() {
    return {
        isSwiched: false,
        user : {
            username: "",
            password: ""
        },
        message : '',
        jsonData : "",
        
    }
  },
  methods: {
      checkOutPassword () {
          if((this.user.username.length < 3 || this.user.password.length < 6 ) && this.debug) {
              this.message = '1500'
              return false;
          }
          return true

      },
      parseInData (insideData) {
              if (insideData){
                  if (typeof insideData == 'object'){
                      console.log(insideData)
                    if (insideData.error) {   
                        this.message = insideData.error
                        
                    }
                    if (insideData.username){
                        if (insideData.error == 1){
                            this.$store.commit('saveUser',insideData,true)
                            this.$parent.$parent.switchPage()
                        }    
                    }
                } 
            }
        },


      register : function () {
          if (!this.checkOutPassword()) return
          this.$parent.$parent.sendDataToServer('/register',this.user,this.parseInData)
      },


      login : function () {
          if (!this.checkOutPassword()) return
          this.$parent.$parent.sendDataToServer('/login',this.user,this.parseInData)
      },
      switchPage (){
        if (this.message == '1000') {
            setTimeout(() => {
                this.isSwiched = false;
                this.message = '1001';
            }, 2000);
        }
      },





      rightBttn () {
        this.isSwiched  = true;
      },
      leftBttn () {
        this.isSwiched = false;
      }

  },
  mounted() {
        
  }
}   
</script>


<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.wrong
{
        font-size: 23px;
        line-height: 1.1;
        letter-spacing: 0.091em;
        font-weight: 600;
        font-style: normal;
        padding-top: 10px;
}


* {
    box-sizing: border-box;
}

.centry {
    background: #f6f5f7;
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    font-family: 'Montserrat', sans-serif;
    height: 100vh;
    margin: -20px 0 50px;
}

h1 {
    font-weight: bold;
    margin: 1rem;
}

p {
    font-size: 14px;
    font-weight: 100;
    line-height: 20px;
    letter-spacing: 0.5px;
    margin: 20px 0 30px;
}

button {
    border-radius: 20px;
    border: 1px solid #FF4B2B;
    background-color: #FF4B2B;
    color: #FFFFFF;
    font-size: 12px;
    font-weight: bold;
    padding: 12px 45px;
    letter-spacing: 1px;
    text-transform: uppercase;
    transition: transform 80ms ease-in;
}

button:active {
    transform: scale(0.95);
}

button:focus {
    outline: none;
}

button.ghost {
    background-color: transparent;
    border-color: #FFFFFF;
}

form {
    background-color: #FFFFFF;
    display: flex;
    align-items: center;
    justify-content: center;
    flex-direction: column;
    padding: 0 50px;
    height: 100%;
    text-align: center;
}

input {
    background-color: #eee;
    border: none;
    padding: 12px 15px;
    margin: 8px 0;
    width: 100%;
}

.container {
    background-color: #fff;
    border-radius: 10px;
      box-shadow: 0 14px 28px rgba(0,0,0,0.25), 
            0 10px 10px rgba(0,0,0,0.22);
    position: relative;
    overflow: hidden;
    width: 768px;
    max-width: 100%;
    min-height: 480px;
}

.form-container {
    position: absolute;
    top: 0;
    height: 100%;
    transition: all 0.6s ease-in-out;
}

.sign-in-container {
    left: 0;
    width: 50%;
    z-index: 2;
}

.container.right-panel-active .sign-in-container {
    transform: translateX(100%);
}

.sign-up-container {
    left: 0;
    width: 50%;
    opacity: 0;
    z-index: 1;
}

.container.right-panel-active .sign-up-container {
    transform: translateX(100%);
    opacity: 1;
    z-index: 5;
    animation: show 0.6s;
}


.overlay-container {
    position: absolute;
    top: 0;
    left: 50%;
    width: 50%;
    height: 100%;
    overflow: hidden;
    transition: transform 0.6s ease-in-out;
    z-index: 100;
}

.container.right-panel-active .overlay-container{
    transform: translateX(-100%);
}

.overlay {
    background: #FF416C;
    background: -webkit-linear-gradient(to right, #FF4B2B, #FF416C);
    background: linear-gradient(to right, #FF4B2B, #FF416C);
    background-repeat: no-repeat;
    background-size: cover;
    background-position: 0 0;
    color: #FFFFFF;
    position: relative;
    left: -100%;
    height: 100%;
    width: 200%;
      transform: translateX(0);
    transition: transform 0.6s ease-in-out;
}

.container.right-panel-active .overlay {
      transform: translateX(50%);
}

.overlay-panel {
    position: absolute;
    display: flex;
    align-items: center;
    justify-content: center;
    flex-direction: column;
    padding: 0 40px;
    text-align: center;
    top: 0;
    height: 100%;
    width: 50%;
    transform: translateX(0);
    transition: transform 0.6s ease-in-out;
}

.overlay-left {
    transform: translateX(-20%);
}

.container.right-panel-active .overlay-left {
    transform: translateX(0);
}

.overlay-right {
    right: 0;
    transform: translateX(0);
}

.container.right-panel-active .overlay-right {
    transform: translateX(20%);
}
</style>





