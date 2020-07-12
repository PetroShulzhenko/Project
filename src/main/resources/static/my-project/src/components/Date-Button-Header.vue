<template>
    <div>  
        <header class="main-page-header">
            <router-link tag="button" class="date-button-header" to="/Calendar">
                <img src="../images/imgonline-com-ua-convertcIF55yMAKUZx.png" >
                    Сегодня <span class="data-button" >{{getDateToday()}}</span>
            </router-link>
        </header>
           
    </div>
    </template>
    
    <script>
   

    
    export default {
        name: 'dateButtonHeader',
        data(){
            return {
                
            }
        },
        methods: {
            getDateToday: function(){
                var dateObj = new Date();
                var monthNumber = dateObj.getUTCMonth(); 
                var day = dateObj.getUTCDate();
                var months = ['Января', 'Февраля', 'Марта', 'Апреля', 'Мая', 
                            'Июня', 'Июля', 'Августа', 'Сентября', 'Октября', 'Ноября', 'Декабря']; 

                var currentDate = " :  " + day + " " + months[monthNumber];
                return currentDate;
            }
        }
        
    }
    </script>
    
<style scoped>
    .date-button-header{
    display: flex;
    align-items: center;
    border-radius: 5px;
    background-color: #d72323;
    color: #f5f4f4;
    font-size: 1.3rem;
    padding: 5px 15px 5px 10px;
    margin-top: 3vh;
    border: 0;
    cursor: pointer;
}
.date-button-header img{
    width: 30px;
    margin-right: 5px;
    margin-left: 0px;
}   
</style>