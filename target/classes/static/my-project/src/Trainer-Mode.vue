<template>
   <div>
        <Users v-bind:users="users" />
        <br><br><br><br>
    </div>
</template>

<script>
    import Users from './components/Users.vue'
    
    export default{
        name: 'Trainer',
        components:{
            Users
        },
        data(){
            return{
                users: [
                    {
                        id: 1,
                        name: 'Владимир Шаньков',
                        programType: 'Тренировки',
                        profile: {
                            height: '175cm',
                            weight: '70kg',
                            age: '60лет',
                            trainingExperience: '40лет',
                            previousProgram: 'МатАнализ',
                            health: 'Нет противопоказаний',
                            muscleTarget: 'Пресс',
                            dietTarget: 'Сушка',
                            specialProgram: 'нет',
                            photo:'../image/shankov.jpg',
                            equipment: 'www.mipt.ru',
                            activityLevel: '3 пары в день веду'
                        }
                    },
                    {
                        id: 2,
                        name: 'Сергей Резниченко',
                        programType: 'Питание',
                        profile: {
                            height: '175cm',
                            weight: '70kg',
                            age: '60лет',
                            trainingExperience: '40лет',
                            previousProgram: 'МатАнализ',
                            health: 'Нет противопоказаний',
                            muscleTarget: 'Пресс',
                            dietTarget: 'Сушка',
                            specialProgram: 'нет',
                            photo:'../image/shankov.jpg',
                            equipment: 'www.mipt.ru',
                            activityLevel: '3 пары в день веду'
                        }
                    },
                    {
                        id: 3,
                        name: 'Алекс Антипов',
                        programType: 'Тренировки',
                        profile: {
                            height: '175cm',
                            weight: '70kg',
                            age: '60лет',
                            trainingExperience: '40лет',
                            previousProgram: 'МатАнализ',
                            health: 'Нет противопоказаний',
                            muscleTarget: 'Пресс',
                            dietTarget: 'Сушка',
                            specialProgram: 'нет',
                            photo:'../image/shankov.jpg',
                            equipment: 'www.mipt.ru',
                            activityLevel: '3 пары в день веду'
                        }
                    }
                ]
            }
        }
    }
</script>

<style scoped>

</style>