<template>
    <div class="content">
        <div class="title">
            <h3>用户管理</h3>
            <a href="javascript:;" @click="newUser">
                <i class="el-icon-circle-plus"></i>
            </a>
        </div>
        <el-table :data="tableData" style="width: 96%;margin-left: 2%;margin-top: 2%;margin-bottom: 2%;text-align:center;" size="mini" border>
            <el-table-column prop="username" label="用户名" width="100" align="center"></el-table-column>
            <!-- <el-table-column prop="email" label="邮箱" width="180" align="center"></el-table-column> -->
            <el-table-column prop="roleName" label="角色" align="center"></el-table-column>
            <el-table-column prop="tel" label="手机" align="center"></el-table-column>
            <el-table-column label="操作" align="center">
                <template slot-scope="scope">
                    <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
                    <el-button @click="editClick(scope.row)" type="text" size="small">编辑</el-button>
                    <el-button @click="delClick(scope.row,scope.$index)" type="text" size="small">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-dialog :title="dialogTitle" :visible.sync="dialogFormVisible">
            <el-form :model="form">
                <el-form-item label="用户名" label-width="80px">
                    <el-input v-model="form.name"></el-input>
                </el-form-item>
                <el-form-item label="邮箱" label-width="80px">
                    <el-input v-model="form.email"></el-input>
                </el-form-item>
                <el-form-item label="手机" label-width="80px">
                    <el-input v-model="form.iphone"></el-input>
                </el-form-item>
                <el-form-item label="岗位" label-width="80px">
                    <el-select v-model="form.post" placeholder="请选择岗位">
                        <el-option label="文员" value="文员"></el-option>
                        <el-option label="人力" value="人力"></el-option>
                        <el-option label="前端" value="前端"></el-option>
                        <el-option label="后台" value="后台"></el-option>
                    </el-select>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="dialogFormVisible = false">取 消</el-button>
                <el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>
            </div>
        </el-dialog>
        <el-dialog title="查看用户" :visible.sync="dialogCheck">
            <el-row>
                <el-col :xs="12" :sm="12" :md="12" :lg="12" :xl="12">
                    <div class="check"><span>用户名:</span><span>{{checkData.name}}</span></div>
                </el-col>
                <el-col :xs="12" :sm="12" :md="12" :lg="12" :xl="12">
                    <div class="check"><span>邮箱:</span><span>{{checkData.email}}</span></div>
                </el-col>
                <el-col :xs="12" :sm="12" :md="12" :lg="12" :xl="12">
                    <div class="check"><span>手机:</span><span>{{checkData.iphone}}</span></div>
                </el-col>
                <el-col :xs="12" :sm="12" :md="12" :lg="12" :xl="12">
                    <div class="check"><span>岗位:</span><span>{{checkData.post}}</span></div>
                </el-col>
            </el-row>
            <div slot="footer" class="dialog-footer">
                <el-button type="primary" @click="dialogCheck = false" size="mini">确 定</el-button>
            </div>
        </el-dialog>
    </div>
</template>
<script>
export default {
    data () {
        return {
            tableData: [],
            dialogFormVisible: false,
            dialogCheck: false,
            checkData: {},
            form: {
                name: '',
                email: '',
                iphone: '',
                post: ''
            },
            dialogTitle: '新建用户'
        }
    },
    mounted () {
        this.getUser()
    },
    methods: {
        handleClick (row) {
            console.log(row)
            this.checkData = row
            this.dialogCheck = true
        },
        newUser () {
            this.dialogTitle = '新建用户'
            this.dialogFormVisible = true
        },
        editClick (row) {
            console.log(row)
            this.dialogTitle = '编辑用户'
            this.dialogFormVisible = true
            this.form = row
        },
        delClick (row, index) {
            console.log(row, index)
            this.dialogFormVisible = true
        },
        // 获取用户管理数据
        getUser () {
            this.$api.user()
            .then((res) => {
                console.log(res)
                this.tableData = res.data
            })
        }
    }
}
</script>
<style scoped>
.content{border: 1px solid #409EFF;border-radius: 5px;width: 70%;margin-top: 25px;margin-left: 5%;}
.title{width: 100%;height: 35px;background: #409EFF;overflow: hidden;border-top-left-radius: 5px;border-top-right-radius: 5px;}
.title h3{margin: 0;padding: 0;font-size: 14px;font-weight: 400;color: #fff;float: left;line-height: 35px;width: 30%;margin-left: 15px;text-align: left;}
.title a{display: block;float: right;width: 40px;margin-right: 15px;}
.title a i{font-size: 21px;color: #fff;margin-top: 7px;}
.check{height: 30px;line-height: 30px;overflow: hidden;}
.check span{text-align: right;display: block;float: left;height: 30px;line-height: 30px;}
.check span:nth-child(1){width: 80px;}
.check span:nth-child(2){margin-left: 8px;}
.el-select{width: 100%;}
.dialog-footer{text-align: center;}
</style>

