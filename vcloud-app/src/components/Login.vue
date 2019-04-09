<template lang="">
    <div class="contents">
        <div class="login">
            <el-row>
                <el-col :xs="24" :sm="24" :md="24" :lg="24" :xl="24">
                    <h3 class="">用户登录</h3>
                </el-col>
            </el-row>
            <el-row class="loginDiv">
                <el-col :xs="4" :sm="4" :md="4" :lg="4" :xl="4">
                    <div class="">用户名:</div>
                </el-col>
                <el-col :xs="18" :sm="18" :md="18" :lg="18" :xl="18">
                    <el-input v-model="username" placeholder="请输入用户名"></el-input>
                </el-col>
            </el-row>
            <el-row class="loginDiv">
                <el-col :xs="4" :sm="4" :md="4" :lg="4" :xl="4">
                    <span class="">密码:</span>
                </el-col>
                <el-col :xs="18" :sm="18" :md="18" :lg="18" :xl="18">
                    <el-input v-model="password" type="password" placeholder="请输入密码"></el-input>
                </el-col>
            </el-row>
            <el-row class="loginDiv">
                <el-col :xs="20" :sm="20" :md="20" :lg="20" :xl="20" :offset="2">
                    <el-button type="primary" @click="login" class="btn">登录</el-button>
                </el-col>
            </el-row>
        </div>
    </div>
</template>
<script>
export default {
    data () {
        return {
            username: '',
            password: ''
        }
    },
    mounted () {
        sessionStorage.removeItem('headerSign')
    },
    methods: {
        login () {
            // if (this.username == 'admin' && this.username == 'admin') {
            //     this.$router.push({path: '/index'})
            //     this.$emit('headerEvent',true)
            // } else {
            //     console.log(888888)
            // }
            // 登录功能
            this.$api.login({account: this.username, password: this.password})
            .then((res) => {
                console.log(res)
                if (res.data && res.code == 200) {
                    sessionStorage.setItem('authorization',res.data)
                    this.$router.push({path: '/index'})
                    this.$emit('headerEvent',true)
                }
            })
            // this.$http({
            //     url: 'http://localhost:3000/serverApi/login',
            //     method: 'POST',
            //     headers: {'content-type': 'application/json'},
            //     data: {
            //         username: this.username,
            //         password: this.password
            //     }
            // }).then((res) => {
            //     console.log(res)
            //     if (res.data.data) {
            //         this.$router.push({path: '/index'})
            //         this.$emit('headerEvent',true)
            //     } else {
            //         console.log(res.data.msg)
            //     }
            // }).catch((res) => {
            //     console.log(res)
            // })
        }
    }
}
</script>

<style scoped>
.contents{width: 100%;height: 100vh;background: url(../assets/bg.png);}
.login{height: 320px;width: 520px;background: #fff;border-radius: 5px;position: absolute;top: 50%;left: 50%;margin-left: -260px;margin-top: -160px;}
.loginDiv{margin-top: 15px;}
.btn{width: 120px;}
</style>
