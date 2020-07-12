<template>
    <div class="wrapper">
    <div class="stat-table">
        <table>
            <tr>
                <td>Вес:</td>
                <td>{{dietPlan.weight}}</td>
            </tr>
            <tr>
                <td>Белки:</td>
                <td>{{dietPlan.protein}}</td>
            </tr>
            <tr>
                <td>Жиры:</td>
                <td>{{dietPlan.fat}}</td>
            </tr>
            <tr>
                <td>Углеводы:</td>
                <td>{{dietPlan.carbohydrates}}</td>
            </tr>
        </table>
    </div>
    <div class="meal-table">
        <table>
            <tr>
                <th colspan="3">Завтрак</th>
            </tr>
            <tr>
                <td>Белки:</td>
                <td>{{dietPlan.breakfast.p}}</td>
            </tr>
            <tr>
                <td>Углеводы:</td>
                <td>{{dietPlan.breakfast.c}}</td>
            </tr>
            <tr>
                <td>Жиры:</td>
                <td>{{dietPlan.breakfast.f}}</td>
            </tr>
        </table>
        <table>
            <tr>
                <th colspan="3">Обед 1</th>
            </tr>
            <tr>
                <td>Белки:</td>
                <td>{{dietPlan.lunch1.p}}</td>
            </tr>
            <tr>
                <td>Углеводы:</td>
                <td>{{dietPlan.lunch1.c}}</td>
            </tr>
            <tr>
                <td>Жиры:</td>
                <td>{{dietPlan.lunch1.f}}</td>
            </tr>
        </table>
        <table>
            <tr>
                <th colspan="3">Обед 2</th>
            </tr>
            <tr>
                <td>Белки:</td>
                <td>{{dietPlan.lunch2.p}}</td>
            </tr>
            <tr>
                <td>Углеводы:</td>
                <td>{{dietPlan.lunch2.c}}</td>
            </tr>
            <tr>
                <td>Жиры:</td>
                <td>{{dietPlan.lunch2.f}}</td>
            </tr>
        </table>
        <table>
            <tr>
                <th colspan="3">Перекус</th>
            </tr>
            <tr>
                <td>Белки:</td>
                <td>{{dietPlan.snacks.p}}</td>
            </tr>
            <tr>
                <td>Углеводы:</td>
                <td>{{dietPlan.snacks.c}}</td>
            </tr>
            <tr>
                <td>Жиры:</td>
                <td>{{dietPlan.snacks.f}}</td>
            </tr>
        </table>
        <table>
            <tr>
                <th colspan="3">Ужин</th>
            </tr>
            <tr>
                <td>Белки:</td>
                <td>{{dietPlan.dinner.p}}</td>
            </tr>
            <tr>
                <td>Углеводы:</td>
                <td>{{dietPlan.dinner.c}}</td>
            </tr>
            <tr>
                <td>Жиры:</td>
                <td>{{dietPlan.dinner.f}}</td>
            </tr>
        </table>
    </div>
    </div>
</template>

<script>

    export default {
        name: "dietPlan",
        props: ["dietPlan"],
        data(){
            return{
                
            }
        }
    }
</script>

<style scoped>
    .stat-table{
        display: flex;
        justify-content: center;
        font-size: 20px;
        border: 1px solid black;     
           
    }
    .meal-table{
        display: flex;
        margin: 5vh 5vw;
    }
    .meal-table table{
        margin: 0 5vw;
    }
    .wrapper{
        margin-bottom: 15vh;
    }
</style>