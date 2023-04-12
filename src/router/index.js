import {createRouter, createWebHistory} from 'vue-router'

export default createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: '/',
            redirect: '/mylogin'
        },
        {
            path: '/mylogin',
            component: () => import('../components/agriculture/MyLogin')
        },
        {
            path: '/knife',
            component: () => import('../components/agriculture/Knife'),
            meta: {
                title: '设备管理'
            }
        },
        {
            path: '/main',
            name: 'main',
            component: () => import('../components/agriculture/Main'),
            meta: {
                title: '农业信息系统主页'
            },
            children: [
                {
                    path: '/myshop',
                    name: 'myshop',
                    component: () => import('../components/agriculture/MyShop')
                },
                {
                    path: '/mycar',
                    name: 'mycar',
                    component: () => import('../components/agriculture/MyCar')
                },
                {
                    path: '/equipment',
                    component: () => import('../components/agriculture/Equipment'),
                    meta: {
                        title: '设备管理'
                    }
                },
            ]
        },
        {
            path: '/home3',
            component: () => import('../views/HomePage'),
            meta: {
                title: '设备管理'
            }
        },  {
            path: '/home',
            component: () => import('../views/Home'),
            meta: {
                title: '设备管理'
            }
        },{
            path: '/home2',
            component: () => import('../views/Home2'),
            meta: {
                title: '设备管理'
            }
        }

        // {
        //     path: '/myproduct',
        //     name: 'myproduct',
        //     component: () => import('../components/shopping/MyProduct'),
        //     meta: {
        //         title: '具体商品'
        //     }
        // },
    ]
})