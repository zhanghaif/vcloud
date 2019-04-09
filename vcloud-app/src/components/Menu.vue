<template>
    <div class="content">
        <div class="title">
            <h3>菜单管理</h3>
            <a href="javascript:;">
                <i class="el-icon-circle-plus"></i>
            </a>
        </div>
        <div class="treeContainer">
            <div class="custom-tree-container">
                <div class="block">
                    <el-tree :data="menuData" show-checkbox node-key="id" default-expand-all :expand-on-click-node="false" :props="defaultProps" @node-click="handleNodeClick"></el-tree>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
let id = 1000
export default {
    data () {
        return {
            menuData: [],
            defaultProps: {
                children: 'children',
                label: 'name'
            },
            showSign: -1
        }
    },
    mounted () {
        this.getMenuData()
    },
    methods: {
        handleNodeClick(data) {
            console.log(data)
        },
        // 获取菜单管理数据
        getMenuData () {
            this.$api.permission()
            .then((res) => {
                console.log(res)
                this.menuData = res.data
                console.log(this.menuData)
            })
        },
        handleover (node) {
            this.showSign = node.id
        },
        handleout () {
            this.showSign = -1
        },
        append(data) {
            const newChild = { id: id++, label: 'testtest', children: [] };
            if (!data.children) {
                this.$set(data, 'children', []);
            }
            data.children.push(newChild);
        },
        remove(node, data) {
            const parent = node.parent;
            const children = parent.data.children || parent.data;
            const index = children.findIndex(d => d.id === data.id);
            children.splice(index, 1);
        }
    },
}
</script>

<style scoped>
.content{margin-left: 5%;border: 1px solid #409EFF;border-radius: 5px;width: 70%;margin-top: 25px;}
.title{width: 100%;height: 35px;background: #409EFF;overflow: hidden;border-top-left-radius: 5px;border-top-right-radius: 5px;}
.title h3{margin: 0;padding: 0;font-size: 14px;font-weight: 400;color: #fff;float: left;line-height: 35px;width: 30%;margin-left: 15px;text-align: left;}
.title a{display: block;float: right;width: 40px;margin-right: 15px;}
.title a i{font-size: 21px;color: #fff;margin-top: 7px;}
.treeContainer{margin: 15px;}
.custom-tree-node {
    flex: 1;
    display: flex;
    align-items: center;
    justify-content: space-between;
    font-size: 14px;
    padding-right: 8px;
}
</style>