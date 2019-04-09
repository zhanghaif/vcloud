<template>
    <div class="left">
        <el-row class="tac">
            <el-col>
                <el-menu :default-active="activeMenu" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose" @select="handleSelect" router>
                    <el-menu-item index="/index">
                        <!-- <i class="el-icon-location"></i> -->
                        <span slot="title">首页</span>
                    </el-menu-item>
                    <el-menu-item v-for="(item, index) in menuData" :key="index" :index="item.path">
                        <i :class="item.icon"></i>
                        <span slot="title">{{item.text}}</span>
                    </el-menu-item>
                    <!-- <el-menu-item index="/role">
                        <i class="el-icon-menu"></i>
                        <span slot="title">角色管理</span>
                    </el-menu-item>
                    <el-menu-item index="/menu">
                        <i class="el-icon-document"></i>
                        <span slot="title">菜单管理</span>
                    </el-menu-item> -->
                </el-menu>
            </el-col>
        </el-row>
    </div>
</template>
<script>
export default {
    data() {
        return {
            activeMenu: '/index',
            menuData: [],
            powerData: {
                list: true,
                add: true,
                del: true,
                update: true,
                form: true
            },
            powerJson: {}
        }
    },
    created () {
        if (sessionStorage.getItem('activeMenu')) {
            this.activeMenu = sessionStorage.getItem('activeMenu')
        }
        // 获取菜单
        this.$api.info()
        .then((res) => {
            console.log(res)
            let data = res.data.permissionList
            let testData = []
            let reData = []
            let power = {}
            for (var i=0;i<res.data.permissionList.length;i++) {
                testData.push(res.data.permissionList[i])
            }
            console.log(testData)
            for (var i=0;i<data.length;i++) {
                if (data[i].handle == 'list' && data[i].code.indexOf('list') != -1) {
                    reData.push(data[i])
                }
            }
            console.log(reData)
            for (var i=0;i<reData.length;i++) {
                this.menuData.push({path: '/'+reData[i].code.split(':')[1], text: reData[i].name, icon: reData[i].icon})
            }
            for(var i=0;i<testData.length;i++){
                if(power[testData[i].code.split(':')[1]]){
                    power[testData[i].code.split(':')[1]] = power[testData[i].code.split(':')[1]] +  ',' + testData[i].code.split(':')[2]
                } else {
                    power[testData[i].code.split(':')[1]] = testData[i].code.split(':')[2]
                }
            }
            console.log(power)
            this.powerJson = power
            // console.log(reData)
            // console.log(this.menuData)
            // for (var i=0;i<this.menuData.length;i++) {
            //     if (this.menuData[i] == "permission") {
            //         this.menuData[i] = {path: '/' + this.menuData[i], text: '菜单管理', icon: 'el-icon-document'}
            //     } else if (this.menuData[i] == "role") {
            //         this.menuData[i] = {path: '/' + this.menuData[i], text: '角色管理', icon: 'el-icon-menu'}
            //     } else if (this.menuData[i] == "user") {
            //         this.menuData[i] = {path: '/' + this.menuData[i], text: '用户管理', icon: 'el-icon-location'}
            //     } else if (this.menuData[i] == "log") {
            //         this.menuData[i] = {path: '/' + this.menuData[i], text: '日志管理', icon: 'el-icon-document'}
            //     }
            // }
            // console.log(this.menuData)
        })
        .catch((res) => {
            console.log(res)
        })
    },
    methods: {
        handleOpen(key, keyPath) {
            console.log(key, keyPath)
        },
        handleClose(key, keyPath) {
            console.log(key, keyPath)
        },
        handleSelect (index, path) {
            console.log(index, path, 111111,index.substring(1))
            // 判断权限信息
            if (index != '/index') {
                for (var name in this.powerJson) {
                    if (this.powerJson[index.substring(1)].indexOf('list') != -1) {
                        this.powerData.list = true
                    } else {
                        this.powerData.list = false
                    }
                    if (this.powerJson[index.substring(1)].indexOf('add') != -1) {
                        this.powerData.add = true
                    } else {
                        this.powerData.add = false
                    }
                    if (this.powerJson[index.substring(1)].indexOf('delete') != -1) {
                        this.powerData.del = true
                    } else {
                        this.powerData.del = false
                    }
                    if (this.powerJson[index.substring(1)].indexOf('update') != -1) {
                        this.powerData.update = true
                    } else {
                        this.powerData.update = false
                    }
                    if (this.powerJson[index.substring(1)].indexOf('from') != -1) {
                        this.powerData.form = true
                    } else {
                        this.powerData.form = false
                    }
                }
            } else {
                this.powerData = {
                    list: true,
                    add: true,
                    del: true,
                    update: true,
                    form: true
                }
            }
            sessionStorage.setItem('activeMenu',index)
            sessionStorage.setItem('powerData',JSON.stringify(this.powerData))
        }
    },
}
</script>
<style scoped>
.left{width: 16.66667%;margin-left: 4.16667%;margin-top: 25px;}
.tac{width: 150px;margin: 0 auto;}
.el-menu{border: 1px solid #e6e6e6;}
</style>