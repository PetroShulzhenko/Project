<template>
    <div>
        <div  v-bind:key="user.id" v-for="user in users">
            <user v-bind:user="user" />
        </div>
        
    </div>
</template>

<script>
    import user from './User.vue'
    
    export default{
        name: 'Users',
        components:{
            user
        },
        props: ["users"]
    }
</script>