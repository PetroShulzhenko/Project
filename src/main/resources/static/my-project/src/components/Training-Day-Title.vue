<template>
    <div>
        <h2>{{trainingDayTitle.dayTitle}}</h2>
    </div>
</template>

<script>

    export default {
        name: "trainingDayTitle",
        props: ["trainingDayTitle"],
        data(){
            return{
                
            }
        }
    }
</script>

<style scoped>
    div{
        width: 100%;
        border: 1px solid black;
    }
    h2{
        margin-left: 10px;
    }
</style>