<template>
    <div>
        <div v-bind:key="trainingDay.id" v-for="trainingDay in trainingDays">
            <trainingDayTitle v-bind:trainingDayTitle="trainingDay" />
            <exercises v-bind:exercises="trainingDay" />
        </div>
    </div>
</template>

<script>
    import exercises from './Exercises.vue'
    import trainingDayTitle from './Training-Day-Title.vue'

    export default {
        name: "trainingDays",
        components: {
            trainingDayTitle,
            exercises
        },
        props: ["trainingDays"]
    }
</script>