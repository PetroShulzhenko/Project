<template>
    <form>
        <input class="dayTitle" type="text" placeholder="Название тренировочного дня"> 
        <div class="exercise">
            <input class="exerciseTitle" type="text" placeholder="Название упражнения">
            <input class="exerciseRep" type="text" placeholder="Количество повторений">
            <input class="exercisePDO" type="text" placeholder="ПДО">
            <input class="exerciseRest" type="text" placeholder="Отдых между подходами">
            <input class="exerciseComment" type="text" placeholder="Комментарий">
            <input class="exerciseLink" type="text" placeholder="Ссылка">
        </div> 
    </form>
</template>

<script>
    export default{
        name: "NewTrainingDayProgram"
    }
</script>

<style scoped>
     .dayTitle{
        width: 100%;
        border: 1px solid black;
        text-align: center;
        font-size: 20px;
        margin-bottom: 10px;
    }
    input{
        width: 100%;
        border: 1px dotted black;
        font-size: 15px;
        height: 25px;
    }
    .exercise{
        display: flex;
    }
    .exerciseRep{
        width: auto;
    }
</style>