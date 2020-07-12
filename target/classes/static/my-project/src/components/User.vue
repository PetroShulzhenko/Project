<template>
    <div class="user">
        <div class="line">
            <div class="user-name">{{user.name}}</div>
            <div class="user-programType">{{user.programType}}</div>
            <button class="details" v-on:click="details" >
                <img src="../images/details.png" width="50px" alt="Анкета" title="Анкета">
            </button>
            <button class="newProgram" v-on:click="addProgram" >
                <img src="../images/details.png" width="50px" alt="Составить программу" title="Составить прорамму">
            </button>
        </div>
        <div class="wrapper">
            <div class="wrapperDetails">
                <div class="modal" v-bind:class="{'is-shown-details': detailsStatus}">
                    <span class="close" title="Close Modal"
                    v-on:click="details" >&times;</span>
                    <p>{{user.profile.height}}</p>
                    <p>{{user.profile.weight}}</p>
                    <p>{{user.profile.age}}</p>
                    <p>{{user.profile.trainingExperience}}</p>
                    <p>{{user.profile.previousProgram}}</p>
                    <p>{{user.profile.health}}</p>
                    <p>{{user.profile.muscleTarget}}</p>
                    <p>{{user.profile.dietTarget}}</p>
                    <p>{{user.profile.specialProgram}}</p>
                    <p>{{user.profile.photo}}</p>
                    <p><a :href="user.profile.equipment">Сайт спортзала</a></p>
                    <p>{{user.profile.activityLevel}}</p>
                </div>
            </div>
            
            <div class="wrapperProgram">
                <div class="modal" v-bind:class="{'is-shown-program': newProgramStatus}">
                    <span class="close" title="Close Modal"
                    v-on:click="addProgram" >&times;</span>
                    <NewTrainingDay />
                    
                </div>
            </div>
        </div>
               
        
        
    </div>
</template>

<script>
     import NewTrainingDay from './New-TrainingDay.vue'

    export default{
        name: "user",
        props: ["user"],
        data(){
            return{
                detailsStatus: true,
                newProgramStatus: true
            }
        },
        components: {
            NewTrainingDay
        },
        methods: {
            details: function(){
                this.detailsStatus = !this.detailsStatus;
            },
            addProgram: function(){
                this.newProgramStatus = !this.newProgramStatus;
            }         
        }
    }
</script>

<style scoped>
    .line{
        background: #f4f4f4;
        padding: 10px;
        border-bottom: 1px #ccc dotted;
        display: flex;
        align-items: center;
        justify-content: space-around;
    }
    .user-name{
        width: 100px;
    }
    .user-programType{
        width: 50px;
    }
    button{
        border: 0;
        cursor: pointer;
    }
    .wrapper{
        display: flex;
    }

    /*   DETAILS & PROGRAM */
    .is-shown-details{
        display: none;
    }
    .is-shown-program{
        display: none;
    }
    .close{
        color: #000;
        font-size: 35px;
        font-weight: bold;
        cursor: pointer;
    }
    .wrapperDetails{
        width: 30%;
        text-align: center;
    }
    .wrapperProgram{
        width: 70%;
        text-align: center;
    }
</style>