<template>
  <div class="calendar">  
    <header class="calendar-header">
        <button class="prev" v-on:click="counter -= 1">&#10094;</button>
        <div class="header-month">{{currentMonth(counter)}}<br><span>{{currentYear(yearStep)}}</span></div>
        <button class="next" v-on:click="counter += 1">&#10095;</button>
        
    </header>
    <month />
    <div class="soon">Coming soon!</div>
  </div>
  </template>
  
  <script>
 import month from '../components/Month.vue'
  
  export default {
    name: 'Calendar',
    components:{
      month
    },
    data() {
      return {
        test: "",
        counter: 0,
        yearStep: 0
      }
    },
    methods: {
      currentMonth: function(counter, yearStep){
                var dateObj = new Date();
                var monthNumber = dateObj.getUTCMonth(); 
                var months = ['Январь', 'Февраль', 'Март', 'Апрель', 'Май', 
                            'Июнь', 'Июль', 'Август', 'Сентябрь', 'Октябрь', 'Ноябрь', 'Декабрь']; 
                if ((monthNumber + counter) > 11){
                  this.yearStep += 1;
                  counter = yearStep - yearStep;
                  this.counter = 0;
                  this.monthNumber = 0;
                }
                if ((monthNumber + counter) < 0){
                  yearStep -= 1;
                  counter = 0;
                  monthNumber = 11;
                }
                this.test = months[monthNumber + counter];
                return this.test;
              },
      currentYear: function(yearStep){
                var dateObj = new Date();
                var year = dateObj.getFullYear();
                return year + yearStep;
                           }
    }
  }
  </script>
  
  <style scoped>
    .calendar{
      margin: 0;
      padding: 0;
      position: absolute;
      top: 0;
      left: 0;
      width: 100%;
    }
    .calendar-header {
      display: flex;
      background-color: rgb(240, 218, 138);
      justify-content: space-around;
      align-items: center;
      height: 25vh;
      font-size: 20px;
      text-transform: uppercase;
      letter-spacing: 3px;
    } 
    .header-month{
      display: flex;
      flex-direction: column;
      align-items: center;
      width: 10vw;
    }
    .prev{
      font-size: 30px;
      border: 0;
      background-color: rgb(240, 218, 138);
      cursor: pointer;
    }
    .next{
      font-size: 30px;
      border: 0;
      background-color: rgb(240, 218, 138);
      cursor: pointer;
    }
    .soon{
      display: flex;
      justify-content: center;
      align-items: center;
      font-size: 100px;
      position: absolute;
      left: 0;
      top: 0;
      z-index: 10;
      width: 100vw;
      height: 88.5vh;
      background-color: whitesmoke;
      opacity: 0.7;
    }
  </style>