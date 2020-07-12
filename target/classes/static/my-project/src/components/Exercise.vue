<template>
    <div class="exercise-item">
      <div class="exercise-title">{{exercise.title}}</div>
      <div>{{exercise.sets}}</div>
      <div>{{exercise.PDO}}</div>
      <div>{{exercise.rest}}</div>
      <form :action="exercise.link" target="_blank">
          <button>
              <img src="../images/youtube_logo.png" width="50px">
          </button>
      </form>
      
      <button class="details" v-on:click="details">
        <img src="../images/details.png" width="50px">
      </button>
      <div class="wrapper">
        <div class="modal" v-bind:class="{'is-shown': detailsStatus}">
            <p> {{exercise.details}} </p>
            <span class="close" title="Close Modal"
            v-on:click="details" >&times;</span>
        </div>
      </div>
    </div>
</template>

<script>
    export default {
        name: "exercise",
        props: ["exercise"],
        data(){
            return{
                detailsStatus: true
            }
        },
        methods: {
            details: function(){
                this.detailsStatus = !this.detailsStatus;
            }
        }
    }
</script>

<style scoped>
    .exercise-item {
    background: #f4f4f4;
    padding: 10px;
    border-bottom: 1px #ccc dotted;
    display: flex;
    align-items: center;
    justify-content: space-around;
  }
  .exercise-title{
      width: 100px;
  }

  /*    DETAILS  */
  .is-shown {
  display: none; 
}
.wrapper{
    position: absolute;
    top: 0;
    left: 10vw;
}
.modal{
    position: fixed; 
    z-index: 1; 
    background-color: #fefefe;
    margin: 5px auto 5px auto; 
    border: 1px solid #888;
    width: 80%;
    height: 80%;
    opacity: 0.95;
}
.modal p{
    text-align: center;
}
  .close {
  position: absolute;
  right: 25px;
  top: 0;
  color: #000;
  font-size: 35px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: red;
  cursor: pointer;
}
button{
  border: 0;
}
/* Add Zoom Animation */
.animate {
  -webkit-animation: animatezoom 0.6s;
  animation: animatezoom 0.6s
}

@-webkit-keyframes animatezoom {
  from {-webkit-transform: scale(0)} 
  to {-webkit-transform: scale(1)}
}
  
@keyframes animatezoom {
  from {transform: scale(0)} 
  to {transform: scale(1)}
}
button{
  cursor: pointer;
}

</style>