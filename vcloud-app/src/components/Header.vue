<template>
    <div class="header">
        <el-row>
            <el-col :xs="18" :sm="18" :md="18" :lg="18" :xl="18" :offset="1">
                <div class="logo">
                    <div class="logoImg"></div>
                </div>
            </el-col>
            <el-col :xs="4" :sm="4" :md="4" :lg="4" :xl="4" class="login">
                <div class="loginOut">
                    <a href="javascript:;" @click="loginout">登出</a>
                    <a href="javascript:;">admin</a>
                </div>
            </el-col>
        </el-row>
    </div>
</template>
<script>
export default {
    data () {
        return {

        }
    },
    methods: {
        loginout () {
            this.$api.logout()
            .then((res) => {
                console.log(res)
                if (res.code == 200 && res.msg == 'OK') {
                    this.$router.push({path:'/login'})
                    this.$emit('headerEvent',false)
                    sessionStorage.removeItem('activeMenu')
                    sessionStorage.removeItem('authorization')
                }
            }).catch((res) => {
                console.log(res)
            })
            
        }
    },
}
</script>
<style scoped>
a{text-decoration: none;}
.header{width: 100%;height: 45px;background: #409EFF;}
.logoImg{width: 240px;text-align: left;height: 32px;background: url(../assets/logo.png) no-repeat;margin-top: 7px;}
.loginOut{height: 100%;overflow: hidden;}
.loginOut a{display: block;height: 100%;line-height: 45px;float: right;color: #fff;}
.loginOut a:nth-child(2){margin-right: 15px;}
</style>
