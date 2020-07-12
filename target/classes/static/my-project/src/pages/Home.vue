<template>
    <div>
      <dateButtonHeader  class="header-button"/>
      <br><br>
      <trainingDays v-bind:trainingDays ="trainingDays" />
      <br><br>
      <dietPlan v-bind:dietPlan ="dietPlan" />
      
    </div>
    
  </template>
  
  <script>
 import dateButtonHeader from '../components/Date-Button-Header.vue'
 import trainingDays from '../components/Training-Days.vue'
 import dietPlan from '../components/Diet-Plan.vue'
// import axios from 'axios'
  export default {
    name: 'Home',
    components:{
      dateButtonHeader,
      trainingDays,
      dietPlan
    },
    data() {
      return{
        trainingDays: [
          {
            dayTitle: "День спины",
            exercises: [
                {
                id: 1,
                title: "тяга",
                link: "https://www.youtube.com/watch?v=43jdsq8IUHI",
                sets: "3x12",
                PDO: "2",
                details: "fsffsfd fdsfsdfds fsdfsdfdsf fsdfdsfsdfsd sfd sdfdsfsdf asdsad dfsdfd",
                rest: "3 min"
                },
                {
                id: 2,
                title: "трицепс",
                link: "https://www.youtube.com/watch?v=6LyagkoRWYA",
                sets: "2x12",
                PDO: "5",
                details: "fsffsfd fdsfsdfds fsdfsdfdsf fsdfdsfsdfsd sfd sdfdsfsdf asdsad dfsdfd",
                rest: "1 min"
                },
                {
                id: 3,
                title: "бицепс",
                link: "https://www.youtube.com/watch?v=6LyagkoRWYA",
                sets: "3x12",
                PDO: "2",
                details: "fsffsfd fdsfsdfds fsdfsdfdsf fsdfdsfsdfsd sfd sdfdsfsdf asdsad dfsdfd ",
                rest: "3 min"
                },
                {
                id: 4,
                title: "жим",
                link: "https://www.youtube.com/watch?v=6LyagkoRWYA",
                sets: "1x12",
                PDO: "1",
                details: "fsffsfd fdsfsdfds fsdfsdfdsf fsdfdsfsdfsd sfd sdfdsfsdf asdsad dfsdfd",
                rest: "2 min"
                }
                  ]          
          },
          {
            dayTitle: "День ног",
            exercises: [
                {
                id: 1,
                title: "тяга",
                link: "https://www.youtube.com/watch?v=43jdsq8IUHI",
                sets: "3x12",
                PDO: "2",
                details: "fsffsfd fdsfsdfds fsdfsdfdsf fsdfdsfsdfsd sfd sdfdsfsdf asdsad dfsdfd",
                rest: "3 min"
                },
                {
                id: 2,
                title: "трицепс",
                link: "https://www.youtube.com/watch?v=6LyagkoRWYA",
                sets: "2x12",
                PDO: "5",
                details: "fsffsfd fdsfsdfds fsdfsdfdsf fsdfdsfsdfsd sfd sdfdsfsdf asdsad dfsdfd",
                rest: "1 min"
                },
                {
                id: 3,
                title: "бицепс",
                link: "https://www.youtube.com/watch?v=6LyagkoRWYA",
                sets: "3x12",
                PDO: "2",
                details: "fsffsfd fdsfsdfds fsdfsdfdsf fsdfdsfsdfsd sfd sdfdsfsdf asdsad dfsdfd ",
                rest: "3 min"
                },
                {
                id: 4,
                title: "жим",
                link: "https://www.youtube.com/watch?v=6LyagkoRWYA",
                sets: "1x12",
                PDO: "1",
                details: "fsffsfd fdsfsdfds fsdfsdfdsf fsdfdsfsdfsd sfd sdfdsfsdf asdsad dfsdfd",
                rest: "2 min"
                }
                  ]          
          }
        ],
        dietPlan: {
          weight: "77kg",
          protein: "120g",
          fat: "80g",
          carbohydrates: "270g",
          breakfast: {
            p: "15g",
            c: "30g",
            f: "10g"
          }, 
          lunch1: {
            p: "25g",
            c: "30g",
            f: "20g"
          },
          lunch2: {
            p: "35g",
            c: "30g",
            f: "30g"
          },
          snacks: {
            p: "45g",
            c: "30g",
            f: "40g"
          },
          dinner: {
            p: "55g",
            c: "30g",
            f: "50g"
          }
        }
      }
    }
    /*created() {
      axios.get('https://jsonplaceholder.typicode.com/todos?_limit=5')
        .then( res => this.exercises = res.data)
        .catch(err => console.log(err));
    }*/
  }
  </script>
  
  <style>
  .header-button{
    margin-left: 40vw;
  }
  </style>
  