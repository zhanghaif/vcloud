<template>
    <div class="content">
        <div class="title">
            <h3>角色管理</h3>
            <a href="javascript:;">
                <i class="el-icon-circle-plus"></i>
            </a>
        </div>
        <el-table :data="tableData" style="width: 96%;margin-left: 2%;margin-top: 2%;margin-bottom: 2%;text-align:center;" size="mini" border>
            <el-table-column prop="roleName" label="角色" width="100" align="center"></el-table-column>
            <!-- <el-table-column prop="email" label="邮箱" width="180" align="center"></el-table-column>
            <el-table-column prop="iphone" label="手机" align="center"></el-table-column> -->
            <el-table-column prop="description" label="描述" align="center"></el-table-column>
            <el-table-column label="操作" align="center" width="180">
                <template slot-scope="scope">
                    <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
                    <el-button type="text" size="small">编辑</el-button>
                    <el-button type="text" size="small">删除</el-button>
                    <el-button @click="configure(scope.row)" type="text" size="small">配置</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-dialog title="配置权限" :visible.sync="dialogCheck">
            <el-tree :data="menuData" show-checkbox node-key="id" default-expand-all :expand-on-click-node="false" :props="defaultProps"></el-tree>
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
           dialogCheck: false,
           menuData: [],
           defaultProps: {
                children: 'children',
                label: 'name'
           },
           tableData: [] 
        }
    },
    mounted() {
        this.getRole()
    },
    methods: {
        // 获取菜单管理数据
        configure (row) {
            this.$api.permission()
            .then((res) => {
                console.log(res)
                this.dialogCheck = true
                this.menuData = res.data
                console.log(this.menuData)
            })
        },
        // 获取角色管理数据
        getRole () {
            this.$api.role()
            .then((res) => {
                console.log(res)
                this.tableData = res.data
            })
        }
    }
}
</script>

<style scoped>
.content{margin-left: 5%;border: 1px solid #409EFF;border-radius: 5px;width: 70%;margin-top: 25px;}
.title{width: 100%;height: 35px;background: #409EFF;overflow: hidden;border-top-left-radius: 5px;border-top-right-radius: 5px;}
.title h3{margin: 0;padding: 0;font-size: 14px;font-weight: 400;color: #fff;float: left;line-height: 35px;width: 30%;margin-left: 15px;text-align: left;}
.title a{display: block;float: right;width: 40px;margin-right: 15px;}
.title a i{font-size: 21px;color: #fff;margin-top: 7px;}
</style>