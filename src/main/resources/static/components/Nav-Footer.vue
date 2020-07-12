<template>
    <footer class="footer-menu">
    
        <router-link tag="button" class="footer-button footer-button-back" to="/">
            <img src="../images/back-test.png" width="50px">
            <span>Назад</span>
        </router-link>
        
        <router-link tag="button" class="footer-button footer-button-homepage" to="/">
            <img src="../images/homepage.png" width="75px" height="50px">
            <span>Главная</span>
        </router-link>

        <router-link tag="button" class="footer-button footer-button-calendar" to="/Calendar">
            <img src="../images/School_Diary-512.png" width="50px">
            <span>Дневник</span>
        </router-link>

        <router-link tag="button" class="footer-button footer-button-statistic" to="/Statistics">
            <img src="../images/stat.png" width="50px">
            <span>Статистика</span>
        </router-link>
        
        <router-link tag="button" class="footer-button footer-button-other" to="/Other">
            <img src="../images/other.png" width="50px">
            <span>Ещё</span>
        </router-link>  
               
    </footer>
</template>
  
<script> 

  export default {
   name: "Nav"
  }
  </script>
  
  <style scoped>
     .footer-menu{
    display: flex;
    justify-content: space-around;
    width: 100%;
    height: 11.5vh ;
    position: fixed;
    top: 88.5vh;  
    left: 0;
    z-index: 10;
    background-color: #f5f4f4;
    padding-top: 0px;
    padding-bottom: 0px;    
    border-top: 2px solid rgb(133, 133, 133);
    
}
.footer-button{
    background-color: #f5f4f4;
    border: 0;
    display: flex;
    flex-direction: column;   
    align-items: center;
    justify-content: center;
    cursor: pointer;
}
.footer-menu span{
    font-size: 1.2em;
}

.footer-button-calendar img{
    position: relative;
    top: -2px;
}
.footer-button-back span{
    position: relative;
    top: 5px;
}
.footer-button-homepage img{
    position: relative;
    top: -2px;
}
  </style>
  