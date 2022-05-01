<template>    
    <div class="about-us" id="about">
        <div class="wrapper">
            <div class="about-us_container">
                <h2>О нас</h2>
                <div class = 'about-us__grid-container'>

                <div class="card">
                    <img src="../../assets/img/team-3.jpg" style="width:98%; height:250px; margin-right:0px; padding-top: 3px; padding-left: 5px; border-radius: 20px; " alt="Ivan">
                    <h1>Морозов Иван</h1>
                    <p class="title">Директор компании</p>
                    <div style="margin: 24px 0;">
                        <a class = 'f' href="#"><i class="fa fa-dribbble"></i></a>
                        <a class = 'f' href="#"><i class="fa fa-twitter"></i></a>
                        <a class = 'f' href="#"><i class="fa fa-linkedin"></i></a>
                        <a class = 'f' href="#"><i class="fa fa-facebook"></i></a>
                    </div>
                </div>
                    <div class="cardn"></div>
                <div class="card">
                    <img src="../../assets/dima.png" style="width:98%; height:250px; margin-right:0px; padding-top: 3px; padding-left: 5px; border-radius: 20px; " alt="Dmitriy">
                    <h1>Смирнов Дмитрий</h1>
                    <p class="title">Главный бухгалтер</p>
                    <div style="margin: 24px 0;">
                        <a class = 'f' href="#"><i class="fa fa-dribbble"></i></a>
                        <a class = 'f' href="#"><i class="fa fa-twitter"></i></a>
                        <a class = 'f' href="#"><i class="fa fa-linkedin"></i></a>
                        <a class = 'f' href="#"><i class="fa fa-facebook"></i></a>
                    </div>
                </div>
                <div class="cardn"></div>
                <div class="card">
                    <img src="../../assets/img/team-1.jpg" style="width:98%; height:250px; margin-right:0px; padding-top: 3px; padding-left: 5px; border-radius: 20px; " alt="Anny">
                    <h1>Ромская Анна</h1>
                    <p class="title">Бизнесс аналитик</p>
                    <div style="margin: 24px 0;">
                        <a class = 'f' href="#"><i class="fa fa-dribbble"></i></a>
                        <a class = 'f' href="#"><i class="fa fa-twitter"></i></a>
                        <a class = 'f' href="#"><i class="fa fa-linkedin"></i></a>
                        <a class = 'f' href="#"><i class="fa fa-facebook"></i></a>
                    </div>
                </div>

                </div>
            </div>
        </div>
    </div>

</template>







<script>

export default {
  name: 'About',
  props: {
    
  },
 data() {
    return {
     
    }
  },
}
</script>





<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.header a {
        float: left;
        color: black;
        text-align: left;
        padding: 12px;
        text-decoration: none;
        font-size: 18px;
        line-height: 25px;
        border-radius: 4px;
    }

    .header a:hover {
        background-color: #ddd;
        color: black;
    }
    


    @media screen and (max-width: 500px) {
        .header a {
            float: none;
            display: block;
            text-align: left;
        }

    }

    .wrapper {
        width: 1020px;
        margin: 0 auto;
    }

    .about-us{
        width: 100%;
        height: 734px;
        background-color: #e57259;
        border-bottom: 6px solid #e57259;
        margin-top: 0px;
        padding-top: 67px;
        color: #000000;
    }

    .about-us_container{
        margin-left: 40px;
        margin-right: 40px;
    }

    .card {
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.5);
        max-width: 300px;
        
        width: 300px;
        margin: auto;
        text-align: center;
        font-family: arial;
    }
    .cardn {
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0);
        max-width: 300px;
        width: 299px;
        height: 300px;
        margin: auto;
        text-align: center;
        font-family: arial;
    }

    .about-us__grid-container{
        grid-auto-flow: column;
        width: 100%;
        margin-top: 49px;
        display: grid;
        grid-template-columns: 32% 32% 32%;
        grid-template-rows: 55% 10%;
        grid-row-gap: 110px;
        grid-column-gap: 2%;


    }

    .title {
        color: #000000;
        font-size: 18px;
    }

    button {
        border: none;
        outline: 0;
        display: inline-block;
        padding: 8px;
        color: white;
        background-color: #000;
        text-align: center;
        cursor: pointer;
        width: 100%;
        font-size: 18px;
    }

    .f {
        text-decoration: none;
        font-size: 22px;
        color: black;
    }



    .card1 img{
        width:32px;
        height:32px;
        margin-right: 3.5px;
        border-radius: 16px;
    }

    .card1 img:hover{
        width:32px;
        height:32px;
        border-radius: 16px;
        background-color:lightgrey;
    }

</style>

