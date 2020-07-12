<template>
    <div>
        <NewTrainingDayProgram />
        <button v-on:click="addNewExercise">
            Добавить упражнение
        </button>
    </div>
</template>

<script>
    import NewTrainingDayProgram from './New-TrainingDay-Program'
   

    export default{
        name: "NewTrainingDay",
        components: {
            NewTrainingDayProgram
            
        },
        methods:{
            addNewExercise: function(){
                
            }
        }
    }
</script>