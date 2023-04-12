import {createStore} from 'vuex'

export default createStore({
    state(){
        return {
            user:null
        }
    },
    mutations:{
        setUser(state,payload){
            state.user = payload;
        }
    },
    getters:{
        formatUser(state){
            return state.user.username.toUpperCase();
        }
    },
    actions:{
        setUser2(context,payload){
            setTimeout(()=>{
                context.commit("setUser",payload)
            },1000)
        }
    }
})
