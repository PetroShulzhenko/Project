import VueRouter from 'vue-router'
import Home from './pages/Home'
import Calendar from './pages/Calendar'
import Statistics from './pages/Stats'
import Other from './pages/Other'
import Trainer from './Trainer-Mode'

export default new VueRouter({
    routes:[
        {
            path:'',
            component: Home
        },
        {
            path:'/Calendar',
            component: Calendar
        },
        {
            path:'/Statistics',
            component: Statistics
        },
        {
            path:'/Other',
            component: Other
        },
        {
            path: '/Trainer',
            component: Trainer
        }
    ],
    mode: 'history'

})